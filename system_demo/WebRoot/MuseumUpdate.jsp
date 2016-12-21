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
