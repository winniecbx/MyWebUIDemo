drop table if exists field_definition;
create table if not exists field_definition (id serial primary key,  module varchar,   tab varchar,   isCommon boolean,   button varchar,   isGrid boolean,   grid varchar,   gridButton varchar,   winTitle varchar,   fieldType varchar,   fieldLabel varchar,   value varchar,   fieldSeq varchar ); 
