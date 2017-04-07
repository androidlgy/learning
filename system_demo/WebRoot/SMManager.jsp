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
     if(isNull(form1.Motion_Operator.value)){  
   alert("请选择触发条件！"); 
   return false;
   }
    if(isNull(form1.Motion_Value.value)){  
   alert("请输入触发阈值！"); 
   return false;
   }
    if(isNull(form1.SM_MotionID.value)){  
   alert("请选择动作！"); 
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">设备动作设置</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="MySMAddSave.action" onsubmit="return mycheck()">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                 
                  <tr>
                    <td width="42%" height="30" style="padding-left:20px;"> 功能导航： <a href="SensorManager.action">返回上层</a></td>
                           <td width="58%">添加动作:当数据满足以下条件时
                            <select id="Motion_Operator" name="Motion_Operator">
                              <option value="1">&gt;</option>
                              <option value="2">&ge;</option>
                              <option value="3">&lt;</option>
                              <option value="4">&le;</option>
                              <option value="5">==</option>
                            </select>
                      <input class="text1" type="text" id="Motion_Value" name="Motion_Value" /><br></br>
                      <select name="SM_MotionID" id="SM_MotionID">
                        <option value="">请选择动作</option>
                        <s:iterator value="molist">
                        <option value="${Motion_ID}">${Motion_Name}</option>
                        </s:iterator>
                      </select>
                       <input type="submit" name="button" id="button" value="点击添加">
                        
                    <input name="SM_SensorID" type="text" class="noshow" id="SM_SensorID" value="${Sensor_ID}"></td>
                     
                    
                     
                  </tr>
                </table>
              </form>
              
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>传感器名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>阈值</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作内容</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="smlist">
                    <tr align="center">
                      <td height="25" align="center">${Sensor_Name}</td>
                      <td>${Motion_Name}</td>
                      <td>${Motion_Type}</td>
                      <td>${Motion_Value}</td>
                      <td align="center">${Motion_Msg}</td>
                      <td align="center"><a href="SMUpdate.action?SM_ID=${SM_ID}">编辑</a>   <a href="SMDel.action?SM_ID=${SM_ID}&Sensor_ID=${SM_SensorID}" onClick="return confirm('确定要将该动作从该设备移除吗？')">移除</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
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
