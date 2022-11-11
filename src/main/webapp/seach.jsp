<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="shortcut icon"
	href="https://images.fpt.shop/unsafe/filters:quality(90)/fptshop.com.vn/uploads/images/tin-tuc/146257/Originals/lol-la-gi-1.jpeg" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device=width, initial-scale=1.0">
<title>The News</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cssSeach.css">
</head>

<body>

	<div class="container">
		<div class="logo-wrapper d-flex align-items-center">
			<h1>
				<a href="home?index=1"> The News lol </a>
			</h1>
		</div>
	</div>
	<form action="SeachControl" class="search-bar">
		<input type="search" name="search" pattern=".*\S.*" required>
		<button class="search-btn" type="submit">
			<span>Search</span>
		</button>
	</form>

	<div class="container-fluid menu">
		<div class="container">
			<div class="d-flex menu-items">
				<div>
					<a href="home?index=1">Home</a>
				</div>
				<c:if test="${sessionScope.account == null}">
					<div>
						<a href="index.jsp">login</a>
					</div>
				</c:if>
				<c:if test="${sessionScope.account != null}">
					<div class="active">
						<a>Hello, ${sessionScope.account.username}</a>
					</div>
					<div>
						<a href="index.jsp">Log out</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>

	<div class="container main-news">
		<div class="row">
			<div class="col-8">

				<div class="mb-4 mt-4 section">
					<div class="section-title">
						<span>From the search results:</span>

					</div>

					<c:forEach items="${seachList}" var="o">
						<div class="row mb-3 bb-1 pt-0">
							<div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
								<img class="thumb" title="${o.titleName}." src="${o.imageLink}">
							</div>
							<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
								<h5>
									<a href="DetailControl?id=${o.id}"> ${o.titleName} </a>
								</h5>
								<small>${o.dayNews}</small>
								<p class="summary pt-3">${conTent}</p>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
			<div class="col-4">
				<div class="trending mt-4">
					<div class="section-title">
						<span>Trending</span>
					</div>
					<c:forEach items="${trenddingSeach}" var="o">
						<div class="row">
							<div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
								<img class="thumb" title="${o.titleName}." src="${o.imageLink}">
							</div>
							<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
								<a href="DetailControl?id=${o.id}"> ${o.titleName} </a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.html"%>
	<script type="text/javascript">
		window.onscroll = function() {
			setSticky();
		}

		navbar = document.getElementsByClassName('menu')[0];
		var sticky = navbar.offsetTop;
		function setSticky() {
			if (window.pageYOffset >= sticky) {
				navbar.classList.add('sticky');
			} else {
				navbar.classList.remove('sticky');
			}
		}
	</script>
</body>
</html>
