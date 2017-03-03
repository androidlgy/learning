<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
</head>
<script language="JavaScript">


function mycheck(){
     if(isNull(form1.Motion_Operator.value)){  
   alert("请选择触发条件！"); 
   return false;
   }
    if(isNull(form1.Motion_Value.value)){  
   alert("请输入触发阈值！"); 
   return false;
   }
    if(isNull(form1.SM_MotionID.value)){  
   alert("请选择动作！"); 
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">设备动作设置</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="MySMAddSave.action" onsubmit="return mycheck()">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                 
                  <tr>
                    <td width="42%" height="30" style="padding-left:20px;"> 功能导航： <a href="SensorManager.action">返回上层</a></td>
                           <td width="58%">添加动作:当数据满足以下条件时
                            <select id="Motion_Operator" name="Motion_Operator">
                              <option value="1">&gt;</option>
                              <option value="2">&ge;</option>
                              <option value="3">&lt;</option>
                              <option value="4">&le;</option>
                              <option value="5">==</option>
                            </select>
                      <input class="text1" type="text" id="Motion_Value" name="Motion_Value" /><br></br>
                      <select name="SM_MotionID" id="SM_MotionID">
                        <option value="">请选择动作</option>
                        <s:iterator value="molist">
                        <option value="${Motion_ID}">${Motion_Name}</option>
                        </s:iterator>
                      </select>
                       <input type="submit" name="button" id="button" value="点击添加">
                        
                    <input name="SM_SensorID" type="text" class="noshow" id="SM_SensorID" value="${Sensor_ID}"></td>
                     
                    
                     
                  </tr>
                </table>
              </form>
              
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>传感器名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>阈值</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作内容</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="smlist">
                    <tr align="center">
                      <td height="25" align="center">${Sensor_Name}</td>
                      <td>${Motion_Name}</td>
                      <td>${Motion_Type}</td>
                      <td>${Motion_Value}</td>
                      <td align="center">${Motion_Msg}</td>
                      <td align="center"><a href="SMUpdate.action?SM_ID=${SM_ID}">编辑</a>   <a href="SMDel.action?SM_ID=${SM_ID}&Sensor_ID=${SM_SensorID}" onClick="return confirm('确定要将该动作从该设备移除吗？')">移除</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table>
</td>
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
