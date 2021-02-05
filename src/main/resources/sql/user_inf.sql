# CREATE TABLE user_inf
# (
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     NAME VARCHAR(255),
#     pass VARCHAR(255)
# );

INSERT INTO user_inf
VALUES(NULL,'crazyit','123');
INSERT INTO user_inf
VALUES(NULL,'tiger','123');

CREATE TABLE `user_inf` (
                            `id` INT(11) AUTO_INCREMENT AUTO_INCREMENT PRIMARY KEY,
                            `NAME` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
                            `pass` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci'
)
    COLLATE='utf8_general_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=1
;