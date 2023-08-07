<<<<<<< HEAD
window.addEventListener("load", () => {
  const header = document.querySelector("body>div.header"); //header 변수 선언
  const footer = document.querySelector("body>div.footer"); //footer 변수 선언
  const write = document.querySelector("body>div.button"); //글쓰기 버튼 변수 선언
  //헤더 불러오기
  fetch("../html/header.html")
    .then((response) => response.text())
    .then((data) => {
      header.innerHTML = data;
    });
  //푸터 불러오기
  fetch("../html/footer.html")
    .then((response) => response.text())
    .then((data) => {
      footer.innerHTML = data;
    });
  //글쓰기 버튼 클릭
  write.addEventListener("click", (e) => {
    location.href = "../html/write.html";
=======
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
>>>>>>> a25342519161b0a8045e00291ab54d5f2e03857f
  });
});
