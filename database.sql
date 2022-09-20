CREATE DATABASE IF NOT exists jukebox;
use jukebox;

CREATE TABLE artists(
	artists_id int primary key,
	artist_name varchar(50) not null);
    
DROP TABLE artists;

INSERT INTO artists VALUES (1, "BackStreet Boys");
INSERT INTO artists VALUES (2, "Arjit Singh");
INSERT INTO artists VALUES (3, "Akon");
INSERT INTO artists VALUES (4, "Bruno Mars");
INSERT INTO artists VALUES (5, "Weekend");
INSERT INTO artists VALUES (6, "Kesha");
INSERT INTO artists VALUES (7, "Dhruv");
INSERT INTO artists VALUES (8, "Doja");
INSERT INTO artists VALUES (9, "Anne");



CREATE TABLE albums (
    album_id int,
    album_name varchar(40) PRIMARY KEY NOT NULL,
    album_year int NOT NULL
);
DROP TABLE albums;

INSERT INTO albums VALUES (1,"Drowning", 2006);
INSERT INTO albums VALUES (2, "Smack That", 2009);
INSERT INTO albums VALUES (3, "Boys", 2013);
INSERT INTO albums VALUES (4, "Repeat", 2018);
INSERT INTO albums VALUES (5, "Hell", 2011);
INSERT INTO albums VALUES (6, "Kesha", 2011);
INSERT INTO albums VALUES (7, "Nope", 2011);
INSERT INTO albums VALUES (8, "Doja", 2011);
INSERT INTO albums VALUES (9, "Anne", 2011);




CREATE TABLE genre(
genre_id int,
genre_name varchar(50)  primary key not null);

DROP TABLE genre;

INSERT INTO genre VALUES (1, "Party");
INSERT INTO genre VALUES (2, "Chilling");
INSERT INTO genre VALUES (3, "GooseBumps");
INSERT INTO genre VALUES (4, "BollywoodHit");



CREATE TABLE songs (
    songs_id int  PRIMARY KEY,
    songs_name varchar(40) NOT NULL,
    songs_duration varchar(20) NOT NULL,
    songs_path varchar(100) NOT NULL,
	artist_name varchar(50) not null,
    album_name varchar(50) not null,
	genre_name varchar(50) not null
);

DROP TABLE songs;
select * from songs;

INSERT INTO songs VALUES (1, "Kesariya", "3'60''", "src/resources/Kesariya.wav","ArjitSingh", "Brahmastra", "BollywoodHit" );
INSERT INTO songs VALUES (2, "Meaning", "3'50''", "src/resources/Meaning.wav", "BackStreetBoys", "Millennium","GooseBumps");
INSERT INTO songs VALUES (3, "SmackThat","5'60''", "src/resources/SmackThat.wav", "Akon", "Smacky", "Chilling");
INSERT INTO songs VALUES (4, "AlagAasmaan","4'60''", "src/resources/AlagAasmaan.wav", "AnuvJain","Aasmaan", "Chilling");
INSERT INTO songs VALUES (5, "Dooriyan","3'60''", "src/resources/Dooriyan.wav", "MohitChauhan", "LoveAjKal", "Chilling");
INSERT INTO songs VALUES (6, "EmpireOfTheSun","3'60''", "src/resources/Empire Of The Sun.wav","NCSBand", "ElectronicDuo","GooseBumps");
INSERT INTO songs VALUES (7, "JaaneKyun","4'30''", "src/resources/JaaneKyun.wav", "VishalShekar", "Dostana", "BollywoodHit");
INSERT INTO songs VALUES (8, "Lost_Forever","3'60''", "src/resources/Lost_Forever.wav","SergioValentino" ,"Lost","GooseBumps");
INSERT INTO songs VALUES (9, "One_Day","2'60''", "src/resources/One_Day.wav", "Anne","Once","GooseBumps");

CREATE TABLE playlist(playlistId int not null,
playlist_name varchar(50));

drop table playlist;
##select songs.songs_name from songs where playlist(songs_id) and songs(songs_id) = 1;

 create table playlistcontents(playlistid int ,
 songs_name varchar(50));
  

 drop table playlistcontents;
select * from playlistcontents;

select * from songs,playlist where songs_id = 2;



select artist_name,songs_name from artists,songs where artists.artists_id = 2 and songs_id = 2;
select songs_name from songs where artists.artists_id = 2 and songs_id = 2;

select songs_name from songs where artist_name = "Akon";
