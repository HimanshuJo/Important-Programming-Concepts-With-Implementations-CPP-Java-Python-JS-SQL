/*
	Retrieve all the duplicate entries in the resultant table of a left join
	in a one to many relationship table
*/

select (person.FirstName+' '+
case when person.MiddleName is null then '' else person.MiddleName end+' '+person.LastName) as 'Name'
from person.person
where person.person.BusinessEntityID in 

(SELECT person.businessentityaddress.businessentityid
FROM person.person
left JOIN person.BusinessEntityAddress
ON person.person.businessentityid = person.businessentityaddress.businessentityid
GROUP BY person.businessentityaddress.businessentityid
HAVING Count(person.businessentityaddress.businessentityid) > 1)

-------

/*
Multi table left join

Here are the customers and sales tables.

Customers

	id	first_name		last_name		gender		age		customer_since
	1	Daniel			Black				M				34		2014-10-13
	2	Erik				Brown				M				25		2015-06-10
	3	Diana				Trump				F				39		2015-10-25
	4	Anna				Yao				F				19		2017-02-20
	5	Christian		Sanders			M				42		2018-01-31

Sales

	id	date			book_id			customer_id			quantity			amount
	1	2019-09-02		2				3					1					14.99
	2	2019-10-01		1				2					1					12.99
	3	2019-10-01		3				4					1					15.75
*/

SELECT c.id, c.first_name, c.last_name, c.gender, c.age, c.customer_since,   
       s.date AS sales_date, sum(s.amount) AS total_spent
FROM customers c
LEFT JOIN sales s
ON c.id = s.customer_id
GROUP BY c.id;

/*
id	first_name		last_name		gender		age		customer_since		sales_date		total_spent
1	Daniel			Black				M				34			2014-10-13			[NULL]			[NULL]
2	Erik				Brown				M				25			2015-06-10			2019-10-01		12.99
3	Diana				Trump				F				39			2015-10-25			2019-09-02		14.99
4	Anna				Yao				F				19			2017-02-20			2019-10-01		15.75
5	Christian		Sanders			M				42			2018-01-31			[NULL]			[NULL]
*/

/*
We want to analyze how our recent promotional campaign has impacted the behavior of our customers.

Promotions

	id	campaign			customer_id		date
	1	SMS_discount10	2					2019-09-01
	2	SMS_discount10	3					2019-09-01
	3	SMS_discount10	5					2019-09-01

To do this, we need to combine the data about customers, sales, and promotions
*/

SELECT c.id, c.first_name, c.last_name, c.gender, c.age, c.customer_since,
   s.date AS sale, p.date AS promotion
FROM customers c
LEFT JOIN sales s
ON c.id = s.customer_id
LEFT JOIN promotions p
ON c.id = p.customer_id;

/*
id	first_name	last_name	gender	age	customer_since	sale			promotion
1	Daniel		Black			M			34		2014-10-13		[NULL]		[NULL]
2	Erik			Brown			M			25		2015-06-10		2019-10-01	2019-09-01
3	Diana			Trump			F			39		2015-10-25		2019-09-02	2019-09-01
4	Anna			Yao			F			19		2017-02-20		2019-10-01	[NULL]
5	Christian	Sanders		M			42		2018-01-31		[NULL]		2019-09-01
*/

/*
Note that in this example, we used a common field from the first table to join both 
the second and the third tables. 

However, this is not always the case. 

Let’s look at a case in which a common field from the second table is used to 
left-join with the third but not with the first.
*/

/*
We want to explore what book genres most interest our customers. 

This information is very valuable, as it helps us provide a more personalized 
experience to our customers with specific book recommendations. 

For this analysis, we will need the data from customers, sales, and books. 
We have already joined the first two in our first example; to this, we will add the books table.

Books

id	name							author				genre		quantity		price
1	The Lord of the Rings	J. R. R. Tolkien	fantasy		7			12.99
2	Lolita						Vladimir Nabokov	novel			4			14.99
4	The Hobbit					J. R. R. Tolkien	fantasy		10			10.75
5	Death on the Nile			Agatha Christie	detective	8			9.75
*/

SELECT c.id, c.first_name, c.last_name, s.date AS sale,
 b.name AS book, b.genre
FROM customers c
LEFT JOIN sales s
ON c.id = s.customer_id
LEFT JOIN books b
ON s.book_id = b.id;

/*
id	first_name	last_name	sale				book							genre
1	Daniel		Black			[NULL]			[NULL]						[NULL]
2	Erik			Brown			2019-10-01		The Lord of the Rings	fantasy
3	Diana			Trump			2019-09-02		Lolita						novel
4	Anna			Yao			2019-10-01		[NULL]						[NULL]
5	Christian	Sanders		[NULL]			[NULL]						[NULL]

We have two customers (1 and 5) who have not purchased anything and thus have no 
corresponding records in the sales table
*/

-------

/*
	In contrast to the INNER JOIN, the order of the tables plays an important role in the LEFT JOIN, 
	and the results may be completely different if the order changes in your SQL query. 

	When determining the order of tables in a LEFT JOIN, the general rule is to start with the 
	table from which you want to keep all the records in the final result.

	Also, keep in mind that a LEFT JOIN cascades to all joins in a query. 
	If you use a LEFT JOIN, often the subsequent tables should also be left-joined. 
	An INNER JOIN will drop records not found on both sides of the join, and you might lose 
	all the records you want to keep-- the reason for using a LEFT JOIN instead of the 
	usual INNER JOIN in the first place.
*/