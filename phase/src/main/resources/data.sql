insert into public.address (id, city, street, zip, user_id)
values  (1, 'asd', 'qwe', 'asd', null),
        (2, 'asd', 'qwe', 'asd', null),
        (3, 'asd', 'qwe', 'asd', null),
        (4, 'asd', 'qwe', 'asd', null),
        (5, 'asd', 'qwe', 'asd', null);
insert into public.category (id, name)
values  (6, 'qwe'),
        (7, 'qwe'),
        (8, 'qwe'),
        (9, 'qwe'),
        (10, 'qwe'),
        (11, 'qwe');
insert into public.product (id, name, price, rating, category_id)
values  (12, 'qwe', 22, 11, null),
        (13, 'qwe', 22, 11, null),
        (14, 'qwe', 22, 11, null),
        (15, 'qwe', 22, 11, null),
        (16, 'qwe', 22, 11, null);
insert into public.review (id, comment, user_id)
values  (17, 'asdasdsad', null),
        (18, 'asdasdsad', null),
        (19, 'asdasdsad', null),
        (20, 'asdasdsad', null);
insert into public.user_table (id, email, firstname, lastname, password, address_id)
values  (21, 'asdasd@asdasd.com', 'asdasd', 'qweqwe', 'P2asdasd', null),
        (22, 'asdasd@asdasd.com', 'asdasd', 'qweqwe', 'P2asdasd', null),
        (23, 'asdasd@asdasd.com', 'asdasd', 'qweqwe', 'P2asdasd', null),
        (24, 'asdasd@asdasd.com', 'asdasd', 'qweqwe', 'P2asdasd', null),
        (25, 'asdasd@asdasd.com', 'asdasd', 'qweqwe', 'P2asdasd', null);