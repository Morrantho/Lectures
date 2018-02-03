// Shoves a model onto a components state.
// Bind callback looks up an attribute on that model and setState's the original component.
function Binder(component,key,data){
	data.bind = function(attr,e){
		component.state[key][attr] = e.target.value;

		component.setState({
			key:component.state[key]
		});

		console.log(component.state[key]);
	}

	component.state[key] = data;
}

module.exports = Binder;