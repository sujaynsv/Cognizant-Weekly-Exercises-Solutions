-- Database schema creation for geographical territories demonstration
-- This script sets up a basic country table with sample data for ORM learning

use om-learn;

-- Create nations table to store country information
create table country (
    co_code varchar(2) primary key,
    co_name varchar(50)
);

-- Insert sample geographical territory data
insert into country values ('IN', 'India');
insert into country values ('US', 'United States of America');