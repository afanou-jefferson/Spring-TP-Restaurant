create table plat
(
  id_plat int(11) not null primary key auto_increment,
  nom_plat varchar(100) not null unique,
  prix_plat int(7) not null
);