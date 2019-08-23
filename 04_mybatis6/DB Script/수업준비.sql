drop table tb_mybatis_member;

create table tb_mybatis_member(
    id      varchar2(20),
    name    varchar2(20),
    addr    varchar2(100),
    email   varchar2(20),
    join_date date default sysdate
);

insert into tb_mybatis_member values('member-1', 'sbc',    'seoul',    'sbc@yahoo.co.kr', sysdate);
insert into tb_mybatis_member values('member-2', 'spring', 'busan',    'abc@yahoo.co.kr', sysdate);
insert into tb_mybatis_member values('member-3', 'jsp',    'daejeon',  'ddd@yahoo.co.kr', sysdate);
insert into tb_mybatis_member values('member-4', 'spring', 'gyeonggi', 'eee@yahoo.co.kr', sysdate);

select * from tb_mybatis_member;

create table tb_mybatis_account (
    id varchar2(20) primary key,
    money number(10),
    open_date date default sysdate
);

insert into tb_mybatis_account(id, money) values('member-1', 10000);
insert into tb_mybatis_account(id, money) values('member-2', 30000);
insert into tb_mybatis_account(id, money) values('member-3', 70000);
insert into tb_mybatis_account(id, money) values('member-4', 20000);

create table tb_mybatis_board (
    no number(6) primary key,
    title varchar2(200) not null,
    writer varchar2(30) not null,
    content varchar2(4000) not null,
    reg_date date default sysdate
);

create sequence s_mybatis_board_no;

insert into tb_mybatis_board(no, title, writer, content) values(s_mybatis_board_no.nextval, 'a1', 'member-1', 'c1');

insert into tb_mybatis_board(no, title, writer, content) values(s_mybatis_board_no.nextval, 'a2', 'member-1', 'c2');

insert into tb_mybatis_board(no, title, writer, content) values(s_mybatis_board_no.nextval, 'a3', 'member-2', 'c3');

insert into tb_mybatis_board(no, title, writer, content) values(s_mybatis_board_no.nextval, 'a4', 'member-3', 'c4');

create table tb_mybatis_comment
(
  comment_no  number(6),
  no          number(6),
  writer      varchar2(30)   not null,
  content     varchar2(1000) not null,
  reg_date    date           default sysdate
);

create sequence s_mybatis_comment_no;

insert into tb_mybatis_comment(comment_no, no, writer, content) values(s_mybatis_comment_no.nextval, 1, 'member-1', 'c1');

insert into tb_mybatis_comment(comment_no, no, writer, content) values(s_mybatis_comment_no.nextval, 2, 'member-1', 'c2');

insert into tb_mybatis_comment(comment_no, no, writer, content) values(s_mybatis_comment_no.nextval, 2, 'member-2', 'c3');

insert into tb_mybatis_comment(comment_no, no, writer, content) values(s_mybatis_comment_no.nextval, 4, 'member-3', 'c4');

create sequence s_mybatis_file_no;

create table tb_mybatis_file (
	file_no number(6) primary key,
	no number(6),
	file_name varchar2(100),
	file_size number
);

commit;