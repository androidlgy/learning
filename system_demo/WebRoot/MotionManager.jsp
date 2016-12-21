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
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">动作管理</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MotionManager.action">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="MotionAdd.jsp">添加动作</a></td>
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
                    <td bgcolor="#D5E4F4"><strong>内容</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                  <s:iterator id="aa" value="list">
                    <tr align="center">
                      <td height="25" align="center">${Motion_Name}</td>
                      <td>${Motion_Type}</td>
                      <td>${Motion_Msg}</td>
                      <td align="center">                
                        <a href="MotionUpdate.action?Motion_ID=${Motion_ID}">修改</a> 
                        <a href="MotionDelete.action?Motion_ID=${Motion_ID}" onClick="return confirm('确定要删除该动作吗？')">删除</a>
                      </td>
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
