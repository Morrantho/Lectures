const React = require('react');
const ReactRouterDOM = require("react-router-dom");
const Router = ReactRouterDOM.HashRouter;
const Route  = ReactRouterDOM.Route;
const Link   = ReactRouterDOM.Link;

class Projects extends React.Component{
	constructor(props){
		super(props);
		this.state={};
	}

	render(){
		return (
			<div>
				Project Component loaded!
			</div>
		);
	}
}

module.exports = Projects;
