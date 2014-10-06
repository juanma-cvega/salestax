<!DOCTYPE HTML><%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<html>
<head>
<title>Sales tax basket</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/fill_combo_box.js"></script>
<script type="text/javascript" src="js/buttons_controller.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/salestaxesclient.css">
</head>
<body>
	<div>
		<select id="products" ></select>
		<input type="button" id="addProduct" value="Add Product" class="btn btn-primary"/>
		<input type="button" id="clear" value="Clear" class="btn btn-primary"/>
	</div>
	<div>
		<ul id="basketProducts"></ul>
	</div>
	<div>
		<ul>
			<li ><span>Sales Taxes: </span><span id="totalSales">0</span></li>
			<li><span class="negrita">Total: </span><span id="totalPrice">0</span></li>
		</ul>
	</div>
</body>
</html>