CREATE TABLE my_users (
    id   UUID    NOT NULL DEFAULT uuid_generate_v1(),
    name VARCHAR NOT NULL,
    CONSTRAINT my_users_pk PRIMARY KEY (id)
);
