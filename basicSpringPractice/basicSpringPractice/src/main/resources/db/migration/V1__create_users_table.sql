CREATE TABLE users (
                       id SERIAL PRIMARY KEY,          -- auto-increment integer
                       name VARCHAR(100) NOT NULL,     -- name with max 100 characters
                       email VARCHAR(100) UNIQUE,      -- unique email
                       phone VARCHAR(20)                -- optional phone number
);
