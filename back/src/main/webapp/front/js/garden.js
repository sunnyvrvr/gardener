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
    url: "http://localhost:8888/mypost", //실제서버주소
    type: "get",
    data: {'loginid':'id1'},
  
    success: (response) => {
      console.log(response, "--");
   	 	if(response[0] === null){
			alert("글이 없습니다");
			$("#post-title-writer").hide();
			$("#post-content").hide();	
			$(".thumbnail").hide();				
		}else {
      alert("연결완료");
		$("#post-title-writer").text(response[0].mainTitle);
		$("#post-content").text(response[0].content);
		}
    },
    error: () => {
      alert("에러발생");
    },
  });
});
