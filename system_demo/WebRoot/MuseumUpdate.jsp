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
   if(isNull(form1.Museum_Name.value)){  
   alert("请输入名称！"); 
   return false;
   }
    if(isNull(form1.Museum_Address.value)){  
   alert("请输入地址！"); 
   return false;
   }
    if(isNull(form1.Museum_PhoneNumber.value)){  
   alert("请输入号码！"); 
   return false;
   }
   if(isNull(form1.Museum_Email.value)){  
   alert("请输入邮箱！"); 
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改档案馆</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MuseumUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                     <td width="67%"><input name="Museum_ID" type="text" class="noshow" id="Museum_ID" value="<s:property value='Mesumbean.Museum_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>档案馆名称：</td>
                    <td><input name="Museum_Name" type="text" class="text2" id="Museum_Name" value="<s:property value='Mesumbean.Museum_Name'/>"></td>
                  </tr>              
                  <tr>
                     <td height="30" align="right"><span style="color:red;">*</span>地址：</td>
                    <td><input name="Museum_Address" type="text" class="text2" id="Museum_Address" value='<s:property value='Mesumbean.Museum_Address'/>'>
 </td>
                  </tr>
                      <tr>
                     <td height="30" align="right"><span style="color:red;">*</span>联系电话：</td>
                    <td><input name="Museum_PhoneNumber" type="text" class="text2" id="Museum_PhoneNumber" value='<s:property value='Mesumbean.Museum_PhoneNumber'/>'>
 </td>
                  </tr>
                      <tr>
                     <td height="30" align="right"><span style="color:red;">*</span>邮箱：</td>
                    <td><input name="Museum_Email" type="text" class="text2" id="Museum_Email" value='<s:property value='Mesumbean.Museum_Email'/>'>
 </td>
                  </tr>
                  <tr>
                    <td height="30" align="right">简介：</td>
                    <td><textarea name="Museum_Description" id="Museum_Description" cols="45" rows="5" ><s:property value="Mesumbean.Museum_Description"></s:property></textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改档案馆">
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
</center>
</body>
</html>
