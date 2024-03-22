USE TouristGuide_Database;


INSERT INTO TouristAttraction (name, description, city_ID) VALUES('The Petra','Travelers explore Site, discovering the fascinating history and breathtaking architecture of the Nabateans.','1');
INSERT INTO TouristAttraction (name, description, city_ID) VALUES('Taj Mahal','Visitors from across the world come to look at its beauty, The symbol of eternal love and architectural greatness.','2');
INSERT INTO TouristAttraction (name, description, city_ID) VALUES('Eiffel Tower','Couples usually indulge in the romantic ambiance of the cultural landmark','3');
INSERT INTO TouristAttraction (name, description, city_ID) VALUES('Sydney Opera House','Visitors flock to witness world-class performances, experience the vibrant arts scene and views','4');
INSERT INTO TouristAttraction (name, description, city_ID) VALUES('Grand Canyon','A natural wonder, with colorful landscapes and the opportunity to explore the canyons depths through hiking and river rafting','5');


INSERT INTO City(name) VALUES('Jordan');
INSERT INTO City(name) VALUES('Agra');
INSERT INTO City(name) VALUES('Paris');
INSERT INTO City(name) VALUES('Sydney');
INSERT INTO City(name) VALUES('Arizona (United States)');

INSERT INTO Tag(name) VALUES('Historical');
INSERT INTO Tag(name) VALUES('Cultural');
INSERT INTO Tag(name) VALUES('Romantic');
INSERT INTO Tag(name) VALUES('Scenic Harbor Views');
INSERT INTO Tag(name) VALUES('Natural Beauty');

INSERT INTO Tourist_Attraction_Tag (touristAttraction_ID, tag_ID) VALUES (1,1);
INSERT INTO Tourist_Attraction_Tag (touristAttraction_ID, tag_ID) VALUES (2,1);
INSERT INTO Tourist_Attraction_Tag (touristAttraction_ID, tag_ID) VALUES (2,2);
INSERT INTO Tourist_Attraction_Tag (touristAttraction_ID, tag_ID) VALUES (3,3);
INSERT INTO Tourist_Attraction_Tag (touristAttraction_ID, tag_ID) VALUES (4,4);
INSERT INTO Tourist_Attraction_Tag (touristAttraction_ID, tag_ID) VALUES (5,5);