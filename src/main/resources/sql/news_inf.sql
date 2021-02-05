
INSERT INTO news_inf VALUES(NULL, '疯狂Java联盟'),(NULL, 'crazyit.org');


CREATE TABLE `news_inf` (
                            `news_id` INT(11) NOT NULL AUTO_INCREMENT,
                            `news_title` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
                            PRIMARY KEY (`news_id`) USING BTREE
)
    COLLATE='utf8_general_ci'
    ENGINE=InnoDB
    AUTO_INCREMENT=1
;