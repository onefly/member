<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8" import="com.framelib.common.CommonConstants"%>
   <%
	/*********PATH***********/
	String imagePath2 = CommonConstants.IMAGE_PATH;
   %>
			<div class="indiv_cent fixed">
				<div class="indiv_top_img"><a href="#"><img id="bigHeadUrlId" src="<%=imagePath2%>/${user.bigHeadUrl}"
					width="150" height="150" /></a><a href="#" class="top_img01">进入我的空间</a></div>
				<div class="indiv_top_right">
				
				    <div class="indiv_tlt fixed"><span class="width204">昵称：${user.nickname}</span><span class="width160">美试ID：${user.userId }</span> <span class="mail">未读提醒：<em class="luse">34</em></span><p class="indiv_position"><em class="tb07"></em><a href="#" class="luse">了解美试VIP</a></p></div>
					<ul class="fixed">
						<li><p>会员类别：普通会员</p> <p>会员有效期：2014/05/06</p> <p class="left25">体验等级：LV1</p></li>
						<li><p><em class="tb01"></em>积分：<span>${user.score}</span></p> <p><em class="tb02"></em>体验值：<span>${user.experienceValue}</span></p> <p><em class="tb03"></em>体验宝：<span>${user.ingot}</span></p> <p><em class="tb04"></em>体验勋章：<span>${user.medalCount}</span></p></li>
					</ul>
					<div class="indiv_tlb fixed"><a href="#" class="din">帮助中心</a><a href="#" class="zan">点击签到</a>上次登录时间${user.lastLoginTimeStr}</div>					
				</div>
				   
				
				
				
                    				
					
			</div>
			<!-- </div> -->