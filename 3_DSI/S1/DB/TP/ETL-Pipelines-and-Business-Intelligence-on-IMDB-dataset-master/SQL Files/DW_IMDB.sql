--drop database Movies_DW
--CREATE DATABASE Movies_DW
USE Movies_DW
-- DROP TABLE
DROP TABLE IF EXISTS DIM_PERSON;

CREATE TABLE DIM_PERSON (
	Person_SK int not null IDENTITY(1,1),
	nconst varchar(10) not null,
	primaryName varchar(255),
	birthYear int, 
	deathYear int,    
	primaryProfession_sk int,
	knownForTitles_sk int,
	name_webURL varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Person_SK) 	
) ;
CREATE NONCLUSTERED INDEX CIX_DIM_PERSON  ON DIM_PERSON (nconst);

DROP TABLE IF EXISTS DIM_TITLE_INFO;

CREATE TABLE DIM_TITLE_INFO (
	Title_SK int not null IDENTITY(1,1),
	tconst varchar(10) not null,
	movieId int null,
	imdbId varchar(20) null,   
	tmdbId int null,
	Title_Type_SK int,
	primaryTitle varchar(1024),
	originalTitle varchar(1024),
	ml_title varchar(255),
	isAdult bit,
	startYear int,  
	endYear int,   
	runtimeMinutes int,   
	startYear_char varchar(4),  
	endYear_char varchar(4),   
	runtimeMinutes_char varchar(10),
	webURL varchar(max),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Title_SK)  
) ;
CREATE NONCLUSTERED INDEX CIX_DIM_TITLE_INFO  ON DIM_TITLE_INFO (tconst);

DROP TABLE IF EXISTS DIM_TITLE_ENHANCED;

CREATE TABLE DIM_TITLE_ENHANCED (
	Title_Enhanced_SK int not null IDENTITY(1,1),
	Title_SK int,
	title_ordering int NOT NULL,
	title varchar(1024),
	Country_SK int,
	Language_SK INT,
	[types] varchar(255),
	title_attributes varchar(1024),
	isOriginalTitle varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Title_Enhanced_SK)  
) ;
CREATE INDEX IDX_DIM_TITLE_ENHANCED    ON  DIM_TITLE_ENHANCED (Title_Enhanced_SK);



DROP TABLE IF EXISTS DIM_DIRECTOR_INFO;

CREATE TABLE DIM_DIRECTOR_INFO (
	Director_SK int not null IDENTITY(1,1),
	Title_SK int not null,
	Person_SK int not null, 
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Director_SK)  
);


DROP TABLE IF EXISTS DIM_WRITER_INFO ;

CREATE TABLE DIM_WRITER_INFO (
	Writer_SK  int NOT NULL IDENTITY(1,1),
  	Title_SK int not null,
	Person_SK int not null, 
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Writer_SK)
);
CREATE INDEX IDX_SK_DIM_WRITER_INFO     ON DIM_WRITER_INFO(Title_SK,Person_SK);

-- Drop table


DROP TABLE IF EXISTS DIM_EPISODE_INFO;

CREATE TABLE DIM_EPISODE_INFO (
	Epsiode_SK int not null IDENTITY(1,1),
	Title_SK int not null,
	Parent_Title_SK  int,
	seasonNumber int,    
	episodeNumber int,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Epsiode_SK)
) ;
CREATE INDEX IDX_DIM_EPISODE_INFO  ON DIM_EPISODE_INFO (Title_SK ,Parent_Title_SK );


DROP TABLE IF EXISTS DIM_PRINCIPAL_CREW;

CREATE TABLE DIM_PRINCIPAL_CREW (
	Principal_Crew_SK int IDENTITY(1,1),
	Title_SK int,
	[ordering] int,
	Person_SK int,
	Job_Category_SK int,
	characters_name varchar(1024),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Principal_Crew_SK)
) ;
CREATE UNIQUE INDEX UDX_DIM_PRINCIPAL_CREW      ON DIM_PRINCIPAL_CREW(Title_SK, Person_SK, ordering)



 
-- Drop table
DROP TABLE IF EXISTS DIM_KNOWNFORTITLES ;

CREATE TABLE DIM_KNOWNFORTITLES (
	knownForTitles_SK int NOT NULL IDENTITY(1,1),
   	Person_SK int not null, 
	Title_SK int not null,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (knownForTitles_SK)
);
CREATE INDEX IDX_DIM_KNOWNFORTITLES   ON DIM_KNOWNFORTITLES  (Person_SK, Title_SK);

-- Drop table
DROP TABLE IF EXISTS DIM_PRIMARYPROFESSION;

CREATE TABLE DIM_PRIMARYPROFESSION (
	primaryProfession_SK int NOT NULL IDENTITY(1,1),
	primaryProfession varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (primaryProfession_SK )
);

DROP TABLE IF EXISTS DIM_PERSON_PRIMARYPROFESSION;

CREATE TABLE DIM_PERSON_PRIMARYPROFESSION (
	Person_primaryProfession_SK int NOT NULL IDENTITY(1,1),
	Person_SK int, 
	primaryProfession_SK int,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Person_primaryProfession_SK )
);

CREATE INDEX IDX_DIM_PERSON_PRIMARYPROFESSION    ON DIM_PERSON_PRIMARYPROFESSION  (Person_SK, primaryProfession_SK);



DROP TABLE IF EXISTS FACT_IMDB_RATINGS;

CREATE TABLE FACT_IMDB_RATINGS(
	Ratings_SK int not null IDENTITY(1,1),
	Title_SK int not null,
	averageRating real,
	numVotes int,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Ratings_SK)
);

CREATE INDEX IDX_SK_FACT_IMDB_RATINGS    ON FACT_IMDB_RATINGS (Title_SK);



DROP TABLE IF EXISTS FACT_BOX_OFFICE ;

CREATE TABLE FACT_BOX_OFFICE (
	box_office_worldwide_sk int not null identity,
	BoxOffice_Rank int,
	Title_SK int not null,
	Title varchar(255),
	Worldwide_LifetimeGross bigint,
	Domestic_LifetimeGross bigint,
	Foreign_LifetimeGross bigint,
   	Release_Year  int,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (box_office_worldwide_sk)
);

-- Drop table
DROP TABLE IF EXISTS DIM_IMDB_FRANCHISE ;

CREATE TABLE DIM_IMDB_FRANCHISE  (
	Franchise_SK int NOT NULL IDENTITY(1,1),
	Franchise_Name varchar(80),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Franchise_sk)
);

DROP TABLE IF EXISTS FACT_FRANCHISES_GROSS;

CREATE TABLE FACT_FRANCHISES_GROSS (
	Franchise_Gross_SK int NOT NULL IDENTITY(1,1),
	Franchise_SK int, 
	Total_Revenue bigint,
	Number_of_Releases int,
	Top_Release varchar(255),
	Lifetime_Gross bigint,
DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Franchise_Gross_SK)
);


-- Drop table

DROP TABLE IF EXISTS FACT_FRANCHISES_LIST


CREATE TABLE FACT_FRANCHISES_LIST (
	Franchise_List_SK int  NOT NULL,
	Franchise_SK int,
	Title_SK int,
	Realease_Rank int,
	Release_Name varchar(255),
	Lifetime_Gross bigint,
	Max_Theaters int,
	Opening_Gross bigint,
	Open_Theaters int,
	Release_Date datetime,
	Distributor varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL
);



DROP TABLE IF EXISTS DIM_IMDB_BRAND;

CREATE TABLE DIM_IMDB_BRAND  (
	Brand_SK int NOT NULL IDENTITY(1,1),
	Brand_Name varchar(80),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Brand_sk)
);


-- Drop table

DROP TABLE IF EXISTS FACT_BRANDS_GROSS;

CREATE TABLE FACT_BRANDS_GROSS (
    Brands_Gross_SK int NOT NULL IDENTITY(1,1),
	Brand_SK int,
	Total_Revenue bigint,
	Number_of_Releases int,
	Top_Release varchar(255),
	Lifetime_Gross bigint,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Brands_Gross_SK)
);


-- Drop table

DROP TABLE IF EXISTS FACT_BRANDS_LIST


CREATE TABLE FACT_BRANDS_LIST (
	Title_SK int,
   	Brand_SK int,                   
	Realease_Rank int,
	Release_Name varchar(255),
	Lifetime_Gross bigint,
	Max_Theaters int,
	Opening_Gross bigint,
	Open_Theaters int,
	Release_Date datetime,
	Distributor varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL
);



DROP TABLE IF EXISTS DIM_COUNTRY;

CREATE TABLE DIM_COUNTRY (
    	Country_SK int NOT NULL,
	country_name varchar(255),
	alpha_2 varchar(2),
	alpha_3 varchar(3),
	country_code int,
	iso_3166_2 varchar(80),
	region varchar(255),
	sub_region varchar(255),
	intermediate_region varchar(255),
	region_code int,
	sub_region_code int,
	intermediate_region_code int,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Country_SK)
);

DROP TABLE IF EXISTS DIM_LANGUAGE;


CREATE TABLE DIM_LANGUAGE (
    	Language_SK int NOT NULL ,
	alpha3_b varchar(3),
	alpha3_t varchar(3),
	alpha2 varchar(2),
	Language_Name varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Language_SK)
);



DROP TABLE IF EXISTS DIM_GENRES 

CREATE TABLE DIM_GENRES (
	Genre_SK int identity,
	genres varchar(255),
genre_source varchar(80),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Genre_SK)
) ;

-- Drop table
DROP TABLE IF EXISTS DIM_TITLE_GENRES;

CREATE TABLE DIM_TITLE_GENRES(
	titles_genres_sk int NOT NULL IDENTITY(1,1),
    	Title_SK int,
		 genre_source varchar(80),
	Genre_SK  int,
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (titles_genres_sk)
);
CREATE INDEX IDX_SK_DIM_TITLE_GENRES    ON DIM_TITLE_GENRES(Title_SK ,Genre_SK);

DROP TABLE IF EXISTS DIM_JOB_CATEGORIES


CREATE TABLE DIM_JOB_CATEGORIES (
	Job_Category_SK int NOT NULL IDENTITY(1,1),
	job_category varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Job_Category_SK)
) ;


DROP TABLE IF EXISTS DIM_TITLE_TYPE


CREATE TABLE DIM_TITLE_TYPE (
	Title_Type_SK int identity,
	titleType varchar(255),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Title_Type_SK)
) ;

--- Reject Table
DROP TABLE IF EXISTS dim_imdb_title_episode_rejects ; ;

CREATE TABLE dim_imdb_title_episode_rejects (
	title_episode_sk int NOT NULL IDENTITY(1,1),

    title_sk int,
    parent_title_sk int,
	tconst varchar(10) null ,
	parentTconst varchar(10),
	seasonNumber int,
	episodeNumber int,

	reject_reason varchar(80),  
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (title_episode_sk)
);

-- Drop table
DROP TABLE IF EXISTS DIM_PRINCIPAL_CREW_REJECTS;

CREATE TABLE DIM_PRINCIPAL_CREW_REJECTS (
	Principal_Crew_SK int IDENTITY(1,1),
	tconst varchar(10) null,
	[ordering] int,
	nconst varchar(10) null,
	Job_Category_SK int,
	characters_name varchar(1024),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Principal_Crew_SK)
) ;
-- Drop table
DROP TABLE IF EXISTS DIM_DIRECTOR_INFO_REJECTS;

CREATE TABLE DIM_DIRECTOR_INFO_REJECTS (
	Dir_And_Wrt_SK int not null IDENTITY(1,1),
	tconst varchar(10) null,
	nconst varchar(10) null,
	reject_reason varchar(80), 
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Dir_And_Wrt_SK)  
);

DROP TABLE IF EXISTS DIM_WRITER_INFO_REJECTS ;

CREATE TABLE DIM_WRITER_INFO_REJECTS (
	Writer_SK  int NOT NULL IDENTITY(1,1),
  	tconst varchar(10) null,
	nconst varchar(10) null,
reject_reason varchar(80), 
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Writer_SK)
);


-- Drop table
DROP TABLE IF EXISTS DIM_KNOWNFORTITLES_REJECTS ;

CREATE TABLE  DIM_KNOWNFORTITLES_REJECTS (
	knownForTitles_SK int NOT NULL IDENTITY(1,1),
   	tconst varchar(10) null,
	nconst varchar(10) null,
reject_reason varchar(80),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (knownForTitles_SK)
);

DROP TABLE IF EXISTS DIM_TITLE_ENHANCED_REJECTS;

CREATE TABLE DIM_TITLE_ENHANCED_REJECTS (
	Title_Enhanced_SK int not null IDENTITY(1,1),
	tconst varchar(10) null,
	title_ordering int NOT NULL,
	title varchar(1024),
	Country_SK int,
	Language_SK INT,
	[types] varchar(255),
	title_attributes varchar(1024),
	isOriginalTitle varchar(255),
reject_reason varchar(80),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime NOT NULL,
	DI_Modified_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (Title_Enhanced_SK)  
) ;

DROP TABLE if exists dim_imdb_title_basics_ml_rejects ;

CREATE TABLE dim_imdb_title_basics_ml_rejects (
	movieId int not null,           -- MovieLens ID
	ml_title varchar(255),
	ml_tconst varchar(10) NOT NULL,
	imdbId varchar(20),
	tmdbId int,
	 genre_source varchar(80),
	reject_reason varchar(80),
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY CLUSTERED (movieId) 
) ;

DROP TABLE IF EXISTS dim_imdb_genres_ml_rejects;

CREATE TABLE dim_imdb_genres_ml_rejects   (
	genres_ml_rejects_sk int NOT NULL IDENTITY(1,1),

	movieId int null,           -- MovieLens ID
    title_sk int  NULL,

	genres varchar(255),
	genres_sk int null,
    genre_source varchar(80),              -- imdb or MovieLens     
	          
	reject_reason varchar(80) not null default 'tconst not mtached with ml movieid',
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (genres_ml_rejects_sk)
);


--DROP TABLE IF EXISTS fct_ml_genome_scores;

--CREATE TABLE fct_ml_genome_scores (
--	genome_scores_sk int NOT NULL IDENTITY(1,1),

--    title_sk int not null,
--	tagId int NOT NULL,
--	relevance decimal (10,3),

--	DI_JobID varchar(20) NOT NULL,
--	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
--	PRIMARY KEY CLUSTERED (title_sk,tagId)
--);

-- Drop tab
DROP TABLE IF EXISTS fct_ml_genome_tags ;

CREATE TABLE fct_ml_genome_tags (
	tagId int NOT NULL,   -- NK
	tag varchar(255),

	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (tagId)
);
use Movies_DW
-- Drop table
DROP TABLE IF EXISTS fct_ml_ratings ;

CREATE TABLE fct_ml_ratings (
	title_sk int NOT NULL,
	userId int NOT NULL,

	rating decimal(10,3),
	ratings_datetime datetime,

	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY CLUSTERED (title_sk,userId)
);

-- Drop table
DROP TABLE IF EXISTS fct_ml_tags ;

CREATE TABLE fct_ml_tags (
	ml_tags_sk int NOT NULL IDENTITY(1,1),

	title_sk int NOT NULL,
	userId int NOT NULL,
	tag varchar(255),
	ratings_datetime datetime,

	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (ml_tags_sk)
);

DROP TABLE IF EXISTS fct_ml_ratings_rejects ;

CREATE TABLE fct_ml_ratings_rejects (
	movieId int not null,           -- MovieLens ID
	userId int NOT NULL,

	rating decimal(10,3),
	ratings_datetime datetime,

	reject_reason varchar(80) not null default 'tconst not mtached with ml movieid',
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY  (movieId,userId)
);

-- Drop table
DROP TABLE IF EXISTS fct_ml_tags_rejects ;

CREATE TABLE fct_ml_tags_rejects (
	ml_tags_sk int NOT NULL IDENTITY(1,1),

    movieId int null,           -- MovieLens ID
	userId int NOT NULL,
	tag varchar(255),
	ratings_datetime datetime,

	reject_reason varchar(80) not null default 'tconst not mtached with ml movieid',
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (ml_tags_sk)
);

DROP TABLE IF EXISTS fct_ml_genome_scores;

CREATE TABLE fct_ml_genome_scores (
	genome_scores_sk int NOT NULL IDENTITY(1,1),

    title_sk int not null,
	tagId int NOT NULL,
	relevance decimal (10,3),

	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY CLUSTERED (title_sk,tagId)
);


-- Drop table
DROP TABLE IF EXISTS fct_ml_genome_scores_rejects;

CREATE TABLE fct_ml_genome_scores_rejects (
	genome_scores_sk int NOT NULL IDENTITY(1,1),

	movieId int not null,           -- MovieLens ID
	tagId int NOT NULL,
	relevance decimal (10,3),

	reject_reason varchar(80) not null default 'tconst not mtached with ml movieid',
	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (movieId,tagId)
);


DROP TABLE IF EXISTS fct_numbers_daily_box_office ;

CREATE TABLE fct_numbers_daily_box_office (
	daily_box_office_sk int NOT NULL IDENTITY(1,1),

	title_sk int NOT NULL,
	Show_Date datetime NOT NULL,
	Daily_Rank int,
	Daily_Gross bigint,
	Daily_Change_Pct decimal(10,3),
	Weekly_Change_Pct decimal(10,3),
	Number_of_Theaters int,
	Gross_Per_Theater bigint,
	Total_Gross bigint,
	Number_of_Days int,

	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (daily_box_office_sk)
);

-- Drop table
DROP TABLE IF EXISTS fct_numbers_franchise_all_box_office;

CREATE TABLE fct_numbers_franchise_all_box_office (
	franchise_all_sk int NOT NULL IDENTITY(1,1),

	franchise_sk int NOT NULL,

	No_of_Movies int NOT NULL,
	Domestic_Box_Office bigint NOT NULL,
	Infl_Adj_Dom_Box_Office bigint NOT NULL,
	Worldwide_Box_Office bigint NOT NULL,
	First_Year int NOT NULL,
	Last_Year int NOT NULL,
	No_of_Years int NOT NULL,

	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (franchise_all_sk)
);

-- Drop table
DROP TABLE IF EXISTS fct_numbers_franchise_movies_box_office ;

CREATE TABLE fct_numbers_franchise_movies_box_office (
	frachise_movies_box_office_sk int NOT NULL IDENTITY(1,1),
                   
    franchise_sk int NOT NULL,
	Release_Date datetime NOT NULL,
	title_sk int NOT NULL,
	Production_Budget bigint,
	Opening_Weekend bigint,
	Domestic_Box_Office bigint,
	Worldwide_Box_Office bigint,

	DI_JobID varchar(20) NOT NULL,
	DI_Create_DT datetime DEFAULT getdate() NOT NULL,
	PRIMARY KEY (frachise_movies_box_office_sk)
);

/*

ALTER TABLE FACT_FRANCHISES_GROSS ADD 
    FOREIGN KEY (Franchise_SK)
    REFERENCES DIM_IMDB_FRANCHISE (Franchise_SK);

ALTER TABLE FACT_FRANCHISES_LIST ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK);

ALTER TABLE FACT_FRANCHISES_LIST ADD 
    FOREIGN KEY (Franchise_SK)
    REFERENCES DIM_IMDB_FRANCHISE (Franchise_SK);

ALTER TABLE FACT_BRANDS_LIST ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK);

ALTER TABLE FACT_BRANDS_LIST ADD 
    FOREIGN KEY (Brand_SK)
    REFERENCES DIM_IMDB_BRAND(Brand_SK);

ALTER TABLE FACT_BRANDS_GROSS ADD 
    FOREIGN KEY (Brand_SK)
    REFERENCES DIM_IMDB_BRAND(Brand_SK);

ALTER TABLE DIM_TITLE_GENRES ADD 
    FOREIGN KEY (Title_SK )
    REFERENCES DIM_TITLE_INFO(Title_SK);

ALTER TABLE DIM_TITLE_GENRES ADD 
    FOREIGN KEY (Genre_SK )
    REFERENCES DIM_GENRES(Genre_SK);

ALTER TABLE DIM_EPISODE_INFO ADD 
    FOREIGN KEY (Parent_Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK);

ALTER TABLE DIM_KNOWNFORTITLES  ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK);

ALTER TABLE DIM_KNOWNFORTITLES  ADD 
    FOREIGN KEY (Person_SK)
    REFERENCES DIM_PERSON(Person_SK);

ALTER TABLE DIM_PERSON_PRIMARYPROFESSION  ADD 
    FOREIGN KEY (primaryProfession_SK)
    REFERENCES DIM_PRIMARYPROFESSION (primaryProfession_SK);

ALTER TABLE DIM_PERSON_PRIMARYPROFESSION  ADD 
    FOREIGN KEY (Person_SK)
    REFERENCES DIM_PERSON(Person_SK);

ALTER TABLE DIM_PERSON ADD 
    FOREIGN KEY (knownForTitles_sk)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;

ALTER TABLE DIM_PERSON ADD 
    FOREIGN KEY (primaryProfession_sk)
    REFERENCES DIM_JOB_CATEGORIES(Job_Category_SK)
;


ALTER TABLE DIM_TITLE_INFO ADD 
    FOREIGN KEY (Title_Type_SK)
    REFERENCES DIM_TITLE_TYPE(Title_Type_SK)
;

ALTER TABLE DIM_TITLE_ENHANCED ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;

ALTER TABLE DIM_TITLE_ENHANCED ADD 
    FOREIGN KEY (Country_SK)
    REFERENCES DIM_COUNTRY(Country_SK)
;

ALTER TABLE DIM_TITLE_ENHANCED ADD 
    FOREIGN KEY (Language_SK)
    REFERENCES DIM_LANGUAGE(Language_SK)
;

ALTER TABLE DIM_DIRECTOR_INFO ADD 
    FOREIGN KEY (Person_SK)
    REFERENCES DIM_PERSON(Person_SK)
;

ALTER TABLE DIM_DIRECTOR_INFO ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;

ALTER TABLE DIM_WRITER_INFO ADD 
    FOREIGN KEY (Person_SK)
    REFERENCES DIM_PERSON(Person_SK)
;

ALTER TABLE DIM_WRITER_INFO ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;

ALTER TABLE DIM_EPISODE_INFO ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;

ALTER TABLE DIM_PRINCIPAL_CREW ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;

ALTER TABLE DIM_PRINCIPAL_CREW ADD 
    FOREIGN KEY (Person_SK)
    REFERENCES DIM_PERSON(Person_SK)
;

ALTER TABLE DIM_PRINCIPAL_CREW ADD 
    FOREIGN KEY (Job_Category_SK)
    REFERENCES DIM_JOB_CATEGORIES(Job_Category_SK)
;

ALTER TABLE FACT_IMDB_RATINGS ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;

ALTER TABLE FACT_BOX_OFFICE ADD 
    FOREIGN KEY (Title_SK)
    REFERENCES DIM_TITLE_INFO(Title_SK)
;


*/