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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">档案馆管理员管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MuseumAdminManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:10px;"> 功能导航： <a href="MuseumAdminAdd.jsp">添加档案馆管理员</a></td>
                    <td width="72%" style="padding-left:20px;">查询：
                      <select name="SearchRow" id="SearchRow">
                        <option value="Manager_Name">姓名</option>
                        <option value="Manager_Tel">电话</option>
                        <option value="Manager_Username">用户名</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>姓名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>性别</strong></td>
                    <td bgcolor="#D5E4F4"><strong>电话</strong></td>
                    <td bgcolor="#D5E4F4"><strong>用户名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                   <c:choose>
  			<c:when test="${not empty requestScope.pageBean.pageData}">
  				<c:forEach var="emp" items="${requestScope.pageBean.pageData}" varStatus="vs">  
                    <tr align="center">
                      <td style="height: 25px" align="center">${emp.manager_Name}</td>
                       <td  align="center">${emp.manager_Sex}</td>
                      <td  align="center">${emp.manager_Tel}</td>
                      <td >${emp.manager_Username}</td>
                     <td align="center"><a href="MuseumAdminUpdate.action?Manager_ID=${emp.manager_ID}">修改</a> <a href="MuseumAdminDel.action?Manager_ID=${emp.manager_ID}" onClick="return confirm('该档案馆下存在楼宇，确定要删除吗？')">删除</a></td>
                    </tr>
                      </c:forEach>
  			</c:when>
  			<c:otherwise>
  				<tr align="center">
  					<td colspan="5" >对不起，没有你要找的数据</td>
  				</tr>
  			</c:otherwise>
  		</c:choose>   
                </table></td>
            </tr>
          </table>
</td>                 
 </tr>
 <tr>
 <td colspan="5" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="MuseumAdminManager.action?currentPage=1">首页</a>
  				<a href="MuseumAdminManager.action?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="MuseumAdminManager.action?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="MuseumAdminManager.action?currentPage=${requestScope.pageBean.totalPage}">末页</a>
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
