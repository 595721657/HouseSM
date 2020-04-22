<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>房产信息管理系统-展示页面</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/static/css/bootstrap.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<style type="text/css">
.big{
 border: 3px solid black;
 height: 300px;
 line-height: 600px;
 text-align: center;
}
</style>
</head>
<body>
<h2 style="text-align: center;">房产信息查询系统</h2>
<p style="text-align: center;">用户名:<span style="font-weight: bold;">${name }</span> &nbsp;&nbsp;<a href="Users?op=out_login">退出</a></p>
<a href="Real?op=show">房产信息查询</a>
<c:if test="${pg.pageLists ==null}" var="isOK">
<div class="big">
<h1 style="margin: 150px auto;">欢迎使用房产信息查询系统</h1>
</div>
</c:if>
<c:if test="${!isOK }">
<div class="container">
<table class="table table-hover table-striped">
   <tr>
     <td colspan="8">
	     <form action="Real?op=show" method="post">
	               查询类型:<select id="second" name="tiaojian">
				      <option value="1">用户名</option>
				      <option value="2">身份证</option>
				     </select>
				     <input type="text" name="title" value=""/>&nbsp;&nbsp;<button type="submit" class="btn btn-success">搜索</button>
	     </form>
     </td>
   </tr>
   <tr>
     <th>序号</th>
     <th>项目名称</th>
     <th>产权人</th>
     <th>身份证号</th>    
     <th>房屋地址</th>
     <th>房屋类型</th>
     <th>使用面积</th>
     <th>建造时间</th>
   </tr>
   <c:forEach items="${pg.pageLists }" var="a" varStatus = "status">
      <tr>
        <td><c:out value="${status.count}"></c:out></td>
        <td>${a.projectname}</td>
        <td>${a.user.name}</td>
        <td>${a.user.cardid}</td>
        <td>${a.address }</td>
        <td>${a.housetype}</td>
        <td>${a.area}</td>
        <td><fmt:formatDate value="${a.buildtime}" pattern="YYYY-MM-dd HH:mm:ss"/></td>
      </tr>
   </c:forEach>
</table>
<div class="paging" style="height: 200px;">
		<span class="fr">
		【第${pg.currPage }页/共${pg.totalPages}页】
		<a href="${pageContext.request.contextPath }/Real?op=show&pageIndex=1">首页</a>&nbsp;
		<a href="${pageContext.request.contextPath }/Real?op=show&pageIndex=${pg.currPage-1 }">上一页</a>&nbsp;
		<a href="${pageContext.request.contextPath }/Real?op=show&pageIndex=${pg.currPage+1 }">下一页</a>&nbsp;
		<a href="${pageContext.request.contextPath }/Real?op=show&pageIndex=${pg.totalPages }">尾页</a>&nbsp;【共${pg.totalCount}数据】</span>
</div>
</div>
</c:if>
</body>
</html>