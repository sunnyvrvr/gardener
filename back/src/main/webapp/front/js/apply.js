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
$(document).ready(function () {
  $(".apply-btn").on("click", function () {
    $.ajax({
      url: "http://localhost:8888/back/apply",
      type: "POST",
      success: function(response) {
    if (response === true) {
        console.log("작가 정보 등록 성공");
        alert("제출이 완료되었습니다");
    } else {
        console.log("작가 정보 등록 실패");
        alert("제출에 실패하였습니다");
    }
   },
     error: function(error) {
    console.error("Failed to send data to the server:", error);
    alert("제출에 실패하였습니다");
     }
    });
  });
});
