import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
	name: 'search'
})

export class SearchPipe implements PipeTransform {

	transform(items: any[], searchText: string){
		if(!items) return [];
		if(!searchText) return items;

		searchText = searchText.toLowerCase();

		return items.filter( it => {
			return it.title.toLowerCase().includes(searchText);
		});
	}
}
