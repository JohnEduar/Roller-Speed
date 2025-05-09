CREATE DATABASE roller_speed;

CREATE USER IF NOT EXISTS 'speeduser'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON roller_speed.* TO 'speeduser'@'localhost';
FLUSH PRIVILEGES;