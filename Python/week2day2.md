# Week 2 Day 2

## MySQL

<img src="https://www.mysql.com/common/logos/logo-mysql-170x115.png" alt="MySQL Icon" width="200px">

* SQL Statements
* SELECT
* INSERT
* UPDATE
* DELETE
* Joins

### MySQL:
SQL stands for Structured Query Language. It was created specifically for database use. We can use to to perform many tasks such as inserting or creating new data, finding a particular piece of data, deleting or removing data, altering or changing data and joining one or more pieces of data together to name a few. With MySQL in our case as Web Developers, we can do things like store a user when they register on our site, allowing them to login to then display a list of all the products our store carries.

### What is a database and how do we use it?
A database lets us persist (save) data in a secure location on our (MySQL, MongoDB, PostGres, MariaDB) server for later retrieval. We can store as little or large amounts of data that we want. Much more than the measily total of 10MB of data that session supports. We use our database by running MySQL queries through the command line, MySQL Workbench or via some other module. To use our database from our webserver, we first need a way to interact with it through a connector module, supplying our hostname (IP), username, password, port and database we intend to use once connected. 

### SQL Statements
A SQL Statement is written to perform a specific task.
We can create, read, update and delete data with them.  
We use specific keywords to let SQL know what the task is we aim to perform.

### SELECT

We can use SELECT to retrieve data from a particular table in our database. We can also supply SELECT with a WHERE clause, telling MySQL that we expect it to match a field with what we are looking for.


```mysql
SELECT first_name FROM users 
WHERE last_name = "Smith"; 
```

This query will look through all last names in our users table, searching for "Smith". If MySQL finds "Smith", it will give us back ALL the first names of users who have the last name "Smith".

### INSERT

We can use INSERT to insert new data into a particular table. We need to supply the table name with the column names we intend to fill in, as well as the VALUES keyword, containing the the data we want to store.


```mysql
INSERT INTO users(first_name,last_name)
VALUES("John","Smith"); 
```

This query will create a new user in our users table, filling in the first_name and last_name columns with "John" and "Smith". 

### UPDATE

We can use UPDATE to change data in a particular table. We need to supply update with the table we intend to change data, followed by SET. SET needs to be supplied with the column names we wish to change. Now we can use WHERE to specify columns we wish to change. 


```mysql
UPDATE users 
SET first_name="Joe",last_name="Schmoe" 
WHERE first_name = "John" AND last_name = "Smith";
```

This query will look in our users table for the first and last names "John" and "Smith". If it finds columns, it will set the first_name and last_name attributes of those columns to "John" and "Smith". 

#### What happens if we forget to supply a WHERE clause when we UPDATE?
We will end up overwriting all columns in that table with the new data we've supplied. 

### DELETE

We can use DELETE to delete data in a particular table. We first need to specify the table to delete data from, followed by a WHERE clause to specify the columns we wish to delete.

```mysql
DELETE FROM user 
WHERE first_name="Joe" AND last_name="Schmoe";
```

### What happens if we dont supply DELETE with a WHERE clause?
We'll delete all of the columns in our table!!

### JOIN

Consider that we've created another table called addresses that contains a users city,state and steet as well as a user_id. Also, we've added an address_id to our original user's table. How would we be able to find a particular user's address based off of just an id / number? Enter Joins.

Joins allow us to merge two or more tables together, to obtain more data. Typically, we tell the primary keys in one table to match the foreign key id's in another table. In turn this "joins" these two tables together, allowing us to retrieve data we need from both or all of those tables.


```mysql
SELECT * FROM users
JOIN addresses ON addresses.id=users.address_id;
```

This query will match users address ids from our users table and user ids from our addresses table. If it finds a match, we will receive each user's address information (city, state, street) as well as their user information (first_name,last_name). 