$(() => {
  const imgBtn = $("input[name='image']");

  imgBtn.change((e) => {
    const reader = new FileReader();
    const file = e.target.files[0];
    console.log(file);
    reader.readAsDataURL(file);
    reader.onload = () => {
      $(".main-image").css("background-image", `url(${reader.result})`);
    };

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
        console.log(response);
      },
    });
  });
});
