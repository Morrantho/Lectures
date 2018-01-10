// 0, 1, 1, 2, 3, 5

function fib(n){
	var sum  = 1;
	var cur  = 0;
	var temp;

	for(var i=0;i<n-1;i++){
		temp = sum;
		sum  = sum + cur;
		cur  = temp;
	}

	console.log(sum);
}

fib(10);