<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>

<table class="tab_noe fixed">
                    <thead>
                      <tr>
                        <th width="300" align="center" valign="middle">产品名称</th>
                        <th width="120" align="center" valign="middle">体验价（元）</th>
                        <th width="120" align="center" valign="middle">实付款（元）</th>
                        <th width="100" align="center" valign="middle">退款操作</th>
                        <th width="110" align="center" valign="middle">订单状态</th>
                        <th width="120" align="center" valign="middle">订单操作</th>
                      </tr>
                    </thead>
                    <c:if test="${empty nakedOrderDTOList }">
                    	<em>亲，本页还没有您的体验记录呢</em>
                    </c:if>
                    
                    <c:if test="${not empty nakedOrderDTOList }">
	                  <tbody>
                    	<!-- 遍历展示主订单 -->
                    	<c:forEach items="${nakedOrderDTOList}" var="nakedOrder">
		                      <tr class="lt_probm">
		                        <td colspan="6">
		                          <span>订单编号：<em>${nakedOrder.order.id }</em></span>
		                          <span>拍下时间：<fmt:formatDate value="${nakedOrder.order.createTime }" pattern="yyyy/MM/dd hh:mm:ss"/></span>
		                        </td>
		                      </tr>
		                      <!-- 子订单的遍历展示 -->
		                      <c:forEach items="${nakedOrder.orderChilds }" var="childOrder" varStatus="childNum">
			                      <tr class="border_bottom">
			                        <td height="120" align="center" valign="middle" class="border_img">
			                          <div>
			                            <a href="#" class="fl f_l">
			                              <img src="<%=basePath %>/images/exchange01.jpg" width="68" height="68" />
			                            </a>
			                            <p class="fl f_r"><a href="#">CLINIQUE倩碧特效润肤露有油配方进口倩碧黄油天才黄</a>红色 XS${childOrder.id }</p>
			                          </div>
			                        </td>
			                        <td height="120" align="center" valign="middle"><div>${childOrder.actiPrice }</div></td>
			                        
			                        <c:if test="${childNum.first }">
			                          <td height="120" align="center" valign="middle" rowspan="${fn:length(nakedOrder.orderChilds)}">
			                            <div>${nakedOrder.order.orderFund}</div>
			                          </td>
			                        </c:if>
			                        
			                        <!-- 买家手动关闭 -->
			                        <c:if test="${childOrder.state eq 101 }">
				                        <td height="120" align="center" valign="middle"><div></div></td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易关闭
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <!-- <input type="submit" name="button" id="button" class="mybj01" value="支付保证金" />
				                            <p class="yellow">倒计时<br />72:00:00</p> -->
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 买家未付款，定时器自动关闭 -->
				                    <c:if test="${childOrder.state eq 102 }">
				                        <td height="120" align="center" valign="middle"><div></div></td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易关闭
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle" class="br_none">
				                          <div class="zhu">
                          					<p class="yellow"><em class="zhu1"></em><em>未付款</em></p>
                        				  </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 卖家一直未发货，定时器自动关闭，存在补偿问题 -->
				                    <c:if test="${childOrder.state eq 103 }">
				                        <td height="120" align="center" valign="middle"><div></div></td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易关闭
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <p class="yellow">发货超时<br />
				                            				30天 00小时
				                            </p>
				                            <p><a href="#" class="blue">【赔偿标准】</a></p>
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 待付款状态 -->
				                    <c:if test="${childOrder.state eq 200 }">
				                        <td height="120" align="center" valign="middle"><div></div></td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18"><span id="waitPay_${nakedOrder.order.id}">待付款</span>
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                          </div>
				                        </td>
				                         <td id="empty_${nakedOrder.order.id}" height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="closeOrder_${nakedOrder.order.id}"
				                            	onclick="closeOrder('${nakedOrder.order.id}')" class="mybj02" value="取消订单" />
				                            <input type="submit" name="button" id="pay_${nakedOrder.order.id}" class="mybj01" value="立即付款" />
				                            <p class="yellow" id="remaind_paytime_${childOrder.id }">剩余<br />72:00:00</p>
				                          </div>
				                          <script type="text/javascript">
											$(function() {
												var id = "remaind_paytime_${childOrder.id }";
												var end = '<fmt:formatDate value="${childOrder.orderCreateTime}" pattern="yyyy/MM/dd HH:mm:ss" />';
												countdown_hour(id, end);
											});
										  </script>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 已付款未发货状态 ，未发货超7天显示补偿机制-->
				                    <c:if test="${childOrder.state eq 300 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="button" name="noDeliver_refund" id="noDeliver_refund" class="mybj02 show" value="未发货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">已付款
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          
				                          <input type="submit" name="button" id="button" class="mybj01" value="提醒发货" />
				                            <div id="timeout_div_${childOrder.id }" style="display: none">
					                            <p class="yellow" id="timeout_data_${childOrder.id }">发货超时<br/>
					                            				7天  06小时
					                            </p>
					                            <p><a href="#" class="blue">【赔偿标准】</a></p>
				                            </div>
				                          <script type="text/javascript">
											$(function() {
												var id_div = "timeout_div_${childOrder.id }";
												var id_data = "timeout_data_${childOrder.id }";
												var payment_time = '<fmt:formatDate value="${nakedOrder.order.buyerPaymentTime}" pattern="yyyy/MM/dd HH:mm:ss" />';
												var ts = (new Date()) - (new Date(payment_time));
												if (ts < 0){
													ts = 0;
												}
												var dd = parseInt(ts / 1000 / 60 / 60 / 24, 10);
												var hh = parseInt(ts / 1000 / 60 / 60 % 24, 10);
												var mm = parseInt(ts / 1000 / 60 % 60, 10);
												var ss = parseInt(ts / 1000 % 60, 10);
												dd = checkTime(dd);
												hh = checkTime(hh);
												mm = checkTime(mm);
												ss = checkTime(ss);
												if(dd >= 7){
													document.getElementById(id_div).style.display = "block";
													document.getElementById(id_data).innerHTML =
															"发货超时<br/>" + dd + "<em>天</em>" + hh + "<em>时</em>";
												}
											});
										  </script>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 卖家已发货 -->
				                    <c:if test="${childOrder.state eq 400 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button" class="mybj02 show" value="未收货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">已发货
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button"
				                            	onclick="confirmRecieve(${childOrder.id}) " class="mybj01" value="确认收货" />
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 用户已收货，待评价状态 -->
				                    <c:if test="${childOrder.evaluateState eq 801 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button" class="mybj02 show" value="退货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">待评价
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="button" name="nakedEvaluate_btn" id="nakedEvaluate_btn"
				                            	onclick="toEvaluate(${childOrder.id})" class="mybj01" value="发表评论" />
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 系统默认已评价，待卖家回复 -->
									  <c:if test="${childOrder.evaluateState eq 802 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button" class="mybj02 show" value="退货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易完成
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="button" name="nakedEvaluate_btn" id="nakedEvaluate_btn"
				                            	onclick="" class="mybj01" value="体验追评" />
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 买家已评价，待回复 -->
				                    <c:if test="${childOrder.evaluateState eq 803 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button" class="mybj02 show" value="退货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易完成
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="button" name="nakedEvaluate_btn" id="nakedEvaluate_btn"
				                            	onclick="" class="mybj01" value="体验追评" />
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 系统默认已回复，待卖家追评 -->
				                    <c:if test="${childOrder.evaluateState eq 804 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button" class="mybj02 show" value="退货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易完成
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="button" name="nakedEvaluate_btn" id="nakedEvaluate_btn"
				                            	onclick="" class="mybj01" value="体验追评" />
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 卖家已回复，待买家追评 -->
				                    <c:if test="${childOrder.evaluateState eq 805 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button" class="mybj02 show" value="退货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易完成
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="button" name="nakedEvaluate_btn" id="nakedEvaluate_btn"
				                            	onclick="" class="mybj01" value="体验追评" />
				                          </div>
				                        </td>
				                    </c:if>
				                    
				                    <!-- 买家已追评 -->
				                    <c:if test="${childOrder.evaluateState eq 807 }">
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                            <input type="submit" name="button" id="button" class="mybj02 show" value="退货退款" />
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div class="line_height18">交易完成
				                            <p><a href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/order/detail.htm?id=${nakedOrder.order.id}" class="blue">订单详情</a></p>
				                            
				                          </div>
				                        </td>
				                        <td height="120" align="center" valign="middle">
				                          <div>
				                          </div>
				                        </td>
				                    </c:if>
				                             
				                    <!-- 未发货退款(退款中) -->
				                    <c:if test="${childOrder.state eq 610 }">
				                      <td height="120" align="center" valign="middle">
				                      	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未发货退款</em></p>
			                        	</div>
			                          </td>
			                     	  <td height="120" align="center" valign="middle">
			                     	  	<div class="line_height18">
			                          	  <p class="yellow">退款中</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                          	</div>
			                          </td>
			                     	  <td height="120" align="center" valign="middle" class="br_none"><div></div></td>
                      				</c:if>
                      				
                      				<!-- 未发货退款（等待美试确认） -->
                      				<c:if test="${childOrder.state eq 611 }">
				                      <td height="120" align="center" valign="middle">
				                      	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未发货退款</em></p>
			                        	</div>
			                          </td>
			                     	  <td height="120" align="center" valign="middle">
			                     	  	<div class="line_height18">
			                          	  <p class="yellow">等待美试确认退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                          	</div>
			                          </td>
			                     	  <td height="120" align="center" valign="middle" class="br_none"><div></div></td>
                      				</c:if>
                      				
                      				<!-- 未发货退款（退款成功） -->
                      				<c:if test="${childOrder.state eq 612 }">
				                      <td height="120" align="center" valign="middle">
				                      	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未发货退款</em></p>
			                        	</div>
			                          </td>
			                     	  <td height="120" align="center" valign="middle">
			                     	  	<div class="line_height18">
			                          	  <p class="green">已退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                          	</div>
			                          </td>
			                     	  <td height="120" align="center" valign="middle" class="br_none"><div></div></td>
                      				</c:if>
                      				
                      				<!-- 未收货退款（退款中） -->
                      				<c:if test="${childOrder.state eq 620 }">
                      				  <td height="120" align="center" valign="middle">
                      				  	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未收货退款</em></p>
			                        	</div>
			                          </td>
			                      	  <td height="120" align="center" valign="middle">
			                      	  	<div class="line_height18">
			                          	  <p class="yellow">退款中</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                          </td>
			                          <td height="120" align="center" valign="middle" class="br_none"><div></div></td>
			                       </c:if>
                      				
                      				<!-- 未收货退款（品牌拒绝退款） -->
                      				<c:if test="${childOrder.state eq 621 }">
                      				  <td height="120" align="center" valign="middle">
                      				  	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未收货退款</em></p>
			                        	</div>
			                          </td>
			                      	  <td height="120" align="center" valign="middle">
			                      	  	<div class="line_height18">
			                          	  <p class="yellow">品牌拒绝退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                          </td>
			                          <td height="120" align="center" valign="middle" class="br_none"><div></div></td>
			                       </c:if>
                      				
                      				<!-- 未收货退款（美试处理退款中） -->
                      				<c:if test="${childOrder.state eq 622 }">
                      				  <td height="120" align="center" valign="middle">
                      				  	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未收货退款</em></p>
			                        	</div>
			                          </td>
			                      	  <td height="120" align="center" valign="middle">
			                      	  	<div class="line_height18">
			                          	  <p class="yellow">美试处理退款中</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                          </td>
			                          <td height="120" align="center" valign="middle" class="br_none"><div></div></td>
			                       </c:if>
                      				
                      				<!-- 未收货退款（等待美试确认退款） -->
                      				<c:if test="${childOrder.state eq 623 }">
                      				  <td height="120" align="center" valign="middle">
                      				  	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未收货退款</em></p>
			                        	</div>
			                          </td>
			                      	  <td height="120" align="center" valign="middle">
			                      	  	<div class="line_height18">
			                          	  <p class="yellow">等待美试确认退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                          </td>
			                          <td height="120" align="center" valign="middle" class="br_none"><div></div></td>
			                       </c:if>
                      				
                      				<!-- 未收货退款（退款关闭（美试拒绝退款）） -->
                      				<c:if test="${childOrder.state eq 624 }">
                      				  <td height="120" align="center" valign="middle">
                      				  	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未收货退款</em></p>
			                        	</div>
			                          </td>
			                      	  <td height="120" align="center" valign="middle">
			                      	  	<div class="line_height18">
			                          	  <p class="yellow">退款关闭</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                          </td>
			                          <td height="120" align="center" valign="middle" class="br_none">
			                          	<div class="zhu">
                          				  <p class="yellow"><em class="zhu1"></em><em>美试拒绝退款</em></p>
                        				</div>
			                          </td>
			                       </c:if>
                      				
                      				<!-- 未收货退款（退款关闭（用户超时关闭）） -->
                      				<c:if test="${childOrder.state eq 625 }">
                      				  <td height="120" align="center" valign="middle">
                      				  	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未收货退款</em></p>
			                        	</div>
			                          </td>
			                      	  <td height="120" align="center" valign="middle">
			                      	  	<div class="line_height18">
			                          	  <p class="yellow">退款关闭</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                          </td>
			                          <td height="120" align="center" valign="middle" class="br_none">
			                          	<div class="zhu">
                          				  <p class="yellow"><em class="zhu1"></em><em>用户超时关闭</em></p>
                        				</div>
                        			  </td>
			                       </c:if>
			                       
			                       <!-- 未收货退款（已退款） -->
			                       <c:if test="${childOrder.state eq 626 }">
                      				  <td height="120" align="center" valign="middle">
                      				  	<div class="zhu">
			                          	  <p class="yellow"><em class="zhu"></em><em>未收货退款</em></p>
			                        	</div>
			                          </td>
			                      	  <td height="120" align="center" valign="middle">
			                      	  	<div class="line_height18">
			                          	  <p class="green">已退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                          </td>
			                          <td height="120" align="center" valign="middle" class="br_none">
			                          	<div>
                        				</div>
                        			  </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（退款申请中） -->
			                       <c:if test="${childOrder.state eq 630 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">退款申请中</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（品牌同意退款申请） -->
			                       <c:if test="${childOrder.state eq 631 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">品牌同意退款申请</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（品牌拒绝退款申请） -->
			                       <c:if test="${childOrder.state eq 632 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">品牌拒绝退款申请</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（美试处理退款申请中） -->
			                       <c:if test="${childOrder.state eq 633 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">美试处理退款申请中</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（美试同意退款申请） -->
			                       <c:if test="${childOrder.state eq 634 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">美试同意退款申请</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（退款申请关闭（美试拒绝退款申请）） -->
			                       <c:if test="${childOrder.state eq 635 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">退款申请关闭</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div class="zhu">
                          				  <p class="yellow"><em class="zhu1"></em><em>美试拒绝退款申请</em></p>
                        				</div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（退款申请关闭（用户超时关闭）） -->
			                       <c:if test="${childOrder.state eq 636 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">退款申请关闭</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div class="zhu">
                          				  <p class="yellow"><em class="zhu1"></em><em>用户超时关闭</em></p>
                        				</div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（等待收货退款） -->
			                       <c:if test="${childOrder.state eq 640 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">等待收货退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（品牌拒绝退款） -->
			                       <c:if test="${childOrder.state eq 641 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">品牌拒绝退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（美试处理退款中） -->
			                       <c:if test="${childOrder.state eq 642 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">美试处理退款中</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（等待美试确认退款） -->
			                       <c:if test="${childOrder.state eq 643 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>等待美试确认退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">退款申请中</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（退款关闭（美试拒绝退款）） -->
			                       <c:if test="${childOrder.state eq 644 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">退款关闭</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div class="zhu">
                          				  <p class="yellow"><em class="zhu1"></em><em>美试拒绝退款</em></p>
                        				</div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（退款关闭（用户超时关闭）） -->
			                       <c:if test="${childOrder.state eq 645 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="yellow">退款关闭</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div class="zhu">
                          				  <p class="yellow"><em class="zhu1"></em><em>用户超时关闭</em></p>
                        				</div>
			                         </td>
			                       </c:if>
			                       
			                       <!-- 退货退款（已退款） -->
			                       <c:if test="${childOrder.state eq 646 }">
			                         <td height="120" align="center" valign="middle">
			                         	<div class="zhu">
			                       		  <p class="yellow"><em class="zhu"></em><em>退货退款</em></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle">
			                         	<div class="line_height18">
			                          	  <p class="green">已退款</p>
			                          	  <p><a href="#" class="blue">订单详情</a></p>
			                          	  <p><a href="#" class="blue">退款详情</a></p>
			                        	</div>
			                         </td>
			                         <td height="120" align="center" valign="middle" class="br_none">
			                         	<div></div>
			                         </td>
			                       </c:if>
			                     </tr>
		                      </c:forEach>
		                  </c:forEach>
		               </tbody>
                    </c:if>
                  </table>
              	  <c:if test="${not empty nakedOrderDTOList }">
					<div class="medal_bottom padding35" >
						<!-- 分页组件 -->
						<%@include file="/WEB-INF/jsps/includes/page.jsp"%>
						
					</div>
			      </c:if>
			      
	<div id="hinta" class="hinta">
	  <h2>退款温馨提示</h2>
	  <dl>
	    <dt> 1. 美试网所有产品仅提供一次体验机会，确认退款后不能再次体验。 <br />
	      	 2. 确认退款后您消耗的体验宝将不再返还，请理性申请。 </dt>
	    <dd>
	      <input type="submit" name="button2" id="button2" value="确认退款" class="l_bj" />
	      <input type="submit" name="button2" id="close" class="h_bj" value="取消退款" />
	    </dd>
	  </dl>
	</div>
	<div id="abk" style="z-index:20; position:absolute; top:0; left:0;"></div>
	<script src="<%=basePath %>/js/common/open_div.js" type="text/javascript" defer="defer" ></script> 
	<script>
		$(function(){
			oTk(id('hinta'),id('abk'), id('close'),$('.show'));
		}); 
	</script>