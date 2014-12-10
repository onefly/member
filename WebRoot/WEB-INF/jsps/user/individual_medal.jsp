<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-体验勋章</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="<%=basePath%>/js/common/jquery-1.7.min.js"></script>
<script type="text/javascript">

	function toCurrentPage() {
		var target = $('#currentPage').val();
		var all = ${totalPages};
		if(0 < target && target <= all){
			location = "<%=basePath%>/medal/getAllMedal.htm?page=" + target;
		} else {
			$('#currentPage').attr("value", "");
			alert('无效字符');
		}
	}
</script>
</head>

<body class="white">
	<jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
	<div id="wapper">
		<div class="main">
			<p class="passw_wz">
				您现在位于：首页 >> 我的美试 <span>- 个人首页</span>
			</p>

			<c:import url="/user/usertop.htm"></c:import>

			<div class="indiv_bottom top25">

				<!-- 个人中心左边 -->
				<ul class="indiv_bl">
					<li><a href="#"><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}/user/profile.htm">个人资料</a></li>
					<li><a href="<%=basePath%>/user/accountRecord/getRecord.htm?page=1">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}/apply/getApplyList.htm">我的订单</a></li>
					<li><a href="#">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}/collect/getCommodityCollect.htm">我的收藏</a></li>
					<li><a href="#">我的兑换</a></li>
					<li><a href="${pageContext.request.contextPath}/user/medal/getAllMedal.htm?page=1"
						class="geren_bj">体验勋章</a></li>
					<li><a href="#">美试提醒</a></li>
					<li><a href="${pageContext.request.contextPath}/user/inviteFriends.htm">邀请好友</a></li>
					<li><a href="#">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}/safety/toSafety.htm">安全中心</a></li>
	        		<li><a href="#">投诉中心</a></li>
					<li><a href="#">帮助中心</a></li>
					<li><a href="${pageContext.request.contextPath}/user/logout.htm">退出</a></li>
				</ul>
				<div class="indiv_br fr">
					<div class="medal fixed">
						<div class="medal_top fixed">
							<div class="medal_top_left">
								<span>体验品牌：<em>${count}</em></span><span>共获体验勋章：<em>${totalCount}</em></span>
							</div>
							<div class="medal_top_cent">
								<form
									action="${pageContext.request.contextPath}/user/medal/getAllMedal.htm?page=1"
									method="post" id="brand">
									<input name="key" type="text" class="ssuo" value="${key}" />
								</form>
								<a href="javascript:document.getElementById('brand').submit()">搜索</a>
							</div>
							<div class="medal_top_right">
								<a href="#">如何获得勋章？</a>
							</div>
						</div>
						<div class="medal_cent">
							<ul>
								<c:if test="${not empty list }">
									<!-- 遍历输出 -->
									<c:forEach items="${list }" var="p">
										<li><a href="#"><img
												src="<%=imagePath%>/${p.logoUrl}" width="140" height="140" /></a>
											<span>
												<p class="fize14">${p.brandName}</p>
												<p class="fize12">
													已获勋章：<em>${p.medalCount }</em>枚
												</p>
										</span></li>

									</c:forEach>
								</c:if>
								<c:if test="${ empty list }">
									<em>没有数据啊！亲</em>
								</c:if>
							</ul>
						</div>
						<div class="medal_bottom">
							<em>小贴士：品牌勋章积攒越多，申请免费体验成功概率越高哦！</em>
							<div class="yahoo">
								<c:if test="${not empty list }">
									<c:if test="${currentPage > 1}">
										<a
											href="<%=basePath%>/user/medal/getAllMedal.htm?page=${currentPage-1}">&lt;</a>

									</c:if>
									<c:if test="${currentPage <= 1}">
										<span class="disabled"> &lt; </span>
									</c:if>
									<c:if test="${currentPage<=5}">
										<c:forEach var="i" begin="1" end="${10}" step="1">
											<c:if test="${i<=totalPages}">
												<c:if test="${currentPage==i}">
													<span class="current">${currentPage}</span>
												</c:if>
												<c:if test="${currentPage!=i}">
													<a
														href="<%=basePath%>/user/medal/getAllMedal.htm?page=${i}">${i}</a>
												</c:if>
											</c:if>
										</c:forEach>
									</c:if>

									<c:if test="${currentPage>5}">
										<c:forEach var="i" begin="${currentPage-5}"
											end="${currentPage+5}" step="1">
											<c:if test="${i<=totalPages}">
												<c:if test="${currentPage==i}">
													<span class="current">${currentPage}</span>
												</c:if>
												<c:if test="${currentPage!=i}">
													<a
														href="<%=basePath%>/user/medal/getAllMedal.htm?page=${i}">${i}</a>
												</c:if>
											</c:if>
										</c:forEach>
									</c:if>
									<c:if test="${currentPage < totalPages}">
										<a
											href="<%=basePath%>/user/medal/getAllMedal.htm?page=${currentPage+1}">&gt;
										</a>
									</c:if>
									<c:if test="${currentPage >= totalPages}">
										<span class="disabled"> &gt; </span>
									</c:if>

								共${totalPages}页 ,去第 <input name="" type="text" id="currentPage" />
								页<a href="javascript:toCurrentPage();" class="go">GO</a>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
