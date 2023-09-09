$(() => {
  //header
  const header = $("body>div.header");
  header.load("../html/header.html");

  //footer
  const footer = $("body>div.footer");
  footer.load("../html/footer.html");

  //작가내용 보여주기
  $.ajax({
    url: "http://localhost:8888/back/writer", //실제서버주소
    type: "get",
    data: {writerid:1},
    success: (response) => {
      console.log(response + "--");
      // if (response[0] === null) {
      //   alert("글이 없습니다");
      //   $("#post-title-writer").hide();
      //   $("#post-content").hide();
      //   $("#thumbnail").hide();
      // } else {
      //   alert("연결완료");
      //   $("#post-title-writer").text(response[0].mainTitle);
      //   $("#post-content").text(response[0].content);
      // }
    },
    error: (xhr) => {
      alert("에러발생" + xhr.status);
    },
  });
});
