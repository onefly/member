<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>

<table class="tab_noe fixed">
	<thead>
		<tr>
                      <th width="148" align="center" valign="middle" class="bl_none">产品名称</th>
                      <th width="88" align="center" valign="middle">保证金（元）</th>
                      <th width="88" align="center" valign="middle">本次试用人数</th>
                      <th width="88" align="center" valign="middle">本次申请人数</th>
                      <th width="88" align="center" valign="middle">申请支持人数</th>
                      <th width="95" align="center" valign="middle">试用活动状态 </th>
                      <th width="103" align="center" valign="middle">申请审核状态 </th>
                      <th width="95" align="center" valign="middle" class="br_none">操作</th>
                    </tr>
	</thead>
	<c:forEach items="${applyList}" var="apply">
		<tbody>
			<tr class="lt_probm">
				<td colspan="8"><span><em>申请单编号：</em>${apply.applyId}</span><span><em>申请时间：</em>
						<fmt:formatDate value="${apply.applyTime}"
							pattern="yyyy/MM/dd HH:mm:ss" />
				</span></td>
			</tr>
			<tr class="border_bottom">
				<td width="148" height="120" align="center" valign="middle" class="border_img bl_none"><div>
						<a href="#"><img src="<%=imagePath%>/${apply.productImage}"
							width="68" height="68" />
						<p>${apply.productName}</p></a>
					</div></td>
				<td height="120" align="center" valign="middle"><div>${apply.ensureCash}</div></td>
				<td height="120" align="center" valign="middle"><div>${apply.openCount}</div></td>
				<td height="120" align="center" valign="middle"><div>${apply.applyCount}</div></td>
				<td height="120" align="center" valign="middle"><div
						class="line_height18"><p class="yellow">${apply.supportNum}</p><p>
							<a
								href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/apply/forSupport/${apply.applyId}.htm"
								class="blue" target="_blank">拉赞详情</a>
						</p>
					</div></td>
				<td height="120" align="center" valign="middle"><div>
						<c:if test="${apply.activityState eq 21}"> <div>等待申请开始</div></c:if>
						<c:if test="${apply.activityState eq 22}"> <div>待审核</div></c:if>
						<c:if test="${apply.activityState eq 23}"> <div>审核中</div></c:if>
						<c:if test="${apply.activityState eq 24}"> <div>订单提交中</div></c:if>
						<c:if test="${apply.activityState eq 25}"> <div>试用结束</div></c:if>
					</div></td>
				<td height="120" align="center" valign="middle"><div
						class="line_height18">
						<c:if test="${apply.applyState eq 0}"> 待审核</c:if>
						<c:if test="${apply.applyState eq 1}"> <span class="green">审核通过</span></c:if>
						<c:if test="${apply.applyState eq 2}"> <p class="yellow">审核未通过</p></c:if>
						<p>
							<a
								href="<%=CommonConstants.COMMON_PATH.get("order.maxtp")%>/apply/showDetail.htm?id=${apply.applyId}"
								class="blue" target="_blank">申请单详情</a>
						</p>
						<!-- <p><a href="#" class="blue">申请状态</a></p> -->
					</div></td>
				<td height="120" align="center" valign="middle" class="br_none"><c:if
						test="${apply.submitState eq 1 }">
						<div class="zhu">
                          <p class="green"><em class="zhu2"></em>订单已提交</p>
                        </div>
					</c:if> <c:if
						test="${apply.submitState eq 0 and apply.activityState eq 25 and apply.applyState eq 1}">
						<div class="zhu">
							<div class="zhu">
                          <p class="yellow"><em class="zhu1"></em>未提交订单</p>
                        </div>
						</div>
					</c:if> <c:if
						test="${apply.submitState eq 0 and apply.activityState eq 24 and apply.applyState eq 1}">

						<div>
							<form action="http://127.0.0.1:8080/order/order/toSubmitFreeOrder.htm" method="post">
								<input type="hidden" name="id" value="${apply.applyId}"/>
								<input type="hidden" name="productCode" value="${apply.productCode}"/>
								<input type="hidden" name="version" value="${apply.version}"/>
								<input type="hidden" name="activeId" value="${apply.activityId}"/>
								<input type="hidden" name="standardId" value="${apply.standardId}"/>
								<input type="hidden" name="brandCode" value="${apply.brandId}"/>
								<input type="hidden" name="brandName" value="${apply.brandName}"/>
							 <input type="submit" name="button" id="button" class="input_boredr_none mybj01" value="提交订单" />
							</form>
							<p class="yellow">
								倒计时<br /> <span class="yellow" id="downTime_${apply.applyId}">
									72:00:00</span>

							</p>
						</div>
						<script type="text/javascript">
							$(function() {
								var id = "downTime_${apply.applyId}";
								var end = '<fmt:formatDate value="${apply.submitEndTime}" pattern="yyyy/MM/dd HH:mm:ss" />';
								countdown_hour(id, end);
							});
						</script>
					</c:if></td>
			</tr>
		</tbody>
	</c:forEach>
</table>
<c:if test="${fn:length(applyList) == 0}">
	<tbody>
		<tr class="border_bottom">

			<td colspan="8" height="150" align="center" valign="middle"><div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 没有申请单数据</div></td>
		</tr>
	</tbody>
</c:if>
<c:if test="${fn:length(applyList) gt 0}">
	<div class="medal_bottom padding35">
		<!-- 分页组件 -->
		<%@include file="/WEB-INF/jsps/includes/page.jsp"%>

	</div>
</c:if>


