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

-------

-- E.g 3:

	-- Display list of all Members and how many departments they are allocated to

		select Members.MemberName, Members.MemberID, count(MembersDepartments.DepartmentID) as [Cnt]
		from Members left join MembersDepartments
		on Members.MemberID=MembersDepartments.MemberID
		group by Members.MemberID, Members.MemberName

-------

-- E.g 4:

	-- Display list of all Platform names and how many members they each host. 
	-- If a platform host the same member in two different divs, 
	-- the count of the student should be incremented

		-- Only selecting the platforms which are hosting
		select PlatformID, count(Members.MemberID) as [Number]
		from Divisions inner join Members
		on Divisions.DivisionID=Members.DivisionID
		group by Divisions.PlatformID

		-- selecting all platforms
		select PlatformName, isnull(MembersSize.Number, 0)
		from Platforms left join
		(select PlatformID, count(Members.MemberID) as [Number]
		from Divisions inner join Members
		on Divisions.DivisionID=Members.DivisionID
		group by Divisions.PlatformID) MembersSize
		on Platforms.PlatformID=MembersSize.PlatformID
		order by MemberSize.Number desc