-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema musicfestivaldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `musicfestivaldb` ;

-- -----------------------------------------------------
-- Schema musicfestivaldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `musicfestivaldb` DEFAULT CHARACTER SET utf8 ;
USE `musicfestivaldb` ;

-- -----------------------------------------------------
-- Table `MusicFestival`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `MusicFestival` ;

CREATE TABLE IF NOT EXISTS `MusicFestival` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `location` VARCHAR(100) NULL,
  `number_of_days` INT NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `music_genre` VARCHAR(450) NULL,
  `headliners` VARCHAR(1000) NULL,
  `music_artists_seen` VARCHAR(4500) NULL,
  `ticket_price` DECIMAL NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS musicfest@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'musicfest'@'localhost' IDENTIFIED BY 'musicfest';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'musicfest'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `MusicFestival`
-- -----------------------------------------------------
START TRANSACTION;
USE `musicfestivaldb`;
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (1, 'Sunset Music Festival', 'Tampa Bay, Florida', 2, '2015-05-23', '2015-05-24', 'EDM', 'Tiesto, Skrillex, Armin Van Buuren', 'Skrillex, DVBBS, Flosstradamas, Showtek, The Chainsmokers', 240.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (2, 'Coachella', 'Indio, California', 3, '2016-04-22', '2016-04-24', 'Rock, EDM, Pop, Rap, Indie', 'LCD Soundsystem, Guns N\' Roses, Calvin Harris', 'Guns N\' Roses, Ellie Goulding, Purity Ring, A$AP Rocky, SZA', 375.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (3, 'CRSSD', 'San Diego, California', 2, '2016-10-1', '2016-10-2', 'EDM', 'ZHU, Miike Snow', 'ZHU, Flight Facilities, Cashmere Cat, AC Slater, Claptone', 100.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (4, 'Dirtybird Campout ', 'Silverado, California', 3, '2016-10-7', '2016-10-9', 'House', 'Claude Vonstroke, Reggie Watts, Green Velvet', 'Claude Vonstroke, Reggie Watts, Green Velvet, Justin Martin, Catz \'N Dogz', 150.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (5, 'Electric Forrest', 'Rothbury, Michigan', 4, '2018-06-21', '2018-06-24', 'Rock, EDM, Indie', 'The String Cheese Incident, Bassnectar, Zhu, Griz', 'The String Cheese Incident, Bassnectar, Zhu, Griz, Rufus Du Sol', 360.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (6, 'Lost Lake Festival', 'Phoenix, Arizona', 3, '2017-10-20', '2017-10-22', 'Rock, Rap, EDM', 'The Killers, Chance The Rapper, Odesza', 'Odesza, The Killers, Chance The Rapper, Huey Lewis & The News, Big Gigantic', 190.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (7, 'Life Is Beautiful', 'Las Vegas, Nevada', 3, '2017-09-22', '2017-09-24', 'Rock, Rap, EDM, Pop', 'Chance The Rapper, Muse, Gorillaz, Blink 182', 'Chance The Rapper, Lorde, Pretty Lights, Tycho, Tchami', 265.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (8, 'A&B Group Therapy Weekender', 'The Gorge Amphitheater, Washington', 2, '2019-07-27', '2019-07-28', 'EDM', 'Above & Beyond, Tinlicker, Yotto', 'Above & Beyond, Tinlicker, Yotto, Audien, Gabriel & Dresden', 150.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (9, 'Electric Forest', 'Rothbury, Michigan', 4, '2019-06-27', '2019-07-30', 'Rock, EDM, Indie', 'Odesza, Kygo, Bassnectar, Zeds Dead', 'Odesza, Kygo, Bassnectar, Zeds Dead, Seven Lions', 400.00);
INSERT INTO `MusicFestival` (`id`, `name`, `location`, `number_of_days`, `start_date`, `end_date`, `music_genre`, `headliners`, `music_artists_seen`, `ticket_price`) VALUES (10, 'Decadence', 'Denver, Colorado', 2, '2019-12-30', '2019-12-31', 'EDM', 'Bassnectar, Jai Wolf, REZZ', 'REZZ, Jai Wolf, Shaq, Louis The Child', 380.00);

COMMIT;

