CREATE TABLE IF NOT EXISTS category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_date TIMESTAMP DEFAULT NOW()
);

INSERT INTO category (name, created_date) VALUES ('Catégorie 1', NOW());