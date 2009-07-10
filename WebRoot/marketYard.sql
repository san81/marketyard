drop database marketyard;
create database marketyard;

use marketyard;
drop table IF EXISTS Account_Types;
create table Account_Types(
account_type_id  integer auto_increment primary key,
account_type varchar(20),
description varchar(200)
) ENGINE=INNODB;

drop table IF EXISTS accounts;
create table Accounts(
account_id integer auto_increment primary key,
login_name varchar(20) unique not null,
password varchar(255),
name varchar(200),
mobile varchar(20),
account_type_id integer not null,
address text,
village varchar(255),
regdate datetime,
FOREIGN KEY(account_type_id) REFERENCES Account_Types(account_type_id) ON UPDATE CASCADE
) ENGINE=INNODB;

drop table IF EXISTS seeds;
create table seeds(
seed_id integer auto_increment primary key,
name varchar(255) not null unique
) ENGINE=INNODB;

drop table IF EXISTS slip;
create table slip(
slip_id integer auto_increment primary key,
datetime datetime,
seed_id integer,
farmar_name varchar(200),
farmar_village varchar(200),
buyer_account_id integer,
bags integer,
loose_bag integer,
barthi integer,
rate numeric(10,2),
qtls numeric(12,2),
hamali_rate numeric(10,2),
adthi_rate numeric(10,2),
cc_rate numeric(10,2),
description text,
FOREIGN KEY(seed_id) REFERENCES seeds(seed_id) ON UPDATE CASCADE,
FOREIGN KEY(buyer_account_id) REFERENCES Accounts(account_id) ON UPDATE CASCADE
)ENGINE=INNODB;

drop table if exists transaction;
-- trans_type may be 1-purchase, 2-sale, 3 � payments, 4 - reciepts
create table transaction(
trans_id integer auto_increment primary key,
datetime datetime not null,
account_id integer not null,
amount numeric(14,2) not null,
trans_flow varchar(2) not null,
trans_type integer(2) not null,
reference_id integer,
description text,
FOREIGN KEY(reference_id) REFERENCES slip(slip_id) ON UPDATE CASCADE,
FOREIGN KEY(account_id) REFERENCES accounts(account_id) ON UPDATE CASCADE
);

--- default data
insert into account_types (account_type,description) values ('ADMIN','The only Administrator for the company');
insert into account_types (account_type,description) values ('BUYER','people who participate in the buying');
insert into account_types (account_type,description) values ('SUPPLIER','people who sell out the seeds');

insert into seeds (name) values ('paddy');
insert into seeds (name) values ('maize');
insert into seeds (name) values ('sugarcane');
