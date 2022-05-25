/*
-- system �������� phonedb ���������, ���Ѻο��ϱ� --
create user phonedb identified by phonedb;
grant resource, connect to phonedb;
*/

--���̺�, ������ ����
drop table person;
drop SEQUENCE seq_person_id;

--���̺� ����
create table person(
    person_id    number(5),
    name        VARCHAR2(30)    not null,
    hp          varchar2(20),
    company     varchar2(20),
    PRIMARY KEY (person_id)
);

--������ ����
create sequence seq_person_id
increment by 1
start with 1
nocache;

--insert (������� �ֱ�)
insert into person
values (seq_person_id.nextval, '��ȿ��', '010-1111-1111', '02-1111-1111');

insert into person
values (seq_person_id.nextval, '���켺', '010-2222-2222', '02-2222-2222');

insert into person
values (seq_person_id.nextval, '���缮', '010-3333-3333', '02-3333-3333');

insert into person
values (seq_person_id.nextval, '������', '010-4444-4444', '02-4444-4444');

insert into person
values (seq_person_id.nextval, '������', '010-5555-5555', '02-5555-5555');

select *
from person;

--update (������ ���� ����)
update person
set hp = '010-9999-9999', company = '02-9999-9999'
where person_id = 4;

--delete (������ ����)
delete person
where person_id = 5;

--���� ���
select  person_id
        ,name
        ,hp
        ,company
from person;









