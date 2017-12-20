<!DOCTYPE html>
<!-- saved from url=(0060)https://getbootstrap.com/docs/4.0/examples/narrow-jumbotron/ -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>Fast Spring Evaluation</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/narrow-jumbotron.css" rel="stylesheet">
  </head>

  <body>
  
  
  <% 
  	com.fastspring.excercise.FastSpringAPI.domain.Orders order = (com.fastspring.excercise.FastSpringAPI.domain.Orders) request.getAttribute("order"); 
 	if(order!=null) {
	%>
	Store Session Id is : <%=order.getStoresession().getId() %><br/>
	Order Id is : <%=order.getId() %><br/>
	<% 		
	}
	%>
  
  
	<div class="container">
	<br/>
      <footer class="footer">
        <p>© Company 2017</p>
      </footer>

    </div> <!-- /container -->

</body></html>