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
    url: "/back/mypost",
    type: "get",
    data: { loginId: "loginId" },
    success: (response) => {
      console.log(response, "--");
      const responselength = response.length;

      //결과를 보여줄 위치
      const gardenResult = $("div.posts_part");

      gardenResult.load("./gardenresult.html", () => {
        const viewtable = $("table.writing-list");

        for (var i = 0; i < responselength; i++) {
          const tabletr = document.createElement("tr");

          tabletr.innerHTML = `<td>
            <a>
              <img src="${response[i].mainTitleImg}" alt="제목이미지" 
                        style="display: block; width: 200px; height: 150px;">
            </a>
          </td>
          <td class="test">
            <h2>${response[i].mainTitle}</h2>
            <p>${response[i].content}</p>
          </td>`;
          $(viewtable).append(tabletr);
        }
      });
    },
    error: (xhr) => {
      alert("에러발생" + xhr.status);
    },
  });
  $("div.paging").hide();
});
