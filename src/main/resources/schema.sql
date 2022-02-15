CREATE TABLE app_user
(
    id            INTEGER PRIMARY KEY,
    pseudo        TEXT UNIQUE NOT NULL,
    password      TEXT        NOT NULL,
    creation_date DATE        NOT NULL
);

CREATE TABLE entry
(
    id            INTEGER PRIMARY KEY,
    user_id       INTEGER NOT NULL,
    title         TEXT    NOT NULL,
    last_modified DATE    NOT NULL,
    username      TEXT    NOT NULL,
    password      TEXT    NOT NULL,
    note          TEXT,
    FOREIGN KEY (user_id) REFERENCES app_user (id)
);