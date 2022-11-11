<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device=width, initial-scale=1.0">
<title>${oneNews.titleName}</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon" href="${oneNews.imageLink}" />
</head>

<body>

	<div class="container">
		<div class="logo-wrapper d-flex align-items-center">
			<h1>
				<a href="home?index=1"> The LOL News </a>
			</h1>
		</div>
	</div>
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
				<h1>${oneNews.titleName}</h1>
				<small>${oneNews.dayNews}</small> <img src="${oneNews.imageLink}"
					title="${oneNews.titleName}." class="mt-3 thumb">
				<div class="story mt-4">
					<p>${oneNews.conTent}</p>
				</div>
				<hr>
				<div class="container section mt-4 no-pad">
					<div class="section-title">
						<span>Recommended</span>
					</div>
					<div class="row">
						<c:forEach items="${listRan}" var="o">
							<div class="col-sm-12 col-xs-12 col-md-3 col-lg-3">
								<div class="mb-2 image image-xs">
									<img class="thumb" title="${o.titleName}." src="${o.imageLink}">
								</div>
								<a href="DetailControl?id=${o.id}"> ${o.titleName} </a>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="col-4">
				<div class="trending mt-4">
					<div class="section-title">
						<span>Trending</span>
					</div>
					<c:forEach items="${trenndList}" var="o">
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

