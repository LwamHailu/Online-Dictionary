<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>WAP Dictionary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/dict.css">

<script   
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>

	$(document).ready(
			function() {

				$("#lookUp").click(function() {
				
					search();
				});

				function search() {
					$.ajax({
						url : "./DictServlet",
						type : "POST",
						dataType : "json",
						data : {
							word : $("#searchWord").val()
						},
						success : function(resultData) {
							$("#list").html("");
							
							if (resultData.length === 0) {
								
								$("#list").append("<em>No Matching Word Found!</em>");
								
							} else {
								var output = "";
								$.each(resultData, function(index, value) {
									if (value['wordType'] === "") {
										output = output + "<li>()    ::   "
												+ value['definition'] + "</li>";
									} else {
										output = output + "<li>("+ value['wordType'] + ")    ::   "
												+ value['definition'] + "</li>";
												
									}
								});
								$("#list").append(output);
							}
						},
						error : function() {
							$("#result").html("Error");
						}

					});
				}
			});
</script>
</head>
<body>
	<div class="main">
		<h1>Online Dictionary</h1>
		<p>
			Word:<input type="text" id="searchWord" name="inputWord" value="halloo">
			 <input type="button" id="lookUp" value="LookUp">
		</p>
		<div id="result">
			<ol id="list">
			</ol>
		</div>
		<div class="validators">
		<a href="http://validator.w3.org/check/referer"><img
			src="img/w3c-html.png" alt="Valid HTML5" /></a> <br /> <a
			href="http://jigsaw.w3.org/css-validator/check/referer"><img
			src="img/w3c-css.png" alt="Valid CSS" /></a> <a
			href="https://webster.cs.washington.edu/jslint/?referer"> <img
			src="https://webster.cs.washington.edu/w3c-js.png" alt="Valid JS" />
		</a>
	</div>
	</div>
</body>
</html>