<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库房环境监测系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">参数管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MyParaManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="30" style="padding-left:20px;"> 功能导航：</td>
                    <td width="78%">查询：
                      <select name="Storehouse_BuildingID" id="Storehouse_BuildingID">
                      <option value="">全部楼宇</option>
                      <s:iterator value="blist">
                      <option value="${Building_ID}">${Building_Name}</option>
                      </s:iterator>
                      </select>
                      <select name="SearchRow" id="SearchRow">
                      <option value="Storehouse_Name">库房号</option>
                        <option value="Sensor_Name">传感器名称</option>
                        <option value="Sensor_Type">传感器类型</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>设备名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>接收数据时间</strong></td>
                    <td bgcolor="#D5E4F4"><strong>设备类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>设备数据</strong></td>
                    <td bgcolor="#D5E4F4"><strong>单位/符号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>设备状态</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Sensor_Name}</td>
                      <td><fmt:formatDate value="${Sensor_ReceiveTime}" type="both"/></td>
                
                      <td>${Sensor_Type}</td>
                      <td align="center">${Sensor_Value}</td>
                      <td align="center">${Sensor_Unit}</td>
                      <td align="center">${Sensor_Status}</td>
                      <td align="center"><a href="ActionManager.action?Sensor_ID=${Sensor_ID}">控制</a> <a href="MySensorUpdate.action?Sensor_ID=${Sensor_ID}">修改</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>

