window.addEventListener("load", () => {
  const header = document.querySelector("body>div.header"); //header 변수 선언
  const footer = document.querySelector("body>div.footer"); //footer 변수 선언

  //헤더 불러오기
  fetch("./html/header.html")
    .then((response) => response.text())
    .then((data) => {
      header.innerHTML = data;
    });
  //푸터 불러오기
  fetch("./html/footer.html")
    .then((response) => response.text())
    .then((data) => {
      footer.innerHTML = data;
    });
});
