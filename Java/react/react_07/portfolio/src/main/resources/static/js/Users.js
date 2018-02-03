const React = require('react');
const ReactDOM = require('react-dom');
const ReactRouterDOM = require("react-router-dom");
const Axios = require("axios");

const Binder = require("./Binder.js");
const BoundInput = require("./BoundInput.js");

class Users extends React.Component{
	constructor(props){
		super(props);

		this.state={
			"users":[],
		};

		Binder(this,"user",{
			"email":"",
			"firstName":""
		});
	}

	create(e){
		e.preventDefault();

		Axios.post("/users/new",this.state.user)
		.then((user)=>{
			user = user["data"];

			user = (
				<tr key={user.id+1000}>
					<td>{user.email}</td>
					<td>{user.firstName}</td>
				</tr>				
			);

			this.state.users.push( user );
			this.setState({"users":this.state.users});

			this.setState({
				"user":{
					"email":"",
					"firstName":""
				}
			});
		})
		.catch(err=>console.log(err));
	}

	init(){
		Axios.get("/users")
		.then((data)=>{
			let users = data["data"];

			for(let i=0;i<users.length;i++){
				users[i] = (
					<tr key={users[i].id}>
						<td>{users[i].email}</td>
						<td>{users[i].firstName}</td>
					</tr>
				);
			}

			this.setState({
				"users":users
			});
		})
		.catch(err=>console.log(err));
	}	

	render(){
		if(this.state.users){
			return (
				<div>
					<table>
						<thead>
							<tr>
								<th>Email:</th>
								<th>First Name:</th>
							</tr>
						</thead>

						<tbody>
							{this.state.users}
						</tbody>
					</table>
					
					<br/>
						<h1>Register:</h1>
					<br/>
					
					<form onSubmit={(e)=>{this.create(e);}}>
						<BoundInput parent={this} model={"user"} path={"email"} />
						<BoundInput parent={this} model={"user"} path={"firstName"} />
						
						<input type="submit" value="Register" />
					</form>
				</div>
			);
		}
	}

	componentDidMount(){this.init();}
}

module.exports = Users;
