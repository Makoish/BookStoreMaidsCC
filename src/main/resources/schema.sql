create table if not exists patron (
  id bigint primary key AUTO_INCREMENT,
  first_Name varchar(255),
    last_Name varchar(255),
    phone_NO varchar(255),
    email varchar(255)

    );


create table if not exists book(
    id bigint primary key auto_increment,
    title varchar(255),
    author varchar(255),
    publication_year varchar(255),
    ISBN varchar(255) UNIQUE

    );



create table if not exists Borrowing_Record(
   id bigint primary key auto_increment,
   patron_id bigint,
   book_id bigint,
   borrow_date date,
   return_date date,
   FOREIGN KEY (patron_id) REFERENCES patron(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (book_id) REFERENCES book(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    UNIQUE (book_id, patron_id)
);