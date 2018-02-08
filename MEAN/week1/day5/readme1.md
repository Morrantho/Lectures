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

This command will create a new database if it doesn't exist, otherwise it will return the existing database.
</details>

<details><summary>What's the Mongo parallel to a SQL row/record?</summary>

	Document (JSON object)
</details>

<details><summary>How would I get all the addresses in California out of a collection of addresses?</summary>
</details>


### Basic CRUD:
#### CREATE - Inserting a document into a collection

	db.COLLECTION_NAME.insert({YOUR_JSON_DOCUMENT})

**Example:** db.users.insert({name: "Rob", email: "rob@gmail.com"})

	
#### READ - Retrieving documents from a collection
	db.COLLECTION_NAME.find({YOUR_QUERY_DOCUMENT})

**Example:** db.users.find({name: "Rob"})

	
#### DESTROY - Removing documents from a collection
	db.COLLECTION_NAME.remove({YOUR_QUERY_DOCUMENT}, BOOLEAN)

**Example:** db.users.remove({email: "rob@gmail.com"})

#### UPDATE - Updating documents in a collection
	db.COLLECTION_NAME.update({QUERY}, {FIELDS_TO_UPDATE}, {OPTIONS})  
	// Note: the {OPTIONS} document is optional

This will completely overwrite everything except the _id field.
 
**Challenge:** How would we update a document and retain the existing information?




