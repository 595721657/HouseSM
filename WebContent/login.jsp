<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<title>房产管理系统————登录页面</title>
<style type="text/css">
   *{margin: 0px auto;padding: 0px;}
   #big{width: 360px;height: 170px;background-color: #FFFACD;margin-top: 130px;}
</style>
</head>
<body>
<div class="container" id="big">
 <form action="Users?op=login" method="post">
   <table class="table">
     <tr>
       <th colspan="2" style="text-align: center;">房产信息管理系统登录</th>
     </tr>
     <tr>
       <th>请输入身份证号：</th>
       <td><input type="text" name="cardid" value=""/></td>
     </tr>
     <tr>
       <th>请输入密码：</th>
       <td><input type="password" name="password" value=""/></td>
     </tr>
     <tr>
       <td colspan="2" style="text-align: center;"><button type="submit" class="btn btn-success" style="margin-right: 50px;">登录</button><a href="add.jsp">注册</a></td>
     </tr>
   </table>
 </form>  
</div>
</body>
</html>