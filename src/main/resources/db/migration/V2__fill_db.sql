INSERT INTO app_user VALUES (1, 'Thorsten', 'notEncryptedPwd', date(timenow()));
INSERT INTO app_user VALUES (2, 'Odin', 'stillNotEncryptedPwd', date(timenow()));
INSERT INTO app_user VALUES (3, 'Loki', '$2y$10$JrOZDkeMN37.ePVmWgwyFeDNy2cbvOTfd06JFS473kfetmztYNf/.', date(timenow()));

INSERT INTO entry VALUES (1, 1, 'thorben-janssen', date(timenow()), 'Thorsten59', 'azerty');
INSERT INTO entry VALUES (2, 1, 'google', date(timenow()), 'ThorstenOnGoogle', 'pa$$w0rd');
INSERT INTO entry VALUES (3, 2, 'thorbenjanssen dot com', date(timenow()), 'Hugin867', '0000aaaa');
INSERT INTO entry VALUES (4, 2, 'fb', date(timenow()), 'Odin', '0000aaaa');