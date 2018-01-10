function coinChange(c){
	var quarters = Math.floor(c / 25);
	c -= quarters*25;
	var dimes    = Math.floor(c / 10);
	c -= dimes*10;
	var nickels  = Math.floor(c / 5);
	c -= nickels*5;
	var pennies  = c / 1;
	c -= pennies;

	console.log(
		"Quarters: "+quarters,
		"Dimes: "+dimes,
		"Nickels:"+nickels,
		"Pennies: "+pennies
	);
}
coinChange(51);