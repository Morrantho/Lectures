class Root extends React.Component{
	constructor(props){
		super(props);

		this.state={
			title:"Mama",
			header:"Header",
			body:"Body",
			footer:"Footer"
		};
	}

	answer(){
		this.setState({
			"reply":"Goto bed, you have school tomorrow.",
		});

		window.setTimeout(()=>{
			this.setState({
				"sibling":"Yea, goto bed bro."
			});
		},2000);

		window.setTimeout(()=>{
			this.setState({
				"response":"Alright, geez."
			});
		},4000);

	}

	render(){
		return (
			<div className="root">
				<h1>{this.state.reply}</h1>

				<Header reply={this.state.sibling} />
				
				<Body callMama={()=>{this.answer();}} stuff={this.state.body} />
			</div>
		);
	}
}

ReactDOM.render(<Root/>,document.getElementById("App"));