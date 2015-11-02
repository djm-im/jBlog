BlogPost | CREATE TABLE `BlogPost` (
  `idBlogPost` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(45) NOT NULL,
  `blogPostText` text,
  `dateTime` varchar(10) DEFAULT NULL,
  `title` varchar(500) NOT NULL,
  `subtitle` varchar(500) NOT NULL,
  PRIMARY KEY (`idBlogPost`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1

