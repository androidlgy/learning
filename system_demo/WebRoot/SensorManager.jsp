<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库房环境监测系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
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
    <%@ include file="left.jsp"%></div>
</div>
<table width="80%" height="59%" border="2">
<tr>
<td width="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">设备管理</td>
            </tr>
            <tr>
              <td height="100%" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="SensorManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： <a href="SensorAdd.action">添加设备</a></td>
                    <td width="78%">查询:  
                    <%if(session.getAttribute("type").toString().equals("1")){%>                 
                      <select name="Museum_ID" id="Museum_ID">
                      <option value="">全部档案馆</option>
                      <s:iterator value="mlist">
                      <option value="${Museum_ID}">${Museum_Name}</option>
                      </s:iterator>
                      </select>
                       <%}%>
                      <select name="Storehouse_BuildingID" id="Storehouse_BuildingID">
                      <option value="">全部楼宇</option>
                      <s:iterator value="blist">
                      <option value="${Building_ID}">${Building_Name}</option>
                      </s:iterator>
                      </select>
                      <select name="SearchRow" id="SearchRow">
                      <option value="Storehouse_Name">库房号</option>
                        <option value="Sensor_Name">设备名称</option>
                        <option value="Sensor_Type">设备类型</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                  <%if(session.getAttribute("type").toString().equals("1")){%>
                    <td height="25" bgcolor="#D5E4F4"><strong>档案馆</strong></td>
                  <%}%>
                    <td bgcolor="#D5E4F4"><strong>楼宇号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>库房号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>设备名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>单位/符号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
             <%--      <s:iterator id="aa" value="slist">
                    <tr align="center">
                      <td height="25" align="center">${Building_Name}</td>
                      <td>${Storehouse_Name}</td>
                      <td>${Sensor_Name}</td>
                      <td align="center">${Sensor_Type}</td>
                      <td align="center">${Sensor_Unit}</td>
                      <td align="center">${Sensor_Description}</td>
                      <td align="center"><a href="SMManager.action?Sensor_ID=${Sensor_ID}">动作</a> <a href="SensorUpdate.action?Sensor_ID=${Sensor_ID}">修改</a> <a href="SensorDelete.action?Sensor_ID=${Sensor_ID}" onClick="return confirm('确定要删除该宿舍吗？')">删除</a></td>
                    </tr>
                  </s:iterator> --%>
                  <!-- 迭代数据 -->
  		<c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
  				<c:forEach var="emp" items="${requestScope.pageBean.pageData}" varStatus="vs">
  					<tr align="center">
  					<%if(session.getAttribute("type").toString().equals("1")){%>
  						<td height="25" align="center">${emp.museum_Name}</td>
  					<%}%>	
  						<td>${emp.building_Name }</td>
  						<td>${emp.storehouse_Name }</td>
  						<td>${emp.sensor_Name }</td>
  						<td>${emp.sensor_Unit }</td>
  						<td align="center"><a href="SMManager.action?Sensor_ID=${emp.sensor_ID}">动作</a> <a href="SensorUpdate.action?Sensor_ID=${emp.sensor_ID}">修改</a> <a href="SensorDelete.action?Sensor_ID=${emp.sensor_ID}" onClick="return confirm('确定要删除该设备吗？')">删除</a></td>
  					</tr>
  				</c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="6">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>
  		
                </table></td>
            </tr>
          </table>
</td>
</tr>
<tr>
<td colspan="3" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="SensorManager.action?currentPage=1">首页</a>
  				<a href="SensorManager.action?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="SensorManager.action?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="SensorManager.action?currentPage=${requestScope.pageBean.totalPage}">末页</a>
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

