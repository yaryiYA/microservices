CREATE EXTENSION "uuid-ossp";

CREATE TABLE animal
(
    id    UUID DEFAULT uuid_generate_v4 (),
    name  VARCHAR(255),
    genus VARCHAR(255),
    CONSTRAINT pk_animal PRIMARY KEY (id)
);


