<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta name="keywords" content="Biosciences, Chemical, Chimerisam">
<title>Davos Login</title>
<!-- Bootstrap styles-->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Application styles-->
<link rel="stylesheet" href="css/app.css">
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
</head>
<body>
	<div class="block-center mt-xl wd-xl">
		<!-- START panel-->
		<div class="panel  panel-flat">
			<div class="panel-heading text-center"
				style="background-color: #ccc5be73 !important;">
<!-- 				<a href="#"> <img class="block-center img-rounded" -->
<!-- 					src="images/ui/anthem-logo.png" alt="Image" -->
<!-- 					style="width: 103px !important;" /> -->
<!-- 				</a> -->
				Login
			</div>
			<div class="panel-body">
				<form class="form-validate mb-lg" role="form" action="login"
					method="post">
					<div class="form-group has-feedback">
						<input class="form-control" id="username" type="text"
							name="username" placeholder="Username" autocomplete="off"
							required />
					</div>
					<div class="form-group has-feedback">
						<input class="form-control" id="exampleInputPassword1"
							type="password" name="password" id="password"
							placeholder="Password" required />
					</div> 
					<button class="btn btn-block btn-primary mt-lg" type="submit">Login</button>
				</form>
				<c:choose>
					<c:when test="${null != error}">
						<div class="alert alert-danger text-center anthem-error">${error}</div>
					</c:when>
					<c:when test="${null != logout}">
						<div class="alert alert-danger text-center anthem-error">${logout}</div>
					</c:when>
				</c:choose>

			</div>
		</div>
		<!-- END panel-->
		<div class="p-lg text-center">
			<span>&copy;</span> <span>2021</span> <span>-</span> <span>Davos Chemical Corporation</span> <br /> <span></span>
		</div>
	</div> 
</body>
</html>