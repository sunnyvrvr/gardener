$(() => {
  let clickStatus = 0;

  const btnClick = () => {
    const inputs = document.querySelectorAll("input");

    if (clickStatus === 0) {
      // 정보 수정 가능한 상태로 변경
      for (let input of inputs) {
        if (input.id !== "joinDate") {
          // 가입날 필드는 수정 불가능하도록 처리
          input.removeAttribute("readonly");
        }
      }
      $(".modifybtn.btn").text("정보 완료");
      clickStatus = 1;
    } else if (clickStatus === 1) {
      // 정보 읽기 전용 상태로 변경
      for (let input of inputs) {
        input.setAttribute("readonly", true);
      }
      $(".modifybtn.btn").text("정보 수정");
      clickStatus = 0;
    }
  };

  // 정보 수정 버튼 클릭 시 이벤트 연결
  $(".modifybtn.btn").on("click", btnClick);

  // 초기 상태에서 가입날 필드를 읽기 전용으로 만들기
  $("#joinDate").prop("readonly", true);
});
