$(() => {
  //header를 넣을 태그 찾기
  const header = $('body>div.header');
  //div.header class속성에 header.html불러오기
  header.load('./html/header.html');

  //footer를 넣을 태그 찾기
  const footer = $('body>div.footer');
  //div.header class속성에 header.html불러오기
  footer.load('./html/footer.html');

  //검색버튼을 클릭하면 할 일 start
  const searchbtn = $('input.search-button');

  searchbtn.click(() => {
    //input에 입력한 값
    const textValue = $('input.search-text').val();

    //select로 선택한 값
    const selectValue = $('select.dropdown').val();

    alert(selectValue + ' button 검색');

    $.ajax({
      url: 'http://localhost:8888/back/search',
      method: 'get',
      data: { select: selectValue, text: textValue },
      //dataType:"json",
      success: (resultData) => {
        //const result = JSON.parse(resultData);
        //검색성공한 데이터를 보여줄 위치
        alert(resultData);
        location.href = './html/search.html';
      },
      error: () => {
        alert('검색 실패');
      },
    });
  });
  //검색버튼을 클릭하면 할 일 end

  //입력창에 엔터를 누르면 할 일 start
  const txtobj = $('input[type=text]');

  txtobj.keyup((e) => {
    if (e.key == 'Enter') {
      //Enter에 입력하면 할 일
      this.alert('enter 입력');
    }
  });
  //입력창에 엔터를 누르면 할 일 start
}); //ready end
