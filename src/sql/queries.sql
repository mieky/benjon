-- name: messages
SELECT * FROM message
ORDER BY date DESC;

-- name: message-by-id
SELECT * FROM message
WHERE id = :id;

-- name: new-message!
-- Adds a new message for given author
INSERT INTO message (id, author_id, message)
VALUES (:id, :author_id, :message);
