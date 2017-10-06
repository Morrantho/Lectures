# Week 1 Day 5

## Flask

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Flask_logo.svg/1200px-Flask_logo.svg.png" alt="Python" width="200px">

* Session
* Hidden Inputs
* Form Validation

<details>
<summary><strong>What is session? How is it different from any other variable?</strong>
</summary>
Session allows us to persist data or variables across HTTP requests. This allows us to access data we may have previously stored, or store that data for future use. A practical example of this is keeping track of a user's cart they may have added products into. If we didnt do this, each time they refreshed the page or navigated elsewhere, their cart items would vanish!
</details>

<details>
<summary><strong>What are hidden inputs? How can we use them to our advantage?</strong>
</summary>
Hidden inputs are hidden from the user whom is viewing that <code>.html</code> file. We can take advantage of that and store data such as that particular user's name or id as attributes that we can access on our server via a form submission! 
</details>