$(() => {
  const header = $("body>div.header"); //header
  header.load("../html/header.html");
  const footer = $("body>div.footer"); //footer
  footer.load("../html/footer.html");

  //DOM트리 form객체 찾기
  const formObj = $("form.signup");
  //아이디 입력란 객체
  const inputIdObj = $("input[name=loginId]");
  //아이디중복확인 버튼
  const btIdDupChk = $("form.signup>button.iddupchk");
  //비밀번호 입력 객체찾기
  const inputPwdObj = $("input[name=pwd]");
  //닉네임 입력 객체찾기
  const inputnameObj = $("input[name=name]");
  //회원가입 버튼
  const btSignup = $("form.signup>button.signup");

  // 세션 없애기
  $.ajax({
    url: "/back/logout",
    method: "GET",
    success: () => {
      console.log("로그아웃 성공");
    },
    error: (xhr) => {
      console.log("로그아웃 실패");
      +xhr.status;
    },
  });
  //회원가입 버튼 누르기
  formObj.submit((e) => {
    alert(formObj.serialize());
    $.ajax({
      url: "/back/member",
      method: formObj.attr("method"),
      type: "post",
      data: formObj.serialize(),
      headers: {
        Accept: "application/json",
      },
      success: (responseObj) => {
        console.log(responseObj);
        if (responseObj === "1") {
          //가입 성공인경우
          console.log(responseObj);
          alert("회원가입이 완료되었습니다");
          location.href = "/back/front/html/login.html"; //페이지 이동
        } else {
          //가입 실패인경우
          console.log(responseObj);
          alert(responseObj);
        }
      },
      error: (xhr) => {
        alert("회원가입에러발생:" + xhr.status + xhr.responseJSON);
      },
    });
    return false;
  });
});
