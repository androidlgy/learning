<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>库房环境监测系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="Style/Styles.css"><!--使用link来调用外部的css文件  -->
  </head>
  <script language="JavaScript">

function mycheck(){
   if(isNull(form1.Type.value)){  
   alert("请选择身份！"); 
   return false;
   }
   if(isNull(form1.Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if(isNull(form1.Password.value)){
   alert("请输入密码！");
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
<center> <!-- 标签对其包围的文本进行水平居中处理 -->
<table height="10%" width="100%">
<tr>
<td  align="center" valign="middle">
<h1><font color="009EE7">泰德安信档案馆库房环境监测系统</font></h1>
</td>
</tr>
</table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0" height="80%" bgcolor="009EE7"><!--with规定表格的宽度，border规定表格边框的宽度，cellspacing规定单元格之间的空白，cellpadding规定单元边沿与其内容之间的空白 -->
    <tr>
      <td height="292" align="center" valign="middle" bgcolor="">
      <table width="350" height="201" border="0" cellpadding="0" cellspacing="0" bgcolor="F7F7F7" >
        <tr>
          <td height="72" align="center"><h3><font color="009EE7">用户登录</font></h3></td>
        </tr>
        <tr>
          <td align="right" valign="middle">
             <form name="form1" action="GoLogin.action" method="post" onSubmit="return mycheck()">
              <table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="ECF9FF">
                <tr>
                  <td height="10" colspan="2" align="center" class="STYLE2"><span style="color:red;">
                    <%if(request.getAttribute("Msg")!=null){%>
                    <%=request.getAttribute("Msg")%>
                    <%}%>
                  </span></td>
                  </tr>
                <tr>
                  <td height="30" align="right" class="STYLE2">身份：</td>
                  <td align="left"><select name="Type" id="Type">
                    <option value="">请选择</option>
                    <option value="系统管理员">系统管理员</option>
                    <option value="档案馆管理员">档案馆管理员</option>
                  </select></td>
                  </tr>
                <tr>
                  <td width="37%" height="30" align="right" class="STYLE2">用户名：</td>
                  <td width="300" align="left"><input type="text" name="Username" id="Username" class="text1" /></td>
                  </tr>
                <tr>
                  <td height="30" align="right" class="STYLE2">密码：</td>
                  <td align="left"><input type="password" name="Password" id="Password" class="text1" /></td>
                  </tr>
                   <tr>
                        <td align="center" colspan="2" ><a href="***" >忘记密码</a></td>
                  </tr>
                  
                <tr>
                  <td height="30" colspan="2" align="center"><label>
                    <input type="submit" name="button" id="button" value="登录" style="background-color: 009EE7;color: F5F5F5">
                  </label></td>
                  </tr>
                 
              </table>
              </form>
          </td>
        </tr>
      </table></td>
    </tr>
  </table>
  <table height="10%">
  <tr>
  <td>
  
  <p id="gray" align="center">版权所有 &copy; 2013-2017 <a target="_blank" href="http://www.hbxgda.org/">湖北孝感档案局</a>&nbsp;&nbsp;&nbsp;<br> 技术支持群：1152835411   技术支持：<a target="_blank" href="http://hbtdaxxxjsyxgs.21hubei.com/">湖北泰德安信技术有限公司</a></p>
  </td>
  </tr>
  </table>
</center>

</body>
</html>