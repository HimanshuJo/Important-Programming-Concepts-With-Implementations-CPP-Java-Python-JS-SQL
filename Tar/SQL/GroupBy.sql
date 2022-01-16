-- Group by syntax:

	select column_name(s) from table_name were condition 
	group by column_name(s) order by column_name(s)

-------

-- E.g 1:

	select count(CustomerID), Country from Customers group by Country;

-------

-- E.g 2:

	select count(CustomerID), Country from Customers group by Country order by Count(CustomerID) DESC;

-------

-- Group by with Join

	-- E.g 1:

		select Shippers.ShipperName, Count(Orders.OrderID) As NumberOfOrders from Orders
		left Join Shippers On Orders.ShipperId=Shippers.ShipperID group by ShipperName; 