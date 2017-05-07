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
   if(isNull(form1.Motion_Name.value)){  
   alert("请输入名称！"); 
   return false;
   }
    if(isNull(form1.Motion_Type.value)){  
   alert("请输入类型！"); 
   return false;
   }
    if(isNull(form1.Building_Msg.value)){  
   alert("请输入消息！"); 
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
<div id="Top" style="width: 80%; height: 10%; min-width: 1135px">
  <div class="Toolbar1">
    <%@ include file="left.jsp"%></div>
</div>
<table width="80%" height="59%" style="border-style: solid;border-width: 2px;min-width: 1135px">
<tr>
<td width="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改动作</td>
            </tr>
            <tr>
              <td height="510" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MotionUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" style="padding-top: 40px;">
                  <tr>
                    <td></td>
                     <td><input name="Motion_ID" type="text" class="noshow" id="Motion_ID" value="<s:property value='motionbean.Motion_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right" style="padding-left: 130px"><span style="color:red;">*</span>动作名称：</td>
                    <td><input name="Motion_Name" type="text" class="text2" id="Motion_Name" value="<s:property value='motionbean.Motion_Name'/>"></td>
                  </tr>              
                  <tr>
                     <td height="30" align="right"><span style="color:red;">*</span>动作类型：</td>
                    <td><!-- <input name="Sensor_Type" type="text" class="text2" id="Sensor_Type"> -->
                   <select name="Motion_Type"  class="text2" id="Motion_Type">
                   <option value="邮件" <s:if test='motionbean.Motion_Type=="邮件"'>selected</s:if>
                   >邮件</option>
                   <option value="语音" <s:if test='motionbean.Motion_Type=="语音"'>selected</s:if>
                   >语音</option>
                     <option value="微信推送" <s:if test='motionbean.Motion_Type=="微信推送"'>selected</s:if>
                   >微信推送</option>
                     <option value="即时通讯-QQ" <s:if test='motionbean.Motion_Type=="即时通讯-QQ"'>selected</s:if>
                   >即时通讯-QQ</option>              
                   </select> 
                    </td>
                  </tr>
                  <tr>
                    <td height="30" align="right">语音文件名：</td>
                   <td>
                    <select name="Motion_Wav" id="Motion_Wav">
                      <option value="">请选择</option>
                      <s:iterator id="aa" value="wlist">
                      <option value="${wav_root}" <s:if test="motionbean.Motion_Wav==wav_root">selected</s:if>>${wav_root}</option>
                      </s:iterator>
                      </select>
                      <span style="color:red;">语音报警必选</span>
                      </td>
                  </tr>
                  <tr>
                    <td height="30" align="right">信息：</td>
                    <td><textarea name="Motion_Msg" id="Motion_Msg" cols="45" rows="5" ><s:property value="motionbean.Motion_Msg"></s:property></textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改动作">
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
