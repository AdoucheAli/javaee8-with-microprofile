DROP TABLE IF EXISTS fruits;
CREATE TABLE fruits (id int not null auto_increment primary key, name VARCHAR(50), season VARCHAR(50));
insert into fruits (name, season) values ('apricot', 'summer');
insert into fruits (name, season) values ('strawberry', 'summer');
insert into fruits (name, season) values ('melon', 'summer');
insert into fruits (name, season) values ('watermelon', 'summer');
insert into fruits (name, season) values ('nectarine', 'summer');

insert into fruits (name, season) values ('quince', 'autumn');
insert into fruits (name, season) values ('blackberry', 'autumn');
insert into fruits (name, season) values ('blueberry', 'autumn');
insert into fruits (name, season) values ('orange', 'autumn');
insert into fruits (name, season) values ('grape', 'autumn');

insert into fruits (name, season) values ('lemon', 'winter');
insert into fruits (name, season) values ('kiwi', 'winter');
insert into fruits (name, season) values ('mandarin', 'winter');
insert into fruits (name, season) values ('pear', 'winter');
insert into fruits (name, season) values ('apple', 'winter');

insert into fruits (name, season) values ('apple', 'spring');
insert into fruits (name, season) values ('lemon', 'spring');
insert into fruits (name, season) values ('kiwi', 'spring');
insert into fruits (name, season) values ('rhubarb', 'spring');
insert into fruits (name, season) values ('rasberry', 'spring');