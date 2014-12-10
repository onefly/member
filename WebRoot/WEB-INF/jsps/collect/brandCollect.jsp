<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-个人资料</title>
<link href="${pageContext.request.contextPath}/style/public.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/style/Individual_center.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/common/jquery-yeqian.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/collect/brandCollect.js"></script>
</head>
<body class="white" >
<input type="hidden" id="path" value="${pageContext.request.contextPath}"/>
	<jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>

	<div id="wapper">
		<div class="main">
			<p class="passw_wz">
				您现在位于：首页 &gt; &gt; 我的美试 <span>- 个人首页</span>
			</p>
			<!-- 个人中心公共头部开始 -->
			<c:import url="/user/usertop.htm"></c:import>
					
			<!-- 个人中心公共头部结束 -->
			<div class="indiv_bottom top25">
				<ul class="indiv_bl">
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>"><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>">个人资料</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.account")%>">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.order")%>">我的订单</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.comment")%>">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.collect")%>" class="geren_bj">我的收藏</a></li>
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
								<li id="one1" onclick="showCommodity()" >收藏的商品</li>
								<li id="one2" onclick="setTab('one',2,2)" class="hover">收藏的品牌</li>
							</ul>
						</div>
						<div class="Contentbox fixed">
							<div id="con_one_1" class="two" style="display: none">
								<div class="collect_a fixed">
									
								</div>
							</div>
							<div id="con_one_2" class="two hover" >
								<div class="collect_a fixed">
									<div class="collect_a_top">
										<span> <input type="checkbox" name="checkbox" onclick="selectAllBrand()" id="allCombox" /> <label for="checkbox">全选</label> <a
											href="javascript:deleteBrand();">删除</a>
										</span>
										<div class="medal_top_cent">
											<form action="<%=basePath%>/collect/getBrandCollect.htm" method="post" id="brandForm">
											<input name="key" value="${key}" type="text" class="ssuo" /> <a href="javascript:document.getElementById('brandForm').submit()">搜索</a>
										</form>
										</div>
									</div>
									<div class="collect_a_cent collect_b_cent">
										<ul>
											
												<c:forEach items="${brandList}" var="brand">
												<li><a href="${brand.brandId}"><img
														src="${brand.logoUrl}" width="142" height="180" /></a>
													<p>
														<input type="checkbox" name="brandBox" 
															value="${brand.collectId}" /> <span><a
															href="${brand.brandId}">${brand.brandName}</a></span>
													</p></li>
											</c:forEach>
											<c:if test="${brandAllCount==0}">
													<li>没有收藏的品牌</li>
														
													</c:if>
										</ul>
									</div>
									<c:if test="${brandAllCount>0}">
									<div class="yahoo">
										<c:if test="${brandPage > 1}">
											<a
												href="<%=basePath%>/collect/getBrandCollect.htm?page=${brandPage-1}">&lt;
											</a>
										</c:if>
										<c:if test="${brandPage <= 1}">
											<span class="disabled"> &lt; </span>
										</c:if>
										<c:if test="${brandPage<=5}">
											<c:forEach var="i" begin="1" end="${10}" step="1">
											<c:if test="${i<=brandAllPage}">
												<c:if test="${brandPage==i}">
													<span class="current">${brandPage}</span>
												</c:if>
												<c:if test="${brandPage!=i}">
													<a
														href="<%=basePath%>/collect/getBrandCollect.htm?page=${i}">${i}</a>
												</c:if>
											</c:if>
											</c:forEach>
										</c:if>

										<c:if test="${brandPage>5}">
											<c:forEach var="i" begin="${brandPage-5}" end="${brandPage+5}" step="1">
												<c:if test="${i<=brandAllPage}">
													<c:if test="${brandPage==i}">
														<span class="current">${brandPage}</span>
													</c:if>
													<c:if test="${brandPage!=i}">
														<a
															href="<%=basePath%>/collect/getBrandCollect.htm?page=${i}">${i}</a>
													</c:if>
												</c:if>
											</c:forEach>
										</c:if>





										<c:if test="${brandPage < brandAllPage}">
											<a
												href="<%=basePath%>/collect/getBrandCollect.htm?page=${brandPage+1}">&gt;
											</a>
										</c:if>
										<c:if test="${brandPage >= brandAllPage}">
											<span class="disabled"> &gt; </span>
										</c:if>

										共${brandAllPage}页 ,去第 <input name="" type="text" id="brandPage" />
										页<a href="javascript:toBrandPage(${brandAllPage});" class="go">GO</a>
									</div>
									</c:if>
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
