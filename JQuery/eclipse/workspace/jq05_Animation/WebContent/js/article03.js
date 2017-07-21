$(function(){
	// 1. 두 번째 p 태그를 지정해서 변수 firstP에 할당
	var firstP = $('p:eq(1)');
	
	// 2. a 태그 클릭하면 firstP의 내용 보였다가 안 보였다가 해보기
	$('a.more').click(function(){
		if(firstP.is(':hidden')){ 	// firstP의 내용이 안 보인다면
			firstP.slideToggle('slow');
			$(this).html('Read less');
		}else{		// firstP의 내용이 보인다면
			firstP.slideToggle('slow');
			$(this).html('Read more');
		}
	}); // click()
	
	// 3. 버튼 누르면 글자 크기 변하게 해보기
	var speech = $('div.speech');
	var defaultSize = speech.css('fontSize');
	// alert(defaultSize);	--> 19.2px
	
	var num = parseInt(defaultSize, 10);
	// alert(num) --> 19
	
	$('#switcher>button').click(function(){
		switch(this.id){		// 클릭된 것(?)의 id 가져올 수 있음
		case 'switcher-large':	// switcher-large 클릭할 때마다 폰트 크기 5씩 증가
			num += 5;
			break;
		case 'switcher-small':	// switcher-small 클릭할 때마다 폰트 크기 5씩 감소
			num -= 5;
			break;
		default:	// switcher-default 클릭하면 default 폰트 사이즈로
			num = parseInt(defaultSize, 10);
		}
		
		$('.speech').animate({fontSize: num + 'px'}, 'fast');	// num으로 fontSize 변화
	}) // click()
});	// function()
