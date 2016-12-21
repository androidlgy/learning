<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<table width="155" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="31" align="center" background="Images/left1.jpg"><strong>系统选项</strong></td>
            </tr>
            <tr>
              <td height="50" align="center" valign="top"><table width="150" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="index.jsp">前台首页</a></td>
                </tr>
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%if(session.getAttribute("type").toString().equals("1")){%>
                  <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MuseumAdminManager.action">档案馆管理员管理</a></td>
                </tr>
                 <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>             
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="RoomAdminManager.action">库房管理员管理</a></td>
                </tr>
                 <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                   <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MuseumManager.action">档案馆管理</a></td>
                </tr>
                 <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>  
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="BuildingManager.action"> 楼宇管理 </a></td>
                </tr>  
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StorehouseManager.action">库房管理 </a></td>
                </tr>
                 <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="SensorManager.action"> 设备管理 </a></td>
                </tr>
                             
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MotionManager.action"> 动作管理 </a></td>
                </tr>
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="ParaManager.action">参数管理</a></td>
                </tr>
                <tr>
                <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
             <%}%>
                <%if(session.getAttribute("type").toString().equals("2")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyBuildingManager.action">楼宇管理</a></td>
                </tr>
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                   <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyParaManager.action">参数管理</a></td>
                </tr>
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyStorehouseManager.action">库房管理 </a></td>
                </tr>
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                 <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MotionManager.action">动作管理</a></td>
                </tr>
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                 <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MySensorManager.action">设备管理 </a></td>
                </tr>
                <tr>
                  <td height="10" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%> 
                
                <%if(session.getAttribute("type").toString().equals("3")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyStudent.action">参数管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyLog.action">用户管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                 <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyLog.action">动作管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                 <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyLog.action">设备管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%> 
              
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="PasswordUpdate.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
          </table>