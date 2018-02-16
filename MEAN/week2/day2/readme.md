# Week 2 - Day 2
<img src="https://coursework.vschool.io/content/images/2015/11/mongoosejs.png" alt="Mongoose JS Logo" width="400px">

# Advanced Mongoose
* Finish all of Basic and Intermediate Mongoose first
* Login and Reg (optional, we're doing it in Angular.)

## Learning Objectives:
* Login and Reg
* Advanced Mongoose techniques

## Optional Lecture:
* Reiterate the steps needed for login and registration in any application. Relate them to what we know about MEAN so far.

## Lecture Questions:
<details>

​	<summary>When a user tries to log in, what are the steps taken??</summary>

 	1. We hit a POST route. Ex: "/users/login"
 	2. Run our controller method for this route. Ex: UserController.login()
 	3. Validate their inputs and find out if they exist in our database.
 	4. If they exist in our database, compare the DB password hash with the POST data password.
 	5. If these inputs match, store the user's id in session. Ex: req.session.id = user._id;
 	6. Redirect them to a dashboard.

</details>
<details>

​	<summary>When a user tries to register, what are the steps taken?</summary>

1. We hit a POST route. Ex: "/users/register"
2. Run our controller method for this route. Ex: UserController.register()
3. Validate their inputs and find out if they already exist in our database. If so, deny creation.
4. If they don't exist, save the user and save the newly generated id in session.
5. Redirect them to a dashboard.

</details>
<details>

​	<summary>When saving a new user to the database, what do we need to do before the save?</summary>

​	Hash the user's password to prevent anyone from seeing it.

</details>
