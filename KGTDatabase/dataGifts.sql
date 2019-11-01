-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO gifts (kid_id, gift_name, gift_picture_name)
VALUES (2,'Backpack','backpack.jpg'),
        (4,'Capital in the Twenty-First Century','capital.jpg');

COMMIT;

