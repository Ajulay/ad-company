CREATE TABLE company
(
  id serial,
  name varchar(30) NOT NULL,
  description varchar(200) NOT NULL,
  addres varchar(100) NOT NULL,
  PRIMARY KEY(id)
  );

CREATE TABLE category
(
  id serial,
  name varchar(30),
  PRIMARY KEY(id)

);

CREATE TABLE ad
(
  id serial,
  name text,
  content text,
  phone varchar(15),
  company_id int NOT NULL,
  category_id int NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(company_id) REFERENCES  company(id),
  FOREIGN KEY(category_id) REFERENCES category(id)
);
