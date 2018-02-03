class Header extends React.Component{
	constructor(props){
		super(props);
	}

	render(){
		return (
			<div className="header">
				<h1>{this.props.stuff}</h1>
			</div>
		);
	}
}