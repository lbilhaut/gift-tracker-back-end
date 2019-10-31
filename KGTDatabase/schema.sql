BEGIN;
DROP TABLE IF EXISTS gifts;
DROP TABLE IF EXISTS kids;
DROP TABLE IF EXISTS families;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
        user_id serial,
        username varchar(64) not null,
        hashed_password varchar(255),
        firstname varchar(64),
        lastname varchar(64),
        email varchar(64),
        phone_number varchar(12),
        
        constraint pk_users primary key(user_id)

);


CREATE TABLE families
(
        family_id serial,
        user_id int not null,
        family_nickname varchar(64) null,
        family_name varchar(64) not null,
        address_street varchar(128) null,
        address_city varchar(64) null,
        address_zipcode varchar(5) null,
        address_state varchar(2) null,
        parent1_firstname varchar(64) null,
        parent1_email varchar(64) null,
        parent1_phone_number varchar(12) null,
        parent2_firstname varchar(64) null,
        parent2_email varchar(64) null,
        parent2_phone_number varchar(12) null,
        notes varchar(512) null,
        
        constraint pk_families primary key(family_id),
        constraint fk_users foreign key (user_id) references users(user_id)
);

CREATE TABLE kids
(
        kid_id serial,
        firstname varchar(64) not null,
        nickname varchar(64) null,
        family_id int not null,
        birth_year int null,
        birth_month int null,
        birth_day int null,
        
        constraint pk_kids primary key(kid_id),
        constraint fk_kids_families foreign key (family_id) references families(family_id)
);

CREATE TABLE gifts(
        gift_id serial,
        kid_id int not null,
        gift_name varchar(64) not null,
        gift_occasion varchar(64) null,
        gift_year int null,
        gift_picture_name varchar(5000) null,
        gift_notes varchar(1024) null,
        
        constraint pk_gifts primary key(gift_id),
        constraint fk_gifts_kids foreign key (kid_id) references kids(kid_id)
);



COMMIT;

--DROP TABLE gifts;
--DROP TABLE kids;
--DROP TABLE families;

-- SEED TABLES WITH DEMO VALUES
INSERT INTO users (username, hashed_password)
VALUES ('Demo', ']E;KuWUZ^,fY-mvQ2+r"djkZMpk6Q<jF');



INSERT INTO families (user_id, family_name)
VALUES (
        (SELECT user_id FROM users WHERE username = 'Demo'), 
        'Skywalker'),
        (
        (SELECT user_id FROM users WHERE username = 'Demo'), 
        'Simpson')
        ;
        
INSERT INTO kids (firstname,family_id)
VALUES ('Leia', (SELECT family_id FROM families WHERE family_name = 'Skywalker')),
        ('Luke', (SELECT family_id FROM families WHERE family_name = 'Skywalker')),
        ('Bart', (SELECT family_id FROM families WHERE family_name = 'Simpson')),
        ('Lisa', (SELECT family_id FROM families WHERE family_name = 'Simpson')),
        ('Maggie', (SELECT family_id FROM families WHERE family_name = 'Simpson'));
        
        

SELECT family_id FROM families WHERE family_name = 'Skywalker';

SELECT family_name
FROM families;

INSERT INTO families(family_nickname, family_name)
VALUES('Other good family', 'Saletes');

INSERT INTO kids(firstname)
VALUES('Charlotte');

SELECT firstname
FROM kids;      

SELECT family_name, family_id
FROM families
WHERE family_name = 'Saletes';

SELECT kid_id
FROM kids
WHERE firstname = 'Charlotte';

SELECT *
FROM kids;

SELECT *
FROM gifts
WHERE kid_id=1;

SELECT username
FROM users;

SELECT hashed_password FROM users WHERE username = 'Lisou';

UPDATE users SET hashed_password = 'laurentPass' WHERE username = 'Laurent';
UPDATE users SET hashed_password = 'lisePass' WHERE username = 'Lisou';


DELETE FROM users WHERE username = '';

UPDATE kids SET firstname = 'Oscar', nickname = 'Ozzy', family_id = 2, birth_year = 2016 WHERE kid_id = 3;

SELECT firstname from kids WHERE family_id IN
        (SELECT family_id from families WHERE user_id = 2);


SELECT * from kids;



SELECT firstname from kids;


SELECT family_id from families WHERE user_id = 1;


DELETE from families where family_id = 8;

DELETE from users where user_id in (7);

SELECT family_name, family_id FROM families WHERE family_name = 'Bilhaut' AND user_id = 8;

SELECT * from kids WHERE firstname = 'Oscar' and family_id in
(SELECT family_id from families where user_id = 8
)
;

SELECT family_id from families where user_id = 8;

