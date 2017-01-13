<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
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
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
  function mycheck(){
   if(isNull(form1.Type.value)){  
   alert("请选择身份！"); 
   return false;
   }
   if(isNull(form1.Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.Password.value)){
   alert("请输入密码！");
   return false;
   }    
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}  
		</script>
<!--start-smoth-scrolling-->
</head>
<body>z
	<!--start-header-->
	<div class="header" id="home">
		<div class="container">
			<div class="head">
			<div class="logo">
				<a href="../Downloads/cpts_292_lv/cpts_292_lv/index.html"><img src="Images/logo.png" alt="" /></a>
			</div>
			<div class="navigation">
				 <span class="menu"></span> 
					<ul class="navig">
						<li><a href="../Downloads/cpts_292_lv/cpts_292_lv/index.html"  class="active hvr-bounce-to-bottom">主页</a></li>
						<li><a href="../Downloads/cpts_292_lv/cpts_292_lv/about.html" class="hvr-bounce-to-bottom">系统介绍</a></li>
						<li><a href="../Downloads/cpts_292_lv/cpts_292_lv/services.html" class="hvr-bounce-to-bottom">服务</a></li>
						<li><a href="../Downloads/cpts_292_lv/cpts_292_lv/typo.html" class="hvr-bounce-to-bottom">关于泰德</a></li>
						<li><a href="../Downloads/cpts_292_lv/cpts_292_lv/contact.html" class="hvr-bounce-to-bottom">联系我们</a></li>
					</ul>
			</div>
				<div class="clearfix"></div>
			</div>
			</div>
		</div>	
	<!-- script-for-menu -->
		<script>
			$("span.menu").click(function(){
				$(" ul.navig").slideToggle("slow" , function(){
				});
			});
		</script>
	<!-- script-for-menu -->
	<!--start-banner-->
	<div class="banner">
		<div class="container">
			<div class="banner-top">
			<h1>系统登录</h1>
				<form name="form1" action="GoLogin.action" method="post" onSubmit="return mycheck()">
              <table style="border-collapse:separate; border-spacing:10px;">
                <tr>
                  <td height="30" colspan="2" align="center" class="STYLE2"><span style="color:red;">
                    <%if(request.getAttribute("Msg")!=null){%>
                    <%=request.getAttribute("Msg")%>
                    <%}%>
                  </span></td>
                  </tr>
                <tr class="bnr-one">
                  <td class="bnr-left"><p>身份：</p></td>
                  <td class="bnr-right"><select name="Type" id="Type">
                    <option value="">请选择</option>
                    <option value="系统管理员">系统管理员</option>
                    <option value="博物馆管理员">档案馆管理员</option>
                  </select></td>
                  </tr>
                <tr class="bnr-one">
                  <td  class="bnr-left"><p>用户名：</p></td>
                  <td class="bnr-right"><input type="text" name="Username" id="Username" class="text1" /></td>
                  </tr>
                <tr class="bnr-one">
          
                  <td height="30"  class="bnr-left" width="37%"><p>密码：</p></td>
                  <td class="bnr-right"><input type="password" name="Password" id="Password" class="text1" /></td>
                  <td class="bnr-right"><a>忘记密码</a></td>
                  </tr>
                <tr class="bnr-one">
                  <td  colspan="2" align="center"><label>
                    <input class="bnr-btn" type="submit" name="button" id="button" value="登录">
                  </label></td>
                  </tr>
              </table>
              </form>
			</div>
		</div>
	</div>
	<!--end-banner-->
	<!--FlexSlider-->
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript">
    $(function(){
      SyntaxHighlighter.all();
    });
    $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
		});
		</script>
	</div>
			<!--End-slider-script-->
	<!--start-blog-->
	<div class="news" id="news">
		<div class="container">
			<div class="news-top heading">
				<h3>LATEST NEWS</h3>
			</div>
			<div class="news-bottom">
				<div class="news-one">
				<div class="col-md-6 news-left">
					<div class="n-left">
						<img src="Images/blog-1.png" alt="" />
					</div>
					<div class="n-right">
						<h4>Sed Condimentum Enim Sem</h4>
						<p class="admin">commodo malesuada.</p>
						<p>Phasellus nec tellus tortor. Vivamus sagittis orci sit amet finibus dapibus. Suspendisse sit amet tempus nunc, id euismod nunc.Maecenas sit amet interdum massa, ut bibendum arcu.</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-6 news-left">
					<div class="n-left">
						<img src="Images/blog-2.png" alt="" />
					</div>
					<div class="n-right">
						<h4>Sed Condimentum Enim Sem</h4>
						<p class="admin">commodo malesuada.</p>
						<p>Phasellus nec tellus tortor. Vivamus sagittis orci sit amet finibus dapibus. Suspendisse sit amet tempus nunc, id euismod nunc.Maecenas sit amet interdum massa, ut bibendum arcu.</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
				</div>
				<div class="news-one">
				<div class="col-md-6 news-left">
					<div class="n-left">
						<img src="Images/blog-3.png" alt="" />
					</div>
					<div class="n-right">
						<h4>Sed Condimentum Enim Sem</h4>
						<p class="admin">commodo malesuada.</p>
						<p>Phasellus nec tellus tortor. Vivamus sagittis orci sit amet finibus dapibus. Suspendisse sit amet tempus nunc, id euismod nunc.Maecenas sit amet interdum massa, ut bibendum arcu.</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="col-md-6 news-left">
					<div class="n-left">
						<img src="Images/blog-4.png" alt="" />
					</div>
					<div class="n-right">
						<h4>Sed Condimentum Enim Sem</h4>
						<p class="admin">commodo malesuada.</p>
						<p>Phasellus nec tellus tortor. Vivamus sagittis orci sit amet finibus dapibus. Suspendisse sit amet tempus nunc, id euismod nunc.Maecenas sit amet interdum massa, ut bibendum arcu.</p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!--end-blog-->
	<!--start-events-->
	<div class="events" id="events">
		<div class="container">
			<div class="events-top heading">
				<h3>UPCOMING EVENTS</h3>
			</div>
			<div class="events-bottom">
				<div class="col-md-4 events-main">
					<div class="events-left">
						<img src="Images/e-1.jpg" alt="" />
						<div class="event-btm">
							<h4>March 14, 2015</h4>
						</div>
						<p>Duis accumsan risus id tellus viverra tincidunt. Quisque vel velit orci. Integer ante tellus, congue at convallis at, rhoncus ut massa.</p>
					</div>
				</div>
				<div class="col-md-4 events-main">
					<div class="events-left">
						<img src="Images/e-2.jpg" alt="" />
						<div class="event-btm">
							<h4>August 14, 2015</h4>
						</div>
						<p>Duis accumsan risus id tellus viverra tincidunt. Quisque vel velit orci. Integer ante tellus, congue at convallis at, rhoncus ut massa.</p>
					</div>
				</div>
				<div class="col-md-4 events-main">
					<div class="events-left">
						<img src="Images/e-3.jpg" alt="" />
						<div class="event-btm">
							<h4>May 14, 2015</h4>
						</div>
						<p>Duis accumsan risus id tellus viverra tincidunt. Quisque vel velit orci. Integer ante tellus, congue at convallis at, rhoncus ut massa.</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--end-events-->
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
</body>
</html>