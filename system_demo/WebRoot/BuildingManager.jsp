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
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Building_Name.value)){  
   alert("请输入名称！"); 
   return false;
   }
   if(isNull(form1.Building_MuseumID.value)){  
   alert("请选择档案馆！"); 
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
<div id="Top" style="width: 80%; height: 10%;min-width: 1135px">
  <div class="Toolbar1">
    <%@ include file="left.jsp"%></div>
</div>
<table width="80%" height="59%" style="border-style: solid;border-width: 2px;min-width: 1135px">
<tr>
<td width="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">楼宇管理</td>
            </tr>
            <tr>
              <td height="515" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="BuildingManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="27%" height="30" style="padding-left:20px;"> 功能导航： <a href="BuildingAdd.action">添加楼宇</a></td>
                    <td width="72%">名称：
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button"  value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4" width="100px"><strong>档案馆名称</strong></td>
                    <td bgcolor="#D5E4F4" width="200px"><strong>名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>简介</strong></td>
                    <td bgcolor="#D5E4F4" width="120px"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                    <td height="45" align="center">${Museum_Name}</td>
                      <td width="250px">${Building_Name}</td>
                      <td align="left">${Building_Introduction}</td>
                      <td align="center">
                        <a href="UBManager.action?Building_ID=${Building_ID}">管理员</a> 
                        <a href="BuildingUpdate.action?Building_ID=${Building_ID}">修改</a> 
                        <a href="BuildingDel.action?Building_ID=${Building_ID}" onClick="return confirm('确定要删除该楼宇吗？')">删除</a>
                      </td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
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
