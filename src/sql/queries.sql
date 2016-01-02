-- name: initialize
CREATE DATABASE benjon;
CREATE USER benjon WITH PASSWORD 'benjon';
GRANT ALL PRIVILEGES ON DATABASE benjon TO benjon;

-- name: populate
CREATE TABLE IF NOT EXISTS message
    (id varchar(36) primary key unique, date timestamp default current_timestamp, message text not null);
    
INSERT INTO message (id, message) VALUES
    ('ms-1-ca8-a966-4e3e-b821-638f64fd9176', 'well hello!'),
    ('ms-2-ca8-a966-4e3e-b821-638f64fd9176', 'second one...');

-- name: messages
select * from message;
