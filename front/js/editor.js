const editor = new toastui.Editor({
  el: document.querySelector("#editor"),
  height: "600px",
  initialEditType: "markdown",
  initialValue: "내용을 입력해 주세요.",
  previewStyle: "vertical",
  hooks: {
    addImageBlobHook: (blob, cb) => {
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
$("div.post-btn").click(() => {
  console.log(editor.getHTML());
});
