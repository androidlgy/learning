<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
    <title>库房环境监测系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<div id="Top" style="width: 80%; height: 10%">
  <div class="Toolbar1">
    <%@ include file="left.jsp"%></div>
</div>
<table width="80%" height="59%" border="2">
<tr>
<td colspan="2">
<form name="form1" method="post" action="CopyOfParaManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="12%" height="30" style="padding-left:10px;"> <strong>数据显示：</strong></td>
                    <td width="88%">查询：
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
<td width="60%" valign="top" height="470">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr align="center">
                    <td style="height: 25px" bgcolor="#D5E4F4"><strong>档案馆</strong></td>
                    <td  bgcolor="#D5E4F4"><strong>楼宇</strong></td>
                    <td  bgcolor="#D5E4F4"><strong>设备</strong></td>
                    <td  bgcolor="#D5E4F4"><strong>接收时间</strong></td>
                    <td  bgcolor="#D5E4F4"><strong>值</strong></td>
                    <td  bgcolor="#D5E4F4"><strong>单位/符号</strong></td>
                    <td  bgcolor="#D5E4F4"><strong>设备状态</strong></td>                 
             </tr>
             <c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
  				<c:forEach var="emp" items="${requestScope.pageBean.pageData}" varStatus="vs">  
                    <tr align="center">
                      <td style="height: 25px" align="center">${emp.museum_Name}</td>
                       <td  align="center">${emp.building_Name}</td>
                      <td  align="center">${emp.sensor_Name}</td>
                      <td ><fmt:formatDate value="${emp.sensor_ReceiveTime}" type="both"/></td>
                      <td >${emp.sensor_Value}</td>
                      <td >${emp.sensor_Unit}</td>
                      
                      <td>
                      <c:if test="${emp.sensor_Status=='true'}">正常</c:if>
                      <c:if test="${emp.sensor_Status=='false'}">异常</c:if>
                     </td>
                      <%-- <td >${emp.sensor_Status}</td> --%>
                    </tr>
                      </c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr align="center">
  					<td colspan="6" >对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>                   
</table>
</td>                 
 <td width="40%" valign="top" >
 <table width="100%" border="0" cellspacing="0" cellpadding="0">
 <tr align="center">
                    <td bgcolor="#D5E4F4" style="height: 25px"><strong>近期警报记录</strong></td>
                    </tr>
                    
                     <c:choose>
  			<c:when test="${not empty requestScope.pageBean1.pageData}">
  				<c:forEach var="emp1" items="${requestScope.pageBean1.pageData}" varStatus="vs">  
                    <tr align="center">
                      <td align="center" style="height: 25px">${emp1.alarm_Thing}</td>
                    </tr>
                            </c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr>
  					<td colspan="1">对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>      
                  </table>
 </td>
 </tr>
 <tr>
 <td colspan="7" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="?currentPage=1">首页</a>
  				<a href="CopyOfParaManager.action?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="CopyOfParaManager.action?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="CopyOfParaManager.action?currentPage=${requestScope.pageBean.totalPage}">末页</a>
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

