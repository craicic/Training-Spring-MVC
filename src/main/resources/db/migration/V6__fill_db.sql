INSERT INTO app_user VALUES (4, 'Ivan', 'notEncryptedPwd', date(timenow()));

INSERT INTO entry VALUES (5, 4, 'thorben-janssen', date(timenow()), 'Ivan59', 'azerty', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ultricies, est eget finibus lobortis, erat tellus placerat arcu, eget porttitor erat lorem a ligula. Quisque ultricies eleifend fringilla.');
INSERT INTO entry VALUES (6, 4, 'google', date(timenow()), 'IvanOnGoogle', 'pa$$w0rd', 'Nulla ullamcorper sem et ligula dictum faucibus.');
INSERT INTO entry VALUES (7, 4, 'microsoft', date(timenow()), 'IVms', 'pa$$w0rd', 'Nulla ullamcorper sem et ligula dictum faucibus.');
INSERT INTO entry VALUES (8, 4, 'facebook', date(timenow()), 'ivFB', 'p4ù$$wd', 'Nam lobortis finibus ipsum, vel dignissim mi euismod sed.');
INSERT INTO entry VALUES (9, 4, 'github', date(timenow()), 'IvanDevs', 'pa$$w0rd', 'Sem et ligula dictum faucibus.');
INSERT INTO entry VALUES (10, 4, 'gitlab', date(timenow()), 'IvanDevs', 'noSec', 'Nulla facilisi.');
