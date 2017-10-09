# Week 2 Day 1

## MySQL Workbench

<img src="https://cdn.iconverticons.com/files/png/7fbe544b039fd4f3_256x256.png" alt="MySQL Workbench Icon" width="200px">

* ERD Diagrams
* Entity Relationships
* MySQL Workbench
* DB Data Types

### What is a database and how do we use it?
A database lets us persist (save) data in a secure location on our (MySQL, MongoDB, PostGres, MariaDB) server for later retrieval. We can store as little or large amounts of data that we want. Much more than the measily total of 10MB of data that session supports. We use our database by running MySQL queries through the command line, MySQL Workbench or via some other module. To use our database from our webserver, we first need a way to interact with it through a connector module, supplying our hostname (IP), username, password, port and database we intend to use once connected. 

### Why don't we just use session?
A database lets us organize our data in a far more structured way than session. The amount of data that can be stored is only limited to the size of the harddrive that the MySQL server is running on. HTTP sessions have very limited storage, usually 10MB or so. We also cant store large chunks of data into session. What if we wanted to store the entire text of a Harry Potter book? Session would quickly run out of space, storing maybe a few hundred pages. However, MySQL would very happily store all of this without issues. MySQL is also much more secure than session. Altho some web frameworks hash session data, its still far less secure than a MySQL server.  

### What is MySQL Workbench?
MySQL Workbench is a GUI tool we can use to interact directly with our databases as opposed to using a command line interface. We can create, read, update and destroy data in our SQL tables, make ERD's for our database, turn those ERD's into SQL tables directly (Forward Engineer) and a plethora of other benefits.

### What is an ERD, and how does it benefit us?
Entity Relationship Diagrams allow us to map out or visualize how we intend to store our data in (MySQL tables) in a human readable manner. They let us visually plan out how our data relates to other data as well as what we want to store and how we store it. This benefits us by giving us an overview of how and what data will be stored, as well as reduce errors or issues we may have down the road (You will see).

### What are some real world examples of 1:1, 1:N, N:N relationships?
One To One:
* User & Address
* Employee & Organization
* Car Model & Company
* Book & Company

One To Many:
* Users & Posts
* Customer & Orders
* Authors & Books
* Bands & Albums

Many To Many:
* Products & Categories
* Students & Classes
* Employees & Meetings
* Users & Roles

### MySQL Data Types:

Numeric Data Types:

* VARCHAR(number of characters)
Variable number of Non-numeric characters up to 255 characters.
Uses only up the number of characters in space.

* CHAR(number of characters)
Stores non-numeric characters
Users up all space for the number of characters.

* INT
Used to store integers. 
Unsigned: 0 - 4294967295.
Signed: -2147483648 - 2147483647.

* BIGINT
BIGINT would be used for columns that would need to store huge numbers.
Unsigned: 0 - 18446744073709551615
Signed: -9223372036854775807 to 9223372036854775808

* TINYINT
TINYINT would be good to use for numbers that will be relatively small.
Unsigned: 0 - 255
Signed: -127 - 127

* FLOAT
Used to store floating point numbers (decimals)
such as the cost of an item.

* TEXT
Used to store a large amount of text, like a description, message, or comment. Use this for any text that VARCHAR() is too small to handle.

* DATETIME
used to store a date and time in the format YYYY-MM-DD hh:mm:ss

