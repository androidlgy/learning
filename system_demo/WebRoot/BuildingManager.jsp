<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8"%> 
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库房环境监测系统</title>
    <base href="<%=basePath%>">
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Building_Name.value)){  
   alert("请输入名称！"); 
   return false;
   }
   if(isNull(form1.Building_MuseumID.value)){  
   alert("请选择档案馆！"); 
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
  <div id="Top" style="width: 80%; height: 10%">
  <div class="Toolbar1">
    <div class="CentreBox">
      <div class="Logo"><a href="index.jsp" target="_self"><img src="Images/MYLOGO.png" alt="网站名称"/></a></div>
      <div class="Menu">
        <ul class="List1">
<li class="Select"><a href="CopyOfParaManager.action" target="_self">首页</a></li>
          <li><a href="CopyOfParaManager.action" target="_self">用户管理</a></li>
          <li><a href="CopyOfParaManager.action" target="_self">档案馆管理</a></li>
          <li><a href="CopyOfParaManager.action" target="_self">设备管理</a></li>
          <li><a href="CopyOfParaManager.action" target="_self">数据管理</a></li>
        </ul>
        <ul class="List2">
          <li><a href="#" target="_blank">企业微博</a></li>
          <li><a href="#" target="_blank">关于系统</a></li>
        </ul>
         
      </div>
      <div class="UserInfo">
        <div class="NickName"><span class="PicMiddle"><a href="#" target="_self"><img src="Images/Vip.png" alt="VIP用户" /></a></span>&nbsp;&nbsp;<a href="http://www.baidu.com" target="_self">当前用户：${sessionScope.Manager_Username}</a></div>
      </div>
      <!-- <div class="Setting"><a href="http://www.baidu.com" target="_self"></a></div>
      <div class="Message"><a href="http://www.baidu.com" target="_self"></a></div> -->
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
          <li><a href="MuseumAdminManager.action" target="_blank">档案馆管理员管理</a></li>
          <li><a href="RoomAdminManager.action" target="_blank">楼宇管理员管理</a></li>
          <li><a href="#" target="_blank">库房管理员管理</a></li>
          <li><a href="PasswordUpdate.jsp" target="_blank">修改密码</a></li>
          <%}%>
          <%if(session.getAttribute("type").toString().equals("2")){%> 
           <li><a href="RoomAdminManager.action" target="_blank">楼宇管理员管理</a></li>
          <li><a href="#" target="_blank">库房管理员管理</a></li>
          <li><a href="PasswordUpdate.jsp" target="_blank">修改密码</a></li>
          <%}%>
          <li><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></li>
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
        <%if(session.getAttribute("type").toString().equals("1")){%>
          <li class="Select"><a href="BuildingManager.action" target="_blank">楼宇管理</a></li>
          <li><a href="StorehouseManager.action" target="_blank">库房管理</a></li>
           <%}%>
           <%if(session.getAttribute("type").toString().equals("2")){%>
          <li class="Select"><a href="MyBuildingManager.action" target="_blank">楼宇管理</a></li>
          <li><a href="MyStorehouseManager.action" target="_blank">库房管理</a></li>
           <%}%>
           
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
          <!-- <li class="Select"><a href="#" target="_blank">添加设备</a></li>
          <li><a href="#" target="_blank">修改设备</a></li> -->
          <%if(session.getAttribute("type").toString().equals("1")){%>
          <li><a href="SensorManager.action" target="_blank">查看设备</a></li>
           <%}%>
           <%if(session.getAttribute("type").toString().equals("2")){%>
          <li><a href="MySensorManager.action" target="_blank">查看设备</a></li>
           <%}%>
           <li><a href="MotionManager.action" target="_blank">报警设置</a></li>
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
<table width="80%" height="59%" border="2">
<tr>
<td width="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">楼宇管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="BuildingManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="BuildingAdd.action">添加楼宇</a></td>
                    <td width="72%">名称：
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button"  value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>档案馆名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>简介</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                    <td height="25" align="center">${Museum_Name}</td>
                      <td>${Building_Name}</td>
                      <td>${Building_Introduction}</td>
                      <td align="center">
                        <a href="UBManager.action?Building_ID=${Building_ID}">管理员</a> 
                        <a href="BuildingUpdate.action?Building_ID=${Building_ID}">修改</a> 
                        <a href="BuildingDel.action?Building_ID=${Building_ID}" onClick="return confirm('确定要删除该楼宇吗？')">删除</a>
                      </td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table>
    <table height="1%" width="80%">
    <tr>
      <td background="Images/bootBg.jpg" align="center"><span id="time"></span></td>
    </tr>  	
  </table >
  </center> 
</body>
</html>
