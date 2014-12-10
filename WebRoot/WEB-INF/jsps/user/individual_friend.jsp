<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-邀请好友</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet"
	type="text/css" />

<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript" src="<%=basePath%>/js/user/ZeroClipboard.js"></script>
</head>
<script language="javascript" src="js/jquery-yeqian.js"></script>


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
					<li><a href="<%=basePath%>/user/accountRecord/getRecord.htm?page=1">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}/apply/getApplyList.htm">我的订单</a></li>
					<li><a href="#">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}/collect/getCommodityCollect.htm">我的收藏</a></li>
					<li><a href="#">我的兑换</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/medal/getAllMedal.htm?page=1">体验勋章</a></li>
					<li><a href="#">美试提醒</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/inviteFriends.htm"
						class="geren_bj">邀请好友</a></li>
					<li><a href="#">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}/safety/toSafety.htm">安全中心</a></li>
					<li><a href="#">帮助中心</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/logout.htm">退出</a></li>
				</ul>

				<div class="indiv_br fr">
					<div class=" friend">
						<h2>每邀请一个好友成功注册，可获得美试网 1000 积分</h2>
						<ul class="fixed">
							<li><div class="friend_left">[ 方式一 ]</div>
								<div class="friend_right">
									直接发送给QQ好友、QQ群、论坛等
									<p>
										您的专属邀请链接<br />复制链接发给好友，对方通过该链接注册成功即可！
									</p><span class="ul01">亲爱的，我刚注册了一个超震撼的网站，超多大牌体验试用，强烈推荐，下手要快噢！网址是:www.maxtp.com/member/register/forward.htm?userId=${userId}
									</span>
									<a id="d_clip_button"  class="ul02" class="my_clip_button" data-clipboard-target="fe_text"><b>复制链接</b></a>
<br/>
<textarea style="display: none" id="fe_text" cols="50" rows="3">亲爱的，我刚注册了一个超震撼的网站，超多大牌体验试用，强烈推荐，下手要快噢！网址是:www.maxtp.com/member/register/forward.htm?userId=${userId}</textarea>
								</div></li>
						</ul>

						<ul class="fixed">
							<li><div class="friend_left">[ 方式二 ]</div>
								<div class="friend_right">
									分享到微博、空间等
									<p>邀请更多好友 分享品质生活</p>
									<dl>
										<div class="jiathis_style_32x32">
											<a class="jiathis_button_qzone"><font size="4">qq空间</font></a>
											<a class="jiathis_button_tsina"><font size="4">新浪微博</font></a>
											<a class="jiathis_button_tqq"><font size="4">腾讯微博</font></a><br>


												<a class="jiathis_button_weixin"><font size="4">微信</font></a>
												<a class="jiathis_button_renren"><font size="4">人人网</font></a>

												<a class="jiathis_button_douban"><font size="4">豆瓣</font></a>
										</div>
										<script type="text/javascript"
											src="http://v3.jiathis.com/code/jia.js?uid=1395709882214812"
											charset="utf-8">
										</script>
										<!-- JiaThis Button END -->
										<script type="text/javascript">
											var jiathis_config = {
												data_track_clickback : true,
												url : "www.maxtp.com/member/register/forward.htm?userId=${userId}",
												summary : "",
												title : "亲爱的，我刚注册了一个超震撼的网站，超多大牌体验试用，强烈推荐，下手要快噢！网址是:www.maxtp.com/member/register/forward.htm?userId=${userId}",
												shortUrl : true,
												hideMore : false
											}
										</script>

									</dl>
								</div></li>
						</ul>
						<h3>
							您已成功邀请注册 <em>${count}</em> 人，共获 <em>${count*1000}</em> 积分
						</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript" src="<%=basePath%>/js/user/ZeroClipboard.js"></script>
<script type="text/javascript">
// 定义一个新的复制对象
var clip = new ZeroClipboard( document.getElementById("d_clip_button"), {
  moviePath: "<%=basePath%>/flash/ZeroClipboard.swf"
} );

// 复制内容到剪贴板成功后的操作
clip.on( 'complete', function(client, args) {
   alert("复制成功");
} );

</script>

