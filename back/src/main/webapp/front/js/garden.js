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
  //글내용 보여주기
  $.ajax({
    url: "http://localhost:8888/back/mypost",
    type: "get",
    data: {loginId:"loginId"},
    success: (response) => {
      console.log(response, "--");
      const responselength = response.length;
//      alert("연결완료");       
      for (let i = 0; i < responselength; i++) {
         const imageElement = $('div.posts_part>div.post>a.thumbnail>img');
    // 새로운 이미지 경로로 src 속성 변경
  		  imageElement.attr('src', response[i].mainTitleImg);
        
        $("#post-title-writer").text(response[i].mainTitle);
        $("#post-content").text(response[i].content);
      }
      $(div.posts_part).append(div.post);
    },
    error: () => {
      alert("에러발생");
    },
  });
  $("div.paging").hide();
});
