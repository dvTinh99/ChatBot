<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="utf-8">
	<title>Flat design chatbot</title>
	<script src="jquery-3.5.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="style.css">
	
</head>
<body>
 <div class="chatbot">
 	<div class="chatlogs" id="chatlogs">
 	

 	</div>

 	<form id="mesageForm" >
 	<div class="chat-form">
 		<textarea id="message" name ="human"></textarea>
 		 <button id="submit" type="submit" name="sub" >Send</button>
 		<!--  <button type="submit" name="sub" onclick="callSevlet('POST')">Send</button>  -->
 	</div>
 	</form>
 </div>
 <script src="main.js"> </script>
 
 <script>
 $(document).ready(function(){
	 $('#submit').click(function () {
		 var chat = document.getElementById("message").value;
		 var html = "<div id = \"chat_self\" class=\"chat self\">"
			 +"<p class=\"chat-message\">";
		    html+=chat;
		    html+="</p> </div> ";
		    document.getElementById("chatlogs").innerHTML+=html;
	    document.getElementById('message').value=" ";
	    $.ajax({
			type:'POST',
			data:{human: chat},
			url:'AjaxController',
			success: function(result){
				var html = "<div id = \"chat_friend\"class=\"chat friend\">"
					+"<div class=\"user-photo\"><img src=\"picture/download.jpg\"></div>"+
					"<p class=\"chat-message\">";
			    html+=result;
			    html+="</p> </div>";
			    document.getElementById("chatlogs").innerHTML+=html;
			}
		})
	    return false;
	   });	
 })
 
 

</script>
</body>
</html>