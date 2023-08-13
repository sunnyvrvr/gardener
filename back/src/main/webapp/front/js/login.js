$(() => {
  const formObj = $("form.login");

  // 아이디 저장 체크박스
  const cbObj = formObj.find("input[type=checkbox]");
  const savedId = localStorage.getItem("savedId");
  if (savedId !== null) {
    formObj.find("input[name='loginId']").val(savedId);
  }

  formObj.submit((e) => {
    if (cbObj.prop("checked")) {
      const idValue = formObj.find("input[name='loginId']").val();
      localStorage.setItem("savedId", idValue);
    } else {
      localStorage.removeItem("savedId");
    }

    const data = $(e.target).serialize();
    const loginIdValue = formObj.find("input[name='loginId']").val();

    $.ajax({
      url: "/back/login",
      method: "post",
      data: data,
      dataType: "json",
      success: (responseData) => {
        console.log(responseData, " 로그인확인용");
        if (responseData === 1) {
          alert("환영합니다");
          console.log(responseData);
          sessionStorage.setItem("name", responseData);
          location.href = `/back/front/html/index.html`;
        } else if (responseData === 0) {
          alert("로그인실패");
          $("form.login>input[name='loginId']").focus();
        }
      },
      error: (xhr) => {
        alert("에러발생:" + xhr.status);
      },
    });
    return false;
  });
});
