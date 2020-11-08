CREATE DATABASE gtsChakuriServices;
USE gtsChakuriServices;

CREATE TABLE gts_skills
(
	gts_skill_id INT NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
    gts_skill_name varchar(255),
    gts_skill_description varchar(255),
    gts_skill_status boolean
);