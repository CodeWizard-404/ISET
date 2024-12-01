-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 14 jan. 2022 à 11:31
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `csv_db 6`
--
CREATE DATABASE IF NOT EXISTS `csv_db 6` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `csv_db 6`;

-- --------------------------------------------------------

--
-- Structure de la table `customers_unordered`
--

CREATE TABLE `customers_unordered` (
  `ID` int(11) NOT NULL,
  `First name` varchar(255) DEFAULT NULL,
  `Last name` varchar(255) DEFAULT NULL,
  `Number` varchar(5) DEFAULT NULL,
  `Street` varchar(255) DEFAULT NULL,
  `City` varchar(255) DEFAULT NULL,
  `State` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `customers_unordered`
--

INSERT INTO `customers_unordered` (`ID`, `First name`, `Last name`, `Number`, `Street`, `City`, `State`) VALUES
(1, 'Bill', 'Coolidge', '85013', 'Via Real', 'Austin', 'IL'),
(2, 'Thomas', 'Coolidge', '63489', 'Lindbergh Blvd', 'Springfield', 'ca'),
(3, 'Harry', 'Ford', '97249', 'Monroe Street', 'Salt Lake City', 'ca'),
(4, 'Warren', 'McKinley', '82589', 'Westside Freeway', 'Concord', 'ak'),
(5, 'Andrew', 'Taylor', '29886', 'Padre Boulevard', 'Madison', 'CA'),
(6, 'Ulysses', 'Coolidge', '98646', 'Bayshore Freeway', 'Columbus', 'MN'),
(7, 'Theodore', 'Clinton', '12292', 'San Marcos', 'Bismarck', 'NY'),
(8, 'Benjamin', 'Jefferson', '82077', 'Carpinteria North', 'Sacramento', 'ca'),
(9, 'William', 'Van Buren', '21712', 'Tully Road East', 'Albany', 'IL'),
(10, 'Calvin', 'Washington', '50742', 'Richmond Hill', 'Charleston', 'ca'),
(11, 'Jimmy', 'Polk', '76143', 'Richmond Hill', 'Salt Lake City', 'AK'),
(12, 'Calvin', 'Adams', '52386', 'Lake Tahoe Blvd.', 'Montgomery', 'NY'),
(13, 'Ulysses', 'Monroe', '70511', 'Jones Road', 'Trenton', 'IL'),
(14, 'Zachary', 'Tyler', '45040', 'Santa Rosa North', 'Carson City', 'AK'),
(15, 'Ulysses', 'Johnson', '19989', 'Via Real', 'Juneau', 'AL'),
(16, 'George', 'Arthur', '89874', 'Calle Real', 'Annapolis', 'AL'),
(17, 'George', 'Jefferson', '67703', 'Fontaine Road', 'Pierre', 'IL'),
(18, 'Herbert', 'Grant', '90635', 'North Ventu Park Road', 'Columbus', 'AK'),
(19, 'Calvin', 'Washington', '37446', 'E Fowler Avenue', 'Pierre', 'al'),
(20, 'John', 'Harrison', '86745', 'San Marcos', 'Annapolis', 'AK'),
(21, 'Benjamin', 'Ford', '27921', 'Carpinteria Avenue', 'Providence', 'CA'),
(22, 'Andrew', 'Fillmore', '96878', 'Greenwood Road', 'Saint Paul', 'AK'),
(23, 'Warren', 'Arthur', '22920', 'Jean de la Fontaine', 'Madison', 'MN'),
(24, 'Calvin', 'Pierce', '41962', 'Santa Rosa North', 'Juneau', 'ca'),
(25, 'Woodrow', 'Clinton', '30587', 'San Diego Freeway', 'Topeka', 'CA'),
(26, 'George', 'Jefferson', '95054', 'Padre Boulevard', 'Denver', 'ak'),
(27, 'Lyndon', 'Eisenhower', '14379', 'Newbury Road', 'Lincoln', 'al'),
(28, 'John', 'Adams', '49993', 'El Camino Real', 'Phoenix', 'AK'),
(29, 'Woodrow', 'Adams', '62404', 'Jones Road', 'Springfield', 'IL'),
(30, 'George', 'Adams', '40011', 'South Highway', 'Concord', 'ca'),
(31, 'Dwight', 'Pierce', '24382', 'North Atherton Street', 'Providence', 'ca'),
(32, 'Thomas', 'Polk', '14024', 'San Simeon', 'Lansing', 'MN'),
(33, 'Jimmy', 'Coolidge', '19658', 'North Ventu Park Road', 'Sacramento', 'ca'),
(34, 'Theodore', 'Reagan', '30441', 'Lake Tahoe Blvd.', 'Raleigh', 'AL'),
(35, 'William', 'Wilson', '96762', 'San Luis Obispo North', 'Harrisburg', 'al'),
(36, 'Andrew', 'McKinley', '45619', 'San Luis Obispo North', 'Bismarck', 'AK'),
(37, 'George', 'Coolidge', '67507', 'Santa Monica Road', 'Columbus', 'AK'),
(38, 'Richard', 'Carter', '42127', 'Carpinteria Avenue', 'Columbia', 'ca'),
(39, 'Herbert', 'Hoover', '93826', 'N Harrison St', 'Santa Fe', 'ca'),
(40, 'Herbert', 'Hoover', '86542', 'East Calle Primera', 'Harrisburg', 'ca'),
(41, 'Chester', 'Quincy', '38921', 'Santa Monica Road', 'Des Moines', 'ca'),
(42, 'Herbert', 'Washington', '71351', 'Padre Boulevard', 'Indianapolis', 'CA'),
(43, 'Richard', 'Coolidge', '66918', 'S Rustle St', 'Madison', 'IL'),
(44, 'Dwight', 'Pierce', '53765', 'Burnett Road', 'Cheyenne', 'AL'),
(45, 'Calvin', 'Madison', '77564', 'Harry S Truman Blvd', 'Boise', 'al'),
(46, 'Zachary', 'Pierce', '91312', 'Santa Ana Freeway', 'Annapolis', 'AK'),
(47, 'Thomas', 'Roosevelt', '47330', 'East Fry Blvd.', 'Carson City', 'CA'),
(48, 'Thomas', 'Reagan', '76890', 'Fontaine Road', 'Jackson', 'ca'),
(49, 'Ulysses', 'Reagan', '42195', 'Cerrillos Road', 'Dover', 'al'),
(50, 'Martin', 'Johnson', '32782', 'Padre Boulevard', 'Springfield', 'NY'),
(51, 'Lyndon', 'Harding', '92517', 'Burnett Road', 'Little Rock', 'AK'),
(52, 'Warren', 'Taft', '34746', 'Newbury Road', 'Richmond', 'IL'),
(53, 'Lyndon', 'Jackson', '72876', 'East Fry Blvd.', 'Jackson', 'IL'),
(54, 'Abraham', 'Tyler', '89260', 'Carpinteria North', 'Annapolis', 'NY'),
(55, 'Bill', 'Eisenhower', '56724', 'Timberlane Drive', 'Jackson', 'ak'),
(56, 'Rutherford', 'Harrison', '27209', 'Bailard Avenue', 'Tallahassee', 'AL'),
(57, 'Jimmy', 'Garfield', '60346', 'Harbor Dr', 'Helena', 'AL'),
(58, 'Herbert', 'Arthur', '38585', 'East Calle Primera', 'Springfield', 'AL'),
(59, 'Millard', 'Reagan', '47551', 'South Roosevelt Drive', 'Sacramento', 'al'),
(60, 'Rutherford', 'Madison', '16987', 'Bailard Avenue', 'Austin', 'AK'),
(61, 'Benjamin', 'Adams', '48190', 'Grandview Drive', 'Montpelier', 'AL'),
(62, 'Ronald', 'Fillmore', '78647', 'N Kentwood', 'Trenton', 'al'),
(63, 'Calvin', 'Taft', '36327', 'North Preisker Lane', 'Jefferson City', 'ak'),
(64, 'George', 'Truman', '88678', 'N Harrison St', 'Jefferson City', 'ak'),
(65, 'Herbert', 'Pierce', '32958', 'East Main Street', 'Oklahoma City', 'AL'),
(66, 'Woodrow', 'Harrison', '49904', 'Monroe Street', 'Montgomery', 'IL'),
(67, 'Benjamin', 'Adams', '32628', 'Santa Rosa North', 'Boise', 'AL'),
(68, 'Herbert', 'Coolidge', '65573', 'Cabrillo Highway', 'Salt Lake City', 'NY'),
(69, 'Grover', 'Van Buren', '76745', 'San Ysidro Blvd', 'Columbia', 'MN'),
(70, 'Calvin', 'Harrison', '17512', 'Santa Monica Road', 'Baton Rouge', 'ca'),
(71, 'Abraham', 'Hoover', '34027', 'Grandview Drive', 'Augusta', 'IL'),
(72, 'Gerald', 'Adams', '65044', 'Santa Ana Freeway', 'Albany', 'CA'),
(73, 'Dwight', 'Arthur', '65616', 'Hutchinson Rd', 'Nashville', 'MN'),
(74, 'James', 'Fillmore', '77607', 'Bowles Avenue', 'Springfield', 'MN'),
(75, 'Franklin', 'Johnson', '65748', 'East Calle Primera', 'Indianapolis', 'ca'),
(76, 'Rutherford', 'Arthur', '49798', 'N Kentwood', 'Carson City', 'MN'),
(77, 'Benjamin', 'Reagan', '35525', 'North Ventu Park Road', 'Cheyenne', 'AK'),
(78, 'Benjamin', 'Roosevelt', '46838', 'Tully Road East', 'Lansing', 'MN'),
(79, 'Richard', 'Coolidge', '53443', 'Cleveland Ave.', 'Charleston', 'ak'),
(80, 'Warren', 'Tyler', '56024', 'E Fowler Avenue', 'Jackson', 'AL'),
(81, 'James', 'Ford', '78424', 'Erringer Road', 'Jackson', 'ak'),
(82, 'Ulysses', 'Taft', '80435', 'Castillo Drive', 'Dover', 'CA'),
(83, 'Martin', 'Lincoln', '48090', 'Erringer Road', 'Pierre', 'IL'),
(84, 'Warren', 'Grant', '39236', 'Carpinteria North', 'Jefferson City', 'MN'),
(85, 'Gerald', 'Eisenhower', '12903', 'Jones Road', 'Albany', 'NY'),
(86, 'William', 'Buchanan', '86382', 'Bayshore Freeway', 'Raleigh', 'ak'),
(87, 'James', 'Harding', '67244', 'N Harrison St', 'Phoenix', 'IL'),
(88, 'Theodore', 'Wilson', '18980', 'Harry S Truman Blvd', 'Hartford', 'ca'),
(89, 'Richard', 'Madison', '55838', 'Monroe Street', 'Santa Fe', 'ak'),
(90, 'Abraham', 'Wilson', '83959', 'Hutchinson Rd', 'Nashville', 'NY'),
(91, 'John', 'Johnson', '64872', 'Erringer Road', 'Olympia', 'CA'),
(92, 'Rutherford', 'Harding', '46743', 'Steele Lane', 'Boston', 'NY'),
(93, 'John', 'Clinton', '42059', 'Santa Ana Freeway', 'Columbus', 'ca'),
(94, 'Andrew', 'Johnson', '16064', 'Harbor Dr', 'Sacramento', 'IL'),
(95, 'Thomas', 'Fillmore', '26120', 'Jean de la Fontaine', 'Little Rock', 'ca'),
(96, 'Chester', 'Taft', '89505', 'North Preisker Lane', 'Cheyenne', 'AL'),
(97, 'Lyndon', 'Cleveland', '85642', 'North Atherton Street', 'Hartford', 'MN'),
(98, 'Rutherford', 'Polk', '99837', 'Santa Monica Road', 'Boise', 'CA'),
(99, 'Thomas', 'Wilson', '36910', 'Tanger Blvd', 'Salem', 'MN'),
(100, 'Benjamin', 'Taylor', '81222', 'North Erringer Road', 'Concord', 'MN');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `customers_unordered`
--
ALTER TABLE `customers_unordered`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `customers_unordered`
--
ALTER TABLE `customers_unordered`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
--
-- Base de données : `phpmyadmin`
--
CREATE DATABASE IF NOT EXISTS `phpmyadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `phpmyadmin`;

-- --------------------------------------------------------

--
-- Structure de la table `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(10) UNSIGNED NOT NULL,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Structure de la table `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_length` text COLLATE utf8_bin DEFAULT NULL,
  `col_collation` varchar(64) COLLATE utf8_bin NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_bin DEFAULT '',
  `col_default` text COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Structure de la table `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `settings_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Structure de la table `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `export_type` varchar(10) COLLATE utf8_bin NOT NULL,
  `template_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `template_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Structure de la table `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Structure de la table `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp(),
  `sqlquery` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `item_type` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Structure de la table `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Déchargement des données de la table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{\"db\":\"csv_db 6\",\"table\":\"customers_unordered\"},{\"db\":\"CSV_DB 6\",\"table\":\"customers_unordered\"}]');

-- --------------------------------------------------------

--
-- Structure de la table `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Structure de la table `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT 0,
  `x` float UNSIGNED NOT NULL DEFAULT 0,
  `y` float UNSIGNED NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Structure de la table `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin DEFAULT NULL,
  `data_sql` longtext COLLATE utf8_bin DEFAULT NULL,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Structure de la table `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `config_data` text COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';

--
-- Déchargement des données de la table `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2022-01-14 10:30:55', '{\"Console\\/Mode\":\"collapse\",\"lang\":\"fr\"}');

-- --------------------------------------------------------

--
-- Structure de la table `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL,
  `tab` varchar(64) COLLATE utf8_bin NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_bin NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Structure de la table `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users and their assignments to user groups';

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Index pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Index pour la table `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Index pour la table `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Index pour la table `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Index pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Index pour la table `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Index pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Index pour la table `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Index pour la table `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Index pour la table `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Index pour la table `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Index pour la table `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Index pour la table `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Index pour la table `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Base de données : `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test`;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
