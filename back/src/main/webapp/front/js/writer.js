$(() => {
  //header
  const header = $("body>div.header");
  header.load("../html/header.html");

  //footer
  const footer = $("body>div.footer");
  footer.load("../html/footer.html");

  //작가내용 보여주기
  $.ajax({
    url: "http://localhost:8888/back/writermember", //실제서버주소
    type: "get",
    data: { writerid: "1" },
    success: (response) => {
      console.log(response, "--");
      const writerimage = $("div.wr>div.wr_part>img");
      writerimage.attr("src", response.profile);
      $("#wr_name").text(response.name);
      $("#wr_info").text(response.intro);
    },
    error: (xhr) => {
      alert("에러발생" + xhr.status);
    },
  });

  //작가글 보여주기
  $.ajax({
    url: "http://localhost:8888/back/writerpostlist", //실제서버주소
    type: "get",
    data: { writerid: "1" },
    success: (response) => {
      console.log(response, "--");
      const responselength = response.length;
      for (let i = 0; i < responselength; i++) {
        const writerimage = $("#postimage");
        writerimage.attr("src", response[0].mainTitleImg);
        $("#post-title-writer").text(response[0].mainTitle);
        $("#post-content").text(response[0].content);
      }
    },
    error: (xhr) => {
      alert("에러발생" + xhr.status);
    },
  });
  $("div.paging").hide();
});
