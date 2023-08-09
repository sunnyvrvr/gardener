$(() => {
  const backURL = "http://localhost:8888/back";
  //DOM트리에서 form객체찾기
  const formObj = $("form.signup");

  //아이디 입력란 객체 찾기
  const inputIdObj = $("form.signup>input[name=id]");

  //이메일 입력란 객체 찾기
  const inputEmailObj = $("form.signup>input[name=email]");
  
  //필명 입력란 객체 찾기
  const inputNameObj = $("form.signup>input[name=name]");

  //가입버튼 객체 찾기
  const btnSignup = $("form.signup.btn-Signup");

  //아이디 중복확인 버튼 객체 찾기

  //필명 중복확인 버튼

  $.ajax({
    url: `${backURL}/signup`, //$(e.target).attr("action"),
    method: "post", //$(e.target).attr("method"),
    data: formObj.serialize(),
    success: (responseObj) => {
      if (responseObj.status == 1) {
        //가입 성공인경우
        alert("성공:" + responseObj.msg);
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
