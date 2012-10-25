# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table client (
  id                        bigint not null,
  prenom                    varchar(255),
  nom                       varchar(255),
  constraint pk_client primary key (id))
;

create sequence client_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists client;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists client_seq;

