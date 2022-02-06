/*
The DENSE_RANK() is a window function that assigns a rank to each row within a partition of a result set. 

Unlike the RANK() function, the DENSE_RANK() function returns consecutive rank values. 

Rows in each partition receive the same ranks if they have the same values.

The syntax of the DENSE_RANK() function is as follows:

	DENSE_RANK() OVER (
	    [PARTITION BY partition_expression, ... ]
	    ORDER BY sort_expression [ASC | DESC], ...
	)

The DENSE_RANK() function is applied to the rows of each partition defined by the PARTITION BY clause, 
in a specified order, defined by ORDER BY clause. It resets the rank when the partition boundary is crossed.

The PARITION BY clause is optional. If you omit it, the function will treat the whole result 
set as a single partition.
*/

CREATE TABLE sales.dense_rank_demo (
	v VARCHAR(10)
);
	
INSERT INTO sales.dense_rank_demo(v)
VALUES('A'),('B'),('B'),('C'),('C'),('D'),('E');
	
SELECT * FROM sales.dense_rank_demo;

/*
The following statement uses both DENSE_RANK() and RANK() functions to assign a rank to each row of the result set:
*/

SELECT
	v,
	DENSE_RANK() OVER (ORDER BY v) my_dense_rank,
	RANK() OVER (ORDER BY v) my_rank
FROM
	sales.dense_rank_demo;

/*
Output:

v 		my_dense_rank 		my_rank
A 		1 					1
B 		2 					2
B 		2 					2
C 		3 					4
C 		3 					4
D 		4 					6
E 		5 					7
*/

/* -------*******------- */

/*
The following example uses the DENSE_RANK() function to rank products by list prices:
*/

SELECT
	product_id,
	product_name,
	list_price,
	DENSE_RANK () OVER (ORDER BY list_price DESC) price_rank 
FROM
	production.products;

/*
Sample Output:

product_id 		product_name 		list_price 		price_rank
155				Prod1				11999.99		1
149				Prod2				7499.99 		2
156				Prod3 				6499.99 		3
157				Prod4 				6499.99 		3
*/

/* -------*******------- */

/*
Using SQL Server DENSE_RANK() over partitions example

	The following statement ranks -> 'products in each category by list prices'. 

	It returns only the top 3 products per category by list prices.
*/

SELECT * FROM (
	SELECT
		product_id,
		product_name,
		category_id,
		list_price,
		DENSE_RANK () OVER (PARTITION BY category_id ORDER BY list_price DESC) price_rank 
	FROM
		production.products
) t
WHERE price_rank < 3;

/*
Sample Output:

product_id 		product_name 		category_id 		list_price 		price_rank
155				Prod1				1					11999.99		1
149				Prod2				1					7499.99 		2
156				Prod3 				1					6499.99 		3
157				Prod4 				1					6499.99 		3
158				Prod5 				2					16499.99 		1
*/
