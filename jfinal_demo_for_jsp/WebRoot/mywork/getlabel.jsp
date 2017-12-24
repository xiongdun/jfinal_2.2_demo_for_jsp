<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>对Label表的增删改查</title>
<style type="text/css">
table tr td {
	min-width: 50px;
}
</style>
</head>
<body>
	<center>
		<form action="">
			<input type="text" width="220px" name="labelId" /> <input
				type="submit" />
		</form>
		<table>
			<tr style="font-weight: bold;">
				<td>主题Id</td>
				<td>主题名称</td>
				<td>来源</td>
				<td>热度</td>
				<td>父级ID</td>
				<td>等级</td>
				<td>类型</td>
				<td></td>
				<td></td>
			</tr>
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.themeId}</td>
					<td>${item.themeName}</td>
					<td>${item.source}</td>
					<td>${item.heat}</td>
					<td>${item.parent_id}</td>
					<td>${item.level}</td>
					<td>${item.type}</td>
					<td><a href="toDetail.do?id=${item.themeId }">查看</a></td>
					<td><a href="deleteLabel.do?id=${item.themeId }">删除</a></td>
				</tr>
			</c:forEach>
		</table>

	</center>
</body>
</html>