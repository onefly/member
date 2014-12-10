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
<script type="text/javascript"
	src="<%=basePath%>/js/user/ZeroClipboard.js"></script>
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
<li><a href="${pageContext.request.contextPath}/user/profile.htm">个人资料</a></li>
<li><a href="<%=basePath%>/user/accountRecord/getRecord.htm?page=1">我的账户</a></li>
<li><a
	href="${pageContext.request.contextPath}/apply/getApplyList.htm">我的订单</a></li>
<li><a href="#">我的评价</a></li>
<li><a
	href="${pageContext.request.contextPath}/collect/getCommodityCollect.htm">我的收藏</a></li>
<li><a href="#">我的兑换</a></li>
<li><a
	href="${pageContext.request.contextPath}/user/medal/getAllMedal.htm?page=1">体验勋章</a></li>
<li><a href="#">美试提醒</a></li>
<li><a
	href="${pageContext.request.contextPath}/user/inviteFriends.htm"
	class="geren_bj">邀请好友</a></li>
<li><a href="#">我的空间</a></li>
<li><a
	href="${pageContext.request.contextPath}/safety/toSafety.htm">安全中心</a></li>
<li><a href="#">帮助中心</a></li>
<li><a href="${pageContext.request.contextPath}/user/logout.htm">退出</a></li>
</ul>

<div class="indiv_br fr">
        <div id="Tab1" class="data">
          <div class="Menubox">
            <ul>
              <li><a href="#" id="one1" >邀请好友</a></li>
              <li><a href="#" id="one2"  class="hover" >邀请记录</a></li>
            </ul>
          </div>
          <div class="Contentbox fixed">
           
            <div id="con_one_2" class="two" style="display:none;">
              <div class="invitation">
                <h1>您已成功邀请注册<em>${pcount}</em>人，共获<em>${pcount*100}</em>积分</h1>
                <table class="tab_noe top20">
                  <thead class="h30">
                    <tr>
                      <th width="90" class="bl_none"><div>序号</div></th>
                      <th width="200"><div>昵称</div></th>
                      <th width="160"><div>用户ID</div></th>
                      <th width="170"><div>奖励积分</div></th>
                      <th width="170" class="br_none"><div>邀请成功时间</div></th>
                    </tr>
                  </thead>
                  <tbody class="tab_invitation">
                    <tr>
                      <td align="center" valign="middle"><div>1</div></td>
                      <td align="center" valign="middle"><div>我就是别跑我就是别跑</div></td>
                      <td align="center" valign="middle"><div>1234567890</div></td>
                      <td align="center" valign="middle"><div>100</div></td>
                      <td align="center" valign="middle"><div>
                          <p>2014/04/23</p>
                          <p>12:23:03</p>
                        </div></td>
                    </tr>
                  </tbody>
                </table>
               <!-- 分页组件 -->
						<%@include file="/WEB-INF/jsps/includes/page.jsp"%>
            </div>
          </div>
        </div>
      </div>
</div>
</div>
</div>
</body>
</html>
<script type="text/javascript"
	src="<%=basePath%>/js/user/ZeroClipboard.js"></script>
<script type="text/javascript">
// 定义一个新的复制对象
var clip = new ZeroClipboard( document.getElementById("d_clip_button"), {
  moviePath: "<%=basePath%>/flash/ZeroClipboard.swf"
	});

	// 复制内容到剪贴板成功后的操作
	clip.on('complete', function(client, args) {
		alert("复制成功");
	});
</script>

