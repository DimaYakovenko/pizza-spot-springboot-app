create table if not exists Ingredient
(
    id   varchar(10) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists Pizza
(
    id        identity,
    name      varchar(50) not null,
    createdAt timestamp   not null
);

create table if not exists Pizza_Ingredients
(
    pizza_id      bigint      not null,
    ingredient_id varchar(10) not null
);

alter table Pizza_Ingredients
    add foreign key (pizza_id) references Pizza (id);
alter table Pizza_Ingredients
    add foreign key (ingredient_id) references Ingredient (id);

create table if not exists Pizza_Order
(
    id             identity,
    deliveryName   varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity   varchar(50) not null,
    deliveryState  varchar(10) not null,
    ccNumber       varchar(16) not null,
    ccExpiration   varchar(5)  not null,
    ccCVV          varchar(3)  not null,
    placedAt       timestamp   not null
);


create table if not exists PizzaOrder_Pizzas
(
    pizzaOrder_id bigint not null,
    pizza_id      bigint not null
);

alter table PizzaOrder_Pizzas
    add foreign key (pizzaOrder_id) references Pizza_Order (id);
alter table PizzaOrder_Pizzas
    add foreign key (pizza_id) references Pizza (id);


/*
-- create tables for jdbc authentication
CREATE TABLE if not exists users
(
    name VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  TINYINT      NOT NULL DEFAULT 1,
    PRIMARY KEY (name)
);

CREATE TABLE if not exists authorities
(
    name  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (name) REFERENCES users (name)
);

CREATE UNIQUE INDEX ix_auth_username
    on authorities (name, authority);*/
