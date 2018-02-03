class Register extends React.Component{
	constructor(props){
		super(props);
		
		this.state={
			firstName:""
		};
	}

	submit(event){
		event.preventDefault();

		
	}

	setFirstName(event){		
		this.setState({
			firstName:event.target.value
		});
	}

	render(){
		return (
			<form onSubmit={(e)=>{this.submit(e);}}>
				<input
					onChange={(e)=>{this.setFirstName(e);}}
					value={this.state.firstName}
					type="text"
				/>
								
				<input type="submit" />
			</form>
		);
	}
}