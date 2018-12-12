<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
function reviewlist(){
	$.ajax({
		url: 'reviews/reviewlist',
		data: {movieId : 451922},
		dataType:'json',
		success: function(reviewlist){
			//javascript에서 for in 은 인덱스로만 반복된다. 
		}
	})
}

//jquery에서 문서가 시작되자 마자 수행 
$(function(){
	reviewlist()
})

</script>
</html>