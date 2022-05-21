-- phpMyAdmin SQL Dump
-- version 5.0.4deb2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 09, 2021 at 12:38 AM
-- Server version: 10.5.12-MariaDB-0+deb11u1
-- PHP Version: 7.4.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Book-Review`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `post_id` int(11) NOT NULL,
  `body` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `user_id`, `post_id`, `body`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 'It is okay', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(2, 3, 4, 'I love this book!', '2021-10-15 16:52:58', '2021-10-15 16:52:58');

-- --------------------------------------------------------

--
-- Table structure for table `genres`
--

CREATE TABLE `genres` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `genres`
--

INSERT INTO `genres` (`id`, `name`, `slug`) VALUES
(1, 'Fantasy', 'Fantasy'),
(2, 'Science Fiction', 'Science Fiction'),
(3, 'Action & Adventure', 'Action & Adventure'),
(4, 'Mystery', 'Mystery'),
(5, 'Horror', 'Horror'),
(6, 'Romance', 'Romance'),
(7, 'Biography', 'Biography');

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `slug` varchar(255) NOT NULL,
  `views` int(11) NOT NULL DEFAULT 0,
  `image` varchar(255) NOT NULL,
  `body` text NOT NULL,
  `published` tinyint(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `user_id`, `title`, `slug`, `views`, `image`, `body`, `published`, `created_at`, `updated_at`) VALUES
(1, 1, 'Harry Potter and Sorcers Stone', 'Harry Potter and Sorcers Stone', 0, 'HP1.jpg', 'Harry Potter is a great book', 1, '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(2, 2, 'Harry Potter and the Chamber of Secrets', 'Harry Potter and the Chamber of Secrets', 1, 'hp2.jpg', 'Harry potter defeats the dark again', 0, '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(3, 1, 'Harry Potter and the Half Blood Prince', 'Harry Potter and the Half Blood Prince', 1, 'HP6.jpg', 'Everyone loves Harry Potter', 1, '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(4, 3, 'Number the Stars', 'Number the Stars', 0, 'Numstars.jpeg', 'Great book about loyality and friendship', 1, '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(5, 1, 'Diary of Anne Frank', 'Diary of Anne Frank', 0, 'DiaryAF.jpg', 'Anns story is truly tragic.', 1, '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(6, 4, 'StarGirl', 'StarGirl', 0, 'Stargirl.jpg', 'This girl stands out! Dare to be different!!', 1, '2021-10-15 16:52:58', '2021-10-15 16:52:58');

-- --------------------------------------------------------

--
-- Table structure for table `post_genres`
--

CREATE TABLE `post_genres` (
  `id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `genre_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `post_genres`
--

INSERT INTO `post_genres` (`id`, `post_id`, `genre_id`) VALUES
(1, 1, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `replies`
--

CREATE TABLE `replies` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `comment_id` int(11) NOT NULL,
  `body` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `replies`
--

INSERT INTO `replies` (`id`, `user_id`, `comment_id`, `body`, `created_at`, `updated_at`) VALUES
(1, 2, 1, 'WHAT?!?! its the best one ever!', '2021-10-19 16:52:58', '2021-10-15 16:52:58'),
(2, 5, 2, 'It is great', '2021-10-18 16:52:58', '2021-10-15 16:52:58');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` enum('Author','Admin') DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `role`, `password`, `created_at`, `updated_at`) VALUES
(1, 'Kamackey1', 'kamackey1@wvncc.edu', 'Admin', 'Macdaddy0429', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(2, 'Steve', 'noemail@email.com', 'Admin', 'Jjmkam0925', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(3, 'Mackey1', 'Potterhead@email.com', 'Author', 'mypassword123', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(4, 'Smac2', 'fakeemails@email.com', 'Author', 'Asdfghjkl123', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(5, 'Spayde11', 'fun@email.com', 'Admin', 'KKmmaa23', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(6, 'QueenOSpaydes', 'ronweaskey@potter.com', 'Author', 'Book12344', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(7, 'HeartsnSpaydes', 'bestemailever@email.com', 'Admin', '12xcvb12', '2021-10-15 16:52:58', '2021-10-15 16:52:58'),
(8, 'boo', 'blah@blah.net', 'Admin', 'Fun123', '2021-10-15 16:52:58', '2021-10-15 16:52:58');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `post_id` (`post_id`);

--
-- Indexes for table `genres`
--
ALTER TABLE `genres`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `slug` (`slug`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `slug` (`slug`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `post_genres`
--
ALTER TABLE `post_genres`
  ADD PRIMARY KEY (`id`),
  ADD KEY `post_id` (`post_id`),
  ADD KEY `genre_id` (`genre_id`);

--
-- Indexes for table `replies`
--
ALTER TABLE `replies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `comment_id` (`comment_id`),
  ADD KEY `replies_ibfk_1` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `post_genres`
--
ALTER TABLE `post_genres`
  ADD CONSTRAINT `post_genres_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `post_genres_ibfk_2` FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `replies`
--
ALTER TABLE `replies`
  ADD CONSTRAINT `replies_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `replies_ibfk_2` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
