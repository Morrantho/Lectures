const React = require('react');
const ReactDOM = require('react-dom');
const ReactRouterDOM = require("react-router-dom");

const app = document.getElementById("app");

const Router = ReactRouterDOM.HashRouter;
const Route  = ReactRouterDOM.Route;
const Link   = ReactRouterDOM.Link;

const Projects = require("./Projects.js");
const Users = require("./Users.js");

class App extends React.Component{
	constructor(props){
		super(props);
		this.state={};
	}

	render(){
		return (
			<Router>
				<div>
					<Route path="/projects" component={Projects} />
					<Route path="/users" component={Users} />

					<Link to="/projects" >My Projects</Link>
					<Link to="/users" >All Users</Link>
				</div>
			</Router>
		);
	}
}

ReactDOM.render(<App/>,app);