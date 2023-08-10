create database BaiTapOOP;
use BaiTapOOP;

create table Authors(
author_id int primary key not null,
author_name varchar(50),
birth_date date,
nationality varchar(50)
);

create table Genres(
genre_id int primary key not null,
genre_name varchar(50)
);

create table Books(
book_id int primary key not null,
title varchar(50),
publication_year int,
author_id int not null,
genre_id int not null,
foreign key (author_id) references Authors(author_id),
foreign key (genre_id) references Genres(genre_id)
);

insert into Authors(author_id,author_name, birth_date, nationality)
values
(1,'Can Tuan Anh',1996,'Viet Nam'),
(2,'Xuan Dieu',1916,'Viet Nam'),
(3,'To Huu',1920,'Viet Nam'),
(4,'Nguyen Minh Chau',1930,'Viet Nam'),
(5,'Vu Trong Phung',1912,'Viet Nam');

insert into Genres(genre_id, genre_name)
values
(1,'Truyen ngan'),
(2,'Tho'),
(3,'Tieu su'),
(4,'Truyen cam hung'),
(5,'Khoa hoc vien tuong');

insert into Books(book_id , title, publication_year, author_id, genre_id )
values
(1,'Nham nhi :)))',2005,1,1),
(2,'12',2006,2,2),
(3,'53',2011,3,3),
(4,'8',2009,4,4),
(5,'76',2000,5,5);

select book_id , title ,publication_year,author_name,genre_name
from Books b
join Authors a on b.author_id = a.author_id
join Genres g on b.genre_id = g.genre_id;

-- Hiển thị số lượng sách theo thể loại có ít nhất 2 cuốn
select genre_name, count(Books.genre_id) number_genre
from Books
join Genres on Genres.genre_id=Books.genre_id
group by genre_name
having number_genre >= 2;

select author_name, count(Books.author_id)number_author -- count dùng để đếm
from Books
join Authors on Authors.author_id = Books.author_id
group by author_name -- nhóm dữ liệu theo hàng
having number_author >=2; -- Điều kiện  

select book_id,title, publication_year, author_name ,genre_name
from Books b
join Authors a on a.author_id = b.author_id
join Genres g on g.genre_id = b.genre_id
where author_name = 'Can Tuan Anh'
and genre_name = 'Dung Coi Nhau La Anh Em';

