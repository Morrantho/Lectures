class Model{
	constructor(component,key,data){
		this.component=component;
		this.key=key;
		data.bind = this.bind;
		this.component.state[key] = data; // Init in component's state.

		console.log(this);
	}

	bind(attr,event){
		console.log(this.component);

		this.component.state[this.key][this.attr] = event.target.value;
		let model = this.component.state[this.key];

		this.component.setState(model);
	}
}

module.exports = Model;