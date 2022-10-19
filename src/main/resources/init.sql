INSERT INTO cargo_delivery.roles (role_name) VALUES ('customer');
INSERT INTO cargo_delivery.roles (role_name) VALUES ('manager');
INSERT INTO cargo_delivery.roles (role_name) VALUES ('admin');

INSERT INTO cargo_delivery.directions (direction, price) VALUES ('Kyiv', 50);
INSERT INTO cargo_delivery.directions (direction, price) VALUES ('Kharkiv', 35);
INSERT INTO cargo_delivery.directions (direction, price) VALUES ('Poltava', 35);
INSERT INTO cargo_delivery.directions (direction, price) VALUES ('Lviv', 80);
INSERT INTO cargo_delivery.directions (direction, price) VALUES ('Odesa', 75);
INSERT INTO cargo_delivery.directions (direction, price) VALUES ('Donets`k', 25);
INSERT INTO cargo_delivery.directions (direction, price) VALUES ('Ivano-Frankivs`k', 70);

INSERT INTO cargo_delivery.cargo_types (type, price) VALUES ('letter', 10);
INSERT INTO cargo_delivery.cargo_types (type, price) VALUES ('s_package', 20);
INSERT INTO cargo_delivery.cargo_types (type, price) VALUES ('m_package', 30);
INSERT INTO cargo_delivery.cargo_types (type, price) VALUES ('l_package', 40);
INSERT INTO cargo_delivery.cargo_types (type, price) VALUES ('xl_package', 60);