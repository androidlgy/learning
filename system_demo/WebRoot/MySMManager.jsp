<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>库房环境监测系统系统</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
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
<body>
<center>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="150" background="Images/head.jpg" style="color:#06F; font-size:13px; font-weight:bolder; padding-right:50px;"><a>联系我们</a></td>
    </tr>
    <tr>
       <td height="30" background="Images/MenuBg.jpg" align="right">&nbsp;当前用户：${sessionScope.Manager_Username}</td>
    </tr>
    <tr>
      <td height="100%" align="center" valign="top"><table width="80%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="12%" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="88%" align="center" valign="top" bgcolor="#F6F9FE"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">设备动作设置</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="SMAddSave.action" onsubmit="return mycheck()">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                 
                  <tr>
                    <td width="42%" height="30" style="padding-left:20px;"> 功能导航： <a href="MySensorManager.action">返回上层</a></td>
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
                    <td height="25" bgcolor="#D5E4F4"><strong>设备名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>动作内容</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="smlist">
                    <tr align="center">
                      <td height="25" align="center">${Sensor_Name}</td>
                      <td>${Motion_Name}</td>
                      <td>${Motion_Type}</td>
                      <td align="center">${Motion_Msg}</td>
                      <td align="center"><a href="MySMUpdate.action?SM_ID=${SM_ID}">编辑</a>   <a href="MySMDel.action?SM_ID=${SM_ID}&Sensor_ID=${SM_SensorID}" onClick="return confirm('确定要将该动作从该设备移除吗？')">移除</a></td>
                    </tr>
                  </s:iterator>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
