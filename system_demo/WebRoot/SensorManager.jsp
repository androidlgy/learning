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
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
</head>
<body>
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="150" background="Images/head.jpg" style="color:#06F; font-size:13px; font-weight:bolder; padding-right:50px;"><a>联系我们</a></td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg" align="right">&nbsp;当前用户：${sessionScope.Manager_Username}</td>
    </tr>
    <tr>
      <td height="100%" align="center" valign="top"><table width="80%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="12%" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="88%" align="center" valign="top" bgcolor="#F6F9FE"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">设备管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="SensorManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： <a href="SensorAdd.action">添加设备</a></td>
                    <td width="78%">查询：
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
                    <td height="25" bgcolor="#D5E4F4"><strong>楼宇号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>库房号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>设备名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>单位/符号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>简介</strong></td>
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
  						<td height="25" align="center">${emp.building_Name }</td>
  						<td>${emp.storehouse_Name }</td>
  						<td>${emp.sensor_Name }</td>
  						<td>${emp.sensor_Type }</td>
  						<td>${emp.sensor_Unit }</td>
  						<td>${emp.sensor_Description}</td>
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
          </table></td>
        </tr>
      </table></td>
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
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
    
  </table>

</center>
</body>
</html>

