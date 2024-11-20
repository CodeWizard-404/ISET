use Movies_DW
alter view vTop_100_Movies as
select top 100 titleInfo.title_sk,Title,
				Release_Year,
				startYear as 'Release Year',
				runtimeMinutes as'Movie Runtime',
				Worldwide_LifetimeGross,
				Domestic_LifetimeGross as 'Domestic Earning'
from FACT_BOX_OFFICE BO
join DIM_TITLE_INFO titleInfo
on BO.Title_SK = titleInfo.Title_SK
order by Title;
----------------------------------
alter view vActor_Actresses as
(select  tif.Title_SK,
		primaryName,
		birthYear,
		deathYear,
		name_webURL as 'Profile Link',
		characters_name,
		primaryTitle as 'Movie Name',
		startYear as 'Release Year',
		webURL as 'Movie Link',
		case 
			when pc.Job_Category_SK = 7 then 'Actor'
			when pc.Job_Category_SK = 8 then 'Actress'
		end as 'Profession'
from DIM_PERSON p
join (select * from DIM_PRINCIPAL_CREW where Job_Category_SK in(7,8))pc
on p.Person_SK = pc.Person_SK
join DIM_TITLE_INFO tif
on pc.Title_SK = tif.Title_SK
)

---------------------------------------------------
alter view vDirectorInfo as
select	tif.Title_SK,
		primaryName,
		birthYear,
		deathYear,
		name_webURL as 'Profile Link',
		primaryTitle as 'Movie Name',
		startYear as 'Release Year',
		endyear as 'End Year',
		webURL as 'Movie Link'
		
from DIM_PERSON p
join DIM_DIRECTOR_INFO dir
on p.Person_SK = dir.Person_SK
join DIM_TITLE_INFO tif
on dir.Title_SK = tif.Title_SK
----------------------------------------------

alter view vWriterInfo as
select	tif.Title_SK,
		p.primaryName,
		birthYear,
		deathYear,
		name_webURL as 'Profile Link',
		tif.primaryTitle as 'Movie Name',
		startYear as 'Release Year',
		endyear as 'End Year',
		webURL as 'Movie Link'
		
from DIM_PERSON p
join DIM_WRITER_INFO wri
on p.Person_SK = wri.Person_SK
join DIM_TITLE_INFO tif
on wri.Title_SK = tif.Title_SK

-------------------------------------------------------
alter view vGenres as
select tif.Title_SK,
primaryTitle,
genres 

from DIM_TITLE_GENRES tgen
join DIM_TITLE_INFO tif
on tgen.Title_SK = tif.Title_SK
join (select Genre_SK,genres from DIM_GENRES where genre_source = 'IMDB')gen
on gen.Genre_SK = tgen.Genre_SK


-----------------------------------------------------------


alter view vMovies_Selected as
select	tif.Title_SK,
		primaryName,
		birthYear,
		deathYear,
		name_webURL as 'Profile Link',
		characters_name,
		primaryTitle as 'Movie Name',
		startYear as 'Release Year',
		webURL as 'Movie Link',
		case 
			when pc.Job_Category_SK = 7 then 'Actor'
			when pc.Job_Category_SK = 8 then 'Actress'
		end as 'Profession'
from (select * from DIM_PERSON where primaryName in 
('John Cusack','Ana de Armas','Rian Johnson','Daisy Ridley','Samuel L. Jackson','J.J. Abrams','Kathryn Bigelow','Nicolas Cage','Scarlett Johansson','Dwayne Johnson','Emilia Clarke','Woody Harrelson','Idris Elba','Sean Connery','Gal Gadot')) p
join (select * from DIM_PRINCIPAL_CREW where Job_Category_SK in(7,8))pc
on p.Person_SK = pc.Person_SK
join DIM_TITLE_INFO tif
on pc.Title_SK = tif.Title_SK


---------------------------------------------

select count(distinct titleType) from DIM_TITLE_INFO inf
join FACT_IMDB_RATINGS rat
on rat.Title_SK = inf.Title_SK
join DIM_TITLE_TYPE typ
on inf.Title_Type_SK = typ.Title_Type_SK

