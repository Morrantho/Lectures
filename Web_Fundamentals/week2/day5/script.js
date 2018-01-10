$(document).ready(function(){
	var key = "&appid=fd2854e2434db9369d8c58d62002ef7e";
	var url = "http://api.openweathermap.org/data/2.5/weather?q=";

	$("#weatherForm").submit(function(){
		var query = $("#city").val();
		var fullURL = url + query + key;

		$.get(fullURL,function( data ){
			$("#cityName").text(data.name);

			var k = data.main.temp;
			var f = Math.floor((9/5)*(k-273)+32);
			var c = k-273;

			$("#temp").text( f + " degees F" );
		})

		return false;
	})

})