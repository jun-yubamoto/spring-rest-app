CREATE SCHEMA @postgresql.schema@;
alter role ${POSTGRES_USER} set search_path to @postgresql.schema@;