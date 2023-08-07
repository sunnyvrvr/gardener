document.addEventListener("DOMContentLoaded", function () {
  const cancelWriterButton = document.querySelector(".cancelbtn");

  cancelWriterButton.addEventListener("click", function () {
    const confirmation = confirm("작가를 취소하시겠습니까?");

    if (confirmation) {
      const url = "http://localhost:8888/back/cancel";
      const userId = "30";

      // 작가 취소를 서버로 보내기 위해 AJAX 요청을 생성합니다
      const xhr = new XMLHttpRequest();
      xhr.open("POST", url, true);
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
          alert("작가가 취소되었습니다.");
        } else if (xhr.readyState === XMLHttpRequest.DONE) {
          alert("작가 취소를 실패했습니다.");
        }
      };

      // 사용자 ID를 데이터로 담아 AJAX 요청을 보냅니다
      xhr.send("userId=" + encodeURIComponent(30));
    }
  });
});
