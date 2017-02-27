<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title>库房环境监测系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>jQuery蓝色二级导航菜单 - huiyi8素材</title>
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
 <script type="text/javascript">
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
</script>
</head> 
<body>
<center>
  <table  height="30%" width="80%" >
  <tr>
  <td background="Images/p3.jpg"><h2><font style="font-weight: bold;margin-left: 100px; font-size: 200%">泰德档案库房环境监测信息网</font></h2>
  <br>
  <h4 style="font-weight: bold;margin-left: 150px; font-size: 100%">www.tdaxdakfxxw.com</h4>
  </td>
  </tr>
  </table>
  <div id="Top" style="width: 80%; height: 15%">
  <div class="Toolbar1">
    <div class="CentreBox">
      <div class="Logo"><a href="http://www.baidu.com" target="_self"><img src="Images/MYLOGO.png" alt="网站名称"/></a></div>
      <div class="Menu">
        <ul class="List1">
          <li class="Select"><a href="#" target="_blank">首页</a></li>
          <li><a href="#" target="_blank">用户管理</a></li>
          <li><a href="#" target="_blank">档案馆管理</a></li>
          <li><a href="#" target="_blank">设备管理</a></li>
          <li><a href="#" target="_blank">数据管理</a></li>
          
 
        </ul>
        <ul class="List2">
          <li><a href="#" target="_blank">企业微博</a></li>
          <li><a href="#" target="_blank">关于系统</a></li>
        </ul>
         
      </div>
      <div class="UserInfo">
        <div class="NickName"><span class="PicMiddle"><a href="http://www.baidu.com" target="_self"><img src="Images/Vip.png" alt="VIP用户" /></a></span>&nbsp;&nbsp;<a href="http://www.baidu.com" target="_self">当前用户：${sessionScope.Manager_Username}</a></div>
      </div>
      <div class="Setting"><a href="http://www.baidu.com" target="_self"></a></div>
      <div class="Message"><a href="http://www.baidu.com" target="_self"></a></div>
    </div>
  </div>
  <div class="Toolbar2">
    <div class="CentreBox">
      <div class="Menu">
        <ul>
          <li class="Select"><a href="#" target="_blank">火灾报警日志</a></li>
          <li><a href="#" target="_blank">关于系统</a></li>
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
        <%if(session.getAttribute("type").toString().equals("1")){%>
          <li class="Select"><a href="#" target="_blank">系统管理员管理</a></li>
          <li><a href="#" target="_blank">档案馆管理员管理</a></li>
          <li><a href="#" target="_blank">楼宇管理员管理</a></li>
          <li><a href="#" target="_blank">库房管理员管理</a></li>
          <li><a href="#" target="_blank">修改密码</a></li>
          <%}%>
          <%if(session.getAttribute("type").toString().equals("2")){%> 
           <li><a href="#" target="_blank">楼宇管理员管理</a></li>
          <li><a href="#" target="_blank">库房管理员管理</a></li>
          <li><a href="#" target="_blank">修改密码</a></li>
          <%}%>
          <li><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></li>
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
          <li class="Select"><a href="#" target="_blank">楼宇管理</a></li>
          <li><a href="#" target="_blank">库房管理</a></li>
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
          <li class="Select"><a href="#" target="_blank">添加设备</a></li>
          <li><a href="#" target="_blank">修改设备</a></li>
          <li><a href="#" target="_blank">查看设备</a></li>
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
          <li class="Select"><a href="#" target="_blank">显示数据</a></li>
          <li><a href="#" target="_blank">报警管理</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>
 <table>
 <tr>
 <td></td>
 </tr>
 </table>
    <table>
 
    <tr height="1%">
      <td background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  	
  </table >
  </center>
    <span id="time"></span>
</body>
</html>

