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
<script language="javascript" type="text/javascript" src="<%=basePath%>/js/common/datepicker/WdatePicker.js"></script>
<script type="text/javascript">


	function toCurrentPage() {
		var target = $('#currentPage').val();
		var all = ${totalPages};
		if(0 < target && target <= all){
			location = "<%=basePath%>/user/rechargeRecord/getRecord.htm?page="
					+ target;
		} else {
			$('#currentPage').attr("value", "");
			alert('无效字符');
		}
	}
	function toRecharge(){
		var date=$("#account").val();
		location = "<%=basePath%>/user/rechargeRecord/getRecord.htm?page=1&date="
				+ date;

	}
	$(function() {
		$("#rechargeCount").keyup(function(){
			var rechargeCount=$(this).val();
			
			$("#emrechargeMoney").text(rechargeCount*10);
			$("#money2").text(rechargeCount*10);
		});
	$("input[type='radio']").mousedown(function(){
		var money=$(this).val();
		
		$("#money1").text(money);
		$("#money2").text(money);
	});

	
	});
</script>
</head>
<script type="text/javascript">
	$(function() {
		$("#rechargeCount").keyup(function(){
			var rechargeCount=$(this).val();
			$("#emrechargeMoney").text(rechargeCount*10);
		});
	});
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
								<li><a
									href="<%=basePath%>/user/accountRecord/getRecord.htm?page=1">账户记录</a></li>
								<li><a class="hover"
									href="<%=basePath%>/user/rechargeRecord/getRecord.htm?page=1">充值中心</a></li>
								<li><a href="#">赠送中心</a></li>
							</ul>
						</div>
						<div class="Contentbox fixed">

							<div id="con_one_2" class="two hover">
								<div class="paya fixed">
									<div class="paya_top fixed">
										<div class="paya_lia">
											<div class="lia_fl">美试账号：</div>
											<div class="f7fceb">
												<span>${user.phone }（${user.nickname }）</span><span>当前身份：VIP会员</span><span>会员有效期：2014/05/06</span>
											</div>
										</div>
										<div id="Tab2" class="account">
											<div class="Menuboxa">
												<ul>
													<li class="lia_fl">充值项目：</li>
													<li id="two1" style="position: relative;"
														onclick="setTab('two',1,2)" class="hover"><span
														class="fl01"></span>体验宝</li>
													<li id="two2" style="position: relative; right: 1px"
														onclick="setTab('two',2,2)"><span class="fl02"></span>VIP会员</li>
												</ul>
											</div>
											<div class="Contentboxa">
												<div id="con_two_1">
													<div class="experience">
														<ul>
															<li>
																<div class="lia_fl">充值数量：</div> <input id="rechargeCount"name="rechargeCount"
																type="text" class="width100" /> <span class="fl">体验宝<em
																	class="yellow">（1 体验宝=10元）</em></span>
															</li>
															<li>
																<div class="lia_fl">应付金额：</div> <span class="jine"><em
																	class="yellow"id ="emrechargeMoney"></em>元</span>
															</li>
															<li><a href="#" class="anniua">充值</a></li>
														</ul>
													</div>
												</div>
												<div id="con_two_2" style="display: none">
													<div class="experience">
														<ul>
															<li>
																<div class="lia_fl">充值数量：</div>
																<dl>
																	<dt>
																		<input type="radio" name="rechargeMoney" id="checkbox" value="300"/>
																		<label for="checkbox">300元，开通12个月<em
																			class="gray">（年度VIP会员，仅25元/月，赠送60个体验宝，原价600元）</em></label>
																	</dt>
																	<dt>
																		<input type="radio" name="rechargeMoney" id="checkbox"value="180" />
																		<label for="checkbox">180元，开通6个月<em
																			class="gray">（半年度VIP会员，仅30元/月，赠送30个体验宝，原价300元）</em></label>
																	</dt>
																	<dt>
																		<input type="radio" name="rechargeMoney" id="checkbox" value="100" />
																		<label for="checkbox">100元，开通3个月<em
																			class="gray">（季度VIP会员，仅33元/月，赠送15个体验宝，原价150元）</em></label>
																	</dt>
																	<dt>
																		<input type="radio" name="rechargeMoney" id="checkbox" value="40"/>
																		<label for="checkbox">40元，开通1个月<em
																			class="gray">（月度VIP会员，赠送5个体验宝，原价50元）</em></label>
																	</dt>
																</dl>
															</li>
															<li>
																<div class="lia_fl">应付金额：</div> <span class="jine"><em
																	class="yellow" id="money1">0.0</em>元</span>
															</li>
															<li><a href="#" class="anniua">充值</a></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
										<ul class="payb">
											<li>
												<div class="lia_fl">应付金额：</div> <span class="jine"><em
													class="yellow"id="money2">0.0</em>元</span>
											</li>
											<li>
												<div class="lia_fl">支付方式：</div>
												<div class="lia_fr">
													<a href="#"><img src="<%=basePath%>/images/img/yh01.jpg" width="152"
														height="48" /><span></span></a> <a href="#"><img
														src="<%=basePath%>/images/img/yh02.jpg" width="152" height="48" /><span></span></a>
													<a href="#"><img src="<%=basePath%>/images/img/yh03.jpg" width="152"
														height="48" /><span></span></a> <a href="#"><img
														src="<%=basePath%>/images/img/yh04.jpg" width="152" height="48" /><span></span></a>
												</div>
											</li>
											<li>
												<div class="js">
													<div id="LM1" class=" lia_fr" style="DISPLAY: none">
														<a href="#"><img src="<%=basePath%>/images/img/yh01.jpg" width="152"
															height="48" /><span></span></a> <a href="#"><img
															src="<%=basePath%>/images/img/yh02.jpg" width="152" height="48" /><span></span></a>
														<a href="#"><img src="<%=basePath%>/images/img/yh03.jpg" width="152"
															height="48" /><span></span></a> <a href="#"><img
															src="<%=basePath%>/images/img/yh04.jpg" width="152" height="48" /><span></span></a>
													</div>
													<div class="dotline">
														<a onClick=javascript:ShowFLT(1)
															href="javascript:void(null)">更多银行</a>
													</div>
												</div>
											</li>
											<li>
												<div class="lia_fr" style="margin-left: 100px;">
													<a href="#"><img src="<%=basePath%>/images/img/yh05.jpg" width="152"
														height="48" /><span></span></a> <a href="#"><img
														src="<%=basePath%>/images/img/yh06.jpg" width="152" height="48" /><span></span></a>
												</div>
											</li>
											<li class="top20"><a href="#" class="zhifu">去付款</a>
												<p>
													<input type="checkbox" name="checkbox2" id="checkbox2" />
													<label for="checkbox2">同意并接受<em>美试会员服务条款</em></label>
												</p></li>
										</ul>
									</div>
									<div class="paya_bottom">
										<div class="record_top fixed">
											<h2>
												<img src="<%=basePath%>/images/img/yzm04.jpg" width="99" height="26" />
											</h2>
											<div class="fr">
											选择时间<input id="recharge" type="text" class="Wdate" onfocus="WdatePicker({isShowWeek:true})" name="date" value="${date }"/><a
												href="javascrit:toRecharge();">查看</a>
										</div>
										</div>
										<dl class="biaod">
											<dt class="biaod01">充值时间</dt>
											<dt class="biaod02">充值项目</dt>
											<dt class="biaod03">充值数量</dt>
											<dt class="biaod04">充值金额</dt>
										</dl>
										<table width="754" border="0" cellspacing="1" cellpadding="0"
											class="account_biaod">
											<c:if test="${not empty list }">
												<c:forEach items="${list}" var="p">
													<tr>
														<td width="208" align="center" valign="middle"><fmt:formatDate
																value="${p.rechargeTime}" pattern="yyyy/MM/dd" />&nbsp;&nbsp;&nbsp;<fmt:formatDate
																value="${p.rechargeTime}" type="time" /></td>
														<td width="192" align="center" valign="middle">${p.rechargeProject }</td>
														<td width="165" align="center" valign="middle"><em
															class="yellow">${p.rechargeCount }</em></td>
														<td width="184" align="center" valign="middle"><em
															class="yellow">${p.rechargeMoney }</em>元</td>
													</tr>
												</c:forEach>
											</c:if>
											<c:if test="${ empty list }">
												没有数据！
											</c:if>
										</table>
										<div class="medal_bottom padding30">
											<div class="yahoo">
												<c:if test="${not empty list }">
													<c:if test="${currentPage > 1}">
														<a
															href="<%=basePath%>/user/rechargeRecord/getRecord.htm?page=${currentPage-1}">&lt;</a>

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
																		href="<%=basePath%>/user/rechargeRecord/getRecord.htm?page=${i}">${i}</a>
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
																		href="<%=basePath%>/user/rechargeRecord/getRecord.htm?page=${i}">${i}</a>
																</c:if>
															</c:if>
														</c:forEach>
													</c:if>
													<c:if test="${currentPage < totalPages}">
														<a
															href="<%=basePath%>/user/rechargeRecord/getRecord.htm?page=${currentPage+1}">&gt;
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
							<div id="con_one_3" style="display: none;">
								<div class="paya fixed">
									<div class="paya_top fixed">
										<div id="Tab2" class="account">
											<div class="Menuboxa">
												<ul>
													<li class="lia_fl">充值项目：</li>
													<li id="three1" style="position: relative;"
														onclick="setTab('three',1,2)" class="hover"><span
														class="fl01"></span>体验宝</li>
													<li id="three2" style="position: relative; right: 1px"
														onclick="setTab('three',2,2)"><span class="fl02"></span>VIP会员</li>
												</ul>
											</div>
											<div class="Contentboxa">
												<div id="con_three_1">
													<div class="experience">
														<ul>
															<li>
																<div class="lia_fl">接收方美试ID：</div> <input name=""
																type="text" class="width180" /> <span class="fl01">当前账号输入有误<br />
																	请核对后重新填写
															</span>
															</li>
															<li>
																<div class="lia_fl">接收方昵称：</div> <span class="fize14">我就是别跑</span>
															</li>
															<li>
																<div class="lia_fl">赠送数量：</div> <input name=""
																type="text" class="width100" /> <span class="fl">体验宝</span><span
																class="fl01">您的余额数量不足<br /> 请前往<a href="#">充值中心</a>购买
															</span>
															</li>
															<li>
																<div class="lia_fl">赠送理由：</div> <textarea name=""
																	cols="" rows="" class="width350"></textarea> <span>限30字以内</span>
																<p>
																	<input type="checkbox" name="checkbox" id="checkbox" />
																	<label for="checkbox"><em class="yellow">是否通过站内信告诉他</em></label>
																</p>
															</li>
															<li><a href="#" class="anniua">确认赠送</a></li>
														</ul>
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
			</div>
		</div>
	</div>
</body>
</html>
