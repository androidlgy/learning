<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<head>
<style>
body{margin:0;padding:0;overflow-x:hidden;}
html, body{height:70%;}
img{border:none;}
*{font-family:'微软雅黑';font-size:12px;color:#626262;}
dl,dt,dd{display:block;margin:0;}
a{text-decoration:none;}

.container{width:100%;height:100%;margin:auto;}
.leftsidebar_box{width:160px;height:auto !important;overflow:visible !important;height:100% !important;background-color:#3992d0;}
.line{height:2px;width:100%;background-image:url(Images/line_bg.png);background-repeat:repeat-x;}
.leftsidebar_box dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;color:#f5f5f5;font-size:14px;position:relative;line-height:48px;cursor:pointer;}
.leftsidebar_box dd{background-color:#317eb4;padding-left:40px;}
.leftsidebar_box dd a{color:#f5f5f5;line-height:20px;}
.leftsidebar_box dt img{position:absolute;right:10px;top:20px;}
.system_log dt{background-image:url(Images/system.png)}
.custom dt{background-image:url(Images/custom.png)}
.channel dt{background-image:url(Images/channel.png)}
.app dt{background-image:url(Images/app.png)}
.cloud dt{background-image:url(Images/cloud.png)}
.syetem_management dt{background-image:url(Images/syetem_management.png)}
.source dt{background-image:url(Images/source.png)}
.statistics dt{background-image:url(Images/statistics.png)}
.leftsidebar_box dl dd:last-child{padding-bottom:10px;}
</style>
</head>
<body>
<table>
<!-- 代码部分begin -->
<div class="container">
  <div class="leftsidebar_box">
    <div class="line"></div>
    <dl class="system_log">
      <dt>系统记录<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">修改记录</a></dd>
      <dd><a href="#">报警记录</a></dd>
    <!--   <dd><a href="#">消费记录</a></dd>
      <dd><a href="#">操作记录</a></dd> -->
    </dl>
    <dl class="custom">
      <dt>管理员管理<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">系统管理员管理</a></dd>
      <dd><a href="MuseumManager.action">档案馆管理员管理</a></dd>
      <dd><a href="#">楼宇管理员管理</a></dd>
      <dd><a href="#">库房管理员管理</a></dd>
      <!-- <dd><a href="#">即将到期客户管理</a></dd> -->
    </dl>
    <dl class="channel">
      <dt>渠道管理<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">渠道主页</a></dd>
      <dd><a href="#">渠道标准管理</a></dd>
      <dd><a href="#">系统通知</a></dd>
      <dd><a href="#">渠道商管理</a></dd>
      <dd><a href="#">渠道商链接</a></dd>
    </dl>
    <dl class="app">
      <dt>APP管理<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">App运营商管理</a></dd>
      <dd><a href="#">开放接口管理</a></dd>
      <dd><a href="#">接口类型管理</a></dd>
    </dl>
    <dl class="cloud">
      <dt>大数据云平台<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">平台运营商管理</a></dd>
    </dl>
    <dl class="syetem_management">
      <dt>系统管理<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">档案馆管理</a></dd>
      <dd><a href="#">楼宇管理</a></dd>
      <dd><a href="#">库房管理</a></dd>
      <dd><a href="#">设备管理</a></dd>
      <dd><a href="#">动作管理</a></dd>
      <dd><a href="#">参数管理</a></dd>
     <!--  <dd><a href="#"></a></dd> -->
      <dd><a href="#">修改用户密码</a></dd>
    </dl>
    <dl class="source">
      <dt>素材库管理<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">图片库</a></dd>
      <dd><a href="#">链接库</a></dd>
      <dd><a href="#">推广管理</a></dd>
    </dl>
    <dl class="statistics">
      <dt>统计分析<img src="Images/select_xl01.png"></dt>
      <dd class="first_dd"><a href="#">客户统计</a></dd>
    </dl>
  </div>
</div>
<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
<script>
$(function(){
	$(".leftsidebar_box dt").css({"background-color":"#3992d0"});
	$(".leftsidebar_box dt img").attr("src","Images/select_xl01.png");
	$(".leftsidebar_box dd").hide();
	$(".leftsidebar_box dt").click(function(){
		$(".leftsidebar_box dt").css({"background-color":"#3992d0"})
		$(this).css({"background-color": "#317eb4"});
		$(this).parent().find('dd').removeClass("menu_chioce");
		$(".leftsidebar_box dt img").attr("src","Images/select_xl01.png");
		$(this).parent().find('img').attr("src","Images/select_xl.png");
		$(".menu_chioce").slideUp(); 
		$(this).parent().find('dd').slideToggle();
		$(this).parent().find('dd').addClass("menu_chioce");
	});
})
</script>
<!-- 代码部分end -->
</table>
</body>