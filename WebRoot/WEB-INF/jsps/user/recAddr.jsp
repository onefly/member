<%@ include file="/WEB-INF/jsps/includes/import.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>个人中心-收货地址</title>
	<link href="<%=basePath%>/style/public.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/style/Individual_center.css" rel="stylesheet" type="text/css" />
	<link href="<%=basePath%>/js/common/formValidator/style/validator.css" rel="stylesheet" type="text/css" />
</head>
<body class="white">
<%@ include file="/WEB-INF/jsps/includes/top.jsp"%>
<div id="wapper">
  <div class="main">
    <p class="passw_wz">您现在位于：首页 >> 我的美试 <span>- 个人首页</span></p>
    <c:import url="/user/usertop.htm"></c:import>
    <div class="indiv_bottom top25">
     <ul class="indiv_bl">
					<li><a href="#"><em></em>个人首页</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/profile.htm" class="geren_bj">个人资料</a></li>
					<li><a href="<%=basePath%>/user/accountRecord/getRecord.htm?page=1">我的账户</a></li>
					<li><a href="#">我的体验</a></li>
					<li><a href="#">我的评价</a></li>
					<li><a
						href="${pageContext.request.contextPath}/collect/getCommodityCollect.htm">我的收藏</a></li>
					<li><a href="#">我的兑换</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/medal/getAllMedal.htm?page=1"
						>体验勋章</a></li>
					<li><a href="#">美试提醒</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/inviteFriends.htm">邀请好友</a></li>
					<li><a href="#">我的空间</a></li>
					<li><a
						href="${pageContext.request.contextPath}/safety/toSafety.htm">安全中心</a></li>
					<li><a href="#">帮助中心</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/logout.htm">退出</a></li>
				</ul>
      <div class="indiv_br fr">
        <div id="Tab1" class="data">
          <div class="Menubox">
            <ul>
				<li><a href="<%=basePath%>/user/profile.htm">个人资料</a></li>
				<li><a href="<%=basePath%>/user/uploadPhoto.htm">修改头像</a></li>
				<li><a href="<%=basePath%>/user/toRecAddr.htm" class="hover">收货地址</a></li>
            </ul>
          </div>
          <div class="Contentbox fixed">
            <div id="con_one_3" >
              <div class="address fixed" >
              	<form action="<%=basePath%>/user/addRecAddr.htm" method="post" name="addrForm" id="addrForm">
              	  <div id="addrDiv">
	                <ul class="address_a fixed">
						<h3>
							<span class="icon02"></span><span id="addrTitle">新增</span>当前收货地址
						</h3>
						<li>
							<span class="add01"><em>*</em>号为必填项。为保证商品安全送达您手中，请务必写真实信息。</span>
						</li>
						<li>
							<span class="add02"><em>*</em>收货人姓名：</span>
							<input type="hidden" name="recieveAddressId" id="recieveAddressId" value="${recAddr.recieveAddressId}"/>
							<input type="text" name="recieveName" id="recieveName" value="${recAddr.recieveName}"	class="loginFormTdIpt_a">
							<div id="recieveNameTip"></div>
						</li>
						<li>
							<span class="add02"><em>*</em>所在地区：</span>
							<input type="hidden" name="provinceName" id="provinceName" value="${recAddr.provinceName}"/>
							<input type="hidden" name="cityName" id="cityName" value="${recAddr.cityName}"/>
							<input type="hidden" name="districtName" id="districtName" value="${recAddr.districtName}"/>
							<select name="province" id="s_province" class="loginFormTdIpt_c">
								<option>
									请选择
								</option>
							</select>
							<select name="city" id="s_city" class="loginFormTdIpt_c">
								<option>
									请选择
								</option>
							</select>
							<select name="district" id="s_county" class="loginFormTdIpt_c">
								<option>
									请选择
								</option>
							</select>
							<div id="areaTip"></div>
						</li>
						<li>
							<span class="add02"><em>*</em>街道地址：</span>
							<input type="text" name="address" id="address" value="${recAddr.address}"
								class="loginFormTdIpt_b "><div id="addressTip"></div>
						</li>
						<li>
							<span class="add02">邮政编码：</span>
							<input type="text" name="zipCode" id="zipCode" value="${recAddr.zipCode}"
								class="loginFormTdIpt_a"><div id="zipCodeTip"></div>
						</li>
						<li>
							<span class="add02"><em>*</em>手机号码：</span>
							<input type="text" name="recieveMobilephone" value="${recAddr.recieveMobilephone}"
								id="recieveMobilephone" class="loginFormTdIpt_a"><div id="recieveMobilephoneTip"></div>
						</li>
						<li>
							<span class="add02">固定电话：</span>
							<input type="text" name="recieveTelephone" id="recieveTelephone" value="${recAddr.recieveTelephone}"
								class="loginFormTdIpt_a"><div id="recieveTelephoneTip"></div>
						</li>
						<li class="left">
							<c:choose>
								<c:when test="${recAddr.isDefaultAddress==1}">
									<input type="checkbox" name="isDefaultAddress"
										id="isDefaultAddress" value="1" class="data_bd03" checked="checked"/>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="isDefaultAddress"
										id="isDefaultAddress" value="1" class="data_bd03"/>
								</c:otherwise>
							</c:choose>
							<label for="isDefaultAddress" class="data_bd04">
								设为默认地址
							</label>
						</li>
						<li>
							<a href="#" id="subAddr">保存收货地址</a>
						</li>
					</ul>
	              </div>
                </form>
                <div class="address_b"> <span><em>已保存的地址</em>(收货地址最多仅能保存3个)</span>
                  <table width="725" border="0" cellspacing="1" cellpadding="0" bgcolor="92d500" id="tb">
                    <tr>
                      <td width="60" height="30" bgcolor="#ffffff" align="center" valign="middle">收货人</td>
                      <td width="136" height="30" bgcolor="#ffffff" align="center" valign="middle">所在地区</td>
                      <td width="170" height="30" bgcolor="#ffffff" align="center" valign="middle">街道地址</td>
                      <td width="75" height="30" bgcolor="#ffffff" align="center" valign="middle">邮编</td>
                      <td width="102" bgcolor="#ffffff" align="center" valign="middle">电话/手机</td>
                      <td width="83" height="30" bgcolor="#ffffff" align="center" valign="middle">状态</td>
                      <td height="30" bgcolor="#ffffff" align="center" valign="middle">操作</td>
                    </tr>
                    <div id="addrListDiv">
                    <c:forEach items="${addrList}" var="addr">
	                    <tr>
	                      <td width="60" height="80" bgcolor="#f7fceb" align="center" valign="middle">
	                      	${addr.recieveName}
	                      </td>
	                      <td width="136" height="80" bgcolor="#f7fceb" align="center" valign="middle">
                      		<c:choose>
                      			<c:when test="${addr.provinceName==addr.cityName}">
                      				${addr.provinceName}${addr.districtName}
                      			</c:when>
                      			<c:otherwise>
                      				${addr.provinceName}${addr.cityName}${addr.districtName}
                      			</c:otherwise>
                      		</c:choose>
	                      </td>
	                      <td width="170" height="80" bgcolor="#f7fceb" align="left" valign="middle" style="padding:0 5px">${addr.address}</td>
	                      <td width="75" bgcolor="#f7fceb" align="center" valign="middle">${addr.zipCode}</td>
	                      <td width="102" height="80" bgcolor="#f7fceb" align="center" valign="middle">${addr.recieveMobilephone}</td>
	                      <td width="83" height="80" bgcolor="#f7fceb" align="center" valign="middle">
	                      	<c:choose>
	                      		<c:when test="${addr.isDefaultAddress==1}">
	                      			默认地址
	                      		</c:when>
	                      	</c:choose>
	                      </td>
	                      <td height="80" bgcolor="#f7fceb" align="center" valign="middle" class="hons">
	                      	<a href="#" onclick="updateAddr('${addr.recieveAddressId}')">修改</a> | <a href="#" onclick="delAddr('${addr.recieveAddressId}')">删除</a>
	                      </td>
	                    </tr>
                    </c:forEach>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script language="javascript" src="<%=basePath%>/js/common/area.js"></script>
<script language="javascript" src="<%=basePath%>/js/user/recAddr.js"></script>
<script language="javascript" src="<%=basePath%>/js/common/formValidator/formValidator.min.js"></script>
<script language="javascript" src="<%=basePath%>/js/common/formValidator/formValidatorRegex.js"></script>
</body>
</html>
