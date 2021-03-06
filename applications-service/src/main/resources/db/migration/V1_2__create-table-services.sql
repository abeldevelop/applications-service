CREATE TABLE `applications_db`.`services` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`application_id` BIGINT(20) NOT,
	`name` VARCHAR(50) NOT NULL,
	`port` INT NOT NULL,
	`git_url` VARCHAR(255) NOT NULL,
	`documentation_url` VARCHAR(255) NOT NULL
	PRIMARY KEY (`id`),
	UNIQUE KEY (`name`),
	UNIQUE KEY (`port`),
	FOREIGN KEY (`application_id`) REFERENCES `applications_db`(`applications`)
);