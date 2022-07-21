INSERT INTO public.category (id, name) VALUES (1, 'Food');
INSERT INTO public.category (id, name) VALUES (2, 'Electronic');

INSERT INTO public.product (id, name, price,rating, category_id) VALUES (1, 'Coffe', 9.99, 6.8 ,1);
INSERT INTO public.product (id, name, price,rating ,category_id) VALUES (2, 'Tea', 2.5, 5.2 ,1);
INSERT INTO public.product (id, name, price,rating ,category_id) VALUES (3, 'TV', 100, 8.9 ,2);
INSERT INTO public.product (id, name, price,rating ,category_id) VALUES (4, 'PC', 325.00,9.2 ,2);


INSERT INTO public.address (id, street, city, zip) VALUES (1, '123 FF St', 'California', '12345');
INSERT INTO public.address (id, street, city, zip) VALUES (2, '222 JH St', 'Orlando',    '44444');


INSERT INTO public.user_A (id, email, firstname, lastname, password, address_id) VALUES (1, 'admin@admin.com', 'admin', 'admin', 'password', 1);
INSERT INTO public.user_A (id, email, firstname, lastname, password, address_id) VALUES (2, 'user@user.com', 'user', 'user', 'password', 2);

INSERT INTO public.review (id, comment, user_id) VALUES (1, 'Good', 1);
INSERT INTO public.review (id, comment, user_id) VALUES (2, 'Very Good', 2);