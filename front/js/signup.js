$(() => {
  //DOM트리에서 form객체찾기
  formObj = $("formObj.signup");

  //아이디 입력란 객체 찾기
  const inputIdObj = $("form.signup>input[name=id]");

  //이메일 입력란 객체 찾기
  const inputEmailObj = $("form.signup>input[name=email]");

  //가입버튼 객체 찾기
  const btnSignup = $("form.signup>btn-Signup");

  //아이디 중복확인 버튼 객체 찾기

  //필명 중복확인 버튼



  $.ajax({
    url: $(e.target).attr('action'),
    method: $(e.target).attr('method') ,
    data: formObj.serialize(),
    success: (responseObj) => {
      if(responseObj.status == 1){
        //가입 성공인 경우
        alert("성공:" + responseObj.msg)
      }else{
        //가입 실패인 경우
        alert(responseObj.msg)
      }
    }
    
  },
  error:(xhr) => {
    alert("에러:" + xhr.status)
  })
  return false 



  






});
