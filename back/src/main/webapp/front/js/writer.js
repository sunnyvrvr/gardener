$(() => {
  //header
  const header = $("body>div.header");
  header.load("../html/header.html");

  //footer
  const footer = $("body>div.footer");
  footer.load("../html/footer.html");

  //작가내용 보여주기
  $.ajax({
    url: "http://localhost:8888/back/writermember", //실제서버주소
    type: "get",
    data: { writerid: "2" },
    success: (response) => {
      console.log(response, "--");
      const writerimage = $("div.wr>div.wr_part>img");
      writerimage.attr("src", response.profile);
      $("#wr_name").text(response.name);
      $("#wr_info").text(response.intro);
    },
    error: (xhr) => {
      alert("에러발생" + xhr.status);
    },
  });

  //작가글 보여주기
  $.ajax({
    url: "http://localhost:8888/back/writerpostlist", //실제서버주소
    type: "get",
    data: { writerid: "2" },
    success: (response) => {
      console.log(response, "--");
      const responselength = response.length;

      //결과를 보여줄 위치
      const gardenResult = $("div.posts_part");

      gardenResult.load("./writerpostresult.html", () => {
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
