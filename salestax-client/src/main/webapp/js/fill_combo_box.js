var productsData, totalPrice = 0, totalSales = 0;
var fill_combo_box = (function() {
    initialize = function() {
		$.ajax({
		    type: 'GET',
		    url: "/salestaxrest/products",
		    contentType: "application/json",
		    dataType: "json",
		    success:  function(data) {  
		    	productsData = data;
		    	var options = $("#products");
		    	options.append($("<option />").val("0").text("Select a product"));
		    	$.each(data, function(info) {
		    	    options.append($("<option />").val(this.productId).text(this.description));
		    	});
	    	}
	    });
    };

    return {
    	initialize : initialize
    };
})();

$(function(){
	fill_combo_box.initialize();
});