<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8"%> 
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
</head>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">动作管理</td>
            </tr>
            <tr>
              <td height="510px" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MotionManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="MotionAdd.action">添加动作</a></td>
                    <td width="72%">类型： 
                     <select name="SearchKey" id="SearchKey">
                      <option value="邮件">邮件</option>
                      <option value="语音">语音</option>
                      <option value="微信推送">微信推送</option>
                      <option value="即时通讯-QQ">即时通讯-QQ</option>
                      </select>       
                      <input type="submit" name="button" id="button"  value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>名称</strong></td>
                    <td bgcolor="#D5E4F4"><strong>类型</strong></td>
                    <td bgcolor="#D5E4F4"><strong>语音文件名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>内容</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Motion_Name}</td>
                      <td>${Motion_Type}</td>
                      <td>${Motion_Wav}</td>
                      <td>${Motion_Msg}</td>
                      <td align="center">                
                        <a href="MotionUpdate.action?Motion_ID=${Motion_ID}">修改</a> 
                        <a href="MotionDelete.action?Motion_ID=${Motion_ID}" onClick="return confirm('确定要删除该动作吗？')">删除</a>
                      </td>
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
