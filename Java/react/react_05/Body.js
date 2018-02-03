class Body extends React.Component{
	constructor(props){
		super(props);
	}

	render(){
		return (
			<div className="body">
				<h1>{this.props.stuff}</h1>
				<h1>{this.props.reply}</h1>
				<button onClick={()=>{this.props.callMama();}} >Call mama</button>
			</div>
		);
	}
}