CREATE DATABASE benjon;
CREATE USER benjon WITH PASSWORD 'benjon';
GRANT ALL PRIVILEGES ON DATABASE benjon TO benjon;

CREATE TABLE IF NOT EXISTS hero (
    id          VARCHAR(36) PRIMARY KEY UNIQUE,
    name        TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS message (
    id          VARCHAR(36) PRIMARY KEY UNIQUE,
    author_id   VARCHAR(36) NOT NULL,
    date        TIMESTAMP DEFAULT current_timestamp,
    message     TEXT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES hero (id)
);

INSERT INTO hero (id, name) VALUES
    ('c43e4bb6-d04b-4d66-bc5d-bc43296ec15c', 'Jorma Teräs');

INSERT INTO message (id, author_id, message) VALUES
    ('ms-1-ca8-a966-4e3e-b821-638f64fd9176', 'c43e4bb6-d04b-4d66-bc5d-bc43296ec15c', 'well hello!'),
    ('ms-2-ca8-a966-4e3e-b821-638f64fd9176', 'c43e4bb6-d04b-4d66-bc5d-bc43296ec15c', 'i''m selling these fine leather jackets.');
