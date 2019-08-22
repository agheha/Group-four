create sequence seq_store_menu_no;
create sequence seq_store_no;
create sequence seq_user_no;
create sequence seq_rev_no;

-- 유저 테이블 데이터 등록
insert into user_tb(user_no, user_id, user_pass, user_name, user_birth) values (seq_user_no.nextval, 'qweqwe123', 'dsfaqweqw1', '이민기', '19880120');
insert into user_tb(user_no, user_id, user_pass, user_name, user_birth) values (seq_user_no.nextval, 'asemasklq', '12837mkk', '김성룡', '19950321');
insert into user_tb(user_no, user_id, user_pass, user_name, user_birth) values (seq_user_no.nextval, 'qweqwe123', 'zzasdqmwe', '남궁민', '19710928');
insert into user_tb(user_no, user_id, user_pass, user_name, user_birth) values (seq_user_no.nextval, 'ggpqaz', 'asdlkase', '유재석', '19760217');
insert into user_tb(user_no, user_id, user_pass, user_name, user_birth) values (seq_user_no.nextval, 'playbit', 'bit1231', '박주영', '19830505');

-- 메뉴테이블 데이터 등록
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (1, 1, '카츠카레', 8500, 900);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (1, 2, '푸치카츠카레', 7000, 800);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (2, 1, '고기덴뿌라', 7900, 1200);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (2, 2, '충화짬뽕', 8900, 800);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (3, 1, '순대국', 7000, 800);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (3, 2, '물냉면', 7000, 560);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (3, 3, '비빔냉면', 7000, 650);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (4, 1, '솥밥', 7000, 1000);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (4, 2, '등심돈까스', 8000, 1300);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (5, 1, '닭칼국수', 7000, 800);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (5, 2, '춘천닭갈비덮밥', 7000, 900);
insert into store_menu_tb(sto_no,	menu_no, menu, price, calorie) values (5, 3, '닭개장', 7000, 900);

-- 가게 테이블 데이터 등록
insert into store_tb(sto_no, sto_id, sto_pass, sto_name, rst_menu, rst_price, sto_type, bit_distance, sto_gpa, sto_addr,sto_hours, sto_phone_number, sto_seat, sto_now_seat, bit_position, acc_reservation)
values(seq_store_no.nextval, 'asd1234', '12345678', '고이짱돈카츠', '돈카츠', 7500, '일식', 100, 0, '서울특별시 마포구 대흥동 백범로 38', '11302030', '02-714-2253', 40, 0, 0, 0);
insert into store_tb(sto_no, sto_id, sto_pass, sto_name, rst_menu, rst_price, sto_type, bit_distance, sto_gpa, sto_addr,sto_hours, sto_phone_number, sto_seat, sto_now_seat, bit_position, acc_reservation)
values(seq_store_no.nextval, 'qwe1121', 'zxcasd11', '충화반점', '라구짜장', 8900, '중식', 200, 0, '서울특별시 마포구 대흥동 백범로1길 8-9', '11302200', '070-4100-6221', 40, 0, 0, 0);
insert into store_tb(sto_no, sto_id, sto_pass, sto_name, rst_menu, rst_price, sto_type, bit_distance, sto_gpa, sto_addr,sto_hours, sto_phone_number, sto_seat, sto_now_seat, bit_position, acc_reservation)
values(seq_store_no.nextval, 'cjdtjrrhf', 'aqqwe1ssd', '청석골감자탕', '감자탕', 7000, '한식', 150, 0, '서울특별시 마포구 노고산동', '08302200', '02-701-3797', 50, 0, 0, 0);
insert into store_tb(sto_no, sto_id, sto_pass, sto_name, rst_menu, rst_price, sto_type, bit_distance, sto_gpa, sto_addr,sto_hours, sto_phone_number, sto_seat, sto_now_seat, bit_position, acc_reservation)
values(seq_store_no.nextval, 'aqe8712', '123aasw', '홍두깨칼국수', '칼국수', 7000, '한식', 300, 0, '서울특별시 마포구 대흥동 백범로1길 10', '11002000', '02-711-8889', 100, 0, 0, 0);
insert into store_tb(sto_no, sto_id, sto_pass, sto_name, rst_menu, rst_price, sto_type, bit_distance, sto_gpa, sto_addr,sto_hours, sto_phone_number, sto_seat, sto_now_seat, bit_position, acc_reservation)
values(seq_store_no.nextval, 'youdack12', '1231221', '유닭스토리', '닭곰탕', 7000, '한식', 600, 0, '서울특별시 서대문구 창천동 18-72', '11002400', '02-6012-9563', 100, 0, 0, 0);

-- 리뷰테이블 데이터 등록
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(1, 1, 1, 4, '맛있어요', '생각보다 엄청맛있었어요');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(1, 2, 2, 3, '그냥 그래요', '기대만큼 맛있지않아요 ');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(1, 3, 3, 3, '최고에요', '완전맛있어요 ');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(2, 1, 1, 4, '맛있어요', '생각보다 엄청맛있었어요');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(2, 2, 2, 4, '맛있어요', '맛있어요 ');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(2, 3, 3, 5, '최고에요', '최고에요 ');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(3, 1, 1, 4, '맛있어요', '생각보다 엄청맛있었어요');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(3, 2, 2, 3, '그냥 그래요', '기대만큼 맛있지않아요 ');
insert into review_tb(user_no, sto_no, rev_no, gpa, rev_title, rev_content)
values(3, 3, 3, 3, '최고에요', '완전맛있어요 ');

drop table store_tb purge;

drop table store_menu_tb purge;

drop table user_tb purge;

drop table review_tb purge;

drop table admin_tb purge;

drop table RESERVATION_TB purge;

select * from tab;

select *
  from USER_SEQUENCES;
  
drop sequence USER_REVIEW_TB_SEQ;
