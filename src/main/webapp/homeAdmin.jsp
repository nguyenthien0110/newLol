<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="https://images.fpt.shop/unsafe/filters:quality(90)/fptshop.com.vn/uploads/images/tin-tuc/146257/Originals/lol-la-gi-1.jpeg" />
    <title>Home admin</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="manifest" href="/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!-- favicons -->
    <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/styleHomepage.css">
    <link rel="stylesheet" type="text/css" href="css/custom-responsive-style.css">
    <link href="//fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <script type="text/javascript" src="script/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="script/all-plugins.js"></script>
    <script type="text/javascript" src="script/plugin-active.js"></script>
</head>
<body data-spy="scroll" data-target=".main-navigation" data-offset="150">
    <section id="MainContainer">
        <!-- Header starts here -->
        <header id="Header">
            <nav class="main-navigation">
                <div class="container clearfix">
                    <div class="site-logo-wrap">
                        <a class="logo" href="#HeroBanner"><img src="https://tudienwiki.com/wp-content/uploads/2017/07/lien-minh-huyen-thoai.png" alt="Design Studio"></a>
                    </div>
                    <a href="javascript:void(0)" class="menu-trigger hidden-lg-up"><span>&nbsp;</span></a>
                    <div class="main-menu hidden-md-down">
                        <ul class="menu-list">
                            <li><a class="nav-link" href="javascript:void(0)" data-target="#HeroBanner">Home</a></li>
                            <li><a class="nav-link" href="javascript:void(0)" data-target="#Services">Management</a></li>
                            <c:if test="${sessionScope.account == null}">
						 <li><a href="logoutSessionAdmin" class="nav-link">login</a></li>
						</c:if>
						<c:if test="${sessionScope.account != null}">
						<li class="nav-link" style = "color: #fff">Hello, ${sessionScope.account.username}</li>
						<li><a href="logoutSessionAdmin" class="nav-link">Log out</a></li>
						</c:if>
                        </ul>
                    </div>
                </div>
                <div class="mobile-menu hidden-lg-up">
                    <ul class="mobile-menu-list">
                        <li><a class="nav-link" href="javascript:void(0)" data-target="#HeroBanner">Home</a></li>
                        <li><a class="nav-link" href="javascript:void(0)" data-target="#Services">Management</a></li>
                        <c:if test="${sessionScope.account == null}">
						 <li><a href="admin.html" class="nav-link">login</a></li>
						</c:if>
						<c:if test="${sessionScope.account != null}">
						<li class="nav-link" style = "color: #fff">Hello, ${sessionScope.account.username}</li>
						<li><a href="admin.html" class="nav-link">Log out</a></li>
						</c:if>
                    </ul>
                </div>
            </nav>
        </header>
        <!-- Header ends here -->
        <!-- Banner starts here -->
        <section id="HeroBanner">
            <div class="hero-content">
                <h1>welcome admin</h1>
                <p>This is where you can manage everything</p>
                <a href="CRUDcontrol?index=1" class="hero-cta">Get Started</a>
            </div>
        </section>
        <!-- Banner ends here -->
        <!-- Services section starts here -->
        <section id="Services">
            <div class="container">
                <div class="block-heading">
                    <h2>Management</h2>
                    <p>Everything is managed here, you can do anything with it.</p>
                </div>
                <div class="services-wrapper">
                    <div class="each-service">
                        <div class="service-icon"><a href="CRUDcontrol?index=1"><i class="	fa fa-file-text-o" aria-hidden="true"></i></a></div>
                        <h5 class="service-title">POST MANAGEMENT</h5>
                        <p class="service-description">This is where you can manage all posts</p>
                    </div>
                    <div class="each-service">
                        <div class="service-icon"><a href="CRUDaccount"><i class="fa fa-users" aria-hidden="true"></i></a></div>
                        <h5 class="service-title">USER MANAGEMENT</h5>
                        <p class="service-description">This is where you can manage all users</p>
                    </div>   
                    <div class="each-service">
                        <div class="service-icon"><a href="CRUDTypeNewsControl?index=1"><i class="	fa fa-align-left" aria-hidden="true"></i></a></div>
                        <h5 class="service-title">TYPE MANAGEMENT</h5>
                        <p class="service-description">This is where you can manage all type</p>
                    </div> 
                </div>
            </div>
        </section>
        </section>
        
</body>

</html>