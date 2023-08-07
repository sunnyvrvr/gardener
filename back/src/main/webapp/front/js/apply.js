/* apply 자료첨부 주소 추가란 만들기*/
$(document).ready(function () {
  $("#createButton").on("click", function () {
    var inputElement = $(
      "<input class='uri' name='uri' placeholder='주소를 입력해 주세요.' >"
    );
    $("#container").append(inputElement);
  });
});

/* 작가신청 제출하기 */
$(document).ready(() => {
  $(".apply-btn").on("click", () => {
    // 작가 소개
    const introduce = $("textarea[name='introduce']").val();

    // 활동 계획
    const plan = $("textarea[name='plan']").val();

    // 작가 자료 URI 배열
    const uris = [];
    $("input[name='uri']").each(function () {
      const uri = $(this).val().trim();
      if (uri !== "") {
        uris.push(uri);
      }
    });

    const data = {
      introduce: introduce,
      plan: plan,
      uris: uris,
    };

    $.ajax({
      url: "http://localhost:8888/back/apply", // 실제 서버 주소를 넣어주세요.
      type: "POST",
      data: JSON.stringify(data),
      contentType: "application/json; charset=utf-8",
      success: (response) => {
        // 성공적으로 요청이 처리되었을 때 실행할 콜백 함수
        alert("제출이 완료되었습니다");
        console.log("Data successfully sent to the server!");
        
        console.log(response); // 서버에서 보낸 응답 확인
      },
      error: (error) => {
        // 요청이 실패했을 때 실행할 콜백 함수
        console.error("Failed to send data to the server:", error);
      },
    });
  });
});
