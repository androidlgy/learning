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
   if(isNull(form1.TS_TreasuryID.value)){  
   alert("请选择要添加的管理员！"); 
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
  <table  height="29%" width="80%" style="min-width: 1135px">
  <tr>
  <td background="Images/p3.jpg"><h2><font style="font-weight: bold;margin-left: 100px; font-size: 200%">泰德档案库房环境监测信息网</font></h2>
  <br>
  <h4 style="font-weight: bold;margin-left: 150px; font-size: 100%">www.tdaxdakfxxw.com</h4>
  </td>
  </tr>
  </table>
 <div id="Top" style="width: 80%; height: 10%;min-width: 1135px;">
  <div class="Toolbar1">
    <%@ include file="left.jsp"%></div>
</div>
<table width="80%" height="59%" style="border-style: solid;border-width: 2px;min-width: 1135px">
<tr>
<td width="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">库房管理员设置</td>
            </tr>
            <tr>
              <td height="510px" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="TSAddSave.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="40%" height="30" style="padding-left:20px;"> 功能导航： <a href="StorehouseManager.action">返回上层</a></td>
                    <td width="58%">添加管理员：
                      <select name="TS_TreasuryID" id="TS_TreasuryID">
                        <option value="">请选择</option>
                        <s:iterator value="tlist">
                        <option value="${Treasury_ID}">${Treasury_Name}</option>
                        </s:iterator>
                      </select>
                      <input type="submit" name="button" id="button" value="点击添加">
                      <label for="TS_StorehouseID"></label>
                      <input name="TS_StorehouseID" type="text" class="noshow" id="TS_StorehouseID" value="${Storehouse_ID}"></td>
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
                      <td height="25" align="center">${emp.treasury_Name}</td>
                      <td>${emp.treasury_Sex}</td>
                      <td>${emp.treasury_Tel}</td>
                      <td align="center">${emp.treasury_Username}</td>
                      <td align="center"><a href="TSDel.action?TS_ID=${emp.TS_ID}&Storehouse_ID=${emp.TS_StorehouseID}" onClick="return confirm('确定要将该管理员从该楼宇移除吗？')">移除</a></td>
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
          </table></td>
        </tr>
         <tr>
 <td colspan="5" align="center">
  				当前${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }页     &nbsp;&nbsp;
  				
  				<a href="TSManager.action?currentPage=1">首页</a>
  				<a href="TSManager.action?currentPage=${requestScope.pageBean.currentPage-1}">上一页 </a>
  				<a href="TSManager.action?currentPage=${requestScope.pageBean.currentPage+1}">下一页 </a>
  				<a href="TSManager.action?currentPage=${requestScope.pageBean.totalPage}">末页</a>
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
