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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改楼宇</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="BuildingUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Building_ID" type="text" class="noshow" id="Building_ID" value="<s:property value='buildingbean.Building_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>名称：</td>
                    <td><input name="Building_Name" type="text" class="text2" id="Building_Name" value="<s:property value='buildingbean.Building_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>简介：</td>
                    <td><textarea name="Building_Introduction" id="Building_Introduction" cols="45" rows="5"><s:property value='buildingbean.Building_Introduction'/></textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改楼宇">
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

