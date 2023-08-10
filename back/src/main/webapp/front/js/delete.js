document.addEventListener("DOMContentLoaded", function () {
  const deleteBtn = document.querySelector(".deletebtn");

  deleteBtn.addEventListener("click", function () {
    const confirmation = confirm("회원탈퇴 하시겠습니까?");
    
    if (confirmation) {
      const url = "http://localhost:8888/back/deletemember";
      const loginId = document.getElementById("loginId").value; // 사용자 ID를 가져옴
      
      const xhr = new XMLHttpRequest();
      xhr.open("POST", url, true);
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
          // 탈퇴 성공시
          alert("회원탈퇴가 완료되었습니다.");
          window.location.href = "index.html";
        } else if (xhr.readyState === XMLHttpRequest.DONE) {
          // 탈퇴 실패시
          alert("회원탈퇴를 실패했습니다.");
        }
      };
      
      xhr.send("loginId=" + encodeURIComponent(loginId));
    }
  });
});