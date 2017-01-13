<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库房环境监测系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Paix Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/jquery.min.js"></script>
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
</head>
 <script type="text/javascript">
<!--
setInterval("showTime()",1000);

function showTime()
{
var wk = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
var date = new Date();
var msg = "今天是:" + date.getFullYear()+"年";
msg += date.getMonth()+1 +"月";
msg += date.getDate() + "日";
msg += wk[date.getDay()]+" ";
msg += date.getHours()+":" + date.getMinutes()+":"+date.getSeconds();
document.getElementById("time").innerText = msg;
}
//-->
</script> 
<body>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" height="100%">
  <tr height="10%">
 	<div class="header" id="home">
		<div class="container">
			<div class="head">
			<div class="logo">
				<a href="../Downloads/cpts_292_lv/cpts_292_lv/index.html"><img src="Images/logo.png" alt="" /></a>
			</div>
				<div class="clearfix"></div>
			</div>
			</div>
		</div>	
 </tr>
    <tr height="1%">
      <td background="Images/MenuBg.jpg" align="right">&nbsp;当前用户：${sessionScope.Manager_Username}</td>
    </tr>
    <tr height="80%">
      <td height="100%" align="center" valign="top">
      <table width="80%" border="0" cellspacing="0" cellpadding="0" height="100%">
        <tr>
         
          <td width="12%" height="100%" align="left" valign="top" background="Images/leftbg.jpg">
           <%@ include file="Left.jsp"%>
          </td>
          <td width="88%" align="center" valign="middle" bgcolor="#F6F9FE"><h2>欢迎使用档案库房环境监测系统</h2></td>       
        </tr>
      </table>
      </td>
    </tr> 
    <tr height="1%">
      <td height="15" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>
  <span id="time"></span>
  </td>
  </tr>

<tr height="8%">
	<!--start-footer-->
	<div class="footer">
		<div class="container">
		<div class="touch-top heading">
				<h3>FOLLOW US</h3>
			</div>
			<div class="touch-bottom">
				<p>756 gt globel Place, CD-Road,M 07 435.</p>
				<h6 >1 234 567 9871 , 800-2345-679</h6>
				<p>purus tincidunt egestas</p>
				<ul>
					<li><a href="#"><span class="fb"> </span></a></li>
					<li><a href="#"><span class="twit"> </span></a></li>
					<li><a href="#"><span class="google"> </span></a></li>
				</ul>
			</div>
			<div class="footer-top">
				<p class="footer-class">Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网站模板" target="_blank">网站模板</a></p>
			</div>
		</div>
		<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
	<!--end-footer-->
	</tr>
</body>
</html>

