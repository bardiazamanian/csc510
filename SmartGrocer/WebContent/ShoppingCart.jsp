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
           showShoppingCart();
        });

        function showShoppingCart()
        {
            var mainDiv = $("#mainDiv");
         	mainDiv.empty();
         	//Dynamically constructing the Shopping Cart table
         	var $subdiv = $("<div class='bs-example' data-example-id='hoverable-table'>").appendTo(mainDiv);
         	var $table = $("<table id='tbl_shoppinglist' class='table table-hover'>").appendTo($subdiv);
         	var $theader = $("<tr>").appendTo($table);
         	$("<th>").appendTo($theader);
         	$("<th>").text("Item").appendTo($theader);
         	$("<th>").text("Quantity").appendTo($theader);
         	$("<th>").text("Price").appendTo($theader);
         	
         	var $tbody = $("<tbody>").appendTo($table);
         	

       		
         	$.get("GetShoppingCart", function(responseJson) {
         		$.each(responseJson, function(index, shoppingcart) { 
         			var $tr = $("<tr>").appendTo($tbody);
         			var $th = $("<th scope='row'>").appendTo($tr);
         			$("<td class='name'>").append(shoppingcart.item).appendTo($tr);
         			$("<td class='qty'>").append(shoppingcart.itemCount).appendTo($tr);
         			$("<td class='price'>").append(shoppingcart.itemPrice*shoppingcart.itemCount).appendTo($tr);
         	  	});
         		var $tr_extra_1 = $("<tr>").appendTo($tbody)
           		$("<td>").appendTo($tr_extra_1);
           		$("<td>").appendTo($tr_extra_1);
           		$("<td>").appendTo($tr_extra_1);
           		$("<th>").append("Total Price").appendTo($tr_extra_1);
           		var $tr_extra_2 = $("<tr>").appendTo($tbody)
           		$("<td>").appendTo($tr_extra_2);
           		$("<td>").appendTo($tr_extra_2);
           		$("<td>").appendTo($tr_extra_2);
           		$("<td id='total_price_caption'>").append().appendTo($tr_extra_2);
           		$.get("GetTotalPrice", function(jsonTotalPrice){
           			$("#total_price_caption").text(jsonTotalPrice);
           		});
         	});
         	//$.get("GetTotalPrice", function(jsonTotalPrice){$("#total_price_caption").text = jsonTotalPrice});
        }
       $(document).on("click", "#purchase_button", function()
       {
        	$.post("PurchaseItems", function(Status){showShoppingCart();}) 
       });   
            
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
      <!-- Jumbotron--> 	
      <div class="jumbotron">
      	<h2>Shopping Cart</h2>
      </div>
      
	  <a id="home_button" class="btn btn-success" href="home.jsp">Home</a>
	  
	  <p></p>
	  
      <!-- Example row of columns -->
      <div id="mainDiv" class="row">
      </div>
	  <a id="purchase_button" class="btn btn-primary">Purchase</a>
        
      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; CSC510</p>
      </footer>

    </div> <!-- /container -->

  </body>
</html>