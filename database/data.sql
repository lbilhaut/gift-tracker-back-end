-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO users (username, hashed_password)
VALUES ('Demo', ']E;KuWUZ^,fY-mvQ2+r"djkZMpk6Q<jF');

INSERT INTO families (family_name, user_id)
VALUES (
        'Skywalker', (SELECT user_id FROM users WHERE username = 'Demo')),
        (
        'Simpson',  (SELECT user_id FROM users WHERE username = 'Demo'))
        ;
        
INSERT INTO kids (firstname,family_id, user_id)
VALUES ('Leia', (SELECT family_id FROM families WHERE family_name = 'Skywalker'), (SELECT user_id FROM users WHERE username = 'Demo')),
        ('Luke', (SELECT family_id FROM families WHERE family_name = 'Skywalker'), (SELECT user_id FROM users WHERE username = 'Demo')),
        ('Bart', (SELECT family_id FROM families WHERE family_name = 'Simpson'), (SELECT user_id FROM users WHERE username = 'Demo')),
        ('Lisa', (SELECT family_id FROM families WHERE family_name = 'Simpson'), (SELECT user_id FROM users WHERE username = 'Demo')),
        ('Maggie', (SELECT family_id FROM families WHERE family_name = 'Simpson'), (SELECT user_id FROM users WHERE username = 'Demo'));
        
COMMIT;