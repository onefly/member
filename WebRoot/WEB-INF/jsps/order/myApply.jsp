<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-免费申请</title>

	<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/meishi_backstage.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/datepicker/WdatePicker.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/countdown.js"></script>  
<script type="text/javascript">
	function searchList() {
		var url = "${pageContext.request.contextPath}/apply/getApplyDiv.htm";
		$.ajax({
			url : url,
			type : "post", //请求类型
			async : false,//默认true异步请求 ，false同步请求 
			data : $("#searchForm").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
			success : function(data) {
				if (500 == data) {
					//系统内部异常
					//alert('系统内部异常');
					popStatus(2, '系统错误！', 3);
				} else if (501 == data) {
					//用户未登录，请求被拦截
					//alert('未登录');
					popStatus(2, '请先登录！', 3);
				} else {
					//正确返回结果
					$("#applyDivList").html(data);
				}
			}
		});
	}

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
		<jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
		<div class="main">
			<p class="passw_wz">
				您现在位于：首页 &gt;&gt; 我的美试 <span>- 个人首页</span>
			</p>
			<!-- 个人中心公共头部开始 -->
			<c:import url="/user/usertop.htm"></c:import>
			<!-- 个人中心公共头部结束 -->
			<div class="indiv_bottom top25">
				<ul class="indiv_bl">
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>"><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>">个人资料</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.account")%>">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.order")%>" class="geren_bj">我的订单</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.refund")%>">我的退款</a></li>
       				<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.indemnity")%>">发货赔偿</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.comment")%>">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.report")%>">我的报告</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.collect")%>" >我的收藏</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exchange")%>">我的兑换</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.medal")%>">体验勋章</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.remind")%>">美试提醒</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.invite")%>">邀请好友</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.space")%>">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.safe")%>">安全中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.complaint")%>">投诉中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.help")%>">帮助中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exit")%>">退出</a></li>
				</ul>
				<div class="indiv_br fr">
					<div id="Tab1" class="data">
						<div class="Menubox">
							<ul>
								<li><a href="${pageContext.request.contextPath}/apply/getApplyList.htm" class="hover">试用申请单</a></li>
								<li><a href="${pageContext.request.contextPath}/freeOrder/getFreeOrderList.htm">免费试用订单</a></li>
								<li><a href="${pageContext.request.contextPath}/nakedOrder/getNakedOrderList.htm">裸价体验订单</a></li>
							</ul>
						</div>
						<div class="Contentbox fixed">
							<div id="con_one_1" class="two hover">
								<div class="feeling">
									
									 <form class="feeling_top" id="searchForm">
									 <input name="page.pageNum" type="hidden"
												id="hidden_currentPage" value="1">
									 
						                <label for="textfield">产品名称：</label>
						                <input type="text" name="productName" id="textfield" class="input_w210" />
						                <input type="button"   onclick="searchList();"  class="input_boredr_none icon_w80" value="搜索" />
						              </form>
									<div class="feeling_cent fixed" id="applyDivList">
										<!-- 申请单列表div页面 -->
										<jsp:include page="applyListDiv.jsp" />
									</div>
								</div>
							</div>
							<div id="con_one_2" class="two hover" style="display: none;">
								<!--免费试用列表div页面 -->

							</div>
							<div id="con_one_3" style="display: none;">
								<!-- 裸价体验列表div页面 -->

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>