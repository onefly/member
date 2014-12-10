<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type"  content="text/html; charset=utf-8" />
<title>个人中心-我的订单</title>
<link href="<%=basePath %>/style/public.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/style/Individual_center.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/style/base.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/style/meishi_backstage.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="<%=basePath %>/js/user/jQuery-jcDate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/order/order.js"></script>

<script type="text/javascript">
/* 
	//发送按钮的onclick事件
	function send(){
		var content = $("#iptContent").val();//获取文本域的内容
		$("#Layer2").setInterVal(content);//将内容显示在div里面
		location.reload();//刷新页面
	} */
	
/* 	//日期选择插件
	$(document).ready(function(){
		$("input.jcDate").jcDate({
			IcoClass : "jcDateIco",
			Event : "click",
			Speed : 100,
			Left : 0,
			Top : 28,
			format : "-",
			Timeout : 100
		});
	}); */
	
/* 	//下拉列表
	function funcInitSel(e) {
		var objUL = e.getElementsByTagName("ul")[0];
		document.onclick = function() {
			if (e.getAttribute("state") == "0")
				objUL.style.display = "none";
		}
	
		var objTxt = e.getElementsByTagName("input")[0];
		var arrLi = objUL.getElementsByTagName("li");
	
		for (var i = 0; i < arrLi.length; i++) {
			arrLi[i].onmouseover = function() {
				this.className = "on";
			}
			arrLi[i].onmouseout = function() {
				this.className = "";
			}
	
			arrLi[i].onclick = function() {
				objTxt.value = this.innerHTML;
				e.setAttribute("state", 0);
				objUL.style.display = "none";
			}
		}
	}
	
	function funcSel(e) {
		var objUL = e.getElementsByTagName("ul")[0];
		if (objUL.style.display == "none" && e.getAttribute("state") == "1") {
			objUL.style.display = "";
		}
		if (e.offsetWidth > objUL.offsetWidth) {
			objUL.style.width = e.offsetWidth - 2 + "px";
		}
	}
	
	function funcSetOn(e, v) {
		if (e.getAttribute("state") == "") {
			funcInitSel(e);
		}
		e.setAttribute("state", v);
	} */
	
	//选项卡切换
/* 	function setTab(name, cursel, n) {
		for (i = 1; i <= n; i++) {
			var menu = document.getElementById(name + i);
			var con = document.getElementById("con_" + name + "_" + i);
			menu.className = i == cursel ? "hover" : "";
			con.style.display = i == cursel ? "block" : "none";
		}
	} */
	
	//搜索按钮功能
	function searchList() {
		var url = "${pageContext.request.contextPath}/freeOrder/getFreeOrderDiv.htm";
		$.ajax({
			url : url,
			type : "post", //请求类型
			async : false,//默认true异步请求 ，false同步请求 
			data : $("#searchForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
			success : function(data) {
				if (500 == data) {
					//系统内部异常
					alert('系统内部异常');
				} else if (501 == data) {
					//用户未登录，请求被拦截
					alert('未登录');
				} else {
					//正确返回结果
					$("#orderDivList").html(data);
				}
			}
		});
	}
	
	//分页展示
	function toThisPage(all) {
		var target = $('#currentPage').val();
		$("#hidden_currentPage").val(target);
		if (0 < target && target <= all) {
			searchList();
		} else {
			popStatus(2, '无效字符！', 3);
		}
	}
	function toShowPage(page) {
		$("#hidden_currentPage").val(page);
		var all = $("#hidden_allPage").val();
		if (0 < page && page <= all) {
			searchList();
		} else {
			popStatus(2, '无效字符！', 3);
		}
	}
	
	//提交报告按钮
	function toReport(id){
		alert(id);
		location = '<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/report/toFillReport.htm?orderChildId='+id;
	}
	
</script>
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
		font-family: "微软雅黑";
		font-size: 12px;
		color: #555555;
		list-style: none;
	}
</style>
<body class="white">
<div id="wapper">

 <!-- 引入美试网公共头 -->
 <jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
 
  <div class="main">
    <p class="passw_wz">您现在位于：首页 >> 我的美试 <span>- 我的订单</span></p>
    
    	<%-- 引入公共头  --%>
	  	<c:import url="/user/usertop.htm"/>
	  	<%-- 引入公共头结束  --%>
	  	
    <div class="indiv_bottom top25">
      <ul class="indiv_bl">
        <li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>"><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>">个人资料</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.account")%>">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.order")%>" class="geren_bj">我的订单</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.comment")%>">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.collect")%>" >我的收藏</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exchange")%>">我的兑换</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.medal")%>">体验勋章</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.remind")%>">美试提醒</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.invite")%>">邀请好友</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.space")%>">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.safe")%>">安全中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.help")%>">帮助中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exit")%>">退出</a></li>
      </ul>
      <div class="indiv_br fr">
        <div id="Tab1" class="data">
          <div class="Menubox">
            <ul>
              <li><a href="${pageContext.request.contextPath}/apply/getApplyList.htm" >试用申请单</a></li>
			  <li><a href="${pageContext.request.contextPath}/freeOrder/getFreeOrderList.htm" class="hover">免费试用订单</a></li>
			  <li><a href="${pageContext.request.contextPath}/nakedOrder/getNakedOrderList.htm" >裸价体验订单</a></li>
            </ul>
          </div>
          <div class="Contentbox fixed">
            <div id="con_one_1" class="two hover" >
             <div id="con_one_2" class="two hover" >
              <div class="feeling">
                <div class="feeling_top">
                <form action="" id="searchForm">
	              <form action="" id="searchForm">
	                <!-- 为方便查询增加的当前页面值 -->
	                <input name="pageNum" type="hidden" id="hidden_currentPage" value="1">
	                  <label for="textfield">商品名称：</label>
					  <input type="text" name="productName" id="textfield" class="input_w210" />
					  <input type="button"   onclick="searchList();"  class="input_boredr_none icon_w80" value="搜索" />
                  </form>
                </div>
                <div class="feeling_cent fixed" id="orderDivList">
                  <!-- 裸价体验列表展示div -->
                  <jsp:include page="freeListDiv.jsp" />
                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>