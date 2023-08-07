<<<<<<< HEAD
window.addEventListener("load", () => {
  const header = document.querySelector("body>div.header"); //header 변수 선언
  const footer = document.querySelector("body>div.footer"); //footer 변수 선언

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
});
=======
$(() => {
  //header를 넣을 태그 찾기
  const header = $('body>div.header');
  //div.header class속성에 header.html불러오기
  header.load('./html/header.html');

  //footer를 넣을 태그 찾기
  const footer = $('body>div.footer');
  //div.header class속성에 header.html불러오기
  footer.load('./html/footer.html');
})
>>>>>>> a25342519161b0a8045e00291ab54d5f2e03857f
