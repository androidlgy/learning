<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园宿舍管理系统</title>
    <base href="<%=basePath%>">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link href="css/Article.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/Article.js"></script>
<script language="JavaScript">
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Building_Name.value)){
   alert("请输入库房名称！");
   return false;
   }
   if(isNull(form1.Building_Introduction.value)){
   alert("请输入库房介绍！");
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
 <table  height="29%" width="80%" style="min-width: 1135px" >
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
<td width="70%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改楼宇</td>
            </tr>
            <tr>
              <td height="515" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="BuildingUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" style="padding-top: 40px">
                  <tr>
                    <td></td>
                    <td><input name="Building_ID" type="text" class="noshow" id="Building_ID" value="<s:property value='buildingbean.Building_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="40" align="right" style="padding-left: 130px"><span style="color:red;">*</span>楼宇名称：</td>
                    <td><input name="Building_Name" type="text" class="text2" id="Building_Name" value="<s:property value='buildingbean.Building_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="35" align="right"><span style="color:red;">*</span>楼宇简介：</td>
                    <td><textarea name="Building_Introduction" id="Building_Introduction" cols="45" rows="5"><s:property value='buildingbean.Building_Introduction'/></textarea></td>
                  </tr>
                  <tr>
                    <td height="40">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改楼宇">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
            </tr>
          </table>
 </td>
 </tr>
 </table>


    <table height="1%" width="80%">
    <tr>
      <td background="Images/bootBg.jpg" align="center"><span id="time"></span></td>
    </tr>  	
  </table >
  
  
  
</body>
</html>

