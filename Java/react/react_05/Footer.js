class Footer extends React.Component{
	constructor(props){
		super(props);
	}

	render(){
		return (
			<div className="footer">
				<h1>{this.props.stuff}</h1>
			</div>
		);
	}
}