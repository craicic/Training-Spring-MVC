UPDATE app_user SET main_password = 'azerty' WHERE id < 1000;

CREATE TABLE secret (
                      id            INTEGER PRIMARY KEY,
                      user_id       INTEGER NOT NULL,
                      salt         VARCHAR(255) NOT NULL,

                      FOREIGN KEY (user_id) REFERENCES app_user (id)
);

-- INSERT INTO secret (id, user_id, salt) VALUES (1,1,'simpleSalt');
-- INSERT INTO secret (id, user_id, salt) VALUES (2,2,'salt');
-- INSERT INTO secret (id, user_id, salt) VALUES (3,3,'s4lt');
-- INSERT INTO secret (id, user_id, salt) VALUES (4,4,'simpleSalt');

CREATE SEQUENCE IF NOT EXISTS salt_sequence INCREMENT BY 1 MINVALUE 100;