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