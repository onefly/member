<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	   <%@ include file="/WEB-INF/jsps/includes/import.jsp"%>
  <style type="text/css" media="screen">
  html, body { height:100%; background-color: #ffffff;}
  #flashContent { width:100%; height:100%; }
  </style>
  
  <script type="text/javascript">
   function uploadevent(status,picUrl,callbackdata){
	  var data= jQuery.parseJSON(callbackdata);
 // alert(picUrl[0]); //åç«¯å­å¨å¾ç
//alert(data.status);
        status += '';
        
     switch(status){
     case '1':
    	//alert(data.picUrl[0]);
    	//alert($("#bigHeadUrlId").attr("src"));
    	 $("#bigHeadUrlId").attr("src",'<%=imagePath%>'+'/'+data.picUrl[0]);
		//document.getElementById('avatar_priview').innerHTML = "å¤´å1 : <img src='"+filename162+"?" + time + "'/> <br/> å¤´å2: <img src='"+filename48+"?" + time + "'/><br/> å¤´å3: <img src='"+filename20+"?" + time + "'/>" ;
		
	break;
     case '0':
    	 alert("上传失败")
	  window.location.reload();
     break;
     default:
     window.location.reload();
    } 
   }
  </script>
 </head>
 <body>
  <div id="altContent">


<OBJECT classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,40,0"
WIDTH="650" HEIGHT="450" id="myMovieName">
<PARAM NAME=movie VALUE="avatar.swf">
<PARAM NAME=quality VALUE=high>
<PARAM NAME=bgcolor VALUE=#FFFFFF>
<param name="flashvars" value="imgUrl=${pageContext.request.contextPath}/images/defaultHead.jpg&uploadUrl=${pageContext.request.contextPath}/uploadHead.json&uploadSrc=false" />
<EMBED src="${pageContext.request.contextPath}/flash/avatar.swf" quality=high bgcolor=#FFFFFF WIDTH="650" HEIGHT="450" wmode="transparent" flashVars="imgUrl=${pageContext.request.contextPath}/images/defaultHead.jpg&uploadUrl=${pageContext.request.contextPath}/uploadHead.json&uploadSrc=false""
NAME="myMovieName" ALIGN="" TYPE="application/x-shockwave-flash" allowScriptAccess="always"
PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer">
</EMBED>
</OBJECT>
 

  </div>

  <div id="avatar_priview"></div>

</body>
</html>