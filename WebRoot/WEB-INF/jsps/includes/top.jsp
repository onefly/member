<%@ page language="java"   pageEncoding="UTF-8"%>
<link href="${pageContext.request.contextPath}/style/public.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/style/header_footer.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(function() {
		$("#searchSelected").click(function() {
			$("#searchTab").show();
			$(this).addClass("searchOpen");
		});

		$("#searchTab li").hover(function() {
			$(this).addClass("selected");
		}, function() {
			$(this).removeClass("selected");
		});

		$("#searchTab li").click(function() {
			$("#searchSelected").html($(this).html());
			$("#searchTab").hide();
			$("#searchSelected").removeClass("searchOpen");
		});

	});
</script>
<script>
	function a(obj, sType) {
		var oDiv = document.getElementById(obj);
		if (sType == 'show') {
			oDiv.style.display = 'block';
		}
		if (sType == 'hide') {
			oDiv.style.display = 'none';
		}
	}
</script>

<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/user/getTopData.json",
			type : "get",
			async : false,
			success : function(data) {
				if (500 == data) {
					//系统内部异常
					alert('系统内部异常');
				} else if (501 == data) {
					//用户未登录，请求被拦截
					alert('未登录');
				} else {//正确返回结果
					if (data.nickname != "") {
						//alert(data.nickname);
						$("#show_nickname").html(data.nickname);
						$("#login_link").attr("style", "display:none");
						$("#regist_link").attr("style", "display:none");
					}
				}
			}
		});
	});
</script>

<div class="header">



	<div class="header_top">
		<div class="h_topt">
			<div class="chl-poster">
				<div id=site-nav>
					<UL class=quick-menu>
						<LI class=cart><A href="#" rel=nofollow><S><img
									src="${pageContext.request.contextPath }/images/icon/top_png01.png"
									width="18" height="18" /></S>移动美试</A></LI>
						<LI class="mytaobao menu-item last">
							<div class=menu>
								<A class=menu-hd href="#" target=_top><s><img
										src="${pageContext.request.contextPath }/images/icon/top_png02.png"
										width="18" height="18" /></s>关注美试</A>
								<div class=menu-bd>
									<div class=menu-bd-panel></div>
									<S class=r></S><S class=rt></S><S class=lt></S><S class=b></S><S
										class="b b2"></S><S class=rb></S><S class=lb></S>
								</div>
							</div>
						</LI>
						<LI class=cart><A href="#" rel=nofollow><S
								style="margin-right: 3px;"><img
									src="${pageContext.request.contextPath }/images/icon/top_png03.png"
									width="18" height="18" /></S>收藏美试</A></LI>
					</UL>
				</div>
				<SCRIPT type=text/javascript>
					TB.Header.init();
				</SCRIPT>
				</DT>
			</div>
			<div class="h_top_right">
				<span id="show_nickname">欢迎来到美试！</span> <a href="${pageContext.request.contextPath}/user/toLogin.htm" id="login_link">登录</a>
				| <a href="${pageContext.request.contextPath}/register/forward.htm" id="regist_link">免费注册</a> | <a href="${pageContext.request.contextPath}/user/index.htm">我的美试</a> | <a
					href="#">积分商城</a> | <a href="#">公益基金</a> | <a href="#">美试VIP</a> |
				<a href="#">签到</a> | <a href="${pageContext.request.contextPath}/user/logout.htm">退出</a>
			</div>
		</div>
		<div class="h_topc">
			<a href="#" class="logo"></a>
			<div class="seek">
				<p>想试就试 体验品质</p>
				<div class="sek">
					<form method="get" name="" action="http://sc.chinaz.com/jiaoben/"
						target="_blank" style="width: 245px; height: 32px;">
						<div id="searchTxt" class="searchTxt"
							onMouseOver="this.className='searchTxt searchTxtHover';"
							onMouseOut="this.className='searchTxt';">
							<div class="radius" style="top: -2px;"></div>
							<div class="radius" style="top: 31px;"></div>
							<div class="searchMenu">
								<div class="searchSelected" id="searchSelected">网页</div>
								<div style="display: none;" class="searchTab" id="searchTab">
									<div class="radius" style="top: 259px;"></div>
									<div class="radius" style="top: 259px; left: 59px;"></div>
									<ul>
										<li class="">网页</li>
										<li>图片</li>
										<li>视频</li>
										<li>音乐</li>
										<li>地图</li>
										<li>问问</li>
										<li>百科</li>
										<li>新闻</li>
										<li>购物</li>
									</ul>
								</div>
							</div>
							<input name="w" type="text" />
							<div class="searchBtn">
								<a href="#" class="button"></a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="h_tc_r">
				<ul>
					<li onmouseover="a('01', 'show');" onmouseout="a('01', 'hide');"><span
						class="a01"></span>
						<p>大牌体验</p>
						<div style="display: none;" id="01" class="h">
							<span></span>
							<p></p>
						</div></li>
					<li onmouseover="a('02', 'show');" onmouseout="a('02', 'hide');"><span
						class="a02"></span>
						<p>美试指数</p>
						<div style="display: none;" id="02" class="h">
							<span></span>
							<p></p>
						</div></li>
					<li onmouseover="a('03', 'show');" onmouseout="a('03', 'hide');"><span
						class="a03"></span>
						<p>消费真相</p>
						<div style="display: none;" id="03" class="h">
							<span></span>
							<p></p>
						</div></li>
					<li onmouseover="a('04', 'show');" onmouseout="a('04', 'hide');"><span
						class="a04"></span>
						<p>产品互动</p>
						<div style="display: none;" id="04" class="h">
							<span></span>
							<p></p>
						</div></li>
				</ul>
			</div>
		</div>
		<div class="nav">
			<div class="nav_left"></div>
			<div class="nav_right">
				<ul>
					<!-- <li><a href="#" class="hover" >首页</a></li> -->
					<li><a href="#">首页</a></li>
					<li><a href="#">免费试用</a></li>
					<li><a href="#">裸价体验</a></li>
					<li><a href="#">美试指数</a></li>
					<li><a href="#">消费真相</a></li>
					<li><a href="#">产品经理</a></li>
					<li><a href="#">大牌活动</a></li>
					<li><a href="#">私人定制</a></li>
					<li><a href="#">拼手气</a></li>
				</ul>
			</div>
		</div>
	</div>

</div>


