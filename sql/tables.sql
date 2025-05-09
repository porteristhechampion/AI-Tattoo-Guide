CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE styles (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        style VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE suggestions (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             suggestion_text TEXT NOT NULL,
                             user_id INT NOT NULL,
                             style_id INT NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                             FOREIGN KEY (style_id) REFERENCES styles(id) ON DELETE CASCADE
);
