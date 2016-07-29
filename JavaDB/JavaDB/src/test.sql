-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2015 at 09:01 AM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `foodiesdhaka`
--

CREATE TABLE IF NOT EXISTS `foodiesdhaka` (
  `key` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `foodType` varchar(50) DEFAULT NULL,
  `rating` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foodiesdhaka`
--

INSERT INTO `foodiesdhaka` (`key`, `name`, `address`, `foodType`, `rating`) VALUES
(1, 'Madchef', 'House 53, Road 3/A,     Dhanmondi, Dhaka, 1209', 'Burgers , Fast Food and Wraps ', 0),
(2, 'Arabian Fast Food ', 'Road # 5, House # 13/1, Dhanmondi,Dhaka-1219', 'Burgers , Fast Food and Wraps, Pizza ', 0),
(3, 'Takeout', 'Rifles Square, Dhaka', 'Burgers, Fast Food and Wraps ', 0),
(4, 'Baburchi Restaurant ', 'House No 55/A, Dhaka, 1209', 'Bangladeshi, Biryani, Indian ', 0),
(5, 'Boomers Café Dhanmondi ', 'Dhanmondi Anam Rangs Plaza (3rd floor), Dhaka, 120', 'Burgers, Fast Food and Wraps, Indian, Juice', 0),
(6, 'Chilis ', 'House 2 ,Road 32, Dhaka, 1209', 'Chinese Food, Continental, Thai ', 0),
(7, 'Shawarma House Dhanmondi ', 'Anam Rangs Plaza, Shop T/F-7', 'Burgers, Fast Food and Wraps, Italian Food, Pizza ', 0),
(8, 'American Burger Dhanmondi ', 'House no-53/1,, Dhaka, 1209', 'Burgers, Fast Food and Wraps', 0),
(9, 'Real Pizza, Dhanmondi ', 'House 1/5 Block D Lalmatia', 'Pizza ', 0),
(10, 'Jing Ling Chinese Restaurant ', 'Dhanmondi 4/A, Dhaka', 'Chinese Food, Thai ', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
