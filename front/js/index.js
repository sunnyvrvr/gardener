$(() => {
  //header를 넣을 태그 찾기
  const header = $('body>div.header');
  //div.header class속성에 header.html불러오기
  header.load('./html/header.html');

  //footer를 넣을 태그 찾기
  const footer = $('body>div.footer');
  //div.header class속성에 header.html불러오기
  footer.load('./html/footer.html');

  // function search_enter() {
  //   if (Event.KeyCode == 13) {
  //     search_btn();
  //   }
  // }

  // function search_btn() {
  //   if ($('input[name="keyword"]').val() == '') {
  //     alert('검색어를 입력해주세요');
  //     return false;
  //   } else {
  //   }
  // }

  //검색버튼을 클릭하면 할 일 start
  const searchbtn = $('input.search-button');

  searchbtn.click(() => {
    alert('검색');
    location.href = './html/search.html';
  });
  //검색버튼을 클릭하면 할 일 end

  //입력창에 엔터를 누르면 할 일 start
  const txtobj = $('input[type=text]');

  txtobj.keyup((e) => {
    if (e.key == 'Enter') {
      //Enter에 입력하면 할 일
      this.alert('enter입력');
    }
  });
  //입력창에 엔터를 누르면 할 일 start
}); //ready end
