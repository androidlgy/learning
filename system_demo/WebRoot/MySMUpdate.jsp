
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库房环境监测系统系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
</head>
<script language="JavaScript">


function mycheck(){
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
          <li class="Select"><a href="index.jsp" target="_blank">首页</a></li>
          <li><a href="index.jsp" target="_blank">用户管理</a></li>
          <li><a href="index.jsp" target="_blank">档案馆管理</a></li>
          <li><a href="index.jsp" target="_blank">设备管理</a></li>
          <li><a href="index.jsp" target="_blank">数据管理</a></li>
          
 
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">编辑触发动作</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MySMUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="SM_ID" type="text" class="noshow" id="SM_ID" value="<s:property value='sbean.SM_ID'/>"></td>
                   <td width="67%"><input name="SM_SensorID" type="text" class="noshow" id="SM_SensorID" value="<s:property value='sbean.SM_SensorID'/>"></td>
                  </tr>
                   
                 
                  <tr>
                  <%-- <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>库房号：</td>
                    <td><input name="Sensor_StorehouseID" type="text" class="text2" id="Sensor_StorehouseID" value="<s:property value='sbean.Storehouse_Name'/>"></td>
                  </tr> --%>
                 
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span> 当满足以下条件时：</td>
                    <td><!-- <input name="Sensor_Type" type="text" class="text2" id="Sensor_Type"> -->
                                                           
                   <select name="Motion_Operator" class="text2" id="Motion_Operator">
                   <option value="1"
                   <s:if test='sbean.Motion_Operator=="1"'>selected</s:if>
                   >&gt;</option>
                   
                   <option value="2"
                   <s:if test='sbean.Motion_Operator=="2"'>selected</s:if>
                   >&ge;</option>
                   
                   <option value="3"
                   <s:if test='sbean.Motion_Operator=="3"'>selected</s:if>
                   >&lt;</option>
                   
                   <option value="4"
                   <s:if test='sbean.Motion_Operator=="4"'>selected</s:if>
                   >&le;</option>
                   
                   <option value="5"
                   <s:if test='sbean.Motion_Operator=="5"'>selected</s:if>
                   >==</option>
           
                   </select> 
                    </td>
                     <tr>
                    <td height="30" align="right"><span style="color:red;">*</span></td>
                    <td><input name="Motion_Value" type="text" class="text2"  id="Motion_Value" value="<s:property value='sbean.Motion_Value'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>动作：</td>
                    <td><select name="SM_MotionID" id="SM_MotionID">
                      <s:iterator id="aa" value="mlist">
                      <option value="${Motion_ID}" <s:if test="sbean.SM_MotionID==Motion_ID">selected</s:if>>${Motion_Name}</option>
                      </s:iterator>
                      </select></td>
                  </tr>
              
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改触发动作">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
