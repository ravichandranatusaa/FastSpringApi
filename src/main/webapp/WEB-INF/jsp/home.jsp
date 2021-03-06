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
  	com.fastspring.excercise.FastSpringAPI.domain.StoreSession storeSession = (com.fastspring.excercise.FastSpringAPI.domain.StoreSession) request.getAttribute("storesession"); 
 	if(storeSession!=null) {
	%>
	Store Session Id is : <%=storeSession.getId() %> 
	<% 		
	}
	%>
  
  
	<div class="container">
	<br/>
	<form action="/order" method="POST">
    	<input type="hidden" name="storesessionid" id="storesessionid" value="<%=storeSession.getId()%>"/>
          	<input type="submit" class="btn btn-lg btn-success" value="Create Order" role="button"/><br/>
	</form>
	
	
      <footer class="footer">
        <p>� Company 2017</p>
      </footer>

    </div> <!-- /container -->

</body></html>