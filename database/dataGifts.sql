-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

INSERT INTO gifts (kid_id, gift_name, gift_picture_name)
VALUES (2,'Backpack','backpack.jpg'),
       (4,'Chess set','chess.jpg'),
       (1,'T-shirt','Dont mess with a Princess.jpg'),
       (2,'Light saber','light saber.jpg'),
       (5,'Onesies','onesies.jpg'),
       (1,'R2-D2','robot.jpg'),
       (4,'Saxophone','saxophone.jpg'),
       (4,'Capital in the Twenty-First Century','capital.jpg'),
       (3,'Skateboard','skateboard.jpg'),
       (3,'Slingshot','slingshot.jpg'),
       (2,'Spaceship','x-wing.jpg'),
       (1,'Beany','wig.jpg'),
       (5,'Pacifier','pacifier.jpg');

COMMIT;

