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
   if(isNull(form1.Manager_Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if (document.form1.Manager_Password.value != document.form1.Manager_Password2.value) { 
   alert("您两次输入的新密码不一致！请重新输入！"); 
   return false; 
   }  
   if(isNull(form1.Manager_Name.value)){
   alert("请输入姓名！");
   return false;
   }
   if(isNull(form1.Manager_Sex.value)){
   alert("请选择性别！");
   return false;
   }
   if(isNull(form1.Manager_Tel.value)){
   alert("请输入联系电话！");
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
       <td height="15" background="Images/MenuBg.jpg" align="right">&nbsp;当前用户：${sessionScope.Manager_Username}</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top">
      <table width="80%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="12%" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="88%" align="center" valign="top" bgcolor="#F6F9FE"><table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">添加档案馆管理员</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MuseumAdminAdd.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                 <!--  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Manager_ID" type="text" class="noshow" id="Manager_ID"></td>
                  </tr> -->
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>用户名：</td>
                    <td><input name="Manager_Username" type="text" class="text2" id="Manager_Username"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>密码：</td>
                    <td><input name="Manager_Password" type="password" class="text2" id="Manager_Password">
                 </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>重复密码：</td>
                    <td><input name="Manager_Password2" type="password" class="text2" id="Manager_Password2">
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>姓名：</td>
                    <td><input name="Manager_Name" type="text" class="text2" id="Manager_Name"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>性别：</td>
                    <td><select name="Manager_Sex" id="Manager_Sex">
                      <option value="">请选择</option>
                      <option value="男" >男</option>
                      <option value="女" >女</option>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>联系电话：</td>
                    <td><input name="Manager_Tel" type="text" class="text2" id="Manager_Tel"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="添加档案馆管理员">
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

