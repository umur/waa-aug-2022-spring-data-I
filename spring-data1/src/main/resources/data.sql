INSERT INTO addresses (id, street, zip, city)
    VALUES ('1', '1000 N 4th', '52557', 'Fairfield');

INSERT INTO users (id, email, password, firstName, lastName, address_Id)
    VALUES ('1', 'azizbek.makhkamov@miu.edu', '1111', 'Azizbek', 'Makhkamov', '1');

INSERT INTO categories (id, name) VALUES ('1', 'Electronics');
INSERT INTO categories (id, name) VALUES ('2', 'Clothes');

INSERT INTO products (id, name, price, rating, category_id)
    VALUES ('1', 'Monitor', '299.9', '3', '1');
INSERT INTO products (id, name, price, rating, category_id)
    VALUES ('2', 'Headphones', '99.9', '2', '1');
INSERT INTO products (id, name, price, rating, category_id)
    VALUES ('3', 'Laptop', '1299.9', '1', '1');

INSERT INTO products (id, name, price, rating, category_id)
    VALUES ('4', 'Jackets', '79.9', '1', '2');
INSERT INTO products (id, name, price, rating, category_id)
    VALUES ('5', 'Pants', '39.9', '2', '2');
INSERT INTO products (id, name, price, rating, category_id)
    VALUES ('6', 'Sneakers', '139.9', '1', '2');

INSERT INTO reviews (id, comment, user_id, product_id)
    VALUES ('1', 'Monitor looks fine', '1', '1');
INSERT INTO reviews (id, comment, user_id, product_id)
    VALUES ('2', 'I would love to buy these sneakers', '1', '6');
INSERT INTO reviews (id, comment, user_id, product_id)
    VALUES ('3', 'I do not like these jackets', '1', '4');




