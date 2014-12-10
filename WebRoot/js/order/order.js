//取消订单
function closeOrder(orderId){
	$("#confirm").click(function(){
		var url=basePath+"/closeOrder.json";
		$.ajax({
			url : url,
			type : "get", //请求类型
			async : false,//默认true异步请求 ，false同步请求 
			data : {orderId:orderId},//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
			success : function(data) {
				if (500 == data) {
					//系统内部异常
					alert('系统内部异常');
				} else if (501 == data) {
					//用户未登录，请求被拦截
					alert('未登录');
				} else {
					//正确返回结果
					alert(data.result.result);
					$("#pay_"+orderId).attr("value","");
					$("#waitPay_"+orderId).html("交易关闭");
					$("#closeOrder_"+orderId).attr("value","");
					$("#empty_"+orderId).html(" ");
				}
			}
		});
	});
	
}
//确认收货
function confirmRecieve(orderChildId){
	var url=basePath+"/confirmRecieve.json";
	$.ajax({
		url : url,
		type : "get", //请求类型
		async : false,//默认true异步请求 ，false同步请求 
		data : {orderChildId:orderChildId},//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
		success : function(data) {
			if (500 == data) {
				//系统内部异常
				alert('系统内部异常');
			} else if (501 == data) {
				//用户未登录，请求被拦截
				alert('未登录');
			} else {
				//正确返回结果
				alert(data.result.result);
			}
		}
	});
}
//延时收货
function delaySignIn(id){
	var url=basePath+"/deleySignIn.json";
	$.ajax({
		url : url,
		type : "get", //请求类型
		async : false,//默认true异步请求 ，false同步请求 
		data : {id:id},//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
		success : function(data) {
			if (500 == data) {
				//系统内部异常
				alert('系统内部异常');
			} else if (501 == data) {
				//用户未登录，请求被拦截
				alert('未登录');
			} else {
				//正确返回结果
				alert(data.result.result);
			}
		}
	});
}