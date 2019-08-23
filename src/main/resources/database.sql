DROP TABLE roles;
DROP TABLE users;
DROP TABLE user_roles;
/*Table Users*/
CREATE TABLE users (
  id       INT          NOT NULL PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);


/*Table Role*/
CREATE TABLE roles (
  id   INT          NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

/*Table for mapping user and roles*/
CREATE TABLE user_roles (
  uesr_id INT NOT NULL,
  role_id INT NOT NULL,
  FOREIGN KEY (uesr_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),
  UNIQUE (role_id, uesr_id)
);

INSERT INTO users VALUES (1, 'Roman', '$2y$12$J2K6QP1k1AyDb7iW1mESD.z3c3eCVEfTEYV9SyTv6uuo7VwYjodbi');
INSERT INTO roles VALUES (1, 'Role-User');
INSERT INTO roles VALUES (2, 'Role-Admin');

INSERT INTO user_roles VALUES (1, 2);

