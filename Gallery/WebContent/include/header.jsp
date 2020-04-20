<!DOCTYPE html>
<%@page import="org.entity.Users"%>
<html>
<head>





<title>
	<%
	
	String title = (String)request.getSession().getAttribute("title");
	
	
		out.print(title);


	
	
	%>
	



</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/css/style.css">
<style>
body {margin:0;}

.navbar {
  overflow: hidden;
  background-color: #4CAF50;
  position: fixed;
  top: 0;
  width: 100%;
}

.navbar a {
  float: right;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.navbar a:hover {
  background: #ddd;
  color: black;
}

.main {
  padding: 16px;
  margin-top: 30px;
  height: 1500px; /* Used in this example to enable scrolling */
}
</style>
</head>
<body>

<div class="navbar">
  <a href="<%=request.getContextPath()%>/UserController?action=logout">Logout</a>
  <a href="<%=request.getContextPath()%>/UserController?action=edit">Edit</a>
  <a href="<%=request.getContextPath()%>/UserController?action=upload">Upload</a>
  <a href="<%=request.getContextPath()%>/UserController?action=home">Home</a>
</div>



