$(() => {
  //header를 넣을 태그 찾기
  const header = $("body>div.header");
  //div.header class속성에 header.html불러오기
  header.load("../html/header.html");

  //footer를 넣을 태그 찾기
  const footer = $("body>div.footer");
  //div.header class속성에 header.html불러오기
  footer.load("../html/footer.html");

  //글쓰기 버튼으로 연결하기
  $("#write").on("click", function (e) {
    window.location.href = "../html/write.html";
  });
  $.ajax({
    url: "http://localhost:8888/back/mypost",
    type: "get",
    //data: Json,
    //contentType: "application/json",
    //data: `loginid={}`, //로그인하면 세션에 pk로 저장- 에러발생
    data: {loginId: loginId},

    success: (response) => {
      console.log(response, "--");
      if (response[1] === null) {
        alert("글이 없습니다");
        $("#post-title-writer").hide();
        $("#post-content").hide();
        $(".thumbnail").hide();
      } else {
//      alert("연결완료");
        $("#post-title-writer").text(response[1].mainTitle);
        $("#post-content").text(response[1].content);
      }
    },
    error: () => {
      alert("에러발생");
    },
  });
});
