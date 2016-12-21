
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
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">编辑触发动作</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="SMUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="SM_ID" type="text" class="noshow" id="SM_ID" value="<s:property value='sbean.SM_ID'/>"></td>
                   <td width="67%"><input name="SM_SensorID" type="text" class="noshow" id="SM_SensorID" value="<s:property value='sbean.SM_SensorID'/>"></td>
                  </tr>
                                   
                  <tr>
                  <%-- <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>库房号：</td>
                    <td><input name="Sensor_StorehouseID" type="text" class="text2" id="Sensor_StorehouseID" value="<s:property value='sbean.Storehouse_Name'/>"></td>
                  </tr> --%>
                 
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span> 当满足以下条件时：</td>
                    <td><!-- <input name="Sensor_Type" type="text" class="text2" id="Sensor_Type"> -->
                                                           
                   <select name="Motion_Operator" class="text2" id="Motion_Operator">
                   <option value="1"
                   <s:if test='sbean.Motion_Operator=="1"'>selected</s:if>
                   >&gt;</option>
                   
                   <option value="2"
                   <s:if test='sbean.Motion_Operator=="2"'>selected</s:if>
                   >&ge;</option>
                   
                   <option value="3"
                   <s:if test='sbean.Motion_Operator=="3"'>selected</s:if>
                   >&lt;</option>
                   
                   <option value="4"
                   <s:if test='sbean.Motion_Operator=="4"'>selected</s:if>
                   >&le;</option>
                   
                   <option value="5"
                   <s:if test='sbean.Motion_Operator=="5"'>selected</s:if>
                   >==</option>
           
                   </select> 
                    </td>
                     <tr>
                    <td height="30" align="right"><span style="color:red;">*</span></td>
                    <td><input name="Motion_Value" type="text" class="text2"  id="Motion_Value" value="<s:property value='sbean.Motion_Value'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>动作：</td>
                    <td><select name="SM_MotionID" id="SM_MotionID">
                      <s:iterator id="aa" value="mlist">
                      <option value="${Motion_ID}" <s:if test="sbean.SM_MotionID==Motion_ID">selected</s:if>>${Motion_Name}</option>
                      </s:iterator>
                      </select></td>
                  </tr>
              
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改触发动作">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
