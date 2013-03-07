/*
experiment fetching xml with java
*/
use shark_2
go

drop table Book

create table Book (
	BookId int,
	Category varchar(80),
	Title varchar(80),
	[Language] varchar(40),
	Author varchar(255),
	[Year] int,
	Price decimal,
)

grant select on Book to jamesBond

insert into Book (BookId, Category, Title, Language, Author, Year, Price) 
select 1, 'COOKING', 'Everyday Italian', 'en', 'Giada De Laurentiis', 2005, 30.00 union all
select 1, 'CHILDREN', 'Harry Potter', 'en', 'J. K. Rowling', 2005, 29.99 union all
select 1, 'WEB', 'Learning XML', 'en', 'Erik T. Ray', 2003, 39.95

select 
b.Category as "@category",
b.Title as title,
b.Author as author,
b.Year as year,
b.Price as price

from Book b 
for xml path ('book'), root ('bookstore');
