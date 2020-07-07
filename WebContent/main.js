/*
    một số hàm built-in
    1.Alert
    2.Console
    3.Confirm : xuất hiện form với 2 lựa chọn cancel và ok
    4. Prompt : xuất hiện form với 2 lựa chọn cancel và ok và 1 input type text
    5.Set timeout: thực thi 1 function sau khoảng time nhất định(ms)
    6.Set interval: thực thi liên tục 1 function sau khoảng time nhất định(ms)
*/
function sendMessage(message){
    //get message
    var html = "<p class=\"chat-message\">";
    html+=message;
    html+="</p>";
    document.getElementById("chat_self").innerHTML+=html;
   }
function takeMessage(chat){
	$.ajax({
		type:'POST',
		data:{human: chat},
		url:'AjaxController',
		success: function(result){
			console.log(result);
			
		}
	})
}
function callSevlet(methodType){
    document.getElementById('mesageForm').action='jsCallLib';
    document.getElementById('mesageForm').method= methodType;
    document.getElementById('mesageForm').submit;
}
let input =document.querySelector('textarea');
input.addEventListener('keyup',(e) =>{
    if(e.keyCode===13){
        console.log(e.target.value);
        sendMessage();
        document.getElementById("message").value=" ";
    }
})
