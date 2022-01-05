-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 05 jan. 2022 à 12:11
-- Version du serveur :  8.0.23
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `photonet`
--

-- --------------------------------------------------------

--
-- Structure de la table `album`
--

DROP TABLE IF EXISTS `album`;
CREATE TABLE IF NOT EXISTS `album` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomAlbum` varchar(25) NOT NULL,
  `dateCreation` datetime DEFAULT CURRENT_TIMESTAMP,
  `proprioAlbum` int NOT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `portee` enum('prive','public') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_album_user` (`proprioAlbum`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `album`
--

INSERT INTO `album` (`id`, `nomAlbum`, `dateCreation`, `proprioAlbum`, `detail`, `portee`) VALUES
(1, 'firstAlbum', '2022-01-04 23:57:58', 3, 'mon premier album pour tester l\'enregistrement de mes donnees', 'prive');

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

DROP TABLE IF EXISTS `photo`;
CREATE TABLE IF NOT EXISTS `photo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titre` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dateAjout` datetime DEFAULT CURRENT_TIMESTAMP,
  `dateMisajour` datetime DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `album` int DEFAULT NULL,
  `motscles` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `img` longblob NOT NULL,
  `hauteur` bigint NOT NULL,
  `largeur` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_photo_album` (`album`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(25) NOT NULL,
  `prenom` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `userRole` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `username`, `pwd`, `userRole`) VALUES
(1, 'BA', 'Mamie', 'mamie', 'passer', 'administrateur'),
(3, 'Diop', 'ngoumba', 'ptitcoeur', 'passer', 'utilisateur simple'),
(4, 'diop', 'mohamed', 'momo', 'passer', 'utilisateur simple');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `FK_album_user` FOREIGN KEY (`proprioAlbum`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `FK_photo_album` FOREIGN KEY (`album`) REFERENCES `album` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
