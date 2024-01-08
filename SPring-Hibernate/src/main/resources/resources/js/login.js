function loginBtn(){
	var param = {
		username:$("#username").val(),
		
		pass:$("#pass").val()



		
	}
	var ser_data = JSON.stringify(param);
	
	$.ajax({
		type:"POST",
		contentType:'application/json; charset= UTF-8',
		url:'controlUser',
		data: ser_data,
		success: function(data){
			if(data=='OK'){
				//jquery ayfa yönlendirme işlemi
				$(location).attr('href', 'index');
			}else if(data=='ERROR'){
				alert('KUllanıcı adı ve şifrenizi kontrol edin!');
			}
			
		},error:function(data){
			alert(data);
		}
		
	}); 
}	