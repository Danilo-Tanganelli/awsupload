-- Drop tables if they exist
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS "user";

-- Create role table
CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255),
    name VARCHAR(255)
);

-- Create user_roles table
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id)
);

-- Insert data into role table
INSERT INTO role (description, name) VALUES ('Admin role', 'ADMIN');
INSERT INTO role (description, name) VALUES ('User role', 'USER');
