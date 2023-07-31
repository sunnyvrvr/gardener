$(() => {
  const pTag = $("<p><br></p>");
  const imgBtn = $("div.img-pic>input");
  const articleDiv = $("div[name=article]");

  // 에디터 첫 줄 예외처리
  articleDiv.click(() => {
    console.log(articleDiv.contents().first().prevObject[1]);
  });

  // 이미지 버튼 클릭시
  imgBtn.change((e) => {
    const img = e.target.files[0];
    const imgTag = $("<img>");

    if (!img) {
      alert("파일이 없다.");
      return;
    }

    // 이미지 읽기
    const reader = new FileReader();
    reader.readAsDataURL(img);
    reader.onload = (e) => {
      imgTag.attr("src", e.target.result);
      articleDiv.append(imgTag);
    };
  });
});

// 이미지를 중앙정렬 할 div
