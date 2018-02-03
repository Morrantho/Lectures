class Body extends React.Component{
	constructor(props){
		super(props);
	}

	render(){
		return (
			<div className="body">
				<h1>{this.props.stuff}</h1>
			</div>
		);
	}
}