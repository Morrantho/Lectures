function reverse(arr){
	let i=0;
	let j=arr.length-1;
	let tmp;

	while(i < j){
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;

		i++;
		j--;
	}

	return arr;
}
// console.log(reverse([5,10,15,20]));

function rotate(arr,rot){
	if(rot < 0){
		for(let i=rot;i > 0; i--){
			let last = arr[arr.length-1];

			for(let j=arr.length-1;j > 0; j--){
				arr[j] = arr[j-1];
			}

			arr[0] = last;
		}		
	}else{	
		for(let i=0;i < rot; i++){
			let first = arr[0];

			for(let j=0;j<arr.length;j++){
				arr[j] = arr[j+1];
			}

			arr[arr.length-1] = first;
		}
	}


	return arr;
}
console.log(rotate([5,10,15],-1));

// 0 [5,10,15]
// 1 [10,15,5]
// 2 [15,5,10]
// 3 [5,10,15]