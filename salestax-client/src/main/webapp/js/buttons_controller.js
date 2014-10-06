var buttons_controller = (function() {
	initialize = function() {
    	$('#addProduct').click(function() { 	
    		 var indexProduct = $('#products option:selected').val() - 1;
    		 if (indexProduct > -1){
	    		 var price = productsData[indexProduct].price;
	    		 var tax = (productsData[indexProduct].type.tax.value + productsData[indexProduct].importTax.value) * price / 100;
	    		 tax = nearest(tax, 0.05);
	    		 totalSales += tax;
	    		 totalPrice += price + tax;
	    		 $('#totalPrice').html(totalPrice.toFixed(2));
	    		 $('#totalSales').html(totalSales.toFixed(2));
	    		 writeProductInfo(indexProduct, price, tax);
    		 }
	   	});
    	
    	$('#clear').click(function(){
    		totalSales = 0;
    		totalPrice = 0;
    		$('#totalPrice').html(totalPrice);
   		 	$('#totalSales').html(totalSales);
   		 $('#basketProducts').html("");
    	});
    };
    
    nearest = function(value, nearest){
    	value = value / nearest;
    	value = Math.round(value) * nearest;
	    return value;
    };
    
    writeProductInfo = function(indexProduct, price, tax){
    	 var buyedProducts = $("span[id='" + indexProduct + "']");
		 if (buyedProducts.length > 0){
			 buyedProducts.text(Number(buyedProducts.text()) + 1);
		 } else {
			 $('#basketProducts').append("<li><span id='" + indexProduct + "'>1</span> " + productsData[indexProduct].description + "(s): " + (price + tax).toFixed(2));
		 }
    };

    return {
    	initialize : initialize
    };
})();

$(function(){
	buttons_controller.initialize();
});