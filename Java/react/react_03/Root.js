class Root extends React.Component{
	render(){
		return (
			<div className="root">
				<h1>Root Component!</h1>
				<Header/>
				<Body/>
				<Footer/>
			</div>
		);
	}
}

ReactDOM.render(<Root/>,document.getElementById("App"));