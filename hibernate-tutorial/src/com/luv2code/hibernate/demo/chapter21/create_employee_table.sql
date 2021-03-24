CREATE DATABASE IF NOT EXISTS hb_employee_tracker;

drop table if exists employee ;

create table `employee` (
`id` int(11) not null auto_increment,
`first_name` varchar(45) default null,
`last_name` varchar(45) default null,
`company` varchar(45) default null,
PRIMARY KEY(`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;