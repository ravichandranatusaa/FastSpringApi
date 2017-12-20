<!DOCTYPE html>
<!-- saved from url=(0060)https://getbootstrap.com/docs/4.0/examples/narrow-jumbotron/ -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="https://getbootstrap.com/favicon.ico">

<title>Fast Spring Evaluation</title>

<!-- Bootstrap core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../css/narrow-jumbotron.css" rel="stylesheet">

<script src="../js/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript">
	$().ready(
			function() {
				$.ajax({
					type : "GET",
					url : "/storeapi/store",
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					success : function(stores) {
						$.each(stores,
								function(index, item) {
									$("#store").get(0).options[$("#store").get(
											0).options.length] = new Option(
											item.displayname, item.id);
								});
					},
					error : function() {
						alert("Failed to load stores");
					}
				});
			});
</script>
</head>

<body>

	<c:if test="${message} != null">
		<div class="msg">${message}</div>
	</c:if>

	<form action="/login" method="post">
		<div class="container">

			<div class="jumbotron">
				<h4 class="display-3">Welcome to Fast Spring API</h4>
				<br />

				<div class="form-group">
					<label for="userid">User Id</label> <input type="text"
						class="form-control" id="userid" name="userid"
						placeholder="Enter User ID" />
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="Password">
				</div>

				<div class="form-group">
					<label for="store">Select Store</label> <select
						class="form-control" id="store" name="store">
					</select>
				</div>

				<p>
					<input type="submit" value="Create Store Session"
						class="btn btn-lg btn-success" role="button" />
				</p>
			</div>

			<footer class="footer">
				<p>© Company 2017</p>
			</footer>

		</div>
		<!-- /container -->
	</form>

</body>
</html>