# Week 2 - Day 1 - Morning

## MongoDB

<img src="https://webassets.mongodb.com/_com_assets/cms/MongoDB-Logo-5c3a7405a85675366beb3a5ec4c032348c390b3f142f5e6dddf1d78e2df5cb5c.png" width="500" alt="">

### Learning Objectives:
* MongoDB basics
* Mongo shell
* CRUD through the Mongo shell

### Discussion:
* Mongo is NoSQL. NoSQL stands for 'NOT ONLY SQL'.
* Compare documents, collections, and DBs with rows, tables, and Schemas.
* No joins!
* But you can still make your own foreign key relationships manually. We will do this with Mongoose.
* Many-to-many relationships = hard. Not Mongo's strength.
* Not a primary database, SQL is still king of relational data.

### Discussion Questions:
<details><summary>How do I create a new DB?</summary>

	> use DATABASE_NAME

MongoDB "use DATABASE_NAME" is used to create a database. The command will create a new database if it doesn't exist, otherwise it will return the existing database.
</details>

<details><summary>What's the Mongo parallel to a SQL row/record?</summary>

	Document (JSON object)
</details>

<details><summary>If I had an x collection, how could I query just y? (Addresses, addresses in california)</summary>
</details>