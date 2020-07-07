<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Chat with BOT</title>

</head>
<body>
 <table style=" width:100%" >
<tr >
	<td style="width:50%">this is place for a picture BotAI</br>
		<img src="picture/download.jpg" width="200px" height="200px" align="centre">
	</td>
	<td ><form action="restar">
		<input style="width=50% height:50%"  type="submit" value="RESTAR">
	</form></td>
</tr>
<tr>
	<td><%= session.getAttribute("answer") %></td>
	<td><form action="hello" method="post">
		human word : <input type="text" name="human">
		<input type="submit" name="sub" value="send">
		
	</form>
	</td>
	
</tr>
	
</table>

</body>
</html>