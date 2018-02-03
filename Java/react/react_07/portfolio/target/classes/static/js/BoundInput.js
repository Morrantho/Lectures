// Takes a parent component, a model name to lookup in
// the parent component's state, and the path / attribute
// that is being set on that model via the <input />

const React = require('react');

class BoundInput extends React.Component{
	constructor(props){
		super(props);

		this.parent = props.parent;
		this.model  = props.parent.state[props.model];
		// this.name   = props.name;
		this.path   = props.path;
	}

	render(){
		return (
			<input type="text" value={ this.parent.state[ this.props.model ][this.path] } name={this.props.path} onChange={(e)=>{ this.model.bind( this.props.path , e); }}  />
		);
	}
}

module.exports = BoundInput;