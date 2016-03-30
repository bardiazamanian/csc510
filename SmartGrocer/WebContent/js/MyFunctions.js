function saveShoppingList(){
	//var items = new Array();
	var items = "";
	var oTBL = document.getElementById('SLTable');
    	for (var x = 0; x < oTBL.rows.length; x++) {
    		//var temp = new Object();
    		//temp.item = oTBL.rows[x].cells[0].firstChild.data;
    		//temp.count = oTBL.rows[x].cells[1].firstChild.data;
    		//temp.price = oTBL.rows[x].cells[2].firstChild.data;
    		//items[x] = temp;
    		items += oTBL.rows[x].cells[0].firstChild.data;
    		items += ",";
    		items += oTBL.rows[x].cells[1].firstChild.data;
    		items += ",";
    		items += oTBL.rows[x].cells[2].firstChild.data;
    		items += ",";
    	}
    
    $.ajax({
    	url: "saveShoppingList",
    	type: 'POST',
    	dataType: 'json',
    	data: items,
    	cotentType: 'application/json',
    	mimeType: 'application/json',
    	
    	success: function(){
    		//alert("Success");
    	},
    	error:function(data,status,er) {
            //alert("error: "+data+" status: "+status+" er:"+er);
        }
    	
    });
}