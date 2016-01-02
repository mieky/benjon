-- name: messages
SELECT * FROM message;

-- name: insert-message
INSERT INTO message (id, message)
VALUES (:id, :message);
