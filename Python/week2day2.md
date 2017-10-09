# Week 2 Day 1

## MySQL

<img src="https://cdn.iconverticons.com/files/png/7fbe544b039fd4f3_256x256.png" alt="MySQL Workbench Icon" width="200px">

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

### DELETE

### JOIN

