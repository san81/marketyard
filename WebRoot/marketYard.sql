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
regdate timestamp default now(), 
FOREIGN KEY(account_type_id) REFERENCES Account_Types(account_type_id) ON UPDATE CASCADE
) ENGINE=INNODB;

drop table IF EXISTS seeds;
create table seeds(
seed_id integer auto_increment primary key,
name varchar(255) not null unique
) ENGINE=INNODB;

drop table IF EXISTS slip;
-- status column is to check whether the bill has been paid, possible values are PENDING, CLOSED.
create table slip(
slip_id integer auto_increment primary key,
datetime timestamp default now(),
seed_id integer not null,
supplier_account_id integer not null,
buyer_account_id integer not null,
bags integer not null,
loose_bag integer,
barthi integer not null,
rate numeric(10,2) not null,
qtls numeric(12,2) not null,
auto_calculate boolean not null default true,
hamali_rate numeric(10,2),
adthi_rate numeric(10,2),
cc_rate numeric(10,2),
status varchar(10) not null,
description text,
FOREIGN KEY(seed_id) REFERENCES seeds(seed_id) ON UPDATE CASCADE,
FOREIGN KEY(buyer_account_id) REFERENCES Accounts(account_id) ON UPDATE CASCADE,
FOREIGN KEY(supplier_account_id) REFERENCES Accounts(account_id) ON UPDATE CASCADE
)ENGINE=INNODB;

drop table if exists transaction;

-- trans_flow may be 1-debit(DR)(outflow) or 2-credit(CR)(inflow).
-- payment_mode should be either CASH or CHECK. when it is CHECK, then payemnt detaild_id exists.

create table transaction(
trans_id integer auto_increment primary key,
datetime datetime not null,
account_id integer not null,
amount numeric(14,2) not null,
trans_flow varchar(2) not null,
payment_mode varchar(10) not null,
payment_details_id integer,
reference_id integer,
description text,
FOREIGN KEY(reference_id) REFERENCES slip(slip_id) ON UPDATE CASCADE,
FOREIGN KEY(account_id) REFERENCES accounts(account_id) ON UPDATE CASCADE
);

drop table if exists payment_details;
-- entry comes in to this table, only when the payment mode is check.
-- it will represent all the check payment details.
create table payment_details(
payment_details_id integer auto_increment primary key,
datetime datetime not null,
transaction_id integer,
bank_name varchar(100) not null,
branch_name varchar(100),
check_number varchar(25) not null,
amount numeric(14,2) not null,
description varchar(255),
FOREIGN KEY(transaction_id) REFERENCES transaction(trans_id) ON UPDATE CASCADE
);

-- default data
insert into account_types (account_type,description) values ('CAPITAL','Account to represent initial capital investment');
insert into account_types (account_type,description) values ('ADMIN','The only Administrator for the company');
insert into account_types (account_type,description) values ('BUYER','people who participate in the buying');
insert into account_types (account_type,description) values ('SUPPLIER','people who sell out the seeds');
insert into account_types (account_type,description) values ('NOMINAL','account which do not representing persons');
insert into account_types (account_type,description) values ('BANK','account which represents banks');

-- essential entries
insert into accounts (login_name,password,name,account_type_id) values ('anonymous','password','anonymous',4);

insert into accounts (login_name,password,name,account_type_id) values ('Hamali','password','Hamali',5);
insert into accounts (login_name,password,name,account_type_id) values ('CC','password','CC',5);
insert into accounts (login_name,password,name,account_type_id) values ('MF','password','MF',5);

-- defaul data entries
insert into seeds (name) values ('paddy');
insert into seeds (name) values ('maize');
insert into seeds (name) values ('sugarcane');

insert into accounts (login_name,password,name,account_type_id) values ('santosh_capital','password','Santosh',1);
insert into accounts (login_name,password,name,account_type_id) values ('srinu_capital','password','Sreenivas',1);
insert into accounts (login_name,password,name,account_type_id) values ('santosh','password','Santosh',2);
insert into accounts (login_name,password,name,account_type_id) values ('srinu','password','Sreenivas',2);
insert into accounts (login_name,password,name,account_type_id) values ('murali','password','murali',3);
insert into accounts (login_name,password,name,account_type_id) values ('sudheer','password','sudheer',4);
insert into accounts (login_name,password,name,account_type_id) values ('SBI','password','SBI',6);
