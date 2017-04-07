
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
   if(isNull(form1.Sensor_StorehouseID.value)){  
   alert("请选择库房！"); 
   return false;
   }
   if(isNull(form1.Sensor_Name.value)){
   alert("请输入设备名称！");
   return false;
   }
   if(isNull(form1.Sensor_Type.value)){
   alert("请输入设备类型！");
   return false;
   }
   if(isNull(form1.Sensor_Unit.value)){
   alert("请输入设备单位/符号！");
   return false;
   }
   if(isNull(form1.Sensor_Description.value)){
   alert("请输入设备简介！");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改设备</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="SensorUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Sensor_ID" type="text" class="noshow" id="Sensor_ID" value="<s:property value='sbean.Sensor_ID'/>"></td>
                  </tr>
                  
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>库房：</td>
                    <td><select name="Sensor_StorehouseID" id="Sensor_StorehouseID">
                      <s:iterator id="aa" value="slist">
                      <option value="${Storehouse_ID}" <s:if test="sbean.Sensor_StorehouseID==Storehouse_ID">selected</s:if>>${Storehouse_Name}</option>
                      </s:iterator>
                      </select></td>
                  </tr>
                  <tr>
                  <%-- <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>库房号：</td>
                    <td><input name="Sensor_StorehouseID" type="text" class="text2" id="Sensor_StorehouseID" value="<s:property value='sbean.Storehouse_Name'/>"></td>
                  </tr> --%>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>设备名称：</td>
                    <td><input name="Sensor_Name" type="text" class="text2" id="Sensor_Name" id="Sensor_Name" value="<s:property value='sbean.Sensor_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>类型：</td>
                    <td><!-- <input name="Sensor_Type" type="text" class="text2" id="Sensor_Type"> -->
                   <select name="Sensor_Type"  class="text2" id="Sensor_Type">
                   <option value="数值型传感器"
                   <s:if test='sbean.Sensor_Type=="数值型传感器"'>selected</s:if>
                   >数值型传感器</option>
                   
                   <option value="GPS"
                   <s:if test='sbean.Sensor_Type=="GPS"'>selected</s:if>
                   >GPS</option>
                   
                   <option value="图像传感器"
                   <s:if test='sbean.Sensor_Type=="图像传感器"'>selected</s:if>
                   >图像传感器</option>
                   
                   <option value="泛传感器"
                   <s:if test='sbean.Sensor_Type=="泛传感器"'>selected</s:if>
                   >泛传感器</option>
           
                   </select> 
                    </td>
                  </tr>
                  <!-- <option value="男" 
                      <s:if test='userbean.User_Sex=="男"'>selected</s:if>
                      >男
                      </option> -->
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>单位/符号：</td>
                    <td><input name="Sensor_Unit" type="text" class="text2" id="Sensor_Unit" value="<s:property value='sbean.Sensor_Unit'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>简介：</td>
                    <td><input name="Sensor_Description" type="text" class="text2" id="Sensor_Description" value="<s:property value='sbean.Sensor_Description'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改设备">
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
