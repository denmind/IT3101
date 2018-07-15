-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 15, 2018 at 09:15 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `unwind_sms`
--

-- --------------------------------------------------------

--
-- Table structure for table `modifications`
--

CREATE TABLE `modifications` (
  `mod_id` int(11) NOT NULL,
  `salary_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `salary` double NOT NULL COMMENT 'Value of salary by the time the modification is performed',
  `description` varchar(256) NOT NULL,
  `type` enum('DEDUCTION','ADDITION') NOT NULL,
  `datetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `modifications`
--

INSERT INTO `modifications` (`mod_id`, `salary_id`, `amount`, `salary`, `description`, `type`, `datetime`) VALUES
(1, 1, -200, 2800, 'Deduction', 'DEDUCTION', '2018-07-27 12:29:26');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `sal_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`sal_id`, `employee_id`, `amount`) VALUES
(1, 1, 5000),
(2, 2, 500),
(3, 3, 700),
(4, 10, 900),
(5, 12, 650),
(6, 11, 100);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `modifications`
--
ALTER TABLE `modifications`
  ADD PRIMARY KEY (`mod_id`),
  ADD KEY `mod_sal` (`salary_id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`sal_id`),
  ADD KEY `salary_employee` (`employee_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `modifications`
--
ALTER TABLE `modifications`
  MODIFY `mod_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `sal_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `modifications`
--
ALTER TABLE `modifications`
  ADD CONSTRAINT `mod_sal` FOREIGN KEY (`salary_id`) REFERENCES `salary` (`sal_id`);

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `salary_employee` FOREIGN KEY (`employee_id`) REFERENCES `unwind`.`employee` (`employee_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
