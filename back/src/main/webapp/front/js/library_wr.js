$(() => {
  //header를 넣을 태그 찾기
  const header = $('body>div.header');
  header.load('../html/header.html');

  //footer를 넣을 태그 찾기
  const footer = $('body>div.footer');
  footer.load('../html/footer.html');
  
  
  
  $("div.paging").hide();
});


