Create table resultados (
id integer not Null  primary key AUTO_INCREMENT,
Ronda int not Null,
Equipo1 varchar(30) not NULL,
Cant_Goles1 int not Null, 
Cant_Goles2 int not Null,
Equipo2 varchar(30) not NULL);
/**/
Create table pronosticos(
	id integer not Null,
	Participante varchar(50) not NULL, 
	Equipo1 varchar(30) not NULL,
	Gana1 int not Null,
	Empata int not Null,
	Gana2 int not Null,
	Equipo2 varchar(30) not NULL);
	
	/**/
	
	Insert Into resultados(Ronda,Equipo1,Cant_Goles1,Cant_Goles2,Equipo2)
	values 
	(1,'Argentina',1,2,'Arabia Saudita'),
	(1,'Polonia',0,0,'México'),
	(2,'Polonia',2,0,'Arabia Saudita'),
	(2,'Argentina',2,0,'México'),
	(3,'Polonia',0,2,'Argentina'),
	(3,'Arabia Saudita',1,2,'México');
	
	
	
	Insert Into pronosticos values 
	
	(1,'Matias','Argentina',1,0,0,'Arabia Saudita'),
	(2,'Sole','Argentina',1,0,0,'Arabia Saudita'),
	(3,'Mateo','Argentina',1,0,0,'Arabia Saudita'),
	(4,'Ezequiel','Argentina',0,0,1,'Arabia Saudita'),
	
	(1,'Matias','Polonia',0,1,0,'México'),
	(2,'Sole','Polonia',0,1,0,'México'),
	(3,'Mateo','Polonia',1,0,0,'México'),
	(4,'Ezequiel','Polonia',0,1,0,'México'),
	
	(1,'Matias','Polonia',1,0,0,'Arabia Saudita'),
	(2,'Sole','Polonia',0,1,0,'Arabia Saudita'),
	(3,'Mateo','Polonia',1,0,0,'Arabia Saudita'),
	(4,'Ezequiel','Polonia',1,0,0,'Arabia Saudita'),
	
	(1,'Matias','Argentina',0,0,1,'México'),
	(2,'Sole','Argentina',1,0,0,'México'),
	(3,'Mateo','Argentina',0,1,0,'Arabia Saudita'),
	(4,'Ezequiel','Argentina',1,0,0,'México'),
	
	(1,'Matias','Polonia',0,1,0,'Argentina'),
	(2,'Sole','Polonia',0,0,1,'Argentina'),
	(3,'Mateo','Polonia',0,0,1,'Argentina'),
	(4,'Ezequiel','Polonia',0,0,1,'Argentina'),
	
	(1,'Matias','Arabia Saudita',0,0,1,'México'),
	(2,'Sole','Arabia Saudita',0,0,1,'México'),
	(3,'Mateo','Arabia Saudita',0,0,1,'México'),
	(4,'Ezequiel','Arabia Saudita',0,0,1,'México');
	
	/**/
	  create table apostadores(
		  id integer not null,
		  nom varchar(50) not null,
		  asiertos int not null,
		  primary key (id,nom)
	  );
	  
	  
	  Insert Into apostadores values 
	  (1,'Matias',0),
	  (2,'Sole',0),
	  (3,'Mateo',0),
	  (4,'Ezequiel',0);
	  
	/*Cuenta asiertos si los equpos empatan gana*/
UPDATE apostadores ap
	SET asiertos = asiertos +(
    SELECT count(*) FROM pronosticos pr , resultados rs
    WHERE ap.id = pr.id 
	and rs.equipo1=pr.equipo1 
	and rs.equipo2=pr.equipo2 
	and empata=1 and cant_goles1 = cant_goles2	 
);
	/*Cuenta asiertos si el equipo 1 gana*/
	UPDATE apostadores ap
	SET asiertos = asiertos +(
    SELECT count(*) FROM pronosticos pr , resultados rs
    WHERE ap.id = pr.id 
	and rs.equipo1=pr.equipo1 
	and rs.equipo2=pr.equipo2 
	and gana1=1 and cant_goles1 > cant_goles2	 
);
	/*Cuenta asiertos si el equipo 2 gana*/
	UPDATE apostadores ap
	SET asiertos = asiertos + (
    SELECT count(*) FROM pronosticos pr , resultados rs
    WHERE ap.id = pr.id 
	and rs.equipo1=pr.equipo1 
	and rs.equipo2=pr.equipo2 
	and gana2=1 and cant_goles1 < cant_goles2	 
);

select * from pronosticos; /*muestra tabla de pronosticos de partidos*/

select * from resultados; /*muestra tabla de resultados de partidos*/
select * from apostadores; /*muestra tabla de apostadores*/