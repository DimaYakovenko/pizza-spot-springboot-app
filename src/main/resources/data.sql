delete
from PizzaOrder_Pizzas;
delete
from Pizza_Ingredients;
delete
from Pizza;
delete
from Pizza_Order;
delete
from Ingredient;

insert into Ingredient (id, name, type)
values ('THCK', 'Thick Dough', 'DOUGH');

insert into Ingredient (id, name, type)
values ('THN', 'Thin Dough', 'DOUGH');

insert into Ingredient (id, name, type)
values ('CHDDR', 'Cheddar', 'CHEESE');

insert into Ingredient (id, name, type)
values ('PRMZN', 'Parmezan', 'CHEESE');

insert into Ingredient (id, name, type)
values ('BBQ', 'BBQ', 'SAUCE');

insert into Ingredient (id, name, type)
values ('SLS', 'Spicy salsa', 'SAUCE');

insert into Ingredient (id, name, type)
values ('TMT', 'Tomatoes', 'VEGGIES');

insert into Ingredient (id, name, type)
values ('PNPL', 'Pineapple', 'VEGGIES');

insert into Ingredient (id, name, type)
values ('PPRN', 'Pepperoni', 'SAUSAGE');

insert into Ingredient (id, name, type)
values ('SLM', 'Salami', 'SAUSAGE');

/*
-- User user/pass
INSERT INTO users (name, password, enabled)
values ('user',
        '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AQubh4a',
        1);

INSERT INTO authorities (name, authority)
values ('user', 'ROLE_USER');*/