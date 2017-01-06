-- DROP TABLE customers CASCADE CONSTRAINTS;
-- DROP TABLE books     CASCADE CONSTRAINTS;
-- DROP TABLE films     CASCADE CONSTRAINTS;
-- DROP SEQUENCE customer_id;
-- DROP SEQUENCE book_id;
-- DROP SEQUENCE film_id;

CREATE TABLE customers
    ( customer_id   NUMBER(8) PRIMARY KEY
    , customer_name VARCHAR2(64) NOT NULL
    , age           NUMBER(8)
    ) ;
CREATE TABLE books
    ( book_id       NUMBER(8) PRIMARY KEY
    , author        VARCHAR2(64)
    , book_name     VARCHAR2(64) NOT NULL
    , book_year     NUMBER(8)
    ) ;
CREATE TABLE films
    ( film_id       NUMBER(8) PRIMARY KEY
    , film_name     VARCHAR2(64) NOT NULL
    , genre         VARCHAR2(64)
    , budget        NUMBER(8)
    ) ;

CREATE SEQUENCE customer_id
START WITH 1001;
CREATE SEQUENCE book_id
START WITH 2001;
CREATE SEQUENCE film_id
START WITH 3001;

COMMIT;