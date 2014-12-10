<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<link href="<%=basePath%>/style/public.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet"
	type="text/css" />
<link href="<%=basePath%>/css/common/css.css" rel="stylesheet"
	type="text/css" />
</head>

<body class="white">
<%@ include file="/WEB-INF/jsps/includes/top.jsp"%>
<div id="wapper">

<div class="main">
<div class="banner top30"><a href="#"><img src="images/img_01.jpg" width="1000" height="60" /></a></div>
<div class="scroll_banner top15 fixed">
<span class="fl">美试卖家年会，夏季分享2014美试市场活动节奏，夏季分享2014美试市</span>
<span class="fr">美试卖家年会，夏季分享2014美试市场活动节奏，夏季分享2014美试市</span>
</div>
<p class="passw_wz">您现在位于：首页 >> 我的美试 <span>- 个人首页</span></p>

<c:import url="/user/usertop.htm"></c:import>


<div class="indiv_bottom top25">
	
    <ul class="indiv_bl">
  				  <li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>" class="geren_bj" ><em></em>个人首页</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>" >个人资料</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.account")%>">我的账户</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.order")%>">我的订单</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.comment")%>">我的评价</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.collect")%>" >我的收藏</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exchange")%>">我的兑换</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.medal")%>">体验勋章</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.remind")%>">美试提醒</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.invite")%>">邀请好友</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.space")%>">我的空间</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.safe")%>"  >安全中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.help")%>">帮助中心</a></li>
					<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.exit")%>">退出</a></li>
    </ul>
    
    <div class="indiv_br fr">
    <p><img src="<%=basePath%>/images/img/geren01.jpg" width="177" height="46" /></p>
    <div class="indev_new fixed">
     <ul class="fl">
      <h2 class="green">1元体验</h2>
      <li class="fixed">
       <a href="#" class="fl"><img src="<%=basePath%>/images/geren_02.jpg" width="162" height="162" /></a>
       <span class="fl">
        <p><em>申请中的商品：</em>3个</p>
        <p><em>待提交报告：</em>3个</p>
        <a href="#">全部</a>
       </span>
      </li>
     </ul>
      <div class="hr"></div>
     <ul class="fr">
      <h2 class="green">裸价体验</h2> 
      <li class="fixed">
       <a href="#" class="fl"><img src="<%=basePath%>/images/geren_03.jpg" width="162" height="162" /></a>
       <span class="fl">
        <p><em>待收货确认：</em>3个</p>
        <p><em>体验过的商品：</em>3个</p>
        <a href="#">全部</a>
       </span>
      </li>
     </ul>
    </div>
    
    <div class="height28"></div>
    <p><img src="<%=basePath%>/images/img/geren02.jpg" width="130" height="46" /></p>
    <div class="indev_new fixed">
     <ul class="fl">
      <h2 class="green">产品收藏</h2>
      <li class="fixed">
       <a href="#" class="fl"><img src="<%=basePath%>/images/geren_04.jpg" width="162" height="162" /></a>
       <span class="fl">
        <p><em>已收藏：</em>${commodityCount}个</p>
        <a href="<%=basePath%>/collect/getCommodityCollect.htm">全部</a>
       </span>
      </li>
     </ul>
      <div class="hr"></div>
     <ul class="fr">
      <h2 class="green">品牌收藏</h2> 
      <li class="fixed">
       <a href="#" class="fl"><img src="<%=basePath%>/images/geren_05.jpg" width="162" height="162" /></a>
       <span class="fl">
        <p><em>已收藏：</em>${brandCount}个</p>
        <a href="#">全部</a>
       </span>
      </li>
     </ul>
    </div>
    
    
    </div>



</div>


<div class="ty_img fl top35"><img src="<%=basePath%>/images/geren_06.jpg" width="1001" height="103" /></div>

</div>




</div>
</body>
</html>