function checkAge() {
	var ageBox = document.ageForm.age;
	var ageValue = ageBox.value;

	if (ageValue != "") {
		if (!isNaN(ageValue)) {
			if (ageValue >= 19) {
				if (confirm("정말로 성인 사이트 ㄱㄱ?"))
					location.href = "adult.jsp?age=" + ageValue;
			} else {
				alert("미성년자 입장불가임ㅋ");
			}
		} else {
			alert("숫자를 입력하세요");
		}
	} else {
		alert("나이를 입력해야지?");
	}
	ageBox.value = "";
	ageBox.focus();
}
