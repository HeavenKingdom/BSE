# BSE-API
**This repos builds api for BSE**

If you want to use this repos to test BSE App, you need to do things below before u start this application:

*(You can change names below freely as long as u alse change the names in Springboot application)*
* Intsall mysql and create a new database named **bse**  
* Change mysql account info in **appliaction.properties**
* Create a new table named **result**
* This Table has keys below:

keyname | type | length | notNull | mainKey |
 --- | :---: | :---: | :---: | :---: |
id | int | | ✔ | ✔ |
ImgUrl | varchar | 255 | | |
SbmDate | datetime | | | |
JdgDate | datetime | | | |
JdgRes | varchar | | | |

* Create a folder has path like **D:\Files\uploadImgs** This folder is used to store ur uploaded pics

**Some hints**
* Default port is 8081,u can change this in **application.properties**
* Test by open ur browser and input **localhost:8081/record/getAlll**
* Test upload images by **PostMan**


