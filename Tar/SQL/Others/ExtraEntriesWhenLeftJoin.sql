-- 1964
SELECT Count(*) FROM   person.address;

-- 1964
SELECT Count(*) FROM   person.businessentityaddress;

-- 19972
SELECT Count(*) FROM   person.person;

-------*******-------

SELECT person.person.businessentityid, (person.FirstName+' '+
case when person.MiddleName is null then '' else person.MiddleName end+' '+person.LastName) as 'Name'
FROM person.person
LEFT JOIN person.businessentityaddress
ON person.businessentityid = person.businessentityaddress.businessentityid
order by person.FirstName+' '+person.LastName asc

-------*******-------

SELECT Count(*) FROM person.person 
LEFT JOIN person.businessentityaddress
ON person.businessentityid = person.businessentityaddress.businessentityid;

-------*******-------

SELECT person.businessentityaddress.businessentityid
FROM   person.businessentityaddress
RIGHT OUTER JOIN person.person
ON person.person.businessentityid = person.businessentityaddress.businessentityid

-------*******-------

SELECT person.businessentityaddress.businessentityid
FROM   person.businessentityaddress
RIGHT OUTER JOIN person.person
ON person.person.businessentityid = person.businessentityaddress.businessentityid
GROUP  BY person.businessentityaddress.businessentityid
HAVING Count(person.businessentityaddress.businessentityid) > 1

-------*******-------

SELECT Abs((SELECT Count(*) FROM person.person) - 
(SELECT Count(*) FROM person.person
LEFT JOIN person.businessentityaddress
ON person.businessentityid = person.businessentityaddress.businessentityid));

-------*******-------

SELECT *
FROM   person.businessentityaddress
WHERE  person.businessentityaddress.businessentityid = 332;

SELECT person.businessentityaddress.businessentityid,
       Count(person.businessentityaddress.businessentityid)
FROM   person.businessentityaddress
GROUP  BY person.businessentityaddress.businessentityid
HAVING Count(person.businessentityaddress.businessentityid) > 1

-------*******-------

SELECT person.person.firstname + ', '+ person.person.lastname
FROM   person.person
WHERE  person.person.businessentityid IN 
(SELECT person.businessentityaddress.businessentityid
FROM   person.businessentityaddress 
RIGHT OUTER JOIN person.person
ON person.person.businessentityid = person.businessentityaddress.businessentityid
GROUP  BY person.businessentityaddress.businessentityid
HAVING Count(person.businessentityaddress.businessentityid) > 1) 