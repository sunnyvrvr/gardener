document.addEventListener("DOMContentLoaded", function () {
  const deleteBtn = document.querySelector(".deletebtn");

  deleteBtn.addEventListener("click", function () {
    const confirmation = confirm("회원탈퇴 하시겠습니까?");

    if (confirmation) {
      const url = "http://localhost:8888/back/deletemember"; // 탈퇴 처리를 위한 서버 엔드포인트 URL

      // AJAX 요청 생성
      const xhr = new XMLHttpRequest();
      xhr.open("POST", url, true);
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
          // 탈퇴 성공시
          alert("회원탈퇴가 완료되었습니다.");
          // 원하는 추가 동작 수행 (예: 로그아웃 등)
        } else if (xhr.readyState === XMLHttpRequest.DONE) {
          // 탈퇴 실패시
          alert("회원탈퇴를 실패했습니다.");
        }
      };

      // 사용자 ID를 데이터로 담아 AJAX 요청 보냄 (userId는 회원 식별용 아이디)
      xhr.send("userId=" + encodeURIComponent(userId));
    }
  });
});
