-- Join two tables by multiple columns

-- E.g:

	CREATE TABLE MyNewTab(CaseNum int, FileNum int, ActivityNum int, Grade int, Score varchar(100))

	INSERT INTO MyNewTab Values(CaseNum, FileNum, ActivityNum, Grade, Score)

	SELECT E.CaseNum, E.FileNum, E.ActivityNum, E.Grade, V.Score from Evaluation E
	INNER JOIN Value V
	ON E.CaseNum = V.CaseNum AND E.FileNum = V.FileNum AND E.ActivityNum = V.ActivityNum

-------

/*
	A USER may select many products, add them to their CART; 
	a single USER may have multiple CARTS and at the end of the event, 
	they can EMAIL the cart to themselves; the ACTIONS of the user are stored in the actions table

	+---------------------+     +---------------------+     +---------------------+
	| users               |     | carts               |     | actions             |
	+---------------------+     +---------------------+     +---------------------+
	| user_id       [PK]  |--|  | cart_id       [PK]  |     | impression_id [PK]  |
	| email               |  |--| user_id       [FK]  |     | action_name         |
	|                     |     | product_id    [FK]  |  |--| session_id    [FK]* |
	+---------------------+     | session_id    [FK]* |--|  |                     |
	                            |                     |     +---------------------+
	                            +---------------------+    

	Data:

	+------------------------+
	| users                  |
	+------------------------+
	| id   | email           |
	+------+-----------------+
	| 1    | first@mail.org  |
	| 2    | second@mail.org |
	| 3    | third@mail.org  |
	+------+-----------------+

	+------------------------------------------+
	| carts                                    |
	+------------------------------------------+
	| id   | user_id | product_id | session_id |
	+------+---------+------------+------------+
	| 1    | 1       | 5          | 1aaaa      |
	| 2    | 2       | 5          | 2ffff      |
	| 3    | 3       | 8          | 3ddddd     |
	| 4    | 1       | 5          | 1aaaaa     |
	| 5    | 3       | 9          | 3bbbbb     |
	| 6    | 1       | 6          | 1ccccc     |
	+------+---------+------------+------------+

	+-------------------------------+
	| actions                       |
	+-------------------------------+
	| id   | name      | session_id |
	+------+-----------+------------+
	|  1   | ADD       | 1aaaa      |
	|  2   | ADD       | 2ffff      |
	|  3   | SENDMAIL  | 3ddddd     |
	|  4   | ADD       | 3ddddd     |
	|  5   | SENDMAIL  | 2ffff      |
	|  6   | ADD       | 1aaaaa     |
	|  7   | REMOVE    | 3ddddd     |
	|  8   | ADD       | 1ccccc     |
	|  9   | ADD       | 3bbbbb     |
	| 10   | SENDMAIL  | 3bbbbb     |
	+------+-----------+------------+

*/

SELECT u.user_id, c.session_id, c.cart_id, a.impression_id, a.action_name, u.email
FROM users AS u
INNER JOIN carts AS c ON c.user_id = u.user_id
INNER JOIN actions AS a ON a.session_id = c.session_id
ORDER BY u.user_id, c.session_id, c.cart_id