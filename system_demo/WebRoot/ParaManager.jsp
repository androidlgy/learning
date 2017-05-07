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
  <table  height="29%" width="80%" style="min-width: 1135px">
  <tr>
  <td background="Images/p3.jpg"><h2><font style="font-weight: bold;margin-left: 100px; font-size: 200%">泰德档案库房环境监测信息网</font></h2>
  <br>
  <h4 style="font-weight: bold;margin-left: 150px; font-size: 100%">www.tdaxdakfxxw.com</h4>
  </td>
  </tr>
  </table>
<div id="Top" style="width: 80%; height: 10%; min-width: 1135px">
  <div class="Toolbar1">
    <%@ include file="left.jsp"%></div>
</div>
<table width="80%" height="59%" style="border-style: solid;border-width: 2px;min-width: 1135px">
<tr>
<td width="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">设备数据管理</td>
            </tr>
            <tr>
              <td height="30px" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="ParaManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="21%" height="30" style="padding-left:20px;"> 功能导航：</td>
                    <td width="78%">查询：
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
                        <option value="Sensor_Name">传感器名称</option>
                        <option value="Sensor_Type">传感器类型</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
              </td>
              </tr>
              <tr>
              <td height="485px" valign="top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" style="min-width: 1135px">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>档案馆</strong></td>
                    <td bgcolor="#D5E4F4"><strong>设备名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>接收数据时间</strong></td>                  
                    <td bgcolor="#D5E4F4"><strong>设备数据</strong></td>
                    <td bgcolor="#D5E4F4"><strong>单位/符号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>设备状态</strong></td>
             <%--        <td bgcolor="#D5E4F4"><strong>操作</strong></td> --%>
                  </tr>
                  <%-- <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Sensor_Name}</td>
                      <td><fmt:formatDate value="${Sensor_ReceiveTime}" type="both"/></td>
                
                      <td>${Sensor_Type}</td>
                      <td align="center">${Sensor_Value}</td>
                      <td align="center">${Sensor_Unit}</td>
                      <td align="center">${Sensor_Status}</td>
                      <td align="center"><a href="ActionManager.action?Sensor_ID=${Sensor_ID}">控制</a> <a href="SensorUpdate.action?Sensor_ID=${Sensor_ID}">修改</a> <a href="SensorDelete.action?Sensor_ID=${Sensor_ID}" onClick="return confirm('确定要删除该宿舍吗？')">删除</a></td>
                    </tr>
                  </s:iterator> --%>
                  <c:choose>
                  <c:when test="${not empty requestScope.pageBean.pageData }">
                  <c:forEach var="emp" items="${requestScope.pageBean.pageData }" varStatus="vs">
                  <tr align="center">
                  <%if(session.getAttribute("type").toString().equals("1")){%>
                  <td height="25px" align="center">${emp.museum_Name}</td>
                  <%}%>
                  <td height="25" align="center">${emp.sensor_Name}</td>
                  <td><fmt:formatDate value="${emp.sensor_ReceiveTime}" type="both"/></td>
                  <td align="center">${emp.sensor_Value}</td>
                  <td align="center">${emp.sensor_Unit}</td>
                   <td>
                      <c:if test="${emp.sensor_Status=='true'}">正常</c:if>
                      <c:if test="${emp.sensor_Status=='false'}">异常</c:if>
                   </td>
                  </tr>
          
                  </c:forEach>
                  </c:when>
                  <c:otherwise>
                  <tr>
  					<td colspan="6" align="center" style="padding-top: 50px;"><span style="color:red">对不起，没有你要找的数据</span></td>
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
  				
  				
  				 <c:choose> 
				  <c:when test="${requestScope.m!=null || requestScope.sb!=null || requestScope.sk!=null }">   
				<a href="ParaManager.action?currentPage=1&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">首页</a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage-1}&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">上一页 </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage+1}&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">下一页 </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.totalPage}&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">末页</a>
				  </c:when> 
				<%--   <c:when test="${requestScope.m!=null}">   
				    ${param.username} is manager.  
				  </c:when>  --%>
				  <c:otherwise>   
				<a href="ParaManager.action?currentPage=1">首页</a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.totalPage}">末页</a>
				
				  </c:otherwise> 
				
				</c:choose> 
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

