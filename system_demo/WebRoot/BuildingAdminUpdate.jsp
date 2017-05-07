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
   if(isNull(form1.User_Username.value)){  
   alert("请输入用户名！"); 
   return false;
   }
   if (document.form1.User_Password.value != document.form1.User_Password2.value) { 
   alert("您两次输入的新密码不一致！请重新输入！"); 
   return false; 
   }  
   if(isNull(form1.User_Name.value)){
   alert("请输入姓名！");
   return false;
   }
   if(isNull(form1.User_Sex.value)){
   alert("请选择性别！");
   return false;
   }
   if(isNull(form1.User_Tel.value)){
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
 <div id="Top" style="width: 80%; height: 10%;min-width: 1135px">
  <div class="Toolbar1">
    <%@ include file="left.jsp"%></div>
</div>
<table width="80%" height="59%" style="border-style: solid;border-width: 2px;min-width: 1135px">
<tr>
<td width="100%">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改楼宇管理员</td>
            </tr>
            <tr>
              <td height="510px" align="center" valign="top" bgcolor="#F6F9FE">
              <form name="form1" method="post" action="BuildingAdminUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0" style="padding-top: 40px;">
                  <tr>
                    <td></td>
                    <td><input name="User_ID" type="text" class="noshow" id="User_ID" value="<s:property value='userbean.User_ID'/>"></td>
                  </tr>
                  <tr>
                    <td height="33" align="right" style="padding-left: 130px"><span style="color:red;">*</span>用户名：</td>
                    <td><input name="User_Username" type="text" class="text2" id="User_Username" value="<s:property value='userbean.User_Username'/>"></td>
                  </tr>
                  <tr>
                    <td height="33" align="right">密码：</td>
                    <td><input name="User_Password" type="password" class="text2" id="User_Password">
                      <span style="color:#F60">不修改则不填写</span></td>
                  </tr>
                  <tr>
                    <td height="33" align="right">重复密码：</td>
                    <td><input name="User_Password2" type="password" class="text2" id="User_Password2">
                      <span style="color:#F60">不修改则不填写</span></td>
                  </tr>
                  <tr>
                    <td height="33" align="right"><span style="color:red;">*</span>姓名：</td>
                    <td><input name="User_Name" type="text" class="text2" id="User_Name" value="<s:property value='userbean.User_Name'/>"></td>
                  </tr>
                  <tr>
                    <td height="33" align="right"><span style="color:red;">*</span>性别：</td>
                    <td><select name="User_Sex" id="User_Sex">
                      <option value="">请选择</option>
                      <option value="男" 
                      <s:if test='userbean.User_Sex=="男"'>selected</s:if>
                      >男
                      </option>
                      <option value="女" 
                      <s:if test='userbean.User_Sex=="女"'>selected</s:if>
                      >女
                      </option>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="33" align="right"><span style="color:red;">*</span>联系电话：</td>
                    <td><input name="User_Tel" type="text" class="text2" id="User_Tel" value="<s:property value='userbean.User_Tel'/>"></td>
                  </tr>
                  <tr>
                    <td height="33">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改楼宇管理员">
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
