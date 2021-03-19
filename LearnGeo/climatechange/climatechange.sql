-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2021 at 06:13 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `climatechange`
--

-- --------------------------------------------------------

--
-- Table structure for table `credentials`
--

CREATE TABLE `credentials` (
  `uid` varchar(10000) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(1000) NOT NULL,
  `name` varchar(1000) NOT NULL,
  `type` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `data`
--

CREATE TABLE `data` (
  `course` varchar(10000) NOT NULL,
  `youtube` varchar(10000) NOT NULL,
  `quiz` varchar(10000) NOT NULL,
  `news` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data`
--

INSERT INTO `data` (`course`, `youtube`, `quiz`, `news`) VALUES
('{\r\n    \"links\": [\r\n        \"https://www.onlinestudies.com/Climate-Hero-Reduce-your-Carbon-Footprint-Course/Finland/South-Eastern-Finland-University-of-Applied-Sciences-XAMK/\",\r\n        \"https://www.coursera.org/courses?query=environmental%20studies\",\r\n        \"https://www.classcentral.com/subject/environmental-science\",\r\n        \"https://www.shortcoursesportal.com/disciplines/315/environmental-sciences.html\",\r\n        \"https://www.futurelearn.com/subjects/nature-and-environment-courses/climate-change\",\r\n        \"https://alison.com/courses/education/climate-change\",\r\n        \"https://www.coursera.org/specializations/our-responses-climate-change\",\r\n        \"https://www.futurelearn.com/subjects/nature-and-environment-courses/ecology\",\r\n        \"https://www.edx.org/course/climate-change-the-science-and-global-impact\",\r\n        \"https://www.edx.org/course/climate-change-financial-risks-and-opportunities\",\r\n        \"https://www.coursera.org/learn/climate-change-mitigation\"\r\n\r\n    ]\r\n}', '{\r\n    \"links\": [\r\n        \"https://www.youtube.com/watch?v=dcBXmj1nMTQ\",\r\n        \"https://www.youtube.com/watch?v=G4H1N_yXBiA\",\r\n        \"https://www.youtube.com/watch?v=ifrHogDujXw\",\r\n        \"https://www.youtube.com/watch?v=ymarrXoi0ZM\",\r\n        \"https://www.youtube.com/watch?v=OasbYWF4_S8\",\r\n        \"https://www.youtube.com/watch?v=-D_Np-3dVBQ\",\r\n        \"https://www.youtube.com/watch?v=0Puv0Pss33M\",\r\n        \"https://www.youtube.com/watch?v=DhhVr5iLF-c\",\r\n        \"https://www.youtube.com/watch?v=X2YgM1Zw4_E\",\r\n        \"https://www.youtube.com/watch?v=g6H9Q8wB4h8\",\r\n        \"https://www.youtube.com/watch?v=PslL9WC-2cQ\",\r\n        \"https://www.youtube.com/watch?v=PqxMzKLYrZ4\",\r\n        \"https://www.youtube.com/watch?v=gUhxcdzRgLQ\",\r\n        \"https://www.youtube.com/watch?v=bn8R_XqjjI0\",\r\n        \"https://www.youtube.com/watch?v=nTcFXJT0Fsc\",\r\n        \"https://www.youtube.com/watch?v=vONBU7btYuo\"\r\n    ]\r\n}', '{\r\n    \"links\": [\r\n        \"https://climate.nasa.gov/climate_resource_center/interactives/quizzes\",\r\n        \"https://www.earthday.org/the-climate-change-quiz/\",\r\n        \"https://climate.nasa.gov/climate_resources/16/quiz-global-warming/\",\r\n        \"https://www.earthday.org/earth-day-quizzes/?gclid=CjwKCAjw9MuCBhBUEiwAbDZ-7u2R0IrSD13S20WNd_FIWYf6-DM0Jzp_uWKogbegmxJByoH3Wssb4xoCrgsQAvD_BwE\",\r\n        \"https://blogs.ei.columbia.edu/2018/09/27/interactive-quiz-test-knowledge-climate-change-impacts/\",\r\n        \"https://www.washingtonpost.com/climate-solutions/2019/11/22/quiz-how-much-do-you-know-about-climate-change/?arc404=true\",\r\n        \"https://www.nationalgeographic.com/environment/article/global-warming-quiz\",\r\n        \"https://www.earthday.org/environmental-literacy-quiz/\",\r\n        \"https://quizizz.com/admin/quiz/5b9ac0f9c644a90019d13791/environmental-issues\",\r\n        \"https://www.energy.gov/articles/quiz-test-your-climate-change-iq\"\r\n    ]\r\n}', '{\r\n    \"links\": [\r\n        \"https://climate.nasa.gov/news/?page=0&per_page=40&order=publish_date+desc%2C+created_at+desc&search=&category=19%2C98\",\r\n        \"https://edition.cnn.com/specials/world/cnn-climate\",\r\n        \"https://www.hindustantimes.com/environment\",\r\n        \"https://economictimes.indiatimes.com/topic/climate-change\",\r\n        \"https://www.theguardian.com/environment/climate-change\",\r\n        \"https://transitionnetwork.org/news-and-blog/category/climate-change/?gclid=CjwKCAiAhbeCBhBcEiwAkv2cY69KZzyH1dfJ1ESwmVXRrU6QDuTamVoGLzyu9yk-IAwzTIBOTEVF7hoCCBwQAvD_BwE\",\r\n        \"https://www.nature.com/nclimate/articles?year=2021\",\r\n        \"https://www.sciencedaily.com/news/earth_climate/climate/\",\r\n        \"https://www.independent.co.uk/topic/climate-change\",\r\n        \"https://www.sciencedaily.com/news/top/environment/\",\r\n        \"https://timesofindia.indiatimes.com/home/environment\",\r\n        \"https://www.nbcnews.com/science/environment\"\r\n    ]\r\n\r\n}');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
