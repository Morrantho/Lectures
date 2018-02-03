class Root extends React.Component{
	render(){
		return (
			<div className="root">
				<h1>Root Component!</h1>
				<Body/>
			</div>
		);
	}
}

ReactDOM.render(<Root/>,document.getElementById("App"));