create table TIPOS_IDENTIFICACION
(
IDEN_ID SERIAL not null,
IDEN_TIPO_IDENT VARCHAR(20) not null,
primary key (IDEN_ID)
);


create table ESTADOS_CIVILES
(
EST_ID SERIAL not null,
EST_ESTADO_CIVIL VARCHAR(13) not null,
primary key (EST_ID)
);


create table SEXOS
(
SEX_ID SERIAL not null,
SEX_SEXO VARCHAR(13) not null,
primary key (SEX_ID)
);

create table INSTITUCIONES
(
INS_ID SERIAL not null,
INS_INSTITUCION VARCHAR(70) not null,
primary key (INS_ID)
);


create table NIVELES_ESTUDIOS
(
NIV_ID SERIAL not null,
NIV_NIVEL_ESTUDIO VARCHAR(15) not null,
primary key (NIV_ID)
);

create table TITULOS_ESTUDIOS
(
TIT_ID SERIAL not null,
TIT_TITULO_ESTUDIO VARCHAR(70) not null,
primary key (TIT_ID)
);


create table ROLES 
(
ROL_ID SERIAL not null,
ROL_ROL VARCHAR(15) not null,
primary key (ROL_ID)
);


create table FUNCIONARIOS
(
FUN_ID VARCHAR(15) not null,
IDEN_ID INT not null,
FUN_NOMBRE VARCHAR(20) not null,
FUN_APELLIDO_PATERNO VARCHAR(12) not null,
FUN_APELLIDO_MATERNO VARCHAR(12) not null,
EST_ID INT not null,
SEX_ID INT not null,
FUN_DIRECCION VARCHAR(70)not null,
FUN_TELEFONO VARCHAR(15)not null,
FUN_FECHA_NACIMIENTO VARCHAR(10) not null,
primary key (FUN_ID),
foreign key (IDEN_ID) references TIPOS_IDENTIFICACION(IDEN_ID),
foreign key (EST_ID) references ESTADOS_CIVILES(EST_ID),
foreign key (SEX_ID) references SEXOS(SEX_ID)
);




create table INFORMACION_ACADEMICA
(
INF_ID SERIAL not null,
FUN_ID VARCHAR(15) not null,
INS_ID INT not null,
NIV_ID INT not null,
TIT_ID INT not null,
primary key (INF_ID),
foreign key (FUN_ID) references FUNCIONARIOS(FUN_ID),
foreign key (INS_ID) references INSTITUCIONES(INS_ID),
foreign key (NIV_ID) references NIVELES_ESTUDIOS(NIV_ID),
foreign key (TIT_ID) references TITULOS_ESTUDIOS(TIT_ID)
);


create table GRUPOS_FAMILIARES
(
GRU_ID VARCHAR(15) not null,
IDEN_ID INT not null,
GRU_NOMBRE VARCHAR(20) not null,
GRU_APELLIDO_PATERNO VARCHAR(12) not null,
GRU_APELLIDO_MATERNO VARCHAR(12) not null,
EST_ID INT not null,
SEX_ID INT not null,
GRU_DIRECCION VARCHAR(70)not null,
GRU_TELEFONO VARCHAR(15)not null,
GRU_FECHA_NACIMIENTO VARCHAR(10) not null,
FUN_ID VARCHAR(15) not null,
ROL_ID INT not null,
primary key (GRU_ID),
foreign key (IDEN_ID) references TIPOS_IDENTIFICACION(IDEN_ID),
foreign key (EST_ID) references ESTADOS_CIVILES(EST_ID),
foreign key (SEX_ID) references SEXOS(SEX_ID),
foreign key (FUN_ID) references FUNCIONARIOS(FUN_ID),
foreign key (ROL_ID) references ROLES(ROL_ID)
);

ALTER TABLE GRUPOS_FAMILIARES ALTER COLUMN GRU_FECHA_NACIMIENTO SET DATA TYPE VARCHAR(10);

insert into TIPOS_IDENTIFICACION (IDEN_TIPO_IDENT) values 
('Cédula ciudadanía'),
('Tarjeta identidad'),
('Registro civil'),
('Cédula Extranjeria'),
('Pasaporte');


insert into ESTADOS_CIVILES (EST_ESTADO_CIVIL) values
('Soltero/a'),
('Casado/a'),
('Divorciado/a'),
('Viudo/a');


insert into SEXOS (SEX_SEXO) values
('Masculino'),
('Femenino');



insert into INSTITUCIONES (INS_INSTITUCION) values
('Institución Universitaria Digital de Antioquia'),
('Universidad Nacional de Colombia'),
('Pontificia Universidad Javeriana'),
('Universidad de Antioquia'),
('Servicio Nacional de Aprendizaje SENA'),
('Politécnico Grancolombiano'),
('Universidad Naciona Abierta y a Distancia UNAD'),
('Universidad Antonio Nariño');


insert into NIVELES_ESTUDIOS (NIV_NIVEL_ESTUDIO) values
('Bachiller'),
('Técnico Laboral'),
('Técnico Profesional'),
('Tecnólogo'),
('Profesional'),
('Especialización'),
('Maestría'),
('Doctorado');


select * from TIPOS_IDENTIFICACION


insert into TITULOS_ESTUDIOS (TIT_TITULO_ESTUDIO) values
('Administración de Empresas'),
('Ingeniería de Sistemas'),
('Derecho'),
('Contaduria'),
('Ingeniería Electrónica'),
('Ingeniería de Telecomunicaciones'),
('Diseño Gráfico'),
('Publicidad y Mercadeo'),
('Licenciatura en Idiomas'),
('Licenciatura en Matematicas');

insert into ROLES (ROL_ROL) values
('Padre'),
('Madre'),
('Hijo/a'),
('Hermano/a'),
('Abuelo/a'),
('Tio/a'),
('Sobrino'),
('Primo'),
('Conyuge');



insert into FUNCIONARIOS (FUN_ID,IDEN_ID,FUN_NOMBRE,FUN_APELLIDO_PATERNO,FUN_APELLIDO_MATERNO,EST_ID,SEX_ID,FUN_DIRECCION,FUN_TELEFONO,FUN_FECHA_NACIMIENTO) values
('79458956',1,'Carlos Andres','Pérez','Sarmiento',2,1,'Cra 8 con cll 60','3094563259','15/12/1977'),
('54659852',1,'Sandra Milena','Gómez','López',2,2,'Cll 32 con cra 10','3096588521','25/09/1989'),
('80654741',1,'Jorge Martín','Castro','Alvarez',1,1,'Cra 11 con cll 12','3098745617','10/01/1990'),
('41658911',1,'Maria Lucia','Andrade','Benavidez',3,2,'Cll 56 con cra 18','3096874521','3/06/1985'),
('79258693',1,'Jose Guillermo','Jimenez','Mendez',3,1,'Cra 40 con cll 33','3095477411','22/05/1970');


insert into GRUPOS_FAMILIARES (GRU_ID,IDEN_ID,GRU_NOMBRE,GRU_APELLIDO_PATERNO,GRU_APELLIDO_MATERNO,EST_ID,SEX_ID,GRU_DIRECCION,GRU_TELEFONO,GRU_FECHA_NACIMIENTO,FUN_ID,ROL_ID) values
('52356987',1,'Marcela','Ordoñez','Gonzalez',2,2,'Cra 8 con cll 60','3085874529','16/10/1979','79458956',9),
('1023589623',3,'Valentina','Pérez','Ordoñez',1,2,'Cra 8 con cll 60','3094563259','12/01/2022','79458956',3),
('80598521',1,'Juan Carlos','Acosta','Restrepo',2,1,'Cll 32 con cra 10','3085697711','8/09/1985','54659852',9),
('5987456',1,'Alvaro','Nuñez','Diaz',2,1,'Cra 11 con cll 12','3085549688','11/04/1961','80654741',1),
('9563258',1,'Martha Eugenia','Chilatra','Rojas',2,2,'Cra 11 con cll 12','3085549688','25/07/1965','80654741',2);


insert into INFORMACION_ACADEMICA (FUN_ID,INS_ID,NIV_ID,TIT_ID) values 
('79458956',4,5,2),
('54659852',3,6,3),
('80654741',1,5,8),
('41658911',5,7,6),
('79258693',7,6,4);







