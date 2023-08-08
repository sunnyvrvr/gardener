$(() => {
  //DOM트리에서 form객체찾기
  const formObj = $("form.signup");
  //아이디 입력란 객체 찾기
  const inputIdObj = $("form.signup>input[name=loginId]");

  //이메일 입력란 객체 찾기
  const inputEmailObj = $("form.signup>input[name=email]");

  //필명 입력란 객체 찾기
  const inputNameObj = $("form.signup>input[name=name]");

  //가입버튼 객체 찾기
  const btnSignup = $("form.signup.btn-Signup");

  //아이디 중복확인 버튼 객체 찾기

  //필명 중복확인 버튼

  formObj.submit((e) => {
    $(e.target)
      .attr("action", "http://localhost:8888/back/signup")
      .attr("method", "post");
    $.ajax({
      url: formObj.attr("action"),
      method: formObj.attr("method"),
      data: formObj.serialize(),
      success: (responseObj) => {
		  console.log(responseObj);
        if (responseObj === "1") {
          //가입 성공인경우
          swal("지윤이가 함", "회원가입 추카함");
          location.href("./login.html");
        } else {
          //가입 실패인경우
          alert(responseObj.msg);
        }
      },
      error: (xhr) => {
        alert("에러:" + xhr.status);
      },
    });
    return false;
  });
});