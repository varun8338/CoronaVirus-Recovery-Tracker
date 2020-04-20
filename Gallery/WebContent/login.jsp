<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<link rel="stylesheet" href="assets/css/style.css">
<title>Login</title>
</head>
<body>
	<h2 style="text-align: center;">Welcome to my Gallery</h2>

	<div class="wrapper">
		<button
			onclick="document.getElementById('id01').style.display='block'"
			style="width: auto; text-align: center;">Login</button>
		<button
			onclick="document.getElementById('id02').style.display='block'"
			style="width: auto; text-align: center;">Sign Up</button>
	</div>
	
	
	<!-- logic for login window -->
	<div id="id01" class="modal">

		<form class="modal-content animate" action="UserController?action=login"
			method="post">

			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close">&times;</span>
			</div>

			<div class="container">
				<label for="uname"><b>Username</b></label> <input type="text"
					placeholder="Enter Username" name="uname" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required>

				<button type="submit">Login</button>
				<label> <input type="checkbox" checked="checked"
					name="remember"> Remember me
				</label>
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id01').style.display='none'"
					class="cancelbtn">Cancel</button>
				<span class="psw">Forgot <a href="#">password?</a></span>
			</div>
		</form>
	</div>


<!-- logic for sign up window -->

	<div id="id02" class="modal">

		<form class="modal-content animate" action="UserController?action=signUp"
			method="post">

			<div class="imgcontainer">
				<span onclick="document.getElementById('id02').style.display='none'"
					class="close" title="Close">&times;</span>
			</div>

			<div class="container">
				<label for="uname"><b>Username</b></label> <input type="text"
					placeholder="Enter Username" name="uname" required> <label
					for="psw"><b>Password</b></label> <input type="password"
					placeholder="Enter Password" name="psw" required> <label
					for="fname"><b>First Name</b></label> <input type="text"
					placeholder="Enter First Name" name="fname" required> <label
					for="lname"><b>Last Name</b></label> <input type="text"
					placeholder="Enter Last Name" name="lname" required>
					
					<label
					for="dob"><b>Date of birth</b></label> <input type="text"
					placeholder="DD-MM-YYYY" name="dob" required>

				<button type="submit">Submit</button>
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button"
					onclick="document.getElementById('id02').style.display='none'"
					class="cancelbtn">Cancel</button>
			</div>
		</form>
	</div>





	<script type="assets/js/modal.js"></script>
</body>
</html>