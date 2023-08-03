$(() => {
  const backURL = "http://localhost:8888/back";
  const formObj = $("form.login");

  const cbObj = formObj.find("input[type=checkbox]"); //아이디저장 체크박스
  const savedId = localStorage.getItem("savedId");
  if (savedId != null) {
    formObj.find("input[name-id]").val(savedId);
  }
  formObj.submit((e) => {
    if (cbObj.prop("chekced")) {
      //체크된 경우
      const idValue = formObj.find("input[name=id]").val();
      localStorage.setItem("savedId", idValue);
    } else {
      //체크 해제된 경우
      localStorage.removeItem("savedId");
    }

    const data = $(e.target).serialize();
    alert(data);
    $.ajax({
      url: `${backURL}/login`,
      method: "post",
      data: data,
      success: (responseData) => {
        if (responseData.trim() == "0") {
          //로그인 실패인 경우
          alert("로그인실패");
          $("form.login>input[name=id]").focus();
        } else {
          alert(`${backURL}/login`);
          //로그인 성공인 경우
          location.href = "../index.html";
        }
      },
      error: (xhr) => {
        alert("에러:" + xhr.status);
      },
    });
    return false;
  });
});
