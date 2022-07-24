-- Users
INSERT INTO my_user (id, email, first_name, last_name, password)
VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO my_user (id, email, first_name, last_name, password)
VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO my_user (id, email, first_name, last_name, password)
VALUES (3, 'muhyidean@miu.edu', 'muhyidean', 'al-tarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO my_user (id, email, first_name, last_name, password)
VALUES (4, 'levi@miu.edu', 'keith', 'levi', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO my_user (id, email, first_name, last_name, password)
VALUES (5, 'okalu@miu.edu', 'obinna', 'kalu', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO my_user (id, email, first_name, last_name, password)
VALUES (6, 'tina@miu.edu', 'tina', 'xing', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

-- Category
INSERT INTO category (id, name)
VALUES (1, 'CatA');
INSERT INTO category (id, name)
VALUES (2, 'CatB');

-- Products
INSERT INTO product (id, name, price,rating, category_id)
VALUES (1, 'iPhone', 1200.45,5, 1);

INSERT INTO product (id, name, price, rating, category_id)
VALUES (2, 'iPad', 900.56, 3, 2);

INSERT INTO product (id, name, price,rating, category_id)
VALUES (3, 'Pen', 5.0,4, 1);

-- Review
INSERT INTO review (id,comment,user_id)
VALUES (1,'awesome phone',1);

INSERT INTO review (id,comment,user_id)
VALUES (2,'amazing phone',2);

INSERT INTO review (id,comment,user_id)
VALUES (3,'awesome tablet',3);
