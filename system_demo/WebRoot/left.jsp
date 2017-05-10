<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'left.jsp' starting page</title>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
  </head>
  <body>
       <div class="CentreBox">
      <div class="Logo"><a href="index.jsp" target="_self"><img src="Images/MYLOGO.png" alt="网站名称"/></a></div>
      <div class="Menu">
        <ul class="List1">
     <li class="Select"><a href="CopyOfParaManager.action?Username=${sessionScope.Manager_Username}" target="_self">首页</a></li>
          
          <%if(session.getAttribute("type").toString().equals("1")){%>
          <li><a href="CopyOfParaManager.action?Username=${sessionScope.Manager_Username}" target="_self">用户管理</a></li>
          <li><a href="MuseumManager.action?Username=${sessionScope.Manager_Username}" target="_self">档案馆管理</a></li>
          <%}%>
          <%if(session.getAttribute("type").toString().equals("2")){%>
          <li><a href="CopyOfParaManager.action?Username=${sessionScope.Manager_Username}" target="_self">用户管理</a></li>
          <li><a href="BuildingManager.action?Username=${sessionScope.Manager_Username}" target="_self">楼宇管理</a></li>
          <%}%>
          <%if(session.getAttribute("type").toString().equals("3")){%>
          <li><a href="CopyOfParaManager.action?Username=${sessionScope.Manager_Username}" target="_self">用户管理</a></li>
          <li><a href="StorehouseManager.action?Username=${sessionScope.Manager_Username}" target="_self">库房管理</a></li>
          <%}%>       
          <li><a href="SensorManager.action?Username=${sessionScope.Manager_Username}" target="_self">设备管理</a></li>
          <li><a href="CopyOfParaManager.action?Username=${sessionScope.Manager_Username}" target="_self">数据管理</a></li>
        </ul>
        <ul class="List2">
        <%if(session.getAttribute("type").toString().equals("4")){%>
        <li><a href="PasswordUpdate.jsp" target="_blank">修改密码</a></li>
        <%}%>
          <li><a href="#" target="_blank">使用帮助</a></li>
          <li><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></li>
        </ul>
      </div>
      
      <div class="UserInfo">
        <div class="NickName"><span class="PicMiddle"><a href="#" target="_self"><img src="Images/Vip.png" alt="VIP用户" /></a></span>&nbsp;&nbsp;<a href="http://www.baidu.com" target="_self">当前用户：${sessionScope.Manager_Username}</a></div>
      </div> 
      
      <!-- <div class="Setting"><a href="http://www.baidu.com" target="_self"></a></div>
      <div class="Message"><a href="http://www.baidu.com" target="_self"></a></div> -->
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
          <li><a href="BuildingAdminManager.action" target="_blank">楼宇管理员管理</a></li>
          <li><a href="StorehouseAdminManager.action" target="_blank">库房管理员管理</a></li>
          <li><a href="PasswordUpdate.jsp" target="_blank">修改密码</a></li>
          <%}%>
          <%if(session.getAttribute("type").toString().equals("2")){%> 
           <li><a href="BuildingAdminManager.action" target="_blank">楼宇管理员管理</a></li>
          <li><a href="StorehouseAdminManager.action" target="_blank">库房管理员管理</a></li> 
          <li><a href="PasswordUpdate.jsp" target="_blank">修改密码</a></li>      
          <%}%>
          <%if(session.getAttribute("type").toString().equals("3")){%> 
          <li><a href="StorehouseAdminManager.action" target="_blank">库房管理员管理</a></li>
          <li><a href="PasswordUpdate.jsp" target="_blank">修改密码</a></li>       
          <%}%> 
            <%if(session.getAttribute("type").toString().equals("4")){%> 
           <li><a href="SensorManager.action" target="_blank">设备动作</a></li>
          <%}%>        
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
        <%if(session.getAttribute("type").toString().equals("1")){%>
          <li class="Select"><a href="BuildingManager.action" target="_blank">楼宇管理</a></li>
          <li><a href="StorehouseManager.action" target="_blank">库房管理</a></li>
           <%}%>
           <%if(session.getAttribute("type").toString().equals("2")){%>
          <li><a href="StorehouseManager.action" target="_blank">库房管理</a></li>
           <%}%>
           <%if(session.getAttribute("type").toString().equals("3")){%>
          <li><a href="StorehouseManagerAdd.action" target="_blank">增加库房</a></li>
           <%}%>
            <%if(session.getAttribute("type").toString().equals("4")){%>
          <li class="Select"><a href="ParaManager.action" target="_blank">设备数据</a></li>
          <li><a href="AlarmManager.action" target="_blank">报警数据</a></li>
           <%}%>
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
          <!-- <li class="Select"><a href="#" target="_blank">添加设备</a></li>
          <li><a href="#" target="_blank">修改设备</a></li> -->
          <li><a href="MotionManager.action" target="_blank">设备动作</a></li>
        <!--    <li><a href="MotionManager.action" target="_blank">报警设置</a></li> -->
        </ul>
      </div>
      <div class="Menu Hide">
        <ul>
          <li class="Select"><a href="ParaManager.action" target="_blank">设备数据</a></li>
          <li><a href="AlarmManager.action" target="_blank">报警数据</a></li>
          <li><a href="HistoryManager.action" target="_blank">历史数据</a></li>
        </ul>
      </div>
    </div>
  </div>
  </body>
</html>
