class Root extends React.Component{
	constructor(props){
		super(props);
	}

	render(){
		return (
			<div className="root">
				<h1>Root</h1>
				<Header />
				<Body />
				<Footer />
			</div>
		);
	}
}

ReactDOM.render(<Root/>,document.getElementById("App"));