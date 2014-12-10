<%@page import="com.qianqian.order.utils.OrderConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心-发货赔偿</title>
<link href="<%=basePath %>/style/base.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/style/meishi_backstage.css" rel="stylesheet" type="text/css" />
</head>

<body class="white">
<div id="wapper">

 <!-- 引入美试网公共头 -->
 <jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
 
  <div class="main">
    <p class="passw_wz">您现在位于：首页 >> 我的美试 <span>- 发货赔偿</span></p>
    
   	<%-- 引入公共头  --%>
  	<c:import url="/user/usertop.htm"/>
  	<%-- 引入公共头结束  --%>
	  	
    <div class="indiv_bottom top20">
      <ul class="indiv_bl">
       	<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.index")%>"><em></em>个人首页</a></li>
		<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.info")%>">个人资料</a></li>
		<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.account")%>">我的账户</a></li>
		<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.order")%>">我的订单</a></li>
		<li><a href="${pageContext.request.contextPath}<%=CommonConstants.COMMON_PATH.get("user.repay")%>" class="geren_bj">发货赔偿</a></li>
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
      	<div class="border_green">
          <h2 class="compensate_r_top">品牌发货超时赔偿标准</h2>
          <dl class="compensate_r_bottom">
            <dt>发货超时订单，不管品牌有没有发货，都将按发货超时标准进行用户积分赔偿，美试积分可以用于站内积分商城中免费兑换商品</dt>
            <dd> <span>1.发货超时8-15天，赔偿产品实付金额的10%价值的积分</span> <span>2.发货超时16-30天，赔偿产品实付金额的20%价值的积分</span> <span>3.发货超时30天以上交易关闭的，赔偿产品实付金额的50%价值的积分</span> <span class="yellow">具体规则参看美试网【超时发货赔偿说明】</span> </dd>
          </dl>
        </div>
        <div id="Tab1" class="data top35">
          <div class="Menubox">
            <ul>
              <li><a href="${pageContext.request.contextPath}/repay/getOrderRepay.htm?type=1" id="one1" <c:if test="${query.type==1}">class="hover"</c:if>>免费试用订单</a></li>
              <li><a href="${pageContext.request.contextPath}/repay/getOrderRepay.htm?type=0" id="one2" <c:if test="${query.type==0}">class="hover"</c:if>>裸价体验订单</a></li>
            </ul>
          </div>
          <div class="Contentbox fixed">
            <div id="con_one_1" class="two hover">
              <form class="feeling_top" action="${pageContext.request.contextPath}/repay/getOrderRepay.htm" method="post">
              	<input type="hidden" name="type" value="${query.type}" />
                <label for="textfield">产品名称：</label>
                <input type="text" name="productName" id="textfield" class="input_w210" value="${query.productName}" />
                <input type="submit" name="button" id="button" class="input_boredr_none icon_w80" value="搜索" />
              </form>
              <div class="feeling_cent fixed">
                <table class="tab_noe">
                  <thead>
                    <tr>
                    	<th width="222" align="center" valign="middle" class="bl_none">产品名称</th>
                      	<th width="84" align="center" valign="middle">实付款</th>
                      	<th width="136" align="center" valign="middle">订单状态</th>
                      	<th width="96" align="center" valign="middle">发货超时时间</th>
                      	<th width="100" align="center" valign="middle">赔付标准</th>
                      	<th width="78" align="center" valign="middle">赔付积分</th>
                      	<th width="78" align="center" valign="middle" class="br_none">赔付状态</th>
                    </tr>
                  </thead>
                  <c:if test="${not empty pageBean.currentList}">
	                  <c:forEach items="${pageBean.currentList}" var="orderOvertime">
		                  <tbody>
		                    <tr class="lt_probm">
		                    	<td colspan="7"><span><em>订单编号：</em>${orderOvertime.orderId}</span><span><em>拍下时间：</em><fmt:formatDate value="${orderOvertime.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></span></td>
		                    </tr>
		                    <c:forEach items="${orderOvertime.orderChilds}" var="orderChild">
			                    <tr class="border_bottom">
			                      <td height="100" align="center" valign="middle" class="border_img bl_none"><div><a href="#" class="fl f_l"><img src="<%=imagePath %>/${orderChild.prdPic}" width="68" height="68" /></a>
			                          <p class="fl f_r"><a href="#">${orderChild.prdName}</a>${orderChild.stanColorName}&nbsp;${orderChild.stanSizeName}</p>
			                        </div></td>
			                      <td height="100" align="center" valign="middle"><div>${orderOvertime.orderFund}</div></td>
			                      <td height="100" align="center" valign="middle">
			                      	<div class="line_height18">
			                      		<p>
			                      			<c:set var="state" value="${orderOvertime.state}" scope="request"/>
			                      			<%= OrderConstants.orderChildMap.get(request.getAttribute("state")) %>
			                      		</p>
			                          	<p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${orderOvertime.orderId}" class="blue">订单详情</a></p>
			                        </div>
			                      </td>
			                      <td height="100" align="center" valign="middle">
			                      	<div class="line_height18">
			                        	<p class="yellow">发货超时<br />${orderOvertime.overtime }</p>
			                        </div>
			                      </td>
			                      <td height="100" align="center" valign="middle">
			                      	<div class="line_height18">
			                        	<p class="yellow">发货超时${orderOvertime.standardDay}天</p>
			                          	<p class="green">赔付${orderOvertime.repayBalance}%积分</p>
			                        </div>
			                      </td>
			                      <td height="100" align="center" valign="middle">
			                      	<c:if test="${orderOvertime.repayState!=3}">
			                      		<div>${orderOvertime.repayScore}</div>
			                      	</c:if>
			                      	<c:if test="${orderOvertime.repayState==3}">
			                      		<div class="zhu"><p class="yellow"><em class="zhu1"></em>待核算</p></div>
			                      	</c:if>
			                      </td>
			                      <td height="100" align="center" valign="middle" class="br_none">
			                      	<div class="line_height18">
			                        	<p>
			                        		<c:if test="${orderOvertime.repayState==1}">已赔付</c:if>
			                        		<c:if test="${orderOvertime.repayState==2}">待赔付</c:if>
			                        		<c:if test="${orderOvertime.repayState==3}">待核算</c:if>
			                        	</p>
			                          	<p><a href="${pageContext.request.contextPath}/repay/repayDetail.htm?id=${orderOvertime.overtimeId}" class="blue">【赔付详情】</a></p>
			                        </div>
			                      </td>
			                    </tr>
		                    </c:forEach>
		                  </tbody>
	                  </c:forEach>
	               </c:if>
               	</table>
	            <c:choose>
              		<c:when test="${not empty pageBean.currentList}">
	                	<%@include file="/WEB-INF/jsps/includes/page.jsp"%>
                	</c:when>
              		<c:otherwise>
              			<em>暂无订单记录</em>
              		</c:otherwise>
              	</c:choose>
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