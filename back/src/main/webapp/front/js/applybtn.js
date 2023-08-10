$(document).ready(() => {
  // ... (이전 코드 생략)

  // 작가 신청 버튼 클릭 시
  $(".cancelbtn.btn").on("click", function () {
    // 작가 신청 페이지로 이동
    window.location.href = "apply.html";
  });
});
