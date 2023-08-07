$(() => {
  //header를 넣을 태그 찾기
  const header = $('body>div.header');
  //div.header class속성에 header.html불러오기
  header.load('../html/header.html');

  //footer를 넣을 태그 찾기
  const footer = $('body>div.footer');
  //div.header class속성에 header.html불러오기
  footer.load('../html/footer.html');
})
/*
  const wrname = $('body>div.wr>div.wr_part>div.wr_name');
  $(wrname).onload =()=>{
    $.ajax({
      url: "http://localhost:8888/front/html/writer.html",
      method: "get",
      processData: false,
      contentType: false,
      data: {
		  loginid: 'id1'
	  },
      success: (response) => {
        console.log(response, "--");
        sessionStorage.setItem("loginid", response);
      }),
    });
  }),
})
*/