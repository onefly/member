<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>发货赔偿-赔付详情</title>
<link href="<%=basePath %>/style/base.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>/style/meishi_backstage.css" rel="stylesheet" type="text/css" />
</head>
  
<body class="background_gray">
<div id="wapper"> 
  <!-- 引入美试网公共头 -->
 <jsp:include page="/WEB-INF/jsps/includes/top.jsp"></jsp:include>
 
  <div class="main">
   
	<%-- 引入公共头  --%>
  	<!-- <c:import url="http://localhost:8080/order/common/getUserTop.htm?userId=${repayDetail.buyerId}"></c:import> -->
  	<c:import url="common/getUserTop.htm?userId=${repayDetail.buyerId}">
  		<c:param name="pageTitle" value='<%=""+CommonConstants.COMMON_PATH.get("order.maxtp")%>'/>
  	</c:import>
  	<%-- 引入公共头结束  --%>
    
    <div class="n_trace">
      <p class="green hg36">
      	<c:if test="${repayDetail.type==0}">
        	<input type="submit" name="button" id="button" value="裸价体验" class="bj_lj" />
        </c:if>
        <c:if test="${repayDetail.type==1}">
        	<input type="submit" name="button" id="button" value="免费试用" class="bj_lj" />
        </c:if>
       	 发货超时赔偿编号：${repayDetail.id}
      </p>
      <div class="n_traceq boreder top5">
        <div class="n_traceqt"> <span class="bold" style="margin-left:34px;"><em>确认发货超时天数</em><br />
          <fmt:formatDate value="${repayDetail.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></span> <span style="margin-left:270px;"><em>确认发货超时赔偿积分</em><br />
          <fmt:formatDate value="${repayDetail.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></span> <span style="margin-left:260px;"><em>支付赔偿积分</em><br />
          <fmt:formatDate value="${repayDetail.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></span>
          <div class="bj_trace01 fixed" style="display:none;"></div>
          <div class="bj_trace02 fixed" style="display:none;"></div>
          <div class="bj_trace03 fixed"></div>
        </div>
        <table width="998" border="0" cellspacing="0" cellpadding="0" class="n_teceqb background_white">
          <tr class="fize14">
            <td width="333" height="40" align="center" valign="middle">处理时间</td>
            <td width="334" height="40" align="center" valign="middle">处理信息</td>
            <td width="333" height="40" align="center" valign="middle">操作人</td>
          </tr>
          <tr class="fize12">
            <td width="333" height="35" align="center" valign="middle"><fmt:formatDate value="${repayDetail.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
            <td width="334" height="35" align="center" valign="middle">确认品牌发货超时${repayDetail.overtimeDay}天</td>
            <td width="333" height="35" align="center" valign="middle">美试网</td>
          </tr>
          <tr class="fize12">
            <td width="333" height="35" align="center" valign="middle"><fmt:formatDate value="${repayDetail.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
            <td width="334" height="35" align="center" valign="middle">确认发货超时赔偿积分</td>
            <td width="333" height="35" align="center" valign="middle">美试网</td>
          </tr>
          <tr class="fize12">
            <td width="333" height="35" align="center" valign="middle"><fmt:formatDate value="${repayDetail.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
            <td width="334" height="35" align="center" valign="middle">支付赔偿积分</td>
            <td width="333" height="35" align="center" valign="middle">美试网</td>
          </tr>
        </table>
      </div>
    </div>
    <div class="blog_cent top30 fixed">
      <div class="blog_cl fl"><img src="../../../images/bannk/classify09.jpg" width="300" height="535" /></div>
      <div class="blog_cr fr fixed">
        <div class="blog_crt">
          <h2>
          	<c:if test="${repayDetail.type==0}"> 裸价体验</c:if>
	        <c:if test="${repayDetail.type==1}"> 免费试用</c:if>
          </h2>
          <div class="blog_crtc"> <a href="#" class="fl"><img src="../../../images/bannk/classify15.jpg" width="200" height="200" /></a>
            <div class="fr">
              <ul>
                <li class="fr01"><a href="#">Loewe罗意威秋冬新作BRISA系列单肩包</a></li>
                <li class="fr02">本次体验活动已结束，期待下一次<span></span></li>
                <li class="fr03"><span class="gui01">规格：标准</span><span class="gui02">产地：法国</span></li>
                <li class="fr03"><span class="gui01">市场价：￥98.00</span></li>
                <li class="fr04">保证金：￥<em>980.00</em></li>
              </ul>
              <p>累计裸价体验：<em class="green">123456人</em></p>
            </div>
          </div>
        </div>

        <div class="blog_crb top30">
          <h2>美试体验指数</h2>
          <div class="tiyan">
            <div class="cpxhd">
              <h3>产品喜好度</h3>
              <div class="cpxhd_del"> <span class="fl">好</span>
                <div class="cpxhd_du"><span class="color_1" style="width:220px;"></span></div>
                <p>100%</p>
              </div>
              <div class="cpxhd_del"> <span class="fl">一般</span>
                <div class="cpxhd_du"><span class="color_2" style="width:220px;"></span></div>
                <p >40%</p>
              </div>
              <div class="cpxhd_del"> <span class="fl">不好</span>
                <div class="cpxhd_du"><span class="color_3" style="width:220px;"></span></div>
                <p>30%</p>
              </div>
              <p class="time1 fl">产品上线时间：2014/03/28</p>
              <p class="time2 fr">累计裸价体验：<span class="green">123456人</span></p>
            </div>
            <div class="ppphd">
              <h3>品牌偏好度</h3>
              <div class="ppphd_del"> <span class="fl">喜欢</span>
                <div class="ppphd_du"><span class="color_4" style="width:220px;"></span></div>
                <p>100%</p>
              </div>
              <div class="ppphd_del"> <span class="fl">没感觉</span>
                <div class="ppphd_du"><span class="color_5" style="width:20px;"></span></div>
                <p >40%</p>
              </div>
              <div class="ppphd_del"> <span class="fl">不喜欢</span>
                <div class="ppphd_du"><span class="color_6" style="width:120px;"></span></div>
                <p>30%</p>
              </div>
              <p class="time1 fl">品牌入驻时间：2014/03/28</p>
              <p class="time2 fr">累计体验：<span class="green">123456人</span></p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="blog_cent top30 fixed">
      <div class="order_information fl">
        <h2>订单信息</h2>
        <ul class="order_information_list">
          <li>订单编号：${repayDetail.orderId}</li>
          <li>拍下时间：<fmt:formatDate value="${repayDetail.orderCreateTime}" pattern="yyyy/MM/dd HH:mm:ss" /></li>
          <li>品牌商家：${repayDetail.brandName}</li>
          <li>颜色/尺码：${repayDetail.stanColorName}  ${repayDetail.stanSizeName}</li>
          <li>保证金：￥${repayDetail.orderFund}</li>
          <li>发货状态：已发货</li>
          <li>物流公司：${repayDetail.expressCompany}</li>
          <li>快递单号：${repayDetail.expressNumbers}</li>
        </ul>
      </div>
      <div class="order_information fr">
        <h2>发货超时信息</h2>
        <div class="order_shipments">
          <ul>
            <li>品牌发货超时时间：<em class="yellow">${repayDetail.overtime}</em></li>
            <li>赔付积分标准：<em class="yellow">赔偿${repayDetail.reparationUserBalance}%积分</em></li>
            <li>赔付积分：<em class="yellow">${repayDetail.reparationScoreUser}积分</em></li>
          </ul>
          <table border="0" cellspacing="0" cellpadding="0" class="compensate_state fixed">
            <tr>
              <td width="125" align="center" valign="middle" class="compensate_state_fl"><div>赔付状态</div></td>
              <td width="343" align="center" valign="middle"><div>
                  <p><input type="submit" name="button2" id="button2" value="已赔付" class="input_boredr_none state" /></p>
                  <p class="top10">赔付时间：<fmt:formatDate value="${repayDetail.createTime}" pattern="yyyy/MM/dd HH:mm:ss"/></p>
                </div></td>
            </tr>
          </table>
          <p class="yellow top10 fize14">注：发货超时赔付积分请到您的个人账户查询。</p>
        </div>
      </div>
      
    </div>
  </div>
</div>
</body>
</html>