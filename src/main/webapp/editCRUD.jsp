<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${listID.imageLink}" />
<title>${listID.titleName}</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link
	href="https://fonts.googleapis.com/css?family=Quicksand&display=swap"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	font-family: 'Quicksand', sans-serif;
}

body {
	height: 100%;
	width: 100%;
}

.container {
	position: relative;
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 20px 100px;
}

.container:after {
	content: '';
	position: absolute;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0;
	background: url("${listID.imageLink}") no-repeat center;
	background-size: cover;
	filter: blur(50px);
	z-index: -1;
}

.contact-box {
	max-width: 850px;
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	justify-content: center;
	align-items: center;
	text-align: center;
	background-color: #fff;
	box-shadow: 0px 0px 19px 5px rgba(0, 0, 0, 0.19);
}

.left {
	background: url("${listID.imageLink}") no-repeat center;
	background-size: cover;
	height: 100%;
}

.right {
	padding: 25px 40px;
}

h2 {
	position: relative;
	padding: 0 0 10px;
	margin-bottom: 10px;
}

h2:after {
	content: '';
	position: absolute;
	left: 50%;
	bottom: 0;
	transform: translateX(-50%);
	height: 4px;
	width: 50px;
	border-radius: 2px;
	background-color: #2ecc71;
}

.field {
	width: 100%;
	border: 2px solid rgba(0, 0, 0, 0);
	outline: none;
	background-color: rgba(230, 230, 230, 0.6);
	padding: 0.5rem 1rem;
	font-size: 1.1rem;
	margin-bottom: 22px;
	transition: .3s;
}

.field:hover {
	background-color: rgba(0, 0, 0, 0.1);
}

textarea {
	min-width: 400px;
	min-height: 150px;
	max-width: 400px;
	max-height: 400px;
}

.btn {
	width: 100%;
	padding: 0.5rem 1rem;
	background-color: #fff;
	font-size: 1.1rem;
	border: none;
	outline: none;
	cursor: pointer;
	transition: .3s;
}

.btn:hover {
	background-image: linear-gradient(to left top, blue, red);
	font-size: 20px;
	color: #fff;
	transform: translateY(-10%);
	box-shadow: 0px 0px 19px 5px rgba(0, 0, 0, 0.19);
}

.field:focus {
	border: 2px solid rgba(30, 85, 250, 0.47);
	background-color: #fff;
}

@media screen and (max-width: 880px) {
	.contact-box {
		grid-template-columns: 1fr;
	}
	.left {
		height: 200px;
	}
}

.image, a {
	width: 25px;
	height: 25px;
}

.image:hover {
	border-radius: 50%;
	background-image: linear-gradient(to left top, blue, red);
}
</style>
</head>
<body>
	<div class="container">
		<div class="contact-box">
			<div class="left"></div>
			<div class="right">
				<a title="Back" href="CRUDcontrol?index=1"><img class="image"
					src="https://cdn-icons-png.flaticon.com/512/93/93634.png"></a>
				<h2>Edit News</h2>
				<form action="editControl" method="post">
					<label>ID</label> <input name="id" class="field" placeholder="id"
						type="text" value="${listID.id}" readonly> <label>Day
						news</label> <input name="dayNews" class="field" placeholder="Day News"
						type="text" value="${listID.dayNews}" required> <label>Title
						News</label> <input name="titleName" class="field"
						placeholder="Title Name" value="${listID.titleName}" type="text"
						required> <label>Title News</label> <input
						name="imageLink" class="field" placeholder="Link Image"
						value="${listID.imageLink}" type="text" required> <label>Content</label>
					<textarea name="content" class="field" placeholder="Content"
						required>${listID.conTent}</textarea>
					<label>Type News</label> <select class="field" name="typeNews">
						<option style="display: none;" value="${listID.typeNews}">${listID.typeNews}</option>
						<c:forEach items="${listType}" var="o">
							<option value="${o.typeNews}">${o.typeNews}</option>
						</c:forEach>
					</select> <label>Trend</label>
					<div class="field">
						<input type="radio" name="Trend" value="1"
							${listID.trend==true?'checked':''} required> Yes <input
							type="radio" name="Trend" value="0"
							${listID.trend==false?'checked':''} required> No
					</div>
					<button class="btn" type="submit">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>