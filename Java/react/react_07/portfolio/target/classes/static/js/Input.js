const React = require('react');

class Input extends React.Component{
	constructor(props){
		super(props);

		this.parent = props.parent;
		this.model  = props.parent.state[props.model];
		this.name   = props.name;

		// parent - parent component
		// model  - model name that should exist in parent components state. 
	}

	render(){
		return (
			<input type="text" value={ this.parent.state[ this.props.model ][this.name] } name={this.props.name} onChange={(e)=>{ this.model.bind( this.props.name , e); }}  />
		);
	}
}