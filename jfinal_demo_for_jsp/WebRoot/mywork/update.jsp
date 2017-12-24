<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改标签信息</title>
<style type="text/css">
html, div, h4, h1, h3 {
	padding: 0;
	margin: 0;
}

.content {
	margin: 0 auto;
	width: 400px;
	min-height: 500px;
	background: #DEF5DE;
}

.content form {
	margin: 0 auto;
}

.content form input {
	width: 220px;
	height: 25px;
	border: 1px solid green;
	border-radius: 5px;
	margin-left: 50px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="content">
		<h3>修改标签信息</h3>
		<form action="updateLabel.do" method="POST">
			<table>
				<tr>
					<td>主题 Id：</td>
					<td><input type="text" name="yhLabel.themeId"
						value="${label.themeId }" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>主题名称：</td>
					<td><input type="text" name="yhLabel.themeName"
						value="${label.themeName }" /></td>
				</tr>
				<tr>
					<td>来源：</td>
					<td><input type="text" name="yhLabel.source"
						value="${label.source }" /></td>
				</tr>
				<tr>
					<td>热度：</td>
					<td><input type="text" name="yhLabel.heat"
						value="${label.heat }"></td>
				</tr>
				<tr>
					<td>父级 Id：</td>
					<td><input type="text" name="yhLabel.parent_id"
						value="${label.parent_id }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>等级：</td>
					<td><input type="text" name="yhLabel.level"
						value="${label.level }"></td>
				</tr>
				<tr>
					<td>类型：</td>
					<td><input type="text" name="yhLabel.type"
						value="${label.type }"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="提交修改" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>