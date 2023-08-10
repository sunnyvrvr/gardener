$(() => {	
	const backURL = "http://localhost:8888/back";
	//필명 입력란 객체찾기
	const inputNameObj = $('form.find-loginId>input[name=name]')

	//이메일 입력란 객체찾기
	const inputEmailObj = $('form.find-loginId>input[name=email]')

	//아이디 찾기 버튼 객체 찾기
	const btFindLoginId = $('form.find-loginId button.bt-find-id')


	btFindLoginId.click(() => {
		const name = $("input[name='name']").val();
		const email = $("input[name='email']").val();
		$.ajax({
			url: 'http://localhost:8888/back/findloginid',
			method: 'post',
			data: { 'name': name, email: email },
			success: (responseData) => {
				if (responseData != '0') {
					alert('고객님의 아이디는 ' + responseData + ' 입니다')
					location.href =`${backURL}/front/html/login.html`
				} else {
					alert('잘못된 정보입니다, 다시 입력해주세요')
				}
			},
			error: ()=> {
				alert("에러발생~~~~")
			}
		})
		return false;
	})
})


