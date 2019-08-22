-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.

-- store_tb Table Create SQL
CREATE TABLE store_tb
(
    sto_no                  number           NULL, 
    sto_id                  VARCHAR2(30)     NOT NULL, 
    sto_pass                VARCHAR2(30)     NOT NULL, 
    sto_name                VARCHAR2(50)     NOT NULL, 
    rst_menu     VARCHAR2(50)     NOT NULL, 
    rst_price    NUMBER           NOT NULL, 
    sto_type                VARCHAR2(10)     NOT NULL, 
    bit_distance            NUMBER           NOT NULL, 
    sto_gpa                 NUMBER           NULL, 
    sto_addr                VARCHAR2(300)    NULL, 
    sto_hours               VARCHAR2(8)      NULL, 
    sto_phone_number        VARCHAR2(13)	NULL, 
    sto_seat                NUMBER           NULL, 
    sto_now_seat            NUMBER           NULL, 
    bit_position            NUMBER           NULL, 
    acc_reservation         NUMBER           NULL, 
    CONSTRAINT STORE_TB_PK PRIMARY KEY (sto_no)
)
/

COMMENT ON TABLE store_tb IS '가게'
/

COMMENT ON COLUMN store_tb.sto_no IS '가게번호'
/

COMMENT ON COLUMN store_tb.sto_id IS '가게아이디'
/

COMMENT ON COLUMN store_tb.sto_pass IS '가게비밀번호'
/

COMMENT ON COLUMN store_tb.sto_name IS '가게이름'
/

COMMENT ON COLUMN store_tb.rst_menu IS '대표메뉴'
/

COMMENT ON COLUMN store_tb.rst_price IS '대표가격'
/

COMMENT ON COLUMN store_tb.sto_type IS '가게타입'
/

COMMENT ON COLUMN store_tb.bit_distance IS '거리'
/

COMMENT ON COLUMN store_tb.sto_gpa IS '가게평점'
/

COMMENT ON COLUMN store_tb.sto_addr IS '가게주소'
/

COMMENT ON COLUMN store_tb.sto_hours IS '가게영업시간'
/

COMMENT ON COLUMN store_tb.sto_phone_number IS '가게전화번호'
/

COMMENT ON COLUMN store_tb.sto_seat IS '가게좌석수'
/

COMMENT ON COLUMN store_tb.sto_now_seat IS '현재좌석수'
/

COMMENT ON COLUMN store_tb.bit_position IS '비트캠프위치'
/

COMMENT ON COLUMN store_tb.acc_reservation IS '누적예약수'
/


-- store_tb Table Create SQL
CREATE TABLE user_tb
(
    user_no       NUMBER          NULL, 
    user_id       VARCHAR2(30)    NOT NULL, 
    user_pass     VARCHAR2(30)    NOT NULL, 
    user_name     VARCHAR2(30)    NOT NULL, 
    user_birth    VARCHAR2(8)     NOT NULL, 
    CONSTRAINT USER_TB_PK PRIMARY KEY (user_no)
)
/

COMMENT ON TABLE user_tb IS '회원'
/

COMMENT ON COLUMN user_tb.user_no IS '회원번호'
/

COMMENT ON COLUMN user_tb.user_id IS '회원아이디'
/

COMMENT ON COLUMN user_tb.user_pass IS '회원비밀번호'
/

COMMENT ON COLUMN user_tb.user_name IS '회원이름'
/

COMMENT ON COLUMN user_tb.user_birth IS '회원 생년월일'
/


-- store_tb Table Create SQL
CREATE TABLE review_tb
(
    user_no            NUMBER            NULL, 
    sto_no             NUMBER            NULL, 
    rev_no          NUMBER            NULL, 
    gpa				NUMBER	  default 0,
    rev_title       VARCHAR2(300)     NOT NULL, 
    rev_content     VARCHAR2(1000)    NOT NULL, 
    rev_reg_date    DATE   default     sysdate, 
    CONSTRAINT USER_REVIEW_TB_PK PRIMARY KEY (user_no, sto_no, rev_no)
)
/

COMMENT ON TABLE review_tb IS '리뷰'
/

COMMENT ON COLUMN review_tb.user_no IS '회원번호'
/

COMMENT ON COLUMN review_tb.sto_no IS '가게번호'
/

COMMENT ON COLUMN review_tb.gpa IS '평점'
/

COMMENT ON COLUMN review_tb.rev_no IS '리뷰번호'
/

COMMENT ON COLUMN review_tb.rev_title IS '리뷰제목'
/

COMMENT ON COLUMN review_tb.rev_content IS '리뷰내용'
/

COMMENT ON COLUMN review_tb.rev_reg_date IS '리뷰등록일'
/

ALTER TABLE review_tb
    ADD CONSTRAINT FK_user_review_tb_user_no_user FOREIGN KEY (user_no)
        REFERENCES user_tb (user_no)
/

ALTER TABLE review_tb
    ADD CONSTRAINT FK_user_review_tb_sto_no_store FOREIGN KEY (sto_no)
        REFERENCES store_tb (sto_no)
/


-- store_tb Table Create SQL
CREATE TABLE admin_tb
(
    admin_id      VARCHAR2(30)    NOT NULL, 
    admin_pass    VARCHAR2(30)    NOT NULL, 
    CONSTRAINT ADMIN_TB_PK PRIMARY KEY (admin_id)
)
/

COMMENT ON TABLE admin_tb IS '관리자'
/

COMMENT ON COLUMN admin_tb.admin_id IS '관리자아이디'
/

COMMENT ON COLUMN admin_tb.admin_pass IS '관리자비밀번호'
/


-- store_tb Table Create SQL
CREATE TABLE store_menu_tb
(
    sto_no     NUMBER          NULL, 
    menu_no   NUMBER	   NOT NULL,
    menu       VARCHAR2(50)    NOT NULL, 
    price      NUMBER          NOT NULL, 
    calorie    NUMBER          NULL, 
    CONSTRAINT STORE_MENU_TB_PK PRIMARY KEY (sto_no, menu_no)
)
/

COMMENT ON TABLE store_menu_tb IS '메뉴'
/

COMMENT ON COLUMN store_menu_tb.sto_no IS '가게번호'
/

COMMENT ON COLUMN store_menu_tb.menu IS '메뉴'
/

COMMENT ON COLUMN store_menu_tb.price IS '가격'
/

COMMENT ON COLUMN store_menu_tb.calorie IS '열량'
/

ALTER TABLE store_menu_tb
    ADD CONSTRAINT FK_store_menu_tb_sto_no_store_ FOREIGN KEY (sto_no)
        REFERENCES store_tb (sto_no)
/


-- store_tb Table Create SQL
CREATE TABLE reservation_tb
(
    user_no       NUMBER    NULL, 
    sto_no        NUMBER    NULL, 
    rsv_person    NUMBER    NOT NULL, 
    rsv_date      DATE  default  sysdate, 
    CONSTRAINT RESERVATION_TB_PK PRIMARY KEY (user_no, sto_no)
)
/

COMMENT ON TABLE reservation_tb IS '예약'
/

COMMENT ON COLUMN reservation_tb.user_no IS '회원번호'
/

COMMENT ON COLUMN reservation_tb.sto_no IS '가게번호'
/

COMMENT ON COLUMN reservation_tb.rsv_person IS '예약인원'	
/

COMMENT ON COLUMN reservation_tb.rsv_date IS '예약날짜'
/

ALTER TABLE reservation_tb
    ADD CONSTRAINT FK_reservation_tb_sto_no_store FOREIGN KEY (sto_no)
        REFERENCES store_tb (sto_no)
/

ALTER TABLE reservation_tb
    ADD CONSTRAINT FK_reservation_tb_user_no_user FOREIGN KEY (user_no)
        REFERENCES user_tb (user_no)
/
