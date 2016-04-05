<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script> 
        $( document ).ready(function() {
           var mainDiv = $("#mainDiv");
           mainDiv.empty();
           // retrieveShoppingCart();
           retrieveTotalPrice();
        });
        
        function retrieveTotalPrice()
        {
        	 var jumbotron = $(".jumbotron");
             var mainDiv = $("#mainDiv");
             jumbotron.empty();
         	   mainDiv.empty();
         		$("#statusBar").empty();
         	
         	//Dynamically constructing the Shopping List table
         	// var $subdiv = $("<div class='bs-example' data-example-id='hoverable-table'>").appendTo(mainDiv);
         	$.get("GetTotalPrice", function(jsonTotalPrice) {
         	$(jumbotron).append($("<p class='lead'>").text(jsonTotalPrice))
         	});
        }   
            
 </script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<link href="css/justified-nav.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SmartGrocer</title>
</head>
 <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <!-- Jumbotron -->
      <div class="jumbotron">
      </div>

      <!-- Example row of columns -->
      <div id="mainDiv" class="row">
      </div>

      <div id="statusBar" class="row">
      
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; CSC510</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>