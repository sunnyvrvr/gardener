$(() => {
  console.log("먼데");
  $.ajax({
    url: "http://localhost:8888/back/post?num=39",
    success: (response) => {
      console.log(response);
      $(".section-header-main-title").text(response.mainTitle);
      $(".section-header-main-subtitle").text(response.subTitle);
      $(".section-header-info-date").text(response.createPost.substring(0, 19));
      $("article").html(response.content.replace(/\n/g, "<br>")); // 개행문자 가져오기
      $(".section-header-icon span").text(response.favorite);
    },
  });
});
