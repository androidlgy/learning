
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
   if(isNull(form1.Storehouse_BuildingID.value)){  
   alert("请选择楼宇！"); 
   return false;
   }
   if(isNull(form1.Storehouse_Name.value)){
   alert("请输入库房号！");
   return false;
   }
   if(isNull(form1.Storehouse_Type.value)){
   alert("请输入库房类型！");
   return false;
   }
   if(isNull(form1.Storehouse_Number.value)){
   alert("请输入传感器数量！");
   return false;
   }
   if(isNull(form1.Storehouse_Tel.value)){
   alert("请输入电话！");
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改库房</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="StorehouseUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Storehouse_ID" type="text" class="noshow" id="Storehouse_ID" value="<s:property value='sbean.Storehouse_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>楼宇：</td>
                    <td><select name="Storehouse_BuildingID" id="Storehouse_BuildingID">
                      <option value="">请选择</option>
                      <s:iterator id="aa" value="list">
                      <option value="${Building_ID}" <s:if test="sbean.Storehouse_BuildingID==Building_ID">selected</s:if>>${Building_Name}</option>
                      </s:iterator>
                      </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>库房号：</td>
                    <td><input name="Storehouse_Name" type="text" class="text2" id="Storehouse_Name" value="<s:property value='sbean.Storehouse_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>库房类型：</td>
                    <td><input name="Storehouse_Type" type="text" class="text2" id="Storehouse_Type" value="<s:property value='sbean.Storehouse_Type'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>传感器数量：</td>
                    <td><input name="Storehouse_Number" type="text" class="text2" id="Storehouse_Number" value="<s:property value='sbean.Storehouse_Number'/>"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>电话：</td>
                    <td><input name="Storehouse_Tel" type="text" class="text2" id="Storehouse_Tel" value="<s:property value='sbean.Storehouse_Tel'/>"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改库房">
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
