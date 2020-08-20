create table product(
  product_id int not null, -- 제품 번호
  name varchar(50) not null, -- 제품 이름
  type varchar(50) not null, -- 제품 종류
  price int not null,
  amount int not null,  
  PRIMARY KEY (product_id)
);


INSERT INTO product (product_id, name, type, price, amount) VALUES (4000,  "LG전자 디오스", "냉장고", 1821590,4);
INSERT INTO product (product_id, name, type, price, amount) VALUES (1000,  "삼성전자 시리즈 8", "TV", 549000,13);
INSERT INTO product (product_id, name, type, price, amount) VALUES (2000,  "LG전자 75UM", "TV", 1768420,5);
INSERT INTO product (product_id, name, type, price, amount) VALUES (5000,  "삼성전자 비스포크", "냉장고", 1704750,5);
INSERT INTO product (product_id, name, type, price, amount) VALUES (3000,   "삼성전자 시리즈 Q", "TV", 2649020,13);
commit;
select * from product;
select * from product where name like '%삼성%';




