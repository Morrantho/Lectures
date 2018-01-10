// jQuery - Cover: "this", .on(), .submit(), .parent(), .children(), .siblings(), .val()

$(document).ready(()=>{
	console.log("JQUERY ARE YOU THERE?");

	$("form").submit(function( abc ){

		let data = $(this).serialize();

		console.log(data);

		return false;
	});

	$("#nav").click(function(){

		// console.log("CLICKED NAV");


		$("form").submit();
	})
})