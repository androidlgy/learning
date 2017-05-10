<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function init(){
        var kbDom = document.getElementById('kb');
        var obj = document.getElementById('div_video');
        var isIE = window.navigator.userAgent.indexOf("MSIE")>-1;
        JS.Engine.on({
                hello : function(kb){//侦听一个channel
                        kbDom.innerHTML = kb;
                        if(kb!=null){
                       // document.getElementById("kb1").src=kb;
                       /*  if(isIE){
                       
                        }
                        else{ */
                       /*  document.embeds['musicDemo'].src=kb; */
                      /*   } */
                          document.write("<h1 align='center'>警告</h1>");
                          document.write("<p align='center' style='font-size:20px'>"+kb+"</p>");
                          document.write("<p align='center'><img src='Images/timg.jpg'/></p>");
                          document.write("<embed id='sound' src='"+kb+"' hidden='true'></embed>");
                          document.close();
                          $("#div_video").html(html);//动态改变
                          
                         alert(kb);
                        }
                }
        });
        JS.Engine.start('conn');
        JS.Engine.on(
        'start',function(cId,channelList,engine){
        	  alert('连接已建立，连接ID为：' + cId);
        });
}
</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
