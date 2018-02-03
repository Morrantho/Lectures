class Root extends React.Component{
	constructor(props){
		super(props);

		this.title = "HELLO!";

		this.state={
			title:"Root",
			header:"HERES SOME TEXT",
			body:"Body",
			footer:"Footer",
		};
	}

	render(){
		return (
			<div className="root">

				<h1>{this.title} Component!</h1>

				<Header stuff={this.state.header} />
			</div>
		);
	}
}

ReactDOM.render(<Root/>,document.getElementById("App"));