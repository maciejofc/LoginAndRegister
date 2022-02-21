drop schema login_and_register;
create schema login_and_register;
use login_and_register;
CREATE TABLE `users` (
  `id` int not null auto_increment,
  `role` enum('member','admin') default 'member',
  `full_name` varchar(100) not null,
  `date_of_birth` date not null,
  `email` varchar(100) not null unique,
  `password` varchar(100) not null,
  `created_at` datetime default current_timestamp,
  `updated_at` datetime default current_timestamp  on update current_timestamp,
  
  PRIMARY KEY (`id`)
) 