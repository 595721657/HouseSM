<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<title>房产管理系统———注册页面</title>
<style type="text/css">
   *{margin: 0px auto;padding: 0px;}
   #big{width: 360px;height: 270px;background-color: #FFFACD;margin-top: 130px;}
</style>
</head>
<body>
<div class="container" id="big">
 <form action="Users?op=add" method="post">
   <table class="table">
     <tr>
       <th colspan="2" style="text-align: center;">房产信息管理系统注册</th>
     </tr>
     <tr>
       <th>身份证号：</th>
       <td><input type="text" name="cardid" value=""/></td>
     </tr>
     <tr>
       <th>用户名：</th>
       <td><input type="text" name="name" value=""/></td>
     </tr>
     <tr>
       <th>密码：</th>
       <td><input type="password" name="password" value=""/></td>
     </tr>
     <tr>
       <th>确认密码：</th>
       <td><input type="password" name="repassword" value=""/></td>
     </tr>
     <tr>
       <td colspan="2" style="text-align: center;"><button type="submit" class="btn btn-success" style="margin-right: 50px;">登录</button><button type="submit" class="btn btn-success" style="margin-right: 50px;"><a href="login.jsp">返回</a></button></td>
     </tr>
   </table>
 </form>  
 </div>
</body>
</html>