$(() => {
  const backURL = 'http://localhost:8888/back';
  const formObj = $('form.login');

  const cbObj = formObj.find('input[type=checkbox]'); //아이디저장 체크박스
  const savedId = localStorage.getItem('savedId');
  if (savedId != null) {
    formObj.find('input[name-loginId]').val(savedId);
  }

  formObj.submit((e) => {
    if (cbObj.prop('chekced')) {
      //체크된 경우
      const idValue = formObj.find('input[name=loginId]').val();
      localStorage.setItem('savedId', idValue);
    } else {
      //체크 해제된 경우
      localStorage.removeItem('savedId');
    }

    const data = $(e.target).serialize(); // 이벤트가 발생한 곳
    /* alert(data);*/
    $.ajax({
      url: `${backURL}/login`,
      method: 'post',
      data: data, //Servlet로넘어감
      success: (responseData) => {
        //" 12 3".trim() > "123"
        if (responseData.trim() == '0') {
          //로그인 실패인 경우
          alert('로그인실패');
          $('form.login>input[name=loginId]').focus();
        } else if (responseData.trim() == '1') {
          //로그인 성공인 경우
          alert(`${backURL}/login`);
          location.href = './index.html'; //페이지 이동
        } else {
          alert('환영합니다');
        }
      },
      error: (xhr) => {
        alert('에러~~:' + xhr.status);
      },
    });
    return false;
  });
});
