select count(*)from person.BusinessEntityAddress;

select count(*)from person.person;

select count(*) from person.person
left outer join person.BusinessEntityAddress on
person.person.BusinessEntityID=person.BusinessEntityAddress.BusinessEntityID
group by person.person.BusinessEntityID