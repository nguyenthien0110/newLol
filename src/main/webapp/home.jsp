
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
<title>The lol News</title>
<link rel="shortcut icon" href="https://images.fpt.shop/unsafe/filters:quality(90)/fptshop.com.vn/uploads/images/tin-tuc/146257/Originals/lol-la-gi-1.jpeg" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/cssSeach.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>

	<div class="container">
		<div class="logo-wrapper d-flex align-items-center">
			<h1>
				<a href="home?index=1"> The LOL News </a>
			</h1>
		</div>
	</div>
	<div>
		<form action="SeachControl" class="search-bar">
			<input type="search" name="search" pattern=".*\S.*" required>
			<button class="search-btn" type="submit">
				<span>Search</span>
			</button>
		</form>
	</div>
	<div class="container-fluid menu">
		<div class="container">
			<div class="d-flex menu-items">
				<div class="${onclick == true? 'active':''}">
					<a href="home?index=1">Home</a>
						</div>
						<div>
							<a href="#newtype">News type</a>
						</div>
						<div>
							<a href="#latest">Latest Updates</a>
						</div>
						<div>
							<a href="#trending">Trending</a>
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
								<a href="LogoutControl">Log out</a>
								</div>
								</c:if>
				</div>
			</div>
		</div>
	<div class="container main-news section">
		<div class="row">
			<div class="col-sm-12 col-md-6 col-xs-12 col-lg-6">
				<a href="DetailControl?id=${listTop1.id}"><img
					class="thumb mb-3" title="${listTop1.titleName}."
					src="${listTop1.imageLink}"></a>
				<h3>
					<a class="font-large" href="DetailControl?id=${listTop1.id}">
						${listTop1.titleName} </a>
				</h3>
			</div>
			<div class="col-sm-12 col-md-6 col-xs-12 col-lg-6">
				<div class="row">
					<div class="col-md-6 col-sm-12 col-xs-12 col-lg-6">
						<div class="image image-sm mb-1">
							<a href="DetailControl?id=${listTop2.id}"> <img class="thumb"
								title="${listTop2.titleName}." src="${listTop2.imageLink}">
							</a>
						</div>
						<h3 class="mb-4">
							<a href="DetailControl?id=${listTop2.id}">
								${listTop2.titleName} </a>
						</h3>

						<div class="image image-sm mb-1">
							<a href="DetailControl?id=${listTop3.id}"> <img class="thumb"
								title="${listTop3.titleName}." src="${listTop3.imageLink}">
							</a>
						</div>
						<h3 class="mb-4">
							<a href="DetailControl?id=${listTop3.id}">
								${listTop3.titleName} </a>
						</h3>

					</div>

					<div class="col-md-6 col-sm-12 col-xs-12 col-lg-6">
						<div class="image image-sm mb-1">
							<a href="DetailControl?id=${listTop4.id}"> <img class="thumb"
								title="${listTop4.titleName}." src="${listTop4.imageLink}"></a>
						</div>
						<h3 class="mb-4">
							<a href="DetailControl?id=${listTop4.id}">
								${listTop4.titleName} </a>
						</h3>

						<div class="image image-sm mb-3">
							<a href="DetailControl?id=${listTop5.id}"> <img
								class="thumb image-sm" title="${listTop5.titleName}."
								src="${listTop5.imageLink}">
							</a>
						</div>
						<h3>
							<a href="DetailControl?id=${listTop5.id}">
								${listTop5.titleName} </a>
						</h3>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container section mt-4">
		<div class="section-title">
			<span id = "newtype">News type</span>
		</div>

		<div class="row">

			<c:forEach items="${listTypeNews}" var="o">
				<div class="col-sm-12 col-xs-12 col-md-3 col-lg-3">
					<div class="mb-2 image image-xs">
						<img class="thumb" title="${o.typeNews}." src="${o.imagesType}">
					</div>
					<a href="categoryControl?type=${o.typeNews}">${o.typeNews} </a>
				</div>
			</c:forEach>
		</div>
	</div>


	<div class="container section">
		<div class="row">
			<div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
				<div class="mb-4 mt-4">
					<div class="section-title">
						<span id = "latest">Latest Updates</span>
					</div>

					<c:forEach items="${listTotal}" var="o">
						<div class="row mb-3 bb-1 pt-0">
							<div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
								<img class="thumb" title="${o.titleName}."
									src="<c:out value="${o.imageLink}"/>">
							</div>
							<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
								<h5>
									<a href="DetailControl?id=${o.id}"> ${o.titleName} </a>
								</h5>
								<small><c:out value="${o.dayNews}" /></small>
								<p class="summary pt-3">
									<c:out value="${o.conTent}" />
									...
								</p>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>

			<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
				<div class="trending mt-4">
					<div class="section-title">
						<span id ="trending">Trending</span>
					</div>

					<c:forEach items="${listTrendding}" var="o">
						<div class="row">
							<div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
								<img class="thumb" src="${o.imageLink}" title="${o.titleName}.">
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

	<div class="container xlarge">
		<div class="pagination">
			<ul>
				<a href="home?index=${down}"><</a>
				<c:forEach begin="1" end="${totalCount}" var="i">
					<a href="home?index=${i}" class=" ${index==i? 'active':''}">${i}</a><!-- https://stackoverflow.com/questions/4587397/how-to-use-if-else-option-in-jstl -->
				</c:forEach>
				<a href="home?index=${up}">></a>
			</ul>
		</div>
	</div>
<%@ include file="footer.html" %>
<script type="text/javascript">
			window.onscroll = function(){
				setSticky();
			}

			navbar = document.getElementsByClassName('menu')[0];
			var sticky = navbar.offsetTop;
			function setSticky(){
				if(window.pageYOffset >= sticky){
					navbar.classList.add('sticky');
				}else{
					navbar.classList.remove('sticky');
				}
			}
		</script>

</body>

</html>