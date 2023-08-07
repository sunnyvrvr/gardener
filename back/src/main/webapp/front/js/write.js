$(() => {
  let imgs = [];

  // 본문 메인 이미지 선택 시작
  const imgBtn = $("input[name='image']");
  imgBtn.change((e) => {
    const reader = new FileReader();
    const file = e.target.files[0];
    console.log(file);

    reader.readAsDataURL(file);
    reader.onload = () => {
      let formData = new FormData();
      formData.append("image", file);
      $.ajax({
        url: "https://api.imgur.com/3/image",
        method: "POST",
        contentType: false,
        processData: false,
        data: formData,
        headers: {
          Authorization: "Bearer 09d9c70a8bda2147f06c4c8b2885ee00e4e9f5c9",
          Accept: "application/json",
        },
        success: (response) => {
          $(".main-image").css(
            "background-image",
            `url(${response.data.link})`
          );
        },
      });
    };
  });
  // 본문 메인 이미지 선택 끝

  // 본문에서 이미지 선택 시작

  const editor = new toastui.Editor({
    el: document.querySelector("#editor"),
    height: "600px",
    initialEditType: "markdown",
    initialValue: "내용을 입력해 주세요.",
    previewStyle: "vertical",
    hooks: {
      addImageBlobHook: (blob, cb) => {
        console.log(imgs.length);
        if (imgs.length > 2) {
          swal("사진은 5장 까지만 가능합니다.", "", "error");
          return;
        }

        let formData = new FormData();
        formData.append("image", blob);
        console.log(formData);
        $.ajax({
          url: "https://api.imgur.com/3/image",
          method: "POST",
          processData: false,
          contentType: false,
          headers: {
            Authorization: "Bearer 09d9c70a8bda2147f06c4c8b2885ee00e4e9f5c9",
            Accept: "application/json",
          },
          data: formData,
          success: (response) => {
            imgs.push({ contemt: response?.data?.link });
            console.log(response);
            cb(response.data.link);
          },
          error: (status) => {
            console.log(status);
          },
        });
      },
    },
  });

  // 본문에서 이미지 선택 끝

  $("div.post-btn").click(() => {
    const form = $("form");
    const jsonData = form.serialize();
    const content = editor.getMarkdown();
    const mainImage = $(".main-image").css("background-image");
    const mainImgUrl = mainImage.slice(
      mainImage.indexOf('"') + 1,
      mainImage.lastIndexOf('"')
    );

    const formData = new FormData();
    formData.append("jsondata", jsonData);
    formData.append("content", content);
    formData.append("mainImage", mainImgUrl);

    $.ajax({
      url: "http://localhost:8888/post",
      method: "get",
      processData: false,
      contentType: false,
      data: formData,
      success: (response) => {
        console.log(response, "--");
        sessionStorage.setItem("name", response);
      },
    });
  });
});
