select count(*)from person.address;
select count(*)from person.person;
select count(*)from person.BusinessEntityAddress;

-------*******-------

select count(*) from person.person
left join person.BusinessEntityAddress
on person.BusinessEntityID=person.BusinessEntityAddress.BusinessEntityID;

-------*******-------

select person.BusinessEntityAddress.BusinessEntityID from person.BusinessEntityAddress
right outer join person.person on
person.person.BusinessEntityID=person.BusinessEntityAddress.BusinessEntityID

-------*******-------

select person.BusinessEntityAddress.BusinessEntityID from person.BusinessEntityAddress
right outer join person.person on
person.person.BusinessEntityID=person.BusinessEntityAddress.BusinessEntityID GROUP BY 
person.BusinessEntityAddress.BusinessEntityID HAVING 
COUNT(person.BusinessEntityAddress.BusinessEntityID) > 1

-------*******-------

select abs((select count(*) from person.person) - (select count(*) from person.person
left join person.BusinessEntityAddress
on person.BusinessEntityID=person.BusinessEntityAddress.BusinessEntityID));

-------*******-------

select * from person.BusinessEntityAddress where person.BusinessEntityAddress.BusinessEntityID=332;

SELECT 
    person.BusinessEntityAddress.BusinessEntityID, 
    COUNT(person.BusinessEntityAddress.BusinessEntityID)
FROM 
    person.BusinessEntityAddress
GROUP BY 
    person.BusinessEntityAddress.BusinessEntityID
HAVING 
    COUNT(person.BusinessEntityAddress.BusinessEntityID) > 1

-------*******-------

select person.person.FirstName+', '+person.person.LastName from person.person where person.person.BusinessEntityID in
(select person.BusinessEntityAddress.BusinessEntityID from
person.BusinessEntityAddress
right outer join
person.person on
person.person.BusinessEntityID=person.BusinessEntityAddress.BusinessEntityID GROUP BY 
person.BusinessEntityAddress.BusinessEntityID HAVING 
COUNT(person.BusinessEntityAddress.BusinessEntityID) > 1)
