$(() => {
  //header를 넣을 태그 찾기
  const header = $("body>div.header");
  //div.header class속성에 header.html불러오기

 // header.load("./header.html");

  //header.load("./html/header.html");

  //footer를 넣을 태그 찾기
  const footer = $("body>div.footer");
  //div.header class속성에 header.html불러오기

  footer.load("./footer.html");

  footer.load("./html/footer.html");

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
  const searchbtn = $("input.search-button");

  searchbtn.click(() => {
    //input에 입력한 값
    const textValue = $("input.search-text").val();

    //select로 선택한 값
    const selectValue = $("select.dropdown").val();

    alert(selectValue + " button 검색");

    //해당위치에 결과값 출력
    const body = $("div.search-body");

    $.ajax({
      url: "http://localhost:8888/back/search",
      method: "get",
      data: { select: selectValue, text: textValue },
      success: (resultData) => {
        if (resultData.length != 0) {
          //받은 데이터 확인
          console.log(resultData);
          console.log(resultData[0].mainTitle);
          const resultlength = resultData.length;
          console.log(resultlength);
          body.load("./search.html", () => {
            $("td.test > h2").text(resultData[0].mainTitle);
            $("td.test > h3").text(resultData[0].name);
            $("td.test > p").text(resultData[0].content);
          });
        } else {
          alert("검색하는 결과가 없습니다.");
        }
      },
      error: function () {
        alert("검색 실패");
      },
    });

    alert("검색");
    location.href = "./html/search.html";
  });
  //검색버튼을 클릭하면 할 일 end

  //입력창에 엔터를 누르면 할 일 start
  const txtobj = $("input[type=text]");

  txtobj.keyup((e) => {
    if (e.key == "Enter") {
      //Enter에 입력하면 할 일

      this.alert("enter 입력");

      this.alert("enter입력");
    }
  });
  //입력창에 엔터를 누르면 할 일 start
}); //ready end
