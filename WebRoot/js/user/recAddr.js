$(function(){
	$.formValidator.initConfig({submitButtonID:"subAddr",
		onError:function(msg,obj,errorlist){},
		onSuccess:function(){
			var _id = $("#recieveAddressId").val();
			if(_id){
				ajaxSub(basePath+"/user/modifyRecAddr.htm");
			}else{
				if($("#tb tr").length>=4){
					alert("收货地址最多仅能保存3个");
				}else{
					ajaxSub(basePath+"/user/addRecAddr.htm");
				}
			}
		}
	});
	$("#recieveName").formValidator({empty:false,onShow:" ",onFocus:"请输入收货人姓名",onCorrect:" "})
		.inputValidator({min:2,max:10,onError:"收货人姓名为2-10个字符"})
		.regexValidator({regExp:"str",onError:"收货人姓名中含有非法字符",dataType:"enum"});
	$("#address").formValidator({empty:false,onShow:" ",onFocus:"请输入街道地址",onCorrect:" "})
		.inputValidator({min:1,max:100,onError:"街道地址不能大于100个字符"})
		.regexValidator({regExp:"str",onError:"街道地址含有非法字符",dataType:"enum"});
	$("#zipCode").formValidator({empty:true,onShow:" ",onFocus:"请输入邮政编码",onCorrect:" ",onEmpty:""})
		.regexValidator({regExp:"zipcode",onError:"邮政编码输入不对",dataType:"enum"});
	$("#recieveMobilephone").formValidator({empty:false,onShow:" ",onFocus:"请输入手机号码",onCorrect:" "})
		.regexValidator({regExp:"mobile",onError:"手机号码输入不对",dataType:"enum"});
	$("#recieveTelephone").formValidator({empty:true,onShow:" ",onFocus:"请输入固定电话",onCorrect:" ",onEmpty:""})
		.regexValidator({regExp:"tel",onError:"固定电话输入不对",dataType:"enum"});
	$("#s_county").formValidator({
		validatorGroup:"1",
		tipID:"areaTip",
		onShow:" ",
		onFocus:" ",
		onCorrect:" "
	}).functionValidator({
	    fun:function(val,elem){
	    	if(val=="0"){
	    		return "请选择区域";
	    	}else if($("s_province").val()=="0"||$("#s_city").val()=="0"){
	    		return "请选择区域";
	    	}else{
	    		return true;
	    	}
		}
	});
})

_init_area();

function ajaxSub(_url){
	setAreaName();
	jQuery.ajax({
        url: _url,  // 提交的页面
        data: $('#addrForm').serialize(), // 从表单中获取数据
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        type: "POST",                    // 设置请求类型为"POST"，默认为"GET"
        error: function(request) {      // 设置表单提交出错
        	
        },
        success: function(data) {		// 设置表单提交完成使用方法
        	if(data==1){
        		window.location = basePath+"/user/toRecAddr.htm";
        	}else{
        		alert("新增失败");
        	}
       	}
	});
}

function delAddr(id){
	if(confirm('你确定要删除吗？')){
		$.get(basePath+"/user/deleteRecAddr.htm",{id:id,r:Math.random()},function(data){
			if (data == 1) {
				window.location = basePath+"/user/toRecAddr.htm";
			}else{
				alert("删除失败");
			}
		});
	}
}

function updateAddr(id){
	$.get(basePath+"/user/getRecAddr.json",{id:id,r:Math.random()},function(data){
			$("#recieveAddressId").val(data.addr.recieveAddressId);
			$("#recieveName").val(data.addr.recieveName);
			$("#provinceName").val(data.addr.provinceName);
			$("#cityName").val(data.addr.cityName);
			$("#districtName").val(data.addr.districtName);
			$("#address").val(data.addr.address);
			$("#zipCode").val(data.addr.zipCode);
			$("#recieveMobilephone").val(data.addr.recieveMobilephone);
			$("#recieveTelephone").val(data.addr.recieveTelephone);
			$("#addrTitle").text("修改");
			if(data.addr.isDefaultAddress==1){
				$("#isDefaultAddress").attr("checked",true);
			}else{
				$("#isDefaultAddress").attr("checked",false);
			}
			_init_area(data.addr.province,data.addr.city,data.addr.district);
	});
}

/*给地区赋值*/
function setAreaName(){
	$("#provinceName").val($("#s_province option:selected").text());
	$("#cityName").val($("#s_city option:selected").text());
	$("#districtName").val($("#s_county option:selected").text());
}