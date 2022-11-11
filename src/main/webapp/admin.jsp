<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>

<head>
<link rel="stylesheet" href="css/styleLogin.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
  rel="stylesheet">
   <link rel="shortcut icon" href="https://cdn-icons-png.flaticon.com/512/154/154345.png" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
  href="path/to/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
<title>Sign in admin</title>
<style>
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
  background:
    url("https://www.ubackground.com/_ph/11/9448545.jpg")
    no-repeat center;
  background-size: cover;
  z-index: -1;
    transform: translateX(-55%);
}

.contact-box {
  max-width: 850px;
  height: 450px;
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  justify-content: center;
  align-items: center;
  text-align: center;
  background-color: #fff;
  border-style: outset;
  border-radius: 2%;
}

.left {
  background:
    url("http://i.imgur.com/unZKGz6.jpg")
    no-repeat center;
  background-size: cover;
  height: 100%;
  box-shadow: 0px 0px 19px 5px rgba(0, 0, 0, 500);
  border-style: inset;
  border-radius: 30%;
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
  transform: translateX(1%);
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

.box-mini1
{
  margin-top: 0px;
}
.box-mini2
{
  margin: 200hv;
  transform: translateY(100%);
}
a
{
text-decoration: none;
}
a:hover
{
  color: red;
}
</style>
</head>

<body>
  <div class="container">
    <div class="contact-box">
      <div class="left"></div>
      <div class="right">
        <h2>Login Admin</h2>
        <form action="homeAdmin" method="post"> 
        <input class="field" type="text" name="username" placeholder="Username" required >
         <input class="field" type="password" name="password" placeholder="Password" required >
          <button class="btn" style="border-style: inset;" type="submit">Login</button>
        </form>

      </div>
    </div>
  </div>
</body>

</html>