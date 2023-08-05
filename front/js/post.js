$(() => {
  $.ajax({
    url: "http://localhost:8888/back/post?num=40",
    success: (response) => {
      const a = response.content
        .replace(
          /!\[\]\((https:\/\/i\.imgur\.com\/[a-zA-Z0-9]+\.[a-z]+)\)/g,
          '<img src="$1" alt=""/>'
        )
        .replace(/\n/g, "<br>");
      console.log(response);
      $(".section-header-main-title").text(response.mainTitle);
      $(".section-header-main-subtitle").text(response.subTitle);
      $(".main-image").css("background-image", `url(${response.mainTitleImg})`);
      $(".section-header-info-date").text(response.createPost.substring(0, 19));
      $("article").html(a); // 개행문자 가져오기
      $(".section-header-icon span").text(response.favorite);
      $(".writer-profile-name").text(response.member.name);
      $(".writer-profile-intro").text(response.member.intro);
      $(".writer-profile-intro").text(response.member.intro);
      $(".writer-profile-pic > img").attr("src", response.member.profile);
    },
  });
});
