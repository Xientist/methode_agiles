-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 14 avr. 2020 à 14:59
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `budget_managment`
--

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `Nom` varchar(30) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`Nom`, `ID`) VALUES
('jj', 1),
('donii', 2),
('xxx', 3),
('donii', 4),
('xxx', 5),
('jh', 6),
('ennech', 7),
('ennech', 8),
('ennech', 9),
('ennech', 10),
('ennech', 11),
('ennech', 12);

-- --------------------------------------------------------

--
-- Structure de la table `transaction`
--

CREATE TABLE `transaction` (
  `ID` int(11) NOT NULL,
  `Montant` double NOT NULL,
  `Categorie` varchar(30) DEFAULT NULL,
  `personne` int(11) NOT NULL,
  `Date_T` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `transaction`
--

INSERT INTO `transaction` (`ID`, `Montant`, `Categorie`, `personne`, `Date_T`) VALUES
(1, 1545, 'depense', 2, '2020-02-01'),
(6, 7, 'Revenu', 1, '2020-04-08'),
(7, 8, 'depense', 3, '2020-03-05'),
(8, 3, 'Revenu', 2, '2020-03-18'),
(9, 3, 'depense', 1, '2020-03-18'),
(10, 87, 'depense', 1, '2019-03-14'),
(11, 87, 'Revenu', 1, '2019-03-14'),
(12, 1000, 'income', 1, '2015-03-30'),
(13, 1000, 'income', 1, '2015-03-30'),
(14, 1000, 'income', 1, '2015-03-30'),
(15, 7676, 'hghg', 1, '2020-05-31'),
(16, 7676, 'aa', 1, '2020-05-30'),
(17, 5454.7, 'bb', 2, '2018-06-03'),
(18, 1000, 'cc', 3, '2017-11-06');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Passeword` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `personne` (`personne`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
