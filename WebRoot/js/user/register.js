$(function(){
	dateSelector.init("year","month","day");
	
	var validateObj=$("#register_form").Validform({
			tiptype:4,
			usePlugin:{
				passwordstrength:{
					minLen:6,
					maxLen:20
				}
			}

		}); 
	/*$("#refreshImg").click(function(){
		var number=Math.random();
		$("#validCode").attr("src","<%=rootPath %>/register/validcode.htm?number="+number);
		
	});*/
	
	$("#submit").click(function(){
		validateObj.check(false);
		
		var year=$("#year").val();
		
		var month=$("#month").val();
		
		var day=$("#day").val();
		
		var date=year+'/'+month+'/'+day;
		
		$("#brithday").val(date);
		/*var provinceName=$("#selectProv").val()!=null?$._cityInfo[$("#selectProv").val()].n:"";
		
		$("#provinceName").val(provinceName);
		var citys=$._cityInfo[$("#selectProv").val()].c;
		if(citys!=null)
			var cityName=$("#selectCity").val()!=null?citys[$("#selectCity").val()]:"";
		
		$("#cityName").val(cityName);*/
		//alert($("#s_province option:selected").text());  .test($("#password").val())    $("#passwdStrength").val(0);
		$("#provinceName").val($("#s_province option:selected").text());
		$("#cityName").val($("#s_city option:selected").text());
		
		if(/[a-zA-Z]+/.test($("#password").val()) 
				&& /[0-9]+/.test($("#password").val()) 
				&& /\W+\D+/.test($("#password").val())){
			//密码强度为强
			$("#passwdStrength").val(2);
		}else if(/[a-zA-Z]+/.test($("#password").val()) 
				|| /[0-9]+/.test($("#password").val()) 
				|| /\W+\D+/.test($("#password").val())){
			if(/[a-zA-Z]+/.test($("#password").val()) && /[0-9]+/.test($("#password").val())) {
				$("#passwdStrength").val(1);
                
            }else if(/\[a-zA-Z]+/.test($("#password").val()) && /\W+\D+/.test($("#password").val())) {
            	//密码安全性为中
            	$("#passwdStrength").val(1);
                
            }else if(/[0-9]+/.test($("#password").val()) && /\W+\D+/.test($("#password").val())) {
            	//密码安全性为中
            	$("#passwdStrength").val(1);
                
            }else{
            	//密码安全性为弱
            	$("#passwdStrength").val(0);
            }
		}	
		if(!$("#agree").attr("checked"))
			alert("请阅读美试协议");
		else
			$("#register_form").submit();
	});
	_init_area();


	//$.initProv("#selectProv","#selectCity");
});