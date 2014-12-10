<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-我的评价</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet"
	type="text/css" />
<script language=JavaScript src="<%=basePath%>/js/common/js.js"></script>
<script language="javascript"
	src="<%=basePath%>/js/common/jquery-yeqian.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/common/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/common/jQuery-jcDate.js"></script>
<script language="javascript" type="text/javascript" src="<%=basePath%>/js/common/datepicker/WdatePicker.js"></script>
<script type="text/javascript">


	function toCurrentPage() {
		var target = $('#currentPage').val();
		var all = ${totalPages};
		if(0 < target && target <= all){
			location = "<%=basePath%>/user/accountRecord/getRecord.htm?page="
					+ target;
		} else {
			$('#currentPage').attr("value", "");
			alert('无效字符');
		}
	}
	function toAccount(){
		var date=$("#account").val();
		
		location = "<%=basePath%>/user/accountRecord/getRecord.htm?page=1&date="+date;
			
	}
</script>
</head>

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
	<jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
	<div id="wapper">
		<div class="main">
			<p class="passw_wz">
				您现在位于：首页 >> 我的美试 <span>- 个人首页</span>
			</p>
			<c:import url="/user/usertop.htm"></c:import>
			<div class="indiv_bottom top25">
				<ul class="indiv_bl">
						<li><a href="#"><em></em>个人首页</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/profile.htm">个人资料</a></li>
					<li><a href="<%=basePath%>/user/accountRecord/getRecord.htm?page=1" class="geren_bj">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}/apply/getApplyList.htm">我的订单</a></li>
					<li><a href="#">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}/collect/getCommodityCollect.htm">我的收藏</a></li>
					<li><a href="#">我的兑换</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/medal/getAllMedal.htm?page=1">体验勋章</a></li>
					<li><a href="#">美试提醒</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/inviteFriends.htm">邀请好友</a></li>
					<li><a href="#">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}/safety/toSafety.htm">安全中心</a></li>
					<li><a href="#">帮助中心</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/logout.htm">退出</a></li>
				</ul>
				<div class="indiv_br fr fixed">
					<div id="Tab1" class="data">
						<div class="Menubox">
							<ul>
								<li><a  class="hover"
									href="<%=basePath%>/user/accountRecord/getRecord.htm?page=1">账户记录</a></li>
								<li><a href="<%=basePath%>/user/rechargeRecord/getRecord.htm?page=1">充值中心</a></li>
								<li><a href="#">赠送中心</a></li>
							</ul>
						</div>
						<div class="Contentbox fixed">
							<div id="con_one_1" class="two hover">
								<div class="acccount_record fixed">
									<div class="record_top fixed">
										<!--<div class="fr">
											<span class="fl">选择时间</span>
											<form id="account"action="<%=basePath%>/user/accountRecord/getRecord.htm?page=1" method="post">
												 <input type="text"class="jcDate fl" name="date" value="${date}"/> 
											 </form>
											 <a
												href="javascript:document.getElementById('account').submit()" class="fl">查看</a>
										</div>  -->
										<div class="fr">
											选择时间<input id="account" type="text" class="Wdate" onfocus="WdatePicker({isShowWeek:true})" name="date" value="${date }"/><a
												href="javascript:toAccount();">查看</a>
										</div>
									</div>
									<div class="tecord_cent">
										<div class="tecord_cent_top">
											<span class="tecprda_01">来源</span> <span class="tecprda_02"><em
												class="img01"></em>积分</span> <span class="tecprda_03"><em
												class="img02"></em>体验值</span> <span class="tecprda_04"><em
												class="img03"></em>体验宝</span> <span class="tecprda_05"><em
												class="img04"></em>体验勋章</span> <span class="tecprda_06">时间</span>
										</div>
										<table width="754" border="0" cellspacing="1" cellpadding="0"
											class="record_cent_cent">
											<c:if test="${not empty list }">
												<c:forEach items="${list}" var="p">
													<tr>
														<td align="center" valign="middle"
															class="recorda_width160">${p.source}</td>
														<td align="center" valign="middle"
															class="recorda_width109"><span class="f60">${p.score}</span></td>
														<td align="center" valign="middle"
															class="recorda_width110"><span class="f60">${p.experienceValue}</span></td>
														<td align="center" valign="middle"
															class="recorda_width108"><span class="f60">${p.ingot}</span></td>
														<td align="center" valign="middle"
															class="recorda_width110"><span class="f60">${p.medal}</span></td>
														<td valign="middle" class="recorda_width150"><fmt:formatDate
																value="${p.recordTime}" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;<fmt:formatDate
																value="${p.recordTime}" type="time" /></td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${ empty list }">
												没有数据！
											</c:if>

										</table>
									</div>
									<div class="medal_bottom padding30">
										<div class="yahoo">

											<c:if test="${not empty list }">
												<c:if test="${currentPage > 1}">
													<a
														href="<%=basePath%>/user/accountRecord/getRecord.htm?page=${currentPage-1}">&lt;</a>

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
																	href="<%=basePath%>/user/accountRecord/getRecord.htm?page=${i}">${i}</a>
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
																	href="<%=basePath%>/user/accountRecord/getRecord.htm?page=${i}">${i}</a>
															</c:if>
														</c:if>
													</c:forEach>
												</c:if>
												<c:if test="${currentPage < totalPages}">
													<a
														href="<%=basePath%>/user/accountRecord/getRecord.htm?page=${currentPage+1}">&gt;
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
			</div>
		</div>
	</div>
</body>
</html>
