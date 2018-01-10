$(document).ready(function(){
	// When our form is submitted, run this:
	$("#findPokemon").submit( function(){
		// Get the user's input:
		var number = parseInt( $("#userInput").val() );
		// Store our url, adding the user's input to the end.
		var pokeURL = "https://pokeapi.co/api/v2/pokemon/"+number;

		// Finally, make our get request.
		$.get(pokeURL,function( data ){
			// Store the specific pokemon's image.
			var img = data.sprites.front_default;
			// Set our H1's text to the pokemon's name.
			$("#name").text( "Name: "+ data.name );
			// Set our img tag's src to the pokemon's name.
			$("#pokemon").attr( "src", img );
			// Set our second H1's text to the pokemon's weight.
			$("#weight").text( "Weight:" + data.weight );
		});
		// Don't submit our form to any location, just execute the above code.
		return false;
	} )
})