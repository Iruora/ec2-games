-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 04 Décembre 2017 à 09:27
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `chosa`
--

-- --------------------------------------------------------

--
-- Structure de la table `APP_CATEGORY`
--

CREATE TABLE IF NOT EXISTS `APP_CATEGORY` (
  `CATEGORY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NAME` varchar(255) NOT NULL,
  `CATEGORY_PARENT_ID_FK` bigint(20) NOT NULL,
  `USER_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`CATEGORY_ID`),
  KEY `CATEGORY_PARENT_ID_FK` (`CATEGORY_PARENT_ID_FK`,`USER_ID_FK`),
  KEY `USER_ID_FK` (`USER_ID_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `APP_COUNTRY`
--

CREATE TABLE IF NOT EXISTS `APP_COUNTRY` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `NAME_FR` varchar(50) DEFAULT NULL,
  `ISO` varchar(3) DEFAULT NULL,
  `ISO3` varchar(5) DEFAULT NULL,
  `FIPS` varchar(3) DEFAULT NULL,
  `CONTINENT` varchar(3) DEFAULT NULL,
  `PHONE_PREFIX` varchar(45) DEFAULT NULL,
  `POSTAL_CODE` varchar(45) DEFAULT NULL,
  `LANGUAGES` varchar(45) DEFAULT NULL,
  `CURRENCY_ID_FK` bigint(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NULL DEFAULT NULL,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_country_currency` (`CURRENCY_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=249 ;


--
-- Contenu de la table `APP_COUNTRY`
--
INSERT INTO `APP_COUNTRY` (`ID`, `NAME`, `NAME_FR`, `ISO`, `ISO3`, `FIPS`, `CONTINENT`, `PHONE_PREFIX`, `POSTAL_CODE`, `LANGUAGES`, `CURRENCY_ID_FK`, `CREATION_DATE`, `UPDATING_DATE`, `DELETING_DATE`) VALUES
(1, 'Afghanistan', 'Afghanistan', 'AF', 'AFG', 'AF', 'AS', '93', '', 'fa-AF,ps,uz-AF,tk', 3, '2017-07-18 23:00:00', NULL, NULL),
(2, 'Albania', 'Albanie', 'AL', 'ALB', 'AL', 'EU', '355', '', 'sq,el', 1, '2017-07-18 23:00:00', NULL, NULL),
(3, 'Antarctica', 'Antarctique', 'AQ', 'ATA', 'AY', 'AN', '', '', '', NULL, '2017-07-18 23:00:00', NULL, NULL),
(4, 'Algeria', 'Algérie', 'DZ', 'DZA', 'AG', 'AF', '213', '^(d{5})$', 'ar-DZ', 142, '2017-07-18 23:00:00', NULL, NULL),
(5, 'American Samoa', 'Samoa Américaines', 'AS', 'ASM', 'AQ', 'OC', '+1-684', '', 'en-AS,sm,to', 2, '2017-07-18 23:00:00', NULL, NULL),
(6, 'Andorra', 'Andorre', 'AD', 'AND', 'AN', 'EU', '376', '^(?:AD)*(d{3})$', 'ca,fr-AD,pt', 11, '2017-07-18 23:00:00', NULL, NULL),
(7, 'Angola', 'Angola', 'AO', 'AGO', 'AO', 'AF', '244', '', 'pt-AO', 134, '2017-07-18 23:00:00', NULL, NULL),
(8, 'Antigua and Barbuda', 'Antigua-et-Barbuda', 'AG', 'ATG', 'AC', 'NA', '+1-268', '', 'en-AG', 34, '2017-07-18 23:00:00', NULL, NULL),
(9, 'Azerbaijan', 'Azerbaïdjan', 'AZ', 'AZE', 'AJ', 'AS', '994', '^(?:AZ)*(d{4})$', 'az,ru,hy', 7, '2017-07-18 23:00:00', NULL, NULL),
(10, 'Argentina', 'Argentine', 'AR', 'ARG', 'AR', 'SA', '54', '^([A-Z]d{4}[A-Z]{3})$', 'es-AR,en,it,de,fr', 4, '2017-07-18 23:00:00', NULL, NULL),
(11, 'Australia', 'Australie', 'AU', 'AUS', 'AS', 'OC', '61', '^(d{4})$', 'en-AU', 6, '2017-07-18 23:00:00', NULL, NULL),
(12, 'Austria', 'Autriche', 'AT', 'AUT', 'AU', 'EU', '43', '^(d{4})$', 'de-AT,hr,hu,sl', 11, '2017-07-18 23:00:00', NULL, NULL),
(13, 'Bahamas', 'Bahamas', 'BS', 'BHS', 'BF', 'NA', '+1-242', '', 'en-BS', 8, '2017-07-18 23:00:00', NULL, NULL),
(14, 'Bahrain', 'Bahreïn', 'BH', 'BHR', 'BA', 'AS', '973', '^(d{3}d?)$', 'ar-BH,en,fa,ur', 136, '2017-07-18 23:00:00', NULL, NULL),
(15, 'Bangladesh', 'Bangladesh', 'BD', 'BGD', 'BG', 'AS', '880', '^(d{4})$', 'bn-BD,en', 135, '2017-07-18 23:00:00', NULL, NULL),
(16, 'Armenia', 'Arménie', 'AM', 'ARM', 'AM', 'AS', '374', '^(d{6})$', 'hy', 133, '2017-07-18 23:00:00', NULL, NULL),
(17, 'Barbados', 'Barbade', 'BB', 'BRB', 'BB', 'NA', '+1-246', '^(?:BB)*(d{5})$', 'en-BB', 9, '2017-07-18 23:00:00', NULL, NULL),
(18, 'Belgium', 'Belgique', 'BE', 'BEL', 'BE', 'EU', '32', '^(d{4})$', 'nl-BE,fr-BE,de-BE', 11, '2017-07-18 23:00:00', NULL, NULL),
(19, 'Bermuda', 'Bermudes', 'BM', 'BMU', 'BD', 'NA', '+1-441', '^([A-Z]{2}d{2})$', 'en-BM,pt', 13, '2017-07-18 23:00:00', NULL, NULL),
(20, 'Bhutan', 'Bhoutan', 'BT', 'BTN', 'BT', 'AS', '975', '', 'dz', 138, '2017-07-18 23:00:00', NULL, NULL),
(21, 'Bolivia', 'Bolivie', 'BO', 'BOL', 'BL', 'SA', '591', '', 'es-BO,qu,ay', 14, '2017-07-18 23:00:00', NULL, NULL),
(22, 'Bosnia and Herzegovina', 'Bosnie-Herzégovine', 'BA', 'BIH', 'BK', 'EU', '387', '^(d{5})$', 'bs,hr-BA,sr-BA', 15, '2017-07-18 23:00:00', NULL, NULL),
(23, 'Botswana', 'Botswana', 'BW', 'BWA', 'BC', 'AF', '267', '', 'en-BW,tn-BW', 16, '2017-07-18 23:00:00', NULL, NULL),
(24, 'Bouvet Island', 'Île Bouvet', 'BV', 'BVT', 'BV', 'AN', '', '', '', 89, '2017-07-18 23:00:00', NULL, NULL),
(25, 'Brazil', 'Brésil', 'BR', 'BRA', 'BR', 'SA', '55', '^(d{8})$', 'pt-BR,es,en,fr', 18, '2017-07-18 23:00:00', NULL, NULL),
(26, 'Belize', 'Belize', 'BZ', 'BLZ', 'BH', 'NA', '501', '', 'en-BZ,es', 12, '2017-07-18 23:00:00', NULL, NULL),
(27, 'British Indian Ocean Territory', 'Territoire Britannique de l Océan Indien', 'IO', 'IOT', 'IO', 'AS', '246', '', 'en-IO', 2, '2017-07-18 23:00:00', NULL, NULL),
(28, 'Solomon Islands', 'Îles Salomon', 'SB', 'SLB', 'BP', 'OC', '677', '', 'en-SB,tpi', 106, '2017-07-18 23:00:00', NULL, NULL),
(29, 'British Virgin Islands', 'Îles Vierges Britanniques', 'VG', 'VGB', 'VI', 'NA', '+1-284', '', 'en-VG', 2, '2017-07-18 23:00:00', NULL, NULL),
(30, 'Brunei', 'Brunéi Darussalam', 'BN', 'BRN', 'BX', 'AS', '673', '^([A-Z]{2}d{4})$', 'ms-BN,en-BN', 20, '2017-07-18 23:00:00', NULL, NULL),
(31, 'Bulgaria', 'Bulgarie', 'BG', 'BGR', 'BU', 'EU', '359', '^(d{4})$', 'bg,tr-BG', 17, '2017-07-18 23:00:00', NULL, NULL),
(32, 'Myanmar', 'Myanmar', 'MM', 'MMR', 'BM', 'AS', '95', '^(d{5})$', 'my', 46, '2017-07-18 23:00:00', NULL, NULL),
(33, 'Burundi', 'Burundi', 'BI', 'BDI', 'BY', 'AF', '257', '', 'fr-BI,rn', 137, '2017-07-18 23:00:00', NULL, NULL),
(34, 'Belarus', 'Bélarus', 'BY', 'BLR', 'BO', 'EU', '375', '^(d{6})$', 'be,ru', 10, '2017-07-18 23:00:00', NULL, NULL),
(35, 'Cambodia', 'Cambodge', 'KH', 'KHM', 'CB', 'AS', '855', '^(d{5})$', 'km,fr,en', 21, '2017-07-18 23:00:00', NULL, NULL),
(36, 'Cameroon', 'Cameroun', 'CM', 'CMR', 'CM', 'AF', '237', '', 'en-CM,fr-CM', 178, '2017-07-18 23:00:00', NULL, NULL),
(37, 'Canada', 'Canada', 'CA', 'CAN', 'CA', 'NA', '1', '^([a-zA-Z]d[a-zA-Z]d[a-zA-Z]d)$', 'en-CA,fr-CA', 22, '2017-07-18 23:00:00', NULL, NULL),
(38, 'Cape Verde', 'Cap-vert', 'CV', 'CPV', 'CV', 'AF', '238', '^(d{4})$', 'pt-CV', 140, '2017-07-18 23:00:00', NULL, NULL),
(39, 'Cayman Islands', 'Îles Caïmanes', 'KY', 'CYM', 'CJ', 'NA', '+1-345', '', 'en-KY', 23, '2017-07-18 23:00:00', NULL, NULL),
(40, 'Central African Republic', 'République Centrafricaine', 'CF', 'CAF', 'CT', 'AF', '236', '', 'fr-CF,ln,kg', 178, '2017-07-18 23:00:00', NULL, NULL),
(41, 'Sri Lanka', 'Sri Lanka', 'LK', 'LKA', 'CE', 'AS', '94', '^(d{5})$', 'si,ta,en', 111, '2017-07-18 23:00:00', NULL, NULL),
(42, 'Chad', 'Tchad', 'TD', 'TCD', 'CD', 'AF', '235', '', 'fr-TD,ar-TD,sre', 178, '2017-07-18 23:00:00', NULL, NULL),
(43, 'Chile', 'Chili', 'CL', 'CHL', 'CI', 'SA', '56', '^(d{7})$', 'es-CL', 24, '2017-07-18 23:00:00', NULL, NULL),
(44, 'China', 'Chine', 'CN', 'CHN', 'CH', 'AS', '86', '^(d{6})$', 'zh-CN,yue,wuu', 25, '2017-07-18 23:00:00', NULL, NULL),
(45, 'Taiwan', 'Taïwan', 'TW', 'TWN', 'TW', 'AS', '886', '^(d{5})$', 'zh-TW,zh,nan,hak', 116, '2017-07-18 23:00:00', NULL, NULL),
(46, 'Christmas Island', 'Île Christmas', 'CX', 'CXR', 'KT', 'AS', '61', '^(d{4})$', 'en,zh,ms-CC', 6, '2017-07-18 23:00:00', NULL, NULL),
(47, 'Cocos Islands', 'Îles Cocos (Keeling)', 'CC', 'CCK', 'CK', 'AS', '61', '', 'ms-CC,en', 6, '2017-07-18 23:00:00', NULL, NULL),
(48, 'Colombia', 'Colombie', 'CO', 'COL', 'CO', 'SA', '57', '', 'es-CO', 26, '2017-07-18 23:00:00', NULL, NULL),
(49, 'Comoros', 'Comores', 'KM', 'COM', 'CN', 'AF', '269', '', 'ar,fr-KM', 153, '2017-07-18 23:00:00', NULL, NULL),
(50, 'Mayotte', 'Mayotte', 'YT', 'MYT', 'MF', 'AF', '269', '^(d{5})$', 'fr-YT', 11, '2017-07-18 23:00:00', NULL, NULL),
(51, 'Republic of the Congo', 'République du Congo', 'CG', 'COG', 'CF', 'AF', '242', '', 'fr-CG,kg,ln-CG', 178, '2017-07-18 23:00:00', NULL, NULL),
(52, 'Democratic Republic of the Congo', 'République Démocratique du Congo', 'CD', 'COD', 'CG', 'AF', '243', '', 'fr-CD,ln,kg', 139, '2017-07-18 23:00:00', NULL, NULL),
(53, 'Cook Islands', 'Îles Cook', 'CK', 'COK', 'CW', 'OC', '682', '', 'en-CK,mi', 85, '2017-07-18 23:00:00', NULL, NULL),
(54, 'Costa Rica', 'Costa Rica', 'CR', 'CRI', 'CS', 'NA', '506', '^(d{4})$', 'es-CR,en', 27, '2017-07-18 23:00:00', NULL, NULL),
(55, 'Croatia', 'Croatie', 'HR', 'HRV', 'HR', 'EU', '385', '^(?:HR)*(d{5})$', 'hr-HR,sr', 28, '2017-07-18 23:00:00', NULL, NULL),
(56, 'Cuba', 'Cuba', 'CU', 'CUB', 'CU', 'NA', '53', '^(?:CP)*(d{5})$', 'es-CU', 29, '2017-07-18 23:00:00', NULL, NULL),
(57, 'Cyprus', 'Chypre', 'CY', 'CYP', 'CY', 'EU', '357', '^(d{4})$', 'el-CY,tr-CY,en', 11, '2017-07-18 23:00:00', NULL, NULL),
(58, 'Czech Republic', 'République Tchèque', 'CZ', 'CZE', 'EZ', 'EU', '420', '^(d{5})$', 'cs,sk', 31, '2017-07-18 23:00:00', NULL, NULL),
(59, 'Benin', 'Bénin', 'BJ', 'BEN', 'BN', 'AF', '229', '', 'fr-BJ', 179, '2017-07-18 23:00:00', NULL, NULL),
(60, 'Denmark', 'Danemark', 'DK', 'DNK', 'DA', 'EU', '45', '^(d{4})$', 'da-DK,en,fo,de-DK', 32, '2017-07-18 23:00:00', NULL, NULL),
(61, 'Dominica', 'Dominique', 'DM', 'DMA', 'DO', 'NA', '+1-767', '', 'en-DM', 34, '2017-07-18 23:00:00', NULL, NULL),
(62, 'Dominican Republic', 'République Dominicaine', 'DO', 'DOM', 'DR', 'NA', '+1-809 and 1-829', '^(d{5})$', 'es-DO', 33, '2017-07-18 23:00:00', NULL, NULL),
(63, 'Ecuador', 'Équateur', 'EC', 'ECU', 'EC', 'SA', '593', '^([a-zA-Z]d{4}[a-zA-Z])$', 'es-EC', 2, '2017-07-18 23:00:00', NULL, NULL),
(64, 'El Salvador', 'El Salvador', 'SV', 'SLV', 'ES', 'NA', '503', '^(?:CP)*(d{4})$', 'es-SV', 2, '2017-07-18 23:00:00', NULL, NULL),
(65, 'Equatorial Guinea', 'Guinée Équatoriale', 'GQ', 'GNQ', 'EK', 'AF', '240', '', 'es-GQ,fr', 178, '2017-07-18 23:00:00', NULL, NULL),
(66, 'Ethiopia', 'Éthiopie', 'ET', 'ETH', 'ET', 'AF', '251', '^(d{4})$', 'am,en-ET,om-ET,ti-ET,so-ET,sid', 145, '2017-07-18 23:00:00', NULL, NULL),
(67, 'Eritrea', 'Érythrée', 'ER', 'ERI', 'ER', 'AF', '291', '', 'aa-ER,ar,tig,kun,ti-ER', 144, '2017-07-18 23:00:00', NULL, NULL),
(68, 'Estonia', 'Estonie', 'EE', 'EST', 'EN', 'EU', '372', '^(d{5})$', 'et,ru', 143, '2017-07-18 23:00:00', NULL, NULL),
(69, 'Faroe Islands', 'Îles Féroé', 'FO', 'FRO', 'FO', 'EU', '298', '^(?:FO)*(d{3})$', 'fo,da-FO', 32, '2017-07-18 23:00:00', NULL, NULL),
(70, 'Falkland Islands', 'Îles (malvinas) Falkland', 'FK', 'FLK', 'FK', 'SA', '500', '', 'en-FK', 39, '2017-07-18 23:00:00', NULL, NULL),
(71, 'South Georgia and the South Sandwich Islands', 'Géorgie du Sud et les Îles Sandwich du Sud', 'GS', 'SGS', 'SX', 'AN', '', '', 'en', 19, '2017-07-18 23:00:00', NULL, NULL),
(72, 'Fiji', 'Fidji', 'FJ', 'FJI', 'FJ', 'OC', '679', '', 'en-FJ,fj', 40, '2017-07-18 23:00:00', NULL, NULL),
(73, 'Finland', 'Finlande', 'FI', 'FIN', 'FI', 'EU', '358', '^(?:FI)*(d{5})$', 'fi-FI,sv-FI,smn', 11, '2017-07-18 23:00:00', NULL, NULL),
(74, 'Aland Islands', 'Îles Åland', 'AX', 'ALA', '', 'EU', '+358-18', '', 'sv-AX', 11, '2017-07-18 23:00:00', NULL, NULL),
(75, 'France', 'France', 'FR', 'FRA', 'FR', 'EU', '33', '^(d{5})$', 'fr-FR,frp,br,co,ca,eu', 11, '2017-07-18 23:00:00', NULL, NULL),
(76, 'French Guiana', 'Guyane Française', 'GF', 'GUF', 'FG', 'SA', '594', '^((97)|(98)3d{2})$', 'fr-GF', 11, '2017-07-18 23:00:00', NULL, NULL),
(77, 'French Polynesia', 'Polynésie Française', 'PF', 'PYF', 'FP', 'OC', '689', '^((97)|(98)7d{2})$', 'fr-PF,ty', 180, '2017-07-18 23:00:00', NULL, NULL),
(78, 'French Southern Territories', 'Terres Australes Françaises', 'TF', 'ATF', 'FS', 'AN', '', '', 'fr', 11, '2017-07-18 23:00:00', NULL, NULL),
(79, 'Djibouti', 'Djibouti', 'DJ', 'DJI', 'DJ', 'AF', '253', '', 'fr-DJ,ar,so-DJ,aa', 141, '2017-07-18 23:00:00', NULL, NULL),
(80, 'Gabon', 'Gabon', 'GA', 'GAB', 'GB', 'AF', '241', '', 'fr-GA', 178, '2017-07-18 23:00:00', NULL, NULL),
(81, 'Georgia', 'Géorgie', 'GE', 'GEO', 'GG', 'AS', '995', '^(d{4})$', 'ka,ru,hy,az', 146, '2017-07-18 23:00:00', NULL, NULL),
(82, 'Gambia', 'Gambie', 'GM', 'GMB', 'GA', 'AF', '220', '', 'en-GM,mnk,wof,wo,ff', 147, '2017-07-18 23:00:00', NULL, NULL),
(83, 'Palestinian Territory', 'Territoire Palestinien Occupé', 'PS', 'PSE', 'WE', 'AS', '970', '', 'ar-PS', 58, '2017-07-18 23:00:00', NULL, NULL),
(84, 'Germany', 'Allemagne', 'DE', 'DEU', 'GM', 'EU', '49', '^(d{5})$', 'de', 11, '2017-07-18 23:00:00', NULL, NULL),
(85, 'Ghana', 'Ghana', 'GH', 'GHA', 'GH', 'AF', '233', '', 'en-GH,ak,ee,tw', 42, '2017-07-18 23:00:00', NULL, NULL),
(86, 'Gibraltar', 'Gibraltar', 'GI', 'GIB', 'GI', 'EU', '350', '', 'en-GI,es,it,pt', 43, '2017-07-18 23:00:00', NULL, NULL),
(87, 'Kiribati', 'Kiribati', 'KI', 'KIR', 'KR', 'OC', '686', '', 'en-KI,gil', 6, '2017-07-18 23:00:00', NULL, NULL),
(88, 'Greece', 'Grèce', 'GR', 'GRC', 'GR', 'EU', '30', '^(d{5})$', 'el-GR,en,fr', 11, '2017-07-18 23:00:00', NULL, NULL),
(89, 'Greenland', 'Groenland', 'GL', 'GRL', 'GL', 'NA', '299', '^(d{4})$', 'kl,da-GL,en', 32, '2017-07-18 23:00:00', NULL, NULL),
(90, 'Grenada', 'Grenade', 'GD', 'GRD', 'GJ', 'NA', '+1-473', '', 'en-GD', 34, '2017-07-18 23:00:00', NULL, NULL),
(91, 'Guadeloupe', 'Guadeloupe', 'GP', 'GLP', 'GP', 'NA', '590', '^((97)|(98)d{3})$', 'fr-GP', 11, '2017-07-18 23:00:00', NULL, NULL),
(92, 'Guam', 'Guam', 'GU', 'GUM', 'GQ', 'OC', '+1-671', '^(969d{2})$', 'en-GU,ch-GU', 2, '2017-07-18 23:00:00', NULL, NULL),
(93, 'Guatemala', 'Guatemala', 'GT', 'GTM', 'GT', 'NA', '502', '^(d{5})$', 'es-GT', 45, '2017-07-18 23:00:00', NULL, NULL),
(94, 'Guinea', 'Guinée', 'GN', 'GIN', 'GV', 'AF', '224', '', 'fr-GN', 148, '2017-07-18 23:00:00', NULL, NULL),
(95, 'Guyana', 'Guyana', 'GY', 'GUY', 'GY', 'SA', '592', '', 'en-GY', 47, '2017-07-18 23:00:00', NULL, NULL),
(96, 'Haiti', 'Haïti', 'HT', 'HTI', 'HA', 'NA', '509', '^(?:HT)*(d{4})$', 'ht,fr-HT', 149, '2017-07-18 23:00:00', NULL, NULL),
(97, 'Heard Island and McDonald Islands', 'Îles Heard et Mcdonald', 'HM', 'HMD', 'HM', 'AN', ' ', '', '', 6, '2017-07-18 23:00:00', NULL, NULL),
(98, 'Vatican', 'Saint-Siège (état de la Cité du Vatican)', 'VA', 'VAT', 'VT', 'EU', '379', '', 'la,it,fr', 11, '2017-07-18 23:00:00', NULL, NULL),
(99, 'Honduras', 'Honduras', 'HN', 'HND', 'HO', 'NA', '504', '^([A-Z]{2}d{4})$', 'es-HN', 49, '2017-07-18 23:00:00', NULL, NULL),
(100, 'Hong Kong', 'Hong-Kong', 'HK', 'HKG', 'HK', 'AS', '852', '', 'zh-HK,yue,zh,en', 50, '2017-07-18 23:00:00', NULL, NULL),
(101, 'Hungary', 'Hongrie', 'HU', 'HUN', 'HU', 'EU', '36', '^(d{4})$', 'hu-HU', 51, '2017-07-18 23:00:00', NULL, NULL),
(102, 'Iceland', 'Islande', 'IS', 'ISL', 'IC', 'EU', '354', '^(d{3})$', 'is,en,de,da,sv,no', 52, '2017-07-18 23:00:00', NULL, NULL),
(103, 'India', 'Inde', 'IN', 'IND', 'IN', 'AS', '91', '^(d{6})$', 'en-IN,hi,bn,te,mr,ta,ur,gu,ml,kn,or,pa,as,ks,', 53, '2017-07-18 23:00:00', NULL, NULL),
(104, 'Indonesia', 'Indonésie', 'ID', 'IDN', 'ID', 'AS', '62', '^(d{5})$', 'id,en,nl,jv', 54, '2017-07-18 23:00:00', NULL, NULL),
(105, 'Iran', 'République Islamique d Iran', 'IR', 'IRN', 'IR', 'AS', '98', '^(d{10})$', 'fa-IR,ku', 55, '2017-07-18 23:00:00', NULL, NULL),
(106, 'Iraq', 'Iraq', 'IQ', 'IRQ', 'IZ', 'AS', '964', '^(d{5})$', 'ar-IQ,ku,hy', 150, '2017-07-18 23:00:00', NULL, NULL),
(107, 'Ireland', 'Irlande', 'IE', 'IRL', 'EI', 'EU', '353', '', 'en-IE,ga-IE', 11, '2017-07-18 23:00:00', NULL, NULL),
(108, 'Israel', 'Israël', 'IL', 'ISR', 'IS', 'AS', '972', '^(d{5})$', 'he,ar-IL,en-IL,', 58, '2017-07-18 23:00:00', NULL, NULL),
(109, 'Italy', 'Italie', 'IT', 'ITA', 'IT', 'EU', '39', '^(d{5})$', 'it-IT,de-IT,fr-IT,sl', 11, '2017-07-18 23:00:00', NULL, NULL),
(110, 'Ivory Coast', 'Côte d Ivoire', 'CI', 'CIV', 'IV', 'AF', '225', '', 'fr-CI', 179, '2017-07-18 23:00:00', NULL, NULL),
(111, 'Jamaica', 'Jamaïque', 'JM', 'JAM', 'JM', 'NA', '+1-876', '', 'en-JM', 60, '2017-07-18 23:00:00', NULL, NULL),
(112, 'Japan', 'Japon', 'JP', 'JPN', 'JA', 'AS', '81', '^(d{7})$', 'ja', 61, '2017-07-18 23:00:00', NULL, NULL),
(113, 'Kazakhstan', 'Kazakhstan', 'KZ', 'KAZ', 'KZ', 'AS', '7', '^(d{6})$', 'kk,ru', 63, '2017-07-18 23:00:00', NULL, NULL),
(114, 'Jordan', 'Jordanie', 'JO', 'JOR', 'JO', 'AS', '962', '^(d{5})$', 'ar-JO,en', 151, '2017-07-18 23:00:00', NULL, NULL),
(115, 'Kenya', 'Kenya', 'KE', 'KEN', 'KE', 'AF', '254', '^(d{5})$', 'en-KE,sw-KE', 152, '2017-07-18 23:00:00', NULL, NULL),
(116, 'North Korea', 'République Populaire Démocratique de Corée', 'KP', 'PRK', 'KN', 'AS', '850', '^(d{6})$', 'ko-KP', 64, '2017-07-18 23:00:00', NULL, NULL),
(117, 'South Korea', 'République de Corée', 'KR', 'KOR', 'KS', 'AS', '82', '^(?:SEOUL)*(d{6})$', 'ko-KR,en', 65, '2017-07-18 23:00:00', NULL, NULL),
(118, 'Kuwait', 'Koweït', 'KW', 'KWT', 'KU', 'AS', '965', '^(d{5})$', 'ar-KW,en', 154, '2017-07-18 23:00:00', NULL, NULL),
(119, 'Kyrgyzstan', 'Kirghizistan', 'KG', 'KGZ', 'KG', 'AS', '996', '^(d{6})$', 'ky,uz,ru', 66, '2017-07-18 23:00:00', NULL, NULL),
(120, 'Laos', 'République Démocratique Populaire Lao', 'LA', 'LAO', 'LA', 'AS', '856', '^(d{5})$', 'lo,fr,en', 67, '2017-07-18 23:00:00', NULL, NULL),
(121, 'Lebanon', 'Liban', 'LB', 'LBN', 'LE', 'AS', '961', '^(d{4}(d{4})?)$', 'ar-LB,fr-LB,en,hy', 69, '2017-07-18 23:00:00', NULL, NULL),
(122, 'Lesotho', 'Lesotho', 'LS', 'LSO', 'LT', 'AF', '266', '^(d{3})$', 'en-LS,st,zu,xh', 155, '2017-07-18 23:00:00', NULL, NULL),
(123, 'Latvia', 'Lettonie', 'LV', 'LVA', 'LG', 'EU', '371', '^(?:LV)*(d{4})$', 'lv,ru,lt', 68, '2017-07-18 23:00:00', NULL, NULL),
(124, 'Liberia', 'Libéria', 'LR', 'LBR', 'LI', 'AF', '231', '^(d{4})$', 'en-LR', 70, '2017-07-18 23:00:00', NULL, NULL),
(125, 'Libya', 'Jamahiriya Arabe Libyenne', 'LY', 'LBY', 'LY', 'AF', '218', '', 'ar-LY,it,en', 156, '2017-07-18 23:00:00', NULL, NULL),
(126, 'Liechtenstein', 'Liechtenstein', 'LI', 'LIE', 'LS', 'EU', '423', '^(d{4})$', 'de-LI', 71, '2017-07-18 23:00:00', NULL, NULL),
(127, 'Lithuania', 'Lituanie', 'LT', 'LTU', 'LH', 'EU', '370', '^(?:LT)*(d{5})$', 'lt,ru,pl', 72, '2017-07-18 23:00:00', NULL, NULL),
(128, 'Luxembourg', 'Luxembourg', 'LU', 'LUX', 'LU', 'EU', '352', '^(d{4})$', 'lb,de-LU,fr-LU', 11, '2017-07-18 23:00:00', NULL, NULL),
(129, 'Macao', 'Macao', 'MO', 'MAC', 'MC', 'AS', '853', '', 'zh,zh-MO', 159, '2017-07-18 23:00:00', NULL, NULL),
(130, 'Madagascar', 'Madagascar', 'MG', 'MDG', 'MA', 'AF', '261', '^(d{3})$', 'fr-MG,mg', 113, '2017-07-18 23:00:00', NULL, NULL),
(131, 'Malawi', 'Malawi', 'MW', 'MWI', 'MI', 'AF', '265', '', 'ny,yao,tum,swk', 161, '2017-07-18 23:00:00', NULL, NULL),
(132, 'Malaysia', 'Malaisie', 'MY', 'MYS', 'MY', 'AS', '60', '^(d{5})$', 'ms-MY,en,zh,ta,te,ml,pa,th', 75, '2017-07-18 23:00:00', NULL, NULL),
(133, 'Maldives', 'Maldives', 'MV', 'MDV', 'MV', 'AS', '960', '^(d{5})$', 'dv,en', 162, '2017-07-18 23:00:00', NULL, NULL),
(134, 'Mali', 'Mali', 'ML', 'MLI', 'ML', 'AF', '223', '', 'fr-ML,bm', 179, '2017-07-18 23:00:00', NULL, NULL),
(135, 'Malta', 'Malte', 'MT', 'MLT', 'MT', 'EU', '356', '^([A-Z]{3}d{2}d?)$', 'mt,en-MT', 11, '2017-07-18 23:00:00', NULL, NULL),
(136, 'Martinique', 'Martinique', 'MQ', 'MTQ', 'MB', 'NA', '596', '^(d{5})$', 'fr-MQ', 11, '2017-07-18 23:00:00', NULL, NULL),
(137, 'Mauritania', 'Mauritanie', 'MR', 'MRT', 'MR', 'AF', '222', '', 'ar-MR,fuc,snk,fr,mey,wo', 160, '2017-07-18 23:00:00', NULL, NULL),
(138, 'Mauritius', 'Maurice', 'MU', 'MUS', 'MP', 'AF', '230', '', 'en-MU,bho,fr', 77, '2017-07-18 23:00:00', NULL, NULL),
(139, 'Mexico', 'Mexique', 'MX', 'MEX', 'MX', 'NA', '52', '^(d{5})$', 'es-MX', 78, '2017-07-18 23:00:00', NULL, NULL),
(140, 'Monaco', 'Monaco', 'MC', 'MCO', 'MN', 'EU', '377', '^(d{5})$', 'fr-MC,en,it', 11, '2017-07-18 23:00:00', NULL, NULL),
(141, 'Mongolia', 'Mongolie', 'MN', 'MNG', 'MG', 'AS', '976', '^(d{6})$', 'mn,ru', 79, '2017-07-18 23:00:00', NULL, NULL),
(142, 'Moldova', 'République de Moldova', 'MD', 'MDA', 'MD', 'EU', '373', '^(?:MD)*(d{4})$', 'ro,ru,gag,tr', 158, '2017-07-18 23:00:00', NULL, NULL),
(143, 'Montenegro', 'Monténégro', 'ME', 'MNE', 'MJ', 'EU', '381', '^(d{5})$', 'sr,hu,bs,sq,hr,rom', 11, '2017-07-18 23:00:00', NULL, NULL),
(144, 'Montserrat', 'Montserrat', 'MS', 'MSR', 'MH', 'NA', '+1-664', '', 'en-MS', 34, '2017-07-18 23:00:00', NULL, NULL),
(145, 'Morocco', 'Maroc', 'MA', 'MAR', 'MO', 'AF', '212', '^(d{5})$', 'ar-MA,fr', 157, '2017-07-18 23:00:00', NULL, NULL),
(146, 'Mozambique', 'Mozambique', 'MZ', 'MOZ', 'MZ', 'AF', '258', '^(d{4})$', 'pt-MZ,vmw', 80, '2017-07-18 23:00:00', NULL, NULL),
(147, 'Oman', 'Oman', 'OM', 'OMN', 'MU', 'AS', '968', '^(d{3})$', 'ar-OM,en,bal,ur', 90, '2017-07-18 23:00:00', NULL, NULL),
(148, 'Namibia', 'Namibie', 'NA', 'NAM', 'WA', 'AF', '264', '', 'en-NA,af,de,hz,naq', 81, '2017-07-18 23:00:00', NULL, NULL),
(149, 'Nauru', 'Nauru', 'NR', 'NRU', 'NR', 'OC', '674', '', 'na,en-NR', 6, '2017-07-18 23:00:00', NULL, NULL),
(150, 'Nepal', 'Népal', 'NP', 'NPL', 'NP', 'AS', '977', '^(d{5})$', 'ne,en', 82, '2017-07-18 23:00:00', NULL, NULL),
(151, 'Netherlands', 'Pays-Bas', 'NL', 'NLD', 'NL', 'EU', '31', '^(d{4}[A-Z]{2})$', 'nl-NL,fy-NL', 11, '2017-07-18 23:00:00', NULL, NULL),
(152, 'Netherlands Antilles', 'Antilles Néerlandaises', 'AN', 'ANT', 'NT', 'NA', '599', '', 'nl-AN,en,es', 83, '2017-07-18 23:00:00', NULL, NULL),
(153, 'Aruba', 'Aruba', 'AW', 'ABW', 'AA', 'NA', '297', '', 'nl-AW,es,en', 5, '2017-07-18 23:00:00', NULL, NULL),
(154, 'New Caledonia', 'Nouvelle-Calédonie', 'NC', 'NCL', 'NC', 'OC', '687', '^(d{5})$', 'fr-NC', 180, '2017-07-18 23:00:00', NULL, NULL),
(155, 'Vanuatu', 'Vanuatu', 'VU', 'VUT', 'NH', 'OC', '678', '', 'bi,en-VU,fr-VU', 176, '2017-07-18 23:00:00', NULL, NULL),
(156, 'New Zealand', 'Nouvelle-Zélande', 'NZ', 'NZL', 'NZ', 'OC', '64', '^(d{4})$', 'en-NZ,mi', 85, '2017-07-18 23:00:00', NULL, NULL),
(157, 'Nicaragua', 'Nicaragua', 'NI', 'NIC', 'NU', 'NA', '505', '^(d{7})$', 'es-NI,en', 86, '2017-07-18 23:00:00', NULL, NULL),
(158, 'Niger', 'Niger', 'NE', 'NER', 'NG', 'AF', '227', '^(d{4})$', 'fr-NE,ha,kr,dje', 179, '2017-07-18 23:00:00', NULL, NULL),
(159, 'Nigeria', 'Nigéria', 'NG', 'NGA', 'NI', 'AF', '234', '^(d{6})$', 'en-NG,ha,yo,ig,ff', 87, '2017-07-18 23:00:00', NULL, NULL),
(160, 'Niue', 'Niué', 'NU', 'NIU', 'NE', 'OC', '683', '', 'niu,en-NU', 85, '2017-07-18 23:00:00', NULL, NULL),
(161, 'Norfolk Island', 'Île Norfolk', 'NF', 'NFK', 'NF', 'OC', '672', '', 'en-NF', 6, '2017-07-18 23:00:00', NULL, NULL),
(162, 'Norway', 'Norvège', 'NO', 'NOR', 'NO', 'EU', '47', '^(d{4})$', 'no,nb,nn', 89, '2017-07-18 23:00:00', NULL, NULL),
(163, 'Northern Mariana Islands', 'Îles Mariannes du Nord', 'MP', 'MNP', 'CQ', 'OC', '+1-670', '', 'fil,tl,zh,ch-MP,en-MP', 2, '2017-07-18 23:00:00', NULL, NULL),
(164, 'United States Minor Outlying Islands', 'Îles Mineures Éloignées des États-Unis', 'UM', 'UMI', '', 'OC', '', '', 'en-UM', 2, '2017-07-18 23:00:00', NULL, NULL),
(165, 'Micronesia', 'États Fédérés de Micronésie', 'FM', 'FSM', 'FM', 'OC', '691', '^(d{5})$', 'en-FM,chk,pon,yap,kos,uli,woe,nkr,kpg', 2, '2017-07-18 23:00:00', NULL, NULL),
(166, 'Marshall Islands', 'Îles Marshall', 'MH', 'MHL', 'RM', 'OC', '692', '', 'mh,en-MH', 2, '2017-07-18 23:00:00', NULL, NULL),
(167, 'Palau', 'Palaos', 'PW', 'PLW', 'PS', 'OC', '680', '^(96940)$', 'pau,sov,en-PW,tox,ja,fil,zh', 2, '2017-07-18 23:00:00', NULL, NULL),
(168, 'Pakistan', 'Pakistan', 'PK', 'PAK', 'PK', 'AS', '92', '^(d{5})$', 'ur-PK,en-PK,pa,sd,ps,brh', 91, '2017-07-18 23:00:00', NULL, NULL),
(169, 'Panama', 'Panama', 'PA', 'PAN', 'PM', 'NA', '507', '', 'es-PA,en', 92, '2017-07-18 23:00:00', NULL, NULL),
(170, 'Papua New Guinea', 'Papouasie-Nouvelle-Guinée', 'PG', 'PNG', 'PP', 'OC', '675', '^(d{3})$', 'en-PG,ho,meu,tpi', 163, '2017-07-18 23:00:00', NULL, NULL),
(171, 'Paraguay', 'Paraguay', 'PY', 'PRY', 'PA', 'SA', '595', '^(d{4})$', 'es-PY,gn', 93, '2017-07-18 23:00:00', NULL, NULL),
(172, 'Peru', 'Pérou', 'PE', 'PER', 'PE', 'SA', '51', '', 'es-PE,qu,ay', 94, '2017-07-18 23:00:00', NULL, NULL),
(173, 'Philippines', 'Philippines', 'PH', 'PHL', 'RP', 'AS', '63', '^(d{4})$', 'tl,en-PH,fil', 95, '2017-07-18 23:00:00', NULL, NULL),
(174, 'Pitcairn', 'Pitcairn', 'PN', 'PCN', 'PC', 'OC', '', '', 'en-PN', 85, '2017-07-18 23:00:00', NULL, NULL),
(175, 'Poland', 'Pologne', 'PL', 'POL', 'PL', 'EU', '48', '^(d{5})$', 'pl', 96, '2017-07-18 23:00:00', NULL, NULL),
(176, 'Portugal', 'Portugal', 'PT', 'PRT', 'PO', 'EU', '351', '^(d{7})$', 'pt-PT,mwl', 11, '2017-07-18 23:00:00', NULL, NULL),
(177, 'Guinea-Bissau', 'Guinée-Bissau', 'GW', 'GNB', 'PU', 'AF', '245', '^(d{4})$', 'pt-GW,pov', 179, '2017-07-18 23:00:00', NULL, NULL),
(178, 'East Timor', 'Timor-Leste', 'TL', 'TLS', 'TT', 'OC', '670', '', 'tet,pt-TL,id,en', 2, '2017-07-18 23:00:00', NULL, NULL),
(179, 'Puerto Rico', 'Porto Rico', 'PR', 'PRI', 'RQ', 'NA', '+1-787 and 1-939', '^(d{9})$', 'en-PR,es-PR', 2, '2017-07-18 23:00:00', NULL, NULL),
(180, 'Qatar', 'Qatar', 'QA', 'QAT', 'QA', 'AS', '974', '', 'ar-QA,es', 97, '2017-07-18 23:00:00', NULL, NULL),
(181, 'Reunion', 'Réunion', 'RE', 'REU', 'RE', 'AF', '262', '^((97)|(98)(4|7|8)d{2})$', 'fr-RE', 11, '2017-07-18 23:00:00', NULL, NULL),
(182, 'Romania', 'Roumanie', 'RO', 'ROU', 'RO', 'EU', '40', '^(d{6})$', 'ro,hu,rom', 98, '2017-07-18 23:00:00', NULL, NULL),
(183, 'Russia', 'Fédération de Russie', 'RU', 'RUS', 'RS', 'EU', '7', '^(d{6})$', 'ru-RU', 99, '2017-07-18 23:00:00', NULL, NULL),
(184, 'Rwanda', 'Rwanda', 'RW', 'RWA', 'RW', 'AF', '250', '', 'rw,en-RW,fr-RW,sw', 164, '2017-07-18 23:00:00', NULL, NULL),
(185, 'Saint Barthelemy', 'Saint Barthélemy', 'BL', 'BLM', 'TB', 'NA', '590', '', 'fr', 11, '2017-07-18 23:00:00', NULL, NULL),
(186, 'Saint Helena', 'Sainte-Hélène', 'SH', 'SHN', 'SH', 'AF', '290', '^(STHL1ZZ)$', 'en-SH', 100, '2017-07-18 23:00:00', NULL, NULL),
(187, 'Saint Kitts and Nevis', 'Saint-Kitts-et-Nevis', 'KN', 'KNA', 'SC', 'NA', '+1-869', '', 'en-KN', 34, '2017-07-18 23:00:00', NULL, NULL),
(188, 'Anguilla', 'Anguilla', 'AI', 'AIA', 'AV', 'NA', '+1-264', '', 'en-AI', 34, '2017-07-18 23:00:00', NULL, NULL),
(189, 'Saint Lucia', 'Sainte-Lucie', 'LC', 'LCA', 'ST', 'NA', '+1-758', '', 'en-LC', 34, '2017-07-18 23:00:00', NULL, NULL),
(190, 'Saint Martin', 'Saint Martin', 'MF', 'MAF', 'RN', 'NA', '590', '', 'fr', 11, '2017-07-18 23:00:00', NULL, NULL),
(191, 'Saint Pierre and Miquelon', 'Saint-Pierre-et-Miquelon', 'PM', 'SPM', 'SB', 'NA', '508', '^(97500)$', 'fr-PM', 11, '2017-07-18 23:00:00', NULL, NULL),
(192, 'Saint Vincent and the Grenadines', 'Saint-Vincent-et-les Grenadines', 'VC', 'VCT', 'VC', 'NA', '+1-784', '', 'en-VC,fr', 34, '2017-07-18 23:00:00', NULL, NULL),
(193, 'San Marino', 'Saint-Marin', 'SM', 'SMR', 'SM', 'EU', '378', '^(4789d)$', 'it-SM', 11, '2017-07-18 23:00:00', NULL, NULL),
(194, 'Sao Tome and Principe', 'Sao Tomé-et-Principe', 'ST', 'STP', 'TP', 'AF', '239', '', 'pt-ST', 167, '2017-07-18 23:00:00', NULL, NULL),
(195, 'Saudi Arabia', 'Arabie Saoudite', 'SA', 'SAU', 'SA', 'AS', '966', '^(d{5})$', 'ar-SA', 101, '2017-07-18 23:00:00', NULL, NULL),
(196, 'Senegal', 'Sénégal', 'SN', 'SEN', 'SG', 'AF', '221', '^(d{5})$', 'fr-SN,wo,fuc,mnk', 179, '2017-07-18 23:00:00', NULL, NULL),
(197, 'Serbia', 'Serbie', 'RS', 'SRB', 'RB', 'EU', '381', '^(d{6})$', 'sr,hu,bs,rom', 102, '2017-07-18 23:00:00', NULL, NULL),
(198, 'Seychelles', 'Seychelles', 'SC', 'SYC', 'SE', 'AF', '248', '', 'en-SC,fr-SC', 103, '2017-07-18 23:00:00', NULL, NULL),
(199, 'Sierra Leone', 'Sierra Leone', 'SL', 'SLE', 'SL', 'AF', '232', '', 'en-SL,men,tem', 166, '2017-07-18 23:00:00', NULL, NULL),
(200, 'Singapore', 'Singapour', 'SG', 'SGP', 'SN', 'AS', '65', '^(d{6})$', 'cmn,en-SG,ms-SG,ta-SG,zh-SG', 104, '2017-07-18 23:00:00', NULL, NULL),
(201, 'Slovakia', 'Slovaquie', 'SK', 'SVK', 'LO', 'EU', '421', '^(d{5})$', 'sk,hu', 11, '2017-07-18 23:00:00', NULL, NULL),
(202, 'Vietnam', 'Viet Nam', 'VN', 'VNM', 'VM', 'AS', '84', '^(d{6})$', 'vi,en,fr,zh,km', 129, '2017-07-18 23:00:00', NULL, NULL),
(203, 'Slovenia', 'Slovénie', 'SI', 'SVN', 'SI', 'EU', '386', '^(?:SI)*(d{4})$', 'sl,sh', 11, '2017-07-18 23:00:00', NULL, NULL),
(204, 'Somalia', 'Somalie', 'SO', 'SOM', 'SO', 'AF', '252', '^([A-Z]{2}d{5})$', 'so-SO,ar-SO,it,en-SO', 107, '2017-07-18 23:00:00', NULL, NULL),
(205, 'South Africa', 'Afrique du Sud', 'ZA', 'ZAF', 'SF', 'AF', '27', '^(d{4})$', 'zu,xh,af,nso,en-ZA,tn,st,ts', 108, '2017-07-18 23:00:00', NULL, NULL),
(206, 'Zimbabwe', 'Zimbabwe', 'ZW', 'ZWE', 'ZI', 'AF', '263', '', 'en-ZW,sn,nr,nd', 182, '2017-07-18 23:00:00', NULL, NULL),
(207, 'Spain', 'Espagne', 'ES', 'ESP', 'SP', 'EU', '34', '^(d{5})$', 'es-ES,ca,gl,eu', 11, '2017-07-18 23:00:00', NULL, NULL),
(208, 'Western Sahara', 'Sahara Occidental', 'EH', 'ESH', 'WI', 'AF', '212', '', 'ar,mey', 157, '2017-07-18 23:00:00', NULL, NULL),
(209, 'Sudan', 'Soudan', 'SD', 'SDN', 'SU', 'AF', '249', '^(d{5})$', 'ar-SD,en,fia', 165, '2017-07-18 23:00:00', NULL, NULL),
(210, 'Suriname', 'Suriname', 'SR', 'SUR', 'NS', 'SA', '597', '', 'nl-SR,en,srn,hns,jv', 114, '2017-07-18 23:00:00', NULL, NULL),
(211, 'Svalbard and Jan Mayen', 'Svalbard etÎle Jan Mayen', 'SJ', 'SJM', 'SV', 'EU', '47', '', 'no,ru', 89, '2017-07-18 23:00:00', NULL, NULL),
(212, 'Swaziland', 'Swaziland', 'SZ', 'SWZ', 'WZ', 'AF', '268', '^([A-Z]d{3})$', 'en-SZ,ss-SZ', 168, '2017-07-18 23:00:00', NULL, NULL),
(213, 'Sweden', 'Suède', 'SE', 'SWE', 'SW', 'EU', '46', '^(?:SE)*(d{5})$', 'sv-SE,se,sma,fi-SE', 112, '2017-07-18 23:00:00', NULL, NULL),
(214, 'Switzerland', 'Suisse', 'CH', 'CHE', 'SZ', 'EU', '41', '^(d{4})$', 'de-CH,fr-CH,it-CH,rm', 71, '2017-07-18 23:00:00', NULL, NULL),
(215, 'Syria', 'République Arabe Syrienne', 'SY', 'SYR', 'SY', 'AS', '963', '', 'ar-SY,ku,hy,arc,fr,en', 115, '2017-07-18 23:00:00', NULL, NULL),
(216, 'Tajikistan', 'Tadjikistan', 'TJ', 'TJK', 'TI', 'AS', '992', '^(d{6})$', 'tg,ru', 169, '2017-07-18 23:00:00', NULL, NULL),
(217, 'Thailand', 'Thaïlande', 'TH', 'THA', 'TH', 'AS', '66', '^(d{5})$', 'th,en', 117, '2017-07-18 23:00:00', NULL, NULL),
(218, 'Togo', 'Togo', 'TG', 'TGO', 'TO', 'AF', '228', '', 'fr-TG,ee,hna,kbp,dag,ha', 179, '2017-07-18 23:00:00', NULL, NULL),
(219, 'Tokelau', 'Tokelau', 'TK', 'TKL', 'TL', 'OC', '690', '', 'tkl,en-TK', 85, '2017-07-18 23:00:00', NULL, NULL),
(220, 'Tonga', 'Tonga', 'TO', 'TON', 'TN', 'OC', '676', '', 'to,en-TO', 172, '2017-07-18 23:00:00', NULL, NULL),
(221, 'Trinidad and Tobago', 'Trinité-et-Tobago', 'TT', 'TTO', 'TD', 'NA', '+1-868', '', 'en-TT,hns,fr,es,zh', 118, '2017-07-18 23:00:00', NULL, NULL),
(222, 'United Arab Emirates', 'Émirats Arabes Unis', 'AE', 'ARE', 'AE', 'AS', '971', '', 'ar-AE,fa,en,hi,ur', 132, '2017-07-18 23:00:00', NULL, NULL),
(223, 'Tunisia', 'Tunisie', 'TN', 'TUN', 'TS', 'AF', '216', '^(d{4})$', 'ar-TN,fr', 171, '2017-07-18 23:00:00', NULL, NULL),
(224, 'Turkey', 'Turquie', 'TR', 'TUR', 'TU', 'AS', '90', '^(d{5})$', 'tr-TR,ku,diq,az,av', 119, '2017-07-18 23:00:00', NULL, NULL),
(225, 'Turkmenistan', 'Turkménistan', 'TM', 'TKM', 'TX', 'AS', '993', '^(d{6})$', 'tk,ru,uz', 170, '2017-07-18 23:00:00', NULL, NULL),
(226, 'Turks and Caicos Islands', 'Îles Turks et Caïques', 'TC', 'TCA', 'TK', 'NA', '+1-649', '^(TKCA 1ZZ)$', 'en-TC', 2, '2017-07-18 23:00:00', NULL, NULL),
(227, 'Tuvalu', 'Tuvalu', 'TV', 'TUV', 'TV', 'OC', '688', '', 'tvl,en,sm,gil', 6, '2017-07-18 23:00:00', NULL, NULL),
(228, 'Uganda', 'Ouganda', 'UG', 'UGA', 'UG', 'AF', '256', '', 'en-UG,lg,sw,ar', 175, '2017-07-18 23:00:00', NULL, NULL),
(229, 'Ukraine', 'Ukraine', 'UA', 'UKR', 'UP', 'EU', '380', '^(d{5})$', 'uk,ru-UA,rom,pl,hu', 122, '2017-07-18 23:00:00', NULL, NULL),
(230, 'Macedonia', 'L ex-République Yougoslave de Macédoine', 'MK', 'MKD', 'MK', 'EU', '389', '^(d{4})$', 'mk,sq,tr,rmm,sr', 74, '2017-07-18 23:00:00', NULL, NULL),
(231, 'Egypt', 'Égypte', 'EG', 'EGY', 'EG', 'AF', '20', '^(d{5})$', 'ar-EG,en,fr', 35, '2017-07-18 23:00:00', NULL, NULL),
(232, 'United Kingdom', 'Royaume-Uni', 'GB', 'GBR', 'UK', 'EU', '44', '^(([A-Z]d{2}[A-Z]{2})|([A-Z]d{3}[A-Z]{2})|([A', 'en-GB,cy-GB,gd', 19, '2017-07-18 23:00:00', NULL, NULL),
(233, 'Guernsey', 'Guernsey', 'GG', 'GGY', 'GK', 'EU', '+44-1481', '^(([A-Z]d{2}[A-Z]{2})|([A-Z]d{3}[A-Z]{2})|([A', 'en,fr', 19, '2017-07-18 23:00:00', NULL, NULL),
(234, 'Jersey', 'Jersey', 'JE', 'JEY', 'JE', 'EU', '+44-1534', '^(([A-Z]d{2}[A-Z]{2})|([A-Z]d{3}[A-Z]{2})|([A', 'en,pt', 19, '2017-07-18 23:00:00', NULL, NULL),
(235, 'Isle of Man', 'Île de Man', 'IM', 'IMN', 'IM', 'EU', '+44-1624', '^(([A-Z]d{2}[A-Z]{2})|([A-Z]d{3}[A-Z]{2})|([A', 'en,gv', 19, '2017-07-18 23:00:00', NULL, NULL),
(236, 'Tanzania', 'République-Unie de Tanzanie', 'TZ', 'TZA', 'TZ', 'AF', '255', '', 'sw-TZ,en,ar', 174, '2017-07-18 23:00:00', NULL, NULL),
(237, 'United States', 'États-Unis', 'US', 'USA', 'US', 'NA', '1', '^(d{9})$', 'en-US,es-US,haw', 2, '2017-07-18 23:00:00', NULL, NULL),
(238, 'U.S. Virgin Islands', 'Îles Vierges des États-Unis', 'VI', 'VIR', 'VQ', 'NA', '+1-340', '', 'en-VI', 2, '2017-07-18 23:00:00', NULL, NULL),
(239, 'Burkina Faso', 'Burkina Faso', 'BF', 'BFA', 'UV', 'AF', '226', '', 'fr-BF', 179, '2017-07-18 23:00:00', NULL, NULL),
(240, 'Kosovo', 'Kosovo', 'XK', 'XKX', 'KV', 'EU', '', '', 'sq,sr', 11, '2017-07-18 23:00:00', NULL, NULL),
(241, 'Uruguay', 'Uruguay', 'UY', 'URY', 'UY', 'SA', '598', '^(d{5})$', 'es-UY', 125, '2017-07-18 23:00:00', NULL, NULL),
(242, 'Uzbekistan', 'Ouzbékistan', 'UZ', 'UZB', 'UZ', 'AS', '998', '^(d{6})$', 'uz,ru,tg', 126, '2017-07-18 23:00:00', NULL, NULL),
(243, 'Venezuela', 'Venezuela', 'VE', 'VEN', 'VE', 'SA', '58', '^(d{4})$', 'es-VE', 128, '2017-07-18 23:00:00', NULL, NULL),
(244, 'Wallis and Futuna', 'Wallis et Futuna', 'WF', 'WLF', 'WF', 'OC', '681', '^(986d{2})$', 'wls,fud,fr-WF', 180, '2017-07-18 23:00:00', NULL, NULL),
(245, 'Samoa', 'Samoa', 'WS', 'WSM', 'WS', 'OC', '685', '', 'sm,en-WS', 177, '2017-07-18 23:00:00', NULL, NULL),
(246, 'Yemen', 'Yémen', 'YE', 'YEM', 'YM', 'AS', '967', '', 'ar-YE', 130, '2017-07-18 23:00:00', NULL, NULL),
(247, 'Serbia and Montenegro', 'Serbie-et-Monténégro', 'CS', 'SCG', 'YI', 'EU', '381', '^(d{5})$', 'cu,hu,sq,sr', 102, '2017-07-18 23:00:00', NULL, NULL),
(248, 'Zambia', 'Zambie', 'ZM', 'ZMB', 'ZA', 'AF', '260', '^(d{5})$', 'en-ZM,bem,loz,lun,lue,ny,toi', 181, '2017-07-18 23:00:00', NULL, NULL);
--
-- Structure de la table `APP_EXERCICE`
--

CREATE TABLE IF NOT EXISTS `APP_EXERCICE` (
  `EXERCICE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `LEVEL` varchar(255) NOT NULL,
  `URL` varchar(255) NOT NULL,
  `URL_CALLBACK` varchar(255) NOT NULL,
  `Status` enum('ACTIF','INACTIF','DRAFT','') NOT NULL,
  `USER_EXECICE_ID_FK` bigint(20) NOT NULL,
  `PICTURE_ID_FK` bigint(20) NOT NULL,
  `EXERCICE_FILE_ID_FK` bigint(20) NOT NULL,
  `CATEGORY_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`EXERCICE_ID`),
  KEY `USER_EXECICE_ID_FK` (`USER_EXECICE_ID_FK`,`PICTURE_ID_FK`,`EXERCICE_FILE_ID_FK`,`CATEGORY_ID_FK`),
  KEY `PICTURE_ID_FK` (`PICTURE_ID_FK`),
  KEY `CATEGORY_ID_FK` (`CATEGORY_ID_FK`),
  KEY `PICTURE_ID_FK_2` (`PICTURE_ID_FK`),
  KEY `EXERCICE_FILE_ID_FK` (`EXERCICE_FILE_ID_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `APP_FAMILY`
--

CREATE TABLE IF NOT EXISTS `APP_FAMILY` (
  `FAMILY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FAMILY_NAME` varchar(255) NOT NULL,
  `ADRESS` varchar(100) NOT NULL,
  `COUNTRY_ID_FK` bigint(20) NOT NULL,
  `PHONE` varchar(50) NOT NULL,
  `MANAGER_USER_ID_FK` bigint(20) NOT NULL,
  `LOGO_FILE_ID_FK` bigint(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL,
  `UPDATING_DATE` timestamp NOT NULL,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`FAMILY_ID`),
  KEY `MANAGER_USER_ID_FK` (`MANAGER_USER_ID_FK`),
  KEY `LOGO_FILE_ID_FK` (`LOGO_FILE_ID_FK`),
  KEY `COUNTRY` (`COUNTRY_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;



--
-- Structure de la table `APP_FAMILY_MEMBER`
--

CREATE TABLE IF NOT EXISTS `APP_FAMILY_MEMBER` (
  `FAMILY_MEMBER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE` enum('CHILD','PARENT') NOT NULL,
  `USER_ID_FK` bigint(20) NOT NULL,
  `FAMILY_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL,
  `UPDATING_DATE` timestamp NOT NULL,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`FAMILY_MEMBER_ID`),
  KEY `USER_ID_FK` (`USER_ID_FK`),
  KEY `FAMILY_ID_FK` (`FAMILY_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;



--
-- Structure de la table `APP_FILE`
--

CREATE TABLE IF NOT EXISTS `APP_FILE` (
  `FILE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(255) NOT NULL,
  `PATH` varchar(255) NOT NULL,
  `USER_FILE_ID_FK` bigint(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`FILE_ID`),
  KEY `USER_ID_FK` (`USER_FILE_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;



--
-- Structure de la table `APP_HISTORY`
--

CREATE TABLE IF NOT EXISTS `APP_HISTORY` (
  `HISTORY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SCORE` int(11) NOT NULL,
  `USER_ID_FK` bigint(20) NOT NULL,
  `EXERCICE_ID_FK` bigint(20) NOT NULL,
  `Status` enum('PLANED','STARTED','HOLD','CLOSE') NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`HISTORY_ID`),
  KEY `USER_ID_FK` (`USER_ID_FK`,`EXERCICE_ID_FK`),
  KEY `EXERCICE_ID_FK` (`EXERCICE_ID_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `APP_REVIEWS`
--

CREATE TABLE IF NOT EXISTS `APP_REVIEWS` (
  `REVIEWS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SCORE` int(1) NOT NULL,
  `USER_ID_FK` bigint(20) NOT NULL,
  `EXERCICE_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`REVIEWS_ID`),
  KEY `USER_ID_FK` (`USER_ID_FK`,`EXERCICE_ID_FK`),
  KEY `EXERCICE_ID_FK` (`EXERCICE_ID_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `APP_ROLE`
--

CREATE TABLE IF NOT EXISTS `APP_ROLE` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20) NOT NULL,
  `ROLE` enum('ADMIN','USER') NOT NULL,
  `CREATION_DATE` timestamp NOT NULL,
  `UPDATING_DATE` timestamp NOT NULL,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `uni_username_role` (`ROLE`,`USER_ID`),
  KEY `fk_user` (`USER_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=35 ;


--
-- Structure de la table `APP_TEMPLATE_MAIL`
--

CREATE TABLE IF NOT EXISTS `APP_TEMPLATE_MAIL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OBJECT` varchar(100) NOT NULL,
  `BODY` text NOT NULL,
  `EMAIL_KEY` varchar(200) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NULL DEFAULT NULL,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC AUTO_INCREMENT=107 ;

--
-- Contenu de la table `APP_TEMPLATE_MAIL`
--

INSERT INTO `APP_TEMPLATE_MAIL` (`ID`, `OBJECT`, `BODY`, `EMAIL_KEY`, `CREATION_DATE`, `UPDATING_DATE`, `DELETING_DATE`) VALUES
(105, '[CHOSA] Request to confirm your email address', '<center style = "line-height: 170%;"><p>Thank you for your account opening request</p><b><a href="http:// chosa.com" style="font-family:''Open Sans'',sans-serif; font-size: 13px; font-weight: 300; line-height: 1.6; color:#00b4e6 ;text-decoration:none;"> chosa.com </a></b> <p> In order to activate your account, please confirm that you are the</p><p> owner of this email address in <a href="#url#" style="font-family:''Open Sans'',sans-serif; font-size: 13px; font-weight: 300; line-height: 1.6; color:#00b4e6 ;text-decoration:none;"> clicking on this link .</a></p><br> <p> Thank you for your trust, <strong> The chosa team.</strong></p></center>', 'EmailConfirmation', '2017-11-06 17:04:46', '2017-11-14 08:24:45', NULL),
(106, '[CHOSA] Your password request', '<center style = "line-height: 170%;"> <p> Forgot your password? No worries! </p><p> It''s happening to everyone. </p> <button class = "btn"> <a href="#link#change-password?mailUser=#mailUser#" style="text-decoration:none;color:#ffffff "> Change PASSWORD </a> </button> <p> Thank you for your confidence, </p> <br> <strong> The chosa team </strong> </center>', 'MotPassPerdu', '2017-11-06 17:04:46', '2017-11-14 08:24:19', NULL);


--
-- Structure de la table `APP_TRAINING_CENTER`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER` (
  `CENTER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `LOGO_FILE_ID_FK` bigint(20) DEFAULT NULL,
  `MANAGER_USER_ID_FK` bigint(20) NOT NULL,
  `ADRESS` varchar(255) NOT NULL,
  `PHONE` varchar(255) NOT NULL,
  `STATUS` enum('REQUEST','SUSPENDED','VALIDATE') NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  `TRAINING_CENTER_COUNTRY_ID_FK` bigint(20) NOT NULL,
  PRIMARY KEY (`CENTER_ID`),
  KEY `LOGO_FILE_ID_FK` (`LOGO_FILE_ID_FK`,`MANAGER_USER_ID_FK`),
  KEY `MANAGER_USER_ID_FK` (`MANAGER_USER_ID_FK`),
  KEY `MANAGER_USER_ID_FK_2` (`MANAGER_USER_ID_FK`),
  KEY `TRAINING_CENTER_COUNTRY_ID_FK` (`TRAINING_CENTER_COUNTRY_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;



--
-- Structure de la table `APP_TRAINING_CENTER_ACTIVITY`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_ACTIVITY` (
  `TRAINING_CENTER_ACTIVITY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACTIVITY_NAME` varchar(255) NOT NULL,
  `MIN_NUMBER` int(11) NOT NULL,
  `MAX_NUMBER` int(11) NOT NULL,
  `URL_VIDEO` varchar(255) NOT NULL,
  `MIN_AGE` int(11) NOT NULL,
  `MAX_AGE` int(11) NOT NULL,
  `DURATION_ACTIVITY` int(11) NOT NULL,
  `SUBJECT` set('LOGIC','VISUEL','SCIENCE','LANGUAGE','SOCIAL') DEFAULT NULL,
  `DESCRIPTION_ACTIVITY` varchar(255) DEFAULT NULL,
  `EXERCICE_ACTIVITY_ID_FK` bigint(20) DEFAULT NULL,
  `DOCUMENT_ID_FK` bigint(20) DEFAULT NULL,
  `USER_ACTIVITY_ID_FK` bigint(20) DEFAULT NULL,
  `TRAINING_CENTER_ACTIVITY_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TRAINING_CENTER_ACTIVITY_ID`),
  KEY `EXERCICE_ACTIVITY_ID_FK` (`EXERCICE_ACTIVITY_ID_FK`),
  KEY `DOCUMENT_ID_FK` (`DOCUMENT_ID_FK`),
  KEY `USER_ACTIVITY_ID_FK` (`USER_ACTIVITY_ID_FK`),
  KEY `TRAINING_CENTER_ACTIVITY_ID_FK` (`TRAINING_CENTER_ACTIVITY_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;


--
-- Structure de la table `APP_TRAINING_CENTER_AGENDA`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_AGENDA` (
  `TRAINING_CENTER_AGENDA_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EVENT_DATE` timestamp NOT NULL,
  `START_HOUR` timestamp NOT NULL,
  `END_HOUR` timestamp NOT NULL,
  `PLANNED_Number` int(11) NOT NULL,
  `MIN_AGE` int(11) NOT NULL,
  `MAX_AGE` int(11) NOT NULL,
  `STATUS_AGENDA` enum('PLANNED','STARTED','HOLD','STOPPED') NOT NULL,
  `USER_AGENDA_ID_FK` bigint(20) NOT NULL,
  `TEACHER_AGENDA_ID_FK` bigint(20) NOT NULL,
  `DOCUMENT_AGENDA_ID_FK` bigint(20) NOT NULL,
  `ACTIVITY_ID_FK` bigint(20) NOT NULL,
  `CLASS_ID_FK` bigint(20) NOT NULL,
  `EXERCICE_AGENDA_ID_FK` bigint(20) NOT NULL,
  `FILE_AGENDA_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TRAINING_CENTER_AGENDA_ID`),
  KEY `USER_AGENDA_ID_FK` (`USER_AGENDA_ID_FK`),
  KEY `TEACHER_USER_AGENDA_ID_FK` (`TEACHER_AGENDA_ID_FK`),
  KEY `DOCUMENT_AGENDA_ID_FK` (`DOCUMENT_AGENDA_ID_FK`),
  KEY `ACTIVITY_ID_FK` (`ACTIVITY_ID_FK`),
  KEY `CLASS_ID_FK` (`CLASS_ID_FK`),
  KEY `EXERCICE_AGENDA_ID_FK` (`EXERCICE_AGENDA_ID_FK`),
  KEY `FILE_AGENDA_ID_FK` (`FILE_AGENDA_ID_FK`),
  KEY `TEACHER_AGENDA_ID_FK` (`TEACHER_AGENDA_ID_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `APP_TRAINING_CENTER_CLASS`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_CLASS` (
  `TRAINING_CENTER_CLASS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CLASS_NAME` varchar(255) NOT NULL,
  `TEACHER_USER_ID_FK` bigint(20) DEFAULT NULL,
  `TRAINING_CENTER_ID_FK` bigint(20) NOT NULL,
  `PROGRAM_ID_FK` bigint(20) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TRAINING_CENTER_CLASS_ID`),
  KEY `TRAINING_CENTER_ID_FK` (`TRAINING_CENTER_ID_FK`),
  KEY `TEACHER_USER_ID_FK` (`TEACHER_USER_ID_FK`),
  KEY `TRAINING_CENTER_PROGRAM_ID_FK` (`PROGRAM_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;



--
-- Structure de la table `APP_TRAINING_CENTER_MEMBER`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_MEMBER` (
  `TRAINING_CENTER_MEMBER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `Status` enum('REQUEST','BLOQUED','VALIDATE') NOT NULL,
  `ROLE` enum('DIRECTOR','TEACHER','STUDENT','PARENT') NOT NULL,
  `START_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `RELEASE_DATE` timestamp NULL DEFAULT NULL,
  `MEMBER_USER_ID_FK` bigint(20) NOT NULL,
  `TRAINING_CENTER_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TRAINING_CENTER_MEMBER_ID`),
  KEY `MEMBER_USER_ID_FK` (`MEMBER_USER_ID_FK`),
  KEY `CENTER_MEMBER_ID_FK` (`TRAINING_CENTER_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;



--
-- Structure de la table `APP_TRAINING_CENTER_PROGRAM`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_PROGRAM` (
  `TRAINING_CENTER_PROGRAM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PROGRAM_DURATION` int(11) NOT NULL,
  `PROGRAM_NAME` varchar(255) NOT NULL,
  `TRAINING_CENTER_PROGRAM_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TRAINING_CENTER_PROGRAM_ID`),
  KEY `TRAINING_CENTER_PROGRAM_ID_FK` (`TRAINING_CENTER_PROGRAM_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;



--
-- Structure de la table `APP_TRAINING_CENTER_STUDENT`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_STUDENT` (
  `tcStudentId` bigint(20) NOT NULL AUTO_INCREMENT,
  `STUDENT_USER_ID_FK` bigint(20) NOT NULL,
  `TRAINING_CENTER_CLASS_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`tcStudentId`),
  KEY `TRAINING_CENTER_CLASS_ID_FK` (`TRAINING_CENTER_CLASS_ID_FK`),
  KEY `STUDENT_USER_ID_FK` (`STUDENT_USER_ID_FK`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `APP_TRAINING_CENTER_THEME`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_THEME` (
  `TRAINING_CENTER_THEME_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `THEME_NAME` varchar(255) NOT NULL,
  `THEME_DESCRIPTION` varchar(255) NOT NULL,
  `THEME_ORDRE` int(11) NOT NULL,
  `PROGRAM_THEME_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TRAINING_CENTER_THEME_ID`),
  KEY `PROGRAM_THEME_ID_FK` (`PROGRAM_THEME_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;


--
-- Structure de la table `APP_TRAINING_CENTER_THEME_ACTIVITY`
--

CREATE TABLE IF NOT EXISTS `APP_TRAINING_CENTER_THEME_ACTIVITY` (
  `TRAINING_CENTER_THEME_ACTIVITY_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `THEME_ORDRE` int(11) NOT NULL,
  `THEME_ID_FK` bigint(20) DEFAULT NULL,
  `ACTIVITY_ID_FK` bigint(20) NOT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TRAINING_CENTER_THEME_ACTIVITY_ID`),
  KEY `ACTIVITY_ID_FK` (`ACTIVITY_ID_FK`),
  KEY `PROGRAM_ID_FK` (`THEME_ID_FK`),
  KEY `THEME_ID_FK` (`THEME_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;


--
-- Structure de la table `APP_USER`
--

CREATE TABLE IF NOT EXISTS `APP_USER` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_EMAIL` varchar(255) DEFAULT NULL,
  `USER_PASSWORD` varchar(255) DEFAULT NULL,
  `CREATION_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATING_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DELETING_DATE` timestamp NULL DEFAULT NULL,
  `USER_NAME` varchar(255) NOT NULL,
  `FIRST_NAME` varchar(255) NOT NULL,
  `LAST_NAME` varchar(255) NOT NULL,
  `ADRESS` varchar(255) NOT NULL,
  `COUNTRY_ID_FK` bigint(20) DEFAULT NULL,
  `PHONE` varchar(255) NOT NULL,
  `STATUS` enum('SIGNUP','VALIDATE','SUSPENDED') NOT NULL,
  `facebook_id` varchar(255) DEFAULT NULL,
  `google_id` varchar(255) DEFAULT NULL,
  `BIRTHDAY` date NOT NULL,
  `PICTURE_ID_FK` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  KEY `PICTURE_ID_FK` (`PICTURE_ID_FK`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `APP_CATEGORY`
--
ALTER TABLE `APP_CATEGORY`
  ADD CONSTRAINT `CATEGORY_PARENT_ID_FK` FOREIGN KEY (`CATEGORY_PARENT_ID_FK`) REFERENCES `APP_CATEGORY` (`CATEGORY_ID`),
  ADD CONSTRAINT `USER_ID_FK` FOREIGN KEY (`USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_EXERCICE`
--
ALTER TABLE `APP_EXERCICE`
  ADD CONSTRAINT `CATEGORY_ID_FK` FOREIGN KEY (`CATEGORY_ID_FK`) REFERENCES `APP_CATEGORY` (`CATEGORY_ID`),
  ADD CONSTRAINT `EXERCICE_FILE_ID_FK` FOREIGN KEY (`EXERCICE_FILE_ID_FK`) REFERENCES `APP_FILE` (`FILE_ID`),
  ADD CONSTRAINT `PICTURE_ID_FK` FOREIGN KEY (`PICTURE_ID_FK`) REFERENCES `APP_FILE` (`FILE_ID`),
  ADD CONSTRAINT `USER_EXECICE_ID_FK` FOREIGN KEY (`USER_EXECICE_ID_FK`) REFERENCES `APP_EXERCICE` (`EXERCICE_ID`);

--
-- Contraintes pour la table `APP_FAMILY`
--
ALTER TABLE `APP_FAMILY`
  ADD CONSTRAINT `COUNTRY_FAMILY_ID_FK` FOREIGN KEY (`COUNTRY_ID_FK`) REFERENCES `APP_COUNTRY` (`ID`),
  ADD CONSTRAINT `LOGO_FILE_ID_FK` FOREIGN KEY (`LOGO_FILE_ID_FK`) REFERENCES `APP_FILE` (`FILE_ID`),
  ADD CONSTRAINT `MANAGER_USER_ID_FK` FOREIGN KEY (`MANAGER_USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_FAMILY_MEMBER`
--
ALTER TABLE `APP_FAMILY_MEMBER`
  ADD CONSTRAINT `FAMILY_ID_FK` FOREIGN KEY (`FAMILY_ID_FK`) REFERENCES `APP_FAMILY` (`FAMILY_ID`),
  ADD CONSTRAINT `USER_FAMILY_MEMBER_ID_FK` FOREIGN KEY (`USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_FILE`
--
ALTER TABLE `APP_FILE`
  ADD CONSTRAINT `USER_FILE_ID_FK` FOREIGN KEY (`USER_FILE_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_HISTORY`
--
ALTER TABLE `APP_HISTORY`
  ADD CONSTRAINT `EXERCICE_ID_FK` FOREIGN KEY (`EXERCICE_ID_FK`) REFERENCES `APP_EXERCICE` (`EXERCICE_ID`),
  ADD CONSTRAINT `USER_HISTORY_ID_FK` FOREIGN KEY (`USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_REVIEWS`
--
ALTER TABLE `APP_REVIEWS`
  ADD CONSTRAINT `EXERCICE_REVIEWS_ID_FK	` FOREIGN KEY (`EXERCICE_ID_FK`) REFERENCES `APP_EXERCICE` (`EXERCICE_ID`),
  ADD CONSTRAINT `USER_REVIEWS_ID_FK` FOREIGN KEY (`USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_ROLE`
--
ALTER TABLE `APP_ROLE`
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`USER_ID`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER`
--
ALTER TABLE `APP_TRAINING_CENTER`
  ADD CONSTRAINT `TRAINING_CENTER_LOGO_FILE_ID_FK` FOREIGN KEY (`LOGO_FILE_ID_FK`) REFERENCES `APP_FILE` (`FILE_ID`),
  ADD CONSTRAINT `TRAINING_CENTER_MANAGER_USER_ID_FK` FOREIGN KEY (`MANAGER_USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER_ACTIVITY`
--
ALTER TABLE `APP_TRAINING_CENTER_ACTIVITY`
  ADD CONSTRAINT `DOCUMENT_ID_FK` FOREIGN KEY (`DOCUMENT_ID_FK`) REFERENCES `APP_FILE` (`FILE_ID`),
  ADD CONSTRAINT `EXERCICE_ACTIVITY_ID_FK` FOREIGN KEY (`EXERCICE_ACTIVITY_ID_FK`) REFERENCES `APP_EXERCICE` (`EXERCICE_ID`),
  ADD CONSTRAINT `TRAINING_CENTER_ACTIVITY_ID_FK` FOREIGN KEY (`TRAINING_CENTER_ACTIVITY_ID_FK`) REFERENCES `APP_TRAINING_CENTER` (`CENTER_ID`),
  ADD CONSTRAINT `USER_ACTIVITY_ID_FK` FOREIGN KEY (`USER_ACTIVITY_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER_AGENDA`
--
ALTER TABLE `APP_TRAINING_CENTER_AGENDA`
  ADD CONSTRAINT `ACTIVITY_AGENDA_ID_FK` FOREIGN KEY (`ACTIVITY_ID_FK`) REFERENCES `APP_TRAINING_CENTER_ACTIVITY` (`TRAINING_CENTER_ACTIVITY_ID`),
  ADD CONSTRAINT `CLASS_AGENDA_ID_FK` FOREIGN KEY (`CLASS_ID_FK`) REFERENCES `APP_TRAINING_CENTER_CLASS` (`TRAINING_CENTER_CLASS_ID`),
  ADD CONSTRAINT `DOCUMENT_AGENDA_ID_FK` FOREIGN KEY (`DOCUMENT_AGENDA_ID_FK`) REFERENCES `APP_FILE` (`FILE_ID`),
  ADD CONSTRAINT `EXERCICE_AGENDA_ID_FK` FOREIGN KEY (`EXERCICE_AGENDA_ID_FK`) REFERENCES `APP_EXERCICE` (`EXERCICE_ID`),
  ADD CONSTRAINT `FILE_AGENDA_ID_FK` FOREIGN KEY (`FILE_AGENDA_ID_FK`) REFERENCES `APP_FILE` (`FILE_ID`),
  ADD CONSTRAINT `TEACHER_AGENDA_ID_FK` FOREIGN KEY (`TEACHER_AGENDA_ID_FK`) REFERENCES `APP_TRAINING_CENTER_MEMBER` (`TRAINING_CENTER_MEMBER_ID`),
  ADD CONSTRAINT `USER_AGENDA_ID_FK` FOREIGN KEY (`USER_AGENDA_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER_CLASS`
--
ALTER TABLE `APP_TRAINING_CENTER_CLASS`
  ADD CONSTRAINT `TEACHER_USER_ID_FK` FOREIGN KEY (`TEACHER_USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`),
  ADD CONSTRAINT `TRAINING_CENTER_ID_FK_2` FOREIGN KEY (`TRAINING_CENTER_ID_FK`) REFERENCES `APP_TRAINING_CENTER` (`CENTER_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER_MEMBER`
--
ALTER TABLE `APP_TRAINING_CENTER_MEMBER`
  ADD CONSTRAINT `CENTER_MEMBER_ID_FK` FOREIGN KEY (`TRAINING_CENTER_ID_FK`) REFERENCES `APP_TRAINING_CENTER` (`CENTER_ID`),
  ADD CONSTRAINT `MEMBER_USER_ID_FK` FOREIGN KEY (`MEMBER_USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER_PROGRAM`
--
ALTER TABLE `APP_TRAINING_CENTER_PROGRAM`
  ADD CONSTRAINT `TRAINING_CENTER_PROGRAM_ID_FK` FOREIGN KEY (`TRAINING_CENTER_PROGRAM_ID_FK`) REFERENCES `APP_TRAINING_CENTER` (`CENTER_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER_STUDENT`
--
ALTER TABLE `APP_TRAINING_CENTER_STUDENT`
  ADD CONSTRAINT `STUDENT_USER_ID_FK` FOREIGN KEY (`STUDENT_USER_ID_FK`) REFERENCES `APP_USER` (`USER_ID`),
  ADD CONSTRAINT `TRAINING_CENTER_CLASS_ID_FK` FOREIGN KEY (`TRAINING_CENTER_CLASS_ID_FK`) REFERENCES `APP_TRAINING_CENTER_CLASS` (`TRAINING_CENTER_CLASS_ID`);

--
-- Contraintes pour la table `APP_TRAINING_CENTER_THEME_ACTIVITY`
--
ALTER TABLE `APP_TRAINING_CENTER_THEME_ACTIVITY`
  ADD CONSTRAINT `ACTIVITY_ID_FK` FOREIGN KEY (`ACTIVITY_ID_FK`) REFERENCES `APP_TRAINING_CENTER_ACTIVITY` (`TRAINING_CENTER_ACTIVITY_ID`),
  ADD CONSTRAINT `THEME_ID_FK` FOREIGN KEY (`THEME_ID_FK`) REFERENCES `APP_TRAINING_CENTER_THEME` (`TRAINING_CENTER_THEME_ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
