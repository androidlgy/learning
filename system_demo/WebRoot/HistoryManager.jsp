<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>�ⷿ�������ϵͳ</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>

<link type="text/css" rel="stylesheet" href="css/calendar.css" >
<script type="text/javascript" src="js/calendar.js" ></script>  
<script type="text/javascript" src="js/calendar-zh.js" ></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>


 <script type="text/javascript">
setInterval("showTime()",1000);

function showTime()
{
var wk = ["������","����һ","���ڶ�","������","������","������","������"];
var date = new Date();
var msg = "������:" + date.getFullYear()+"��";
msg += date.getMonth()+1 +"��";
msg += date.getDate() + "��";
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
  <td background="Images/p3.jpg"><h2><font style="font-weight: bold;margin-left: 100px; font-size: 200%">̩�µ����ⷿ���������Ϣ��</font></h2>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">�豸���ݹ���</td>
            </tr>
            <tr>
              <td height="30px" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="ParaManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="21%" height="30" style="padding-left:20px;"> ���ܵ�����</td>
                    <td width="78%">��ѯ��
                     <%if(session.getAttribute("type").toString().equals("1")){%>                 
                      <select name="Museum_ID" id="Museum_ID">
                      <option value="">ȫ��������</option>
                      <s:iterator value="mlist">
                      <option value="${Museum_ID}">${Museum_Name}</option>
                      </s:iterator>
                      </select>
                       <%}%>
                      <select name="Storehouse_BuildingID" id="Storehouse_BuildingID">
                      <option value="">ȫ��¥��</option>
                      <s:iterator value="blist">
                      <option value="${Building_ID}">${Building_Name}</option>
                      </s:iterator>
                      </select>
                      <select name="SearchRow" id="SearchRow">
                      <option value="Storehouse_Name">�ⷿ��</option>
                        <option value="Sensor_Name">����������</option>
                        <option value="Sensor_Type">����������</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                                            ��ʼʱ�䣺<input type="text" id="beginTime" name="beginTime" onclick="return showCalendar('beginTime', 'y-mm-dd');"  />
                                            ��ֹʱ�䣺<input type="text" id="endTime" name="endTime" onclick="return showCalendar('endTime', 'y-mm-dd');"  />                   
                      <input type="submit" name="button" id="button" value="�����ѯ"></td>
                  </tr>
                </table>
              </form>
              </td>
              </tr>
              <tr>
              <td height="485px" valign="top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" style="min-width: 1135px">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>������</strong></td>
                    <td bgcolor="#D5E4F4"><strong>�豸����</strong></td>
                    <td bgcolor="#D5E4F4"><strong>��������ʱ��</strong></td>                  
                    <td bgcolor="#D5E4F4"><strong>�豸����</strong></td>
                    <td bgcolor="#D5E4F4"><strong>��λ/����</strong></td>
                    <td bgcolor="#D5E4F4"><strong>�豸״̬</strong></td>
             <%--        <td bgcolor="#D5E4F4"><strong>����</strong></td> --%>
                  </tr>
                  <%-- <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Sensor_Name}</td>
                      <td><fmt:formatDate value="${Sensor_ReceiveTime}" type="both"/></td>
                
                      <td>${Sensor_Type}</td>
                      <td align="center">${Sensor_Value}</td>
                      <td align="center">${Sensor_Unit}</td>
                      <td align="center">${Sensor_Status}</td>
                      <td align="center"><a href="ActionManager.action?Sensor_ID=${Sensor_ID}">����</a> <a href="SensorUpdate.action?Sensor_ID=${Sensor_ID}">�޸�</a> <a href="SensorDelete.action?Sensor_ID=${Sensor_ID}" onClick="return confirm('ȷ��Ҫɾ����������')">ɾ��</a></td>
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
                      <c:if test="${emp.sensor_Status=='true'}">����</c:if>
                      <c:if test="${emp.sensor_Status=='false'}">�쳣</c:if>
                   </td>
                  </tr>
          
                  </c:forEach>
                  </c:when>
                  <c:otherwise>
                  <tr>
  					<td colspan="6" align="center" style="padding-top: 50px;"><span style="color:red">�Բ���û����Ҫ�ҵ�����</span></td>
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
  				��ǰ${requestScope.pageBean.currentPage }/${requestScope.pageBean.totalPage }ҳ     &nbsp;&nbsp;
  				
  				
  				 <c:choose> 
				  <c:when test="${requestScope.m!=null || requestScope.sb!=null || requestScope.sk!=null }">   
				<a href="ParaManager.action?currentPage=1&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">��ҳ</a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage-1}&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">��һҳ </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage+1}&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">��һҳ </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.totalPage}&Museum_ID=${requestScope.m }&Storehouse_BuildingID=${requestScope.sb}&SearchKey=${requestScope.sk}&SearchRow=${requestScope.sr}">ĩҳ</a>
				  </c:when> 
				<%--   <c:when test="${requestScope.m!=null}">   
				    ${param.username} is manager.  
				  </c:when>  --%>
				  <c:otherwise>   
				<a href="ParaManager.action?currentPage=1">��ҳ</a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage-1}">��һҳ </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.currentPage+1}">��һҳ </a>
  				<a href="ParaManager.action?currentPage=${requestScope.pageBean.totalPage}">ĩҳ</a>
				
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

