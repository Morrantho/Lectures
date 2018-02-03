# Day 1

## React

<img src="https://eternitech.com/wp-content/uploads/2016/12/ReactJS.png" alt="Java Logo" width="200px">

### Intro To React

* What is a frontend framework?
* Advantages?
* What is a component? (Think of Lego Concept)
* Babel
* React and ReactDOM
* Basic Setup

### Front-end Frameworks

Front-end frameworks give us the advantage of leaving all the rendering up to our clients. This means our server won't require as many resources per request. Instead of requesting data from our database, rendering it onto a page and sending this back to the client (Templating), our server simply responds with JSON or some other data type per request. The client then takes this data and renders it onto an .html page via the client's browser. Front-end frameworks generally use a single .html page (Single Page Application), swapping in and out different components (Chunks of HTML + CSS + JavaScript), emulating the look of navigating to different pages.

### What is a component?

Front-end frameworks generally use component based design to display content to the end user. Think back to the lego concept in Web Fundamentals. You had different divs for different segments of your web page. Well, you might have a component for navigation, header, body and footer. Each of these are just parts of your web page that each contain their own specific HTML, CSS and Javascript. Each component you construct will have its own custom HTML tag that you will use to create it. This lets us repeat entire portions of our webpage by using a single tag. We can also pass data to components, fire events, submit data with forms and even route to different urls in our app.

### Dependencies:

### Babel

Babel is a JavaScript compiler that will let us use the latest technologies that JavaScript has to offer in our code. This includes ES6 syntax as well as features that we will need in order to use React. One React example is returning a pair of parenthesis in a function, indicating what we specify within them is HTML content, other components and the data we want sent to those components / elements. We'll also make use of ES6 classes, simply because they offer a much neater solution to creating our components (imo).


### React and ReactDOM

We're going to need these two dependencies to work with React. React itself will allow us to create components and a plethora of other features, ReactDOM is what will allow us to render these components onto a webpage by manipulating the DOM.


### Basic Setup

Until we implement a backend such as Java Spring, we will be using the CDN links for Babel, React and ReactDOM for simplicities sake. We're also going to use the development builds of React and ReactDOM for debugging purposes.

Put these 3 scripts in the <code><head></code> of an .html file and you'll be ready to start working with React!!!

Babel:

<code>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.26.0/babel.min.js"></script>
</code>

React:

<code>
	<script crossorigin src="https://unpkg.com/react@16/umd/react.development.js"></script>
</code>

ReactDOM:

<code>
	<script crossorigin src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>	
</code>