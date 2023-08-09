$(() => {
  //header
  const header = $("body>div.header");
  header.load("../html/header.html");

  //footer
  const footer = $("body>div.footer");
  footer.load("../html/footer.html");

  //글내용 보여주기
  $.ajax({
    url: "http://localhost:8888/back/writerpost", //실제서버주소
    type: "get",
    data: { writerid: 1 },
    success: (response) => {
      console.log(response);
      // if (response[1] === null) {
      //   alert("글이 없습니다");
      //   $("#post-title-writer").hide();
      //   $("#post-content").hide();
      //   $("#thumbnail").hide();
      // } else {
      //   alert("연결완료");
      //   $("#post-title-writer").text(response[1].mainTitle);
      //   $("#post-content").text(response[1].content);
      // }
    },
    error: () => {
      alert("에러발생");
    },
  });
});
