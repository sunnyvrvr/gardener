<<<<<<< HEAD
$(() => {
  const num = sessionStorage.getItem("num");
  const pn = $(".pagination");
  $.ajax({
    url: "http://localhost:8888/back/post",
    data: `num=${num}`,
    success: (response) => {
      const article = response.content
        .replace(
          /!\[([^\]]*)\]\((https:\/\/i\.imgur\.com\/[a-zA-Z0-9]+\.[a-z]+)\)/g,
          function (match, altText, src) {
            console.log(match, altText, src);
            if (altText !== "") {
              return (
                '<div class="content-img"><img src="' +
                src +
                '" alt="' +
                altText +
                '"/></div>'
              );
            } else {
              return (
                '<div class="content-img"><img src="' +
                src +
                '" alt=img/></div>'
              );
            }
          }
        )
        .replace(/\n/g, "<br>");
      console.log(response);
      $(".section-header-main-title").text(response.mainTitle);
      $(".section-header-main-subtitle").text(response.subTitle);
      $(".main-image").css("background-image", `url(${response.mainTitleImg})`);
      $(".section-header-info-writer").text(response.member.name);
      $(".section-header-info-date").text(response.createPost.substring(0, 19));
      $("article").html(article); // 개행문자 가져오기
      $(".section-header-icon span").text(response.favorite);
      $(".writer-profile-name").text(response.member.name);
      $(".writer-profile-intro").text(response.member.intro);
      $(".writer-profile-pic > img").attr("src", response.member.profile);
      // 댓글 처리 시작

      // 댓글 처리 끛끝
    },
  });

  // 댓글 등록 버튼 시작
  $(".section-comment > div > button").click((e) => {
    const num = sessionStorage.getItem("num");
    const content = $(e.target).prev().val();

    const data = {
      content: content,
      num: num,
    };
    $.ajax({
      url: "http://localhost:8888/back/comments",
      method: "POST",
      data: data,
      success: (response) => {
        $("textarea").val("");
        return;
      },
      error: (state, err) => {
        console.log(state, err);
      },
    });
  });
  // 댓글 등록 버튼 끝

  // 댓글 가져오기 시작

  $.ajax({
    url: "http://localhost:8888/back/comments",
    data: `num=${num}&cNum=1`,
    success: (response) => {
      console.log(response, "댓글");
      let commentDiv = "";
      $(".section-comment h3").text(`${response.totalCnt}개 댓글`);
      for (let i = 0; i < response.comments.length; i++) {
        commentDiv = `
        <div class='section-comment-wrap'>
        <div class='section-comment-write'>
        <div>
        <div class='section-comment-write name'>${response.comments[i].member.name}</div>
        <div class='section-comment-write date'>${response.comments[i].createDate}</div>
        </div>
        <div>
        <button>댓글 수정</button>
        <button>댓글 삭제</button>
        <img src="../images/report.png" alt="신고 이미지">
        </div>
        </div>
        <p class='section-comment-write content'>${response.comments[i].content}</p>
        <hr>
        </div>
        `;
        $(".section-comment").append(commentDiv);
      }
      pageN(response);
    },
    error: (state, err) => {
      console.log(state, err);
    },
  });
  // 댓글 가져오기 끝

  // 페이지네이션 이동 시작
  pn.click((e) => {
    const cNum = $(e.target).attr("class").slice(4);
    console.log(cNum + " -- ");
    sessionStorage.setItem("cNum", cNum);
    $.ajax({
      url: "http://localhost:8888/back/comments",
      data: `num=${num}&cNum=${sessionStorage.getItem("cNum")}`,
      success: (response) => {
        console.log(response);
        $(".section-comment-wrap").remove();

        for (let i = 0; i < response.comments.length; i++) {
          commentDiv = `
          <div class='section-comment-wrap'>
          <div class='section-comment-write'>
          <div>
          <div class='section-comment-write name'>${response.comments[i].member.name}</div>
          <div class='section-comment-write date'>${response.comments[i].createDate}</div>
          </div>
          <div>
          <button>댓글 수정</button>
          <button>댓글 삭제</button>
          <img src="../images/report.png" alt="신고 이미지">
          </div>
          </div>
          <p class='section-comment-write content'>${response.comments[i].content}</p>
          <hr>
          </div>
          `;
          $(".section-comment").append(commentDiv);
        }
        pageN(response);
      },
    });
  });

  const pageN = (response) => {
    $(".pagination").empty();
    // 페이지네이션
    if (response.startPage > 1) {
      pn.append(`
        <span class=page${response.startPage - 1}>이전</span>&nbsp;&nbsp;
      `);
    }
    for (let i = response.startPage; i <= response.endPage; i++) {
      pn.append(`
        <span class=page${i}>${i}</span>&nbsp;&nbsp;
      `);
    }
    if (response.totalPage > response.endPage) {
      pn.append(`
        <span class=page${response.endPage + 1}>다음</span>
      `);
    }
  };
  // 페이지네이션 이동 끝
});
=======
window.addEventListener("load", () => {});
>>>>>>> 09fd255ea2a3f1db1cf65b830b4073f6b180c1a5
