
It's a console version of program for parsing *.xml files and save data from them to relational database.

First of all you should enter the path of folder to search.

Then you can choice to search all *.xml files inside this directory or not.

If there are not any files in this folder - program will propose you to create one random file.

After one work cycle you can type next folder path.

Program will stop if you will enter word 'end' in request of path.


Application properties:
username=nc_user
password=asdf
url=jdbc:oracle:thin:@localhost:1521:xe
driverClassName=oracle.jdbc.OracleDriver

After first launch go to "db/initialize_db.sql" and uncomment first six rows.
