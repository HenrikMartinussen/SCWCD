/*
experiment fetching xml with java
*/
use sandbox
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

insert into Book (BookId, Category, Title, Language, Author, Year, Price) 
select 1, 'COOKING', 'Everyday Italian', 'en', 'Giada De Laurentiis', 2005, 30.00 union all
select 2, 'CHILDREN', 'Harry Potter', 'en', 'J. K. Rowling', 2005, 29.99 union all
select 3, 'WEB', 'Learning XML', 'en', 'Erik T. Ray', 2003, 39.95

select 
b.Category as "@category",
b.Title as title,
b.Author as author,
b.Year as year,
b.Price as price

from Book b 
for xml path ('book'), root ('bookstore');


USE [sandbox]
GO
/****** Object:  StoredProcedure [dbo].[Bookstore_asXml]    Script Date: 04/02/2013 23:05:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Henrik
-- Create date: 
-- Description:	
-- exec Bookstore_asXml
-- =============================================
ALTER PROCEDURE [dbo].[Bookstore_asXml] 
	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;


select 
b.Category as "@category",
b.Title as title,
b.Author as author,
b.[Year] as year,
b.Price as price
from Book b 
for xml path ('book'), root ('bookstore');

end