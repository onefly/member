<%@ page language="java" pageEncoding="UTF-8" import="java.util.*"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>上传结果</title>
<script src="<%=basePath %>/js/common/jquery-1.11.0.js"></script>
<script type="text/javascript">

	function del(fileUrl){
		$.ajax({
		   url:basePath+"/dfs/delete.json",
		   data:"filePath="+fileUrl,
		   type: "get",                    
		   async : false,
		   dataType:"json",
		   beforeSend:function(){
		   },
		   success:function(data){
		   		if(data.result==0){
	   				alert("删除成功");
			 		$("#img1").remove();
			 		$("#del1").remove();
			 		
		   		}
		 		
		   }  
		});
	}

</script>


</head>
<body>
 <c:forEach items="${filePathList}" varStatus="filePathStatus" var="filePaths">
 	 <a id="del1" href="javascript:void(0);" onclick="javascript:del('${filePaths}');return false;">删除</a>
 	<br/>
 	<br/>
	<img id="img1" src="<%=imagePath %>/${filePaths}" />
	<br/>
 	<br/>
 	<br/>
 	<br/>
 </c:forEach>
 	
</body>
</html>