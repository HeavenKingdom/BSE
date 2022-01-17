# BSE-API
**This repos builds api for BSE**

## Instruction
If you want to use this repos to test BSE App, you need to do things below before u start this application:

*(You can change names below freely as long as u also change the names in Springboot application)*
### 1. Prepare MYSQL
* Intsall mysql and create a new database named **bse**  
* Change mysql account info in **appliaction.properties**
* Create a new table named **result**
* This Table has keys below:

**Result Table**

keyname | type | length | notNull | mainKey |
 --- | :---: | :---: | :---: | :---: |
id | int | | ✔ | ✔ |
ImgUrl | varchar | 255 | | |
SbmDate | datetime | | | |
JdgDate | datetime | | | |
JdgRes | varchar | | | |

### 2. Build SpringBoot environment
* Intsall **IDEA** IDE or **SpringToolSuite4**
* Clone or download this project
* Open it in your IDE and run demoApplication

**Some hints**
* Default port is **8081**, u can change this in **application.properties**
* Test upload images by **PostMan**

### 3. Create folder for picture storage
* Create a folder under the following path **D:\Files\uploadImgs** This folder is used to store ur uploaded pics
* (You can change picture storage path in your project)

## Introduction

### Basic Function

#### 1. Get all the record
* Method:**GET**
* Url: **localhost:8081/record/getAll**
* Decrip: Return all the records in the database. 

#### 2. Get Specific record
* Method:**POST**
* Url: **localhost:8081/record/getRecord**
* Decrip: User posts a record id to server, server returns a specific record 

#### 3. Add record
* Method:**POST**
* Url: **localhost:8081/record/addRecord**
* Decrip: User posts an image to the server, server stores this pic to the path **D:\Files\uploadImgs**, generate a new record and insert this record into database

**Tools Url**
* **Postman:** https://www.postman.com/
* **Idea:** https://www.jetbrains.com/idea/
* **SpringToolSuite4:** https://spring.io/tools
* **Mysql:** https://www.mysql.com/





