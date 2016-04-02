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
           retrieveShippingList();
        });
        
        function retrieveShippingList()
        {
        	 var jumbotron = $(".jumbotron");
             var mainDiv = $("#mainDiv");
             jumbotron.empty();
         	   mainDiv.empty();
         		$("#statusBar").empty();
  	       $("#menu_bought").removeClass("active");
  	       $("#menu_toBuy").addClass("active");
         	
         	//Dynamically constructing the Shopping List table
         	var $subdiv = $("<div class='bs-example' data-example-id='hoverable-table'>").appendTo(mainDiv);
         	var $table = $("<table id='tbl_shoppinglist' class='table table-hover'>").appendTo($subdiv);
         	var $theader = $("<tr>").appendTo($table);
         	$("<th>").appendTo($theader);
         	$("<th>").text("Item").appendTo($theader);
         	$("<th>").text("Price").appendTo($theader);
         	$("<th>").text("Quantity").appendTo($theader);
         	
         	var $tbody = $("<tbody>").appendTo($table);
         	$.get("GetGroceries", function(responseJson) {
         		 
         		 $.each(responseJson, function(index, shoppinglist) { 
         			var $tr = $("<tr>").appendTo($tbody);
         			var $th = $("<th scope='row'>").appendTo($tr);
         			$("<input type='checkbox' name='chkbox' >").val(shoppinglist.item).appendTo($th);
         			$("<td class='name'>").append(shoppinglist.item).appendTo($tr);
         			$("<td class='price'>").append(shoppinglist.itemPrice).appendTo($tr);
         			$("<td class='qty'>").append(shoppinglist.itemCount).appendTo($tr);
         		 
         	 });
         		 
        		 $("<p class='lead'>").text('These are the items on your shopping list').appendTo($(jumbotron))
              $("<button type='button' id='saveShoppingListButton' class='btn btn-primary'>Save Shopping List</button>").appendTo($(mainDiv));
         		 
         	 });
        }
        
       $(document).on("click", "#menu_btn_itemsBoughtLastWeek", function() {        // When HTML DOM "click" event is invoked on element with ID "menu_btn_itemsBoughtLastWeek", execute the following function...
           $.get("getPurchasedItems", function(responseJson) {          // Execute Ajax GET request on URL of "getPurchasedItems" and execute the following function with Ajax response JSON...
          	  	
           	var jumbotron = $(".jumbotron");
               var mainDiv = $("#mainDiv");
               jumbotron.empty();
           	mainDiv.empty();
           	$("#statusBar").empty();
           	$("#menu_toBuy").removeClass("active");
           	$("#menu_bought").addClass("active");
           	var $ul = $("<ul>").appendTo($(mainDiv)); // Create HTML <table> element and append it to HTML DOM element with ID "mainDiv".
          		
               $.each(responseJson, function(index, item) {    // Iterate over the JSON array.
                
               	var $li = $("<li class='list-group-item'>").appendTo($ul);
               	var $input = $("<input type='checkbox' name='chkbox' >").val(item.name).appendTo($li);
               	$li.append(item.name);
               });
               $("<p class='lead'>").text('These are the items bought in the last week. You may select any of the items to add to your shopping list').appendTo($(jumbotron))
              	$("<button type='button' id='addToShoppingListButton' class='btn btn-primary'>Add to Shopping List</button>").appendTo($(mainDiv));
           });
       });
            
            
       $(document).on("click", "#menu_btn_toBuyListButton", function()
       {
    	 	retrieveShippingList();
       });
            
        $(document).on("click", "#saveShoppingListButton", function() {
        	var jsonItemsInTable = [];
        	//var tableValues = [];
        	
        	$('#tbl_shoppinglist tbody tr').each(function() {
					
					item = {};
					
					var itemName = $(this).find(".name").html();
					var itemPrice = $(this).find(".price").html();
					var itemQty = $(this).find(".qty").html()
					if(itemName || itemPrice || itemQty)
					{	
						item["item"] = itemName; //Key/Pair value object that stores values of selected items.
						item["itemPrice"] = itemPrice;
						item["itemCount"] = itemQty;
						
	        			jsonItemsInTable.push(item);
					}
        	});
        	
	       	var json= JSON.stringify(jsonItemsInTable);
	       	var params = {
	       	tableValues: json ,
        		};
        	$.post("GetGroceries", $.param(params), function(response) {})
            	.done(function() {
            		$("#statusBar").addClass('bg-success').css('text-align','right').text("Succesfully saved shopping list");
            	})
            	.fail(function() {
            		$("#statusBar").addClass('bg-error').css('text-align','right').text("Eror occured while saving shopping list");
            
        	}); 	
		});
        
        $(document).on("click", "#addToShoppingListButton", function() {
        	var jsonCheckedItems = [];
        	var checkedVal = [];
        	
        	$('input[name="chkbox"]:checked').each(function() {

			item = {};
			item["name"] = $(this).val();
        		
        			jsonCheckedItems.push(item);
        	});
        	
        	var json= JSON.stringify(jsonCheckedItems);
        	var params = {
        		    checkedVal: json ,
        		};
        	$.post("getPurchasedItems", $.param(params), function(response) {   	}) 
        	.done(function() {
        		$("#statusBar").addClass('bg-success').css('text-align','right').text("Succesfully added items to shopping list");
        	})
        	.fail(function() {
        		$("#statusBar").addClass('bg-error').css('text-align','right').text("Eror occured while adding items to shopping list");
        	});
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
      <div class="masthead">
        <h3 class="text-muted">SmartGrocer</h3>
        <nav>
          <ul class="nav nav-justified">
            <li id="menu_toBuy"><a id="menu_btn_toBuyListButton" href="#">To Buy List</a></li>
            <li id="menu_bought"><a id="menu_btn_itemsBoughtLastWeek" href="#">Bought Last Week</a></li>
          </ul>
        </nav>
      </div>

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