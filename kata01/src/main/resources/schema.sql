DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS "USER";

CREATE TABLE Post
(
    id      INTEGER NOT NULL,
    user_Id INTEGER NOT NULL,
    title   VARCHAR,
    body    VARCHAR,
    version INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE Comment
(
    id      INTEGER NOT NULL,
    post_Id INTEGER NOT NULL,
    name    VARCHAR,
    email   VARCHAR,
    body    VARCHAR,
    version INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE "USER"
(
    id       INTEGER NOT NULL,
    name     VARCHAR,
    username VARCHAR,
    email    VARCHAR,
    version  INTEGER,
    PRIMARY KEY (id)
);