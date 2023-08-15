$(() => {
  const header = $("body>div.header"); //header
  header.load("../html/header.html");

  const footer = $("body>div.footer"); //footer
  footer.load("../html/footer.html");

  //DOM트리 form객체 찾기
  const formObj = $("form.posting");
  //제목입력란
  const mainTitleObj = $("form.posting>input[name=mainTitle]");
  //글쓴이 입력란
  const writerObj = $("form.posting>input[name=writer]");
  //이미지 입력란
  const imageObj = $("form.posting>input[name=mainTitleImg]");
  //글내용 입력란
  const contentObj = $("form.posting>input[name=content]");

  //글쓰기
  formObj.submit((e) => {
    alert(formObj.serialize());
    $.ajax({
      url: "/back/post",
      method: formObj.attr("method"),
      type: "post",
      data: formObj.serialize(),
      headers: {
        Accept: "application/json",
      },
      success: (responseObj) => {
        console.log(responseObj);
        if (responseObj) {
          //글작성 성공
          console.log(responseObj);
          alert("글작성이 완료되었습니다");
          location.href = "/back/front/html/garden.html"; //페이지 이동
        } else {
          //글작성 실패
          console.log(responseObj);
          alert(responseObj);
        }
      },
      error: (xhr) => {
        alert("글쓰기에러발생:" + xhr.status + xhr.responseJSON);
      },
    });
    return false;
  });
});
