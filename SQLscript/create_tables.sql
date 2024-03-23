CREATE DATABASE IF NOT EXISTS TouristGuide_Database;
CREATE SCHEMA IF NOT EXISTS TouristGuide_Database;
USE TouristGuide_Database;

CREATE TABLE IF NOT EXISTS TouristAttraction(
Attraction_ID int auto_increment,
name VARCHAR(50) unique,
description VARCHAR(300),
city VARCHAR(50),
primary key(touristAttractionID),
foreign key(city_ID) references city(city_ID)
);

CREATE TABLE IF NOT EXISTS City(
city_ID int auto_increment,
city_name VARCHAR(50) unique,
primary key(city_ID)
);

CREATE TABLE IF NOT EXISTS Tag(
tag_ID int auto_increment,
name VARCHAR(50) unique,
primary key(tag_ID)

);

CREATE TABLE IF NOT EXISTS Tourist_Attraction_Tag(
touristAttraction_ID int,
tag_ID int,
foreign key(touristAttraction_ID) references Tourist_Attraction (touristAttraction_ID),
foreign key(tag_ID) references tag(tag_ID)
);


