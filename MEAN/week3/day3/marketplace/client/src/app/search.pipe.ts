import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
	name: 'search'
})

export class SearchPipe implements PipeTransform {
	transform(listings,text){
		let newListings = [];

		for(let i=0;i < listings.length;i++){
			if(listings[i].title.toLowerCase().indexOf(text.toLowerCase()) != -1){
				newListings.push(listings[i]);
			}else if(listings[i].location.toLowerCase().indexOf(text.toLowerCase()) != -1){
				newListings.push(listings[i]);
			}
		}

		return newListings;
	}
}
