CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200),
    writer VARCHAR(50),
    content TEXT,
    created_at TIMESTAMP,
    view_count INT DEFAULT 0
);