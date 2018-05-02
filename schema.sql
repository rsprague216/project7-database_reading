/**
 * Author:  Ryan Sprague
 * Created: Apr 24, 2018
 */

DROP TABLE BOOKS;

CREATE TABLE BOOKS (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "TITLE" VARCHAR(128) NOT NULL,
    "AUTHOR" VARCHAR(128) NOT NULL,
    "REVIEW" VARCHAR(1000) NOT NULL,
    RATING INTEGER NOT NULL,
    UNIQUE ("TITLE"),
    PRIMARY KEY (ID)
);

INSERT INTO BOOKS ("TITLE", "AUTHOR", "REVIEW", RATING) VALUES
    ('Percy Jackson', 'Rick Riorden', 'Fantastic series with lovable and relatable characters.', 5),
    ('Harry Potter', 'J.K. Rowling', 'I grew up with this series, and the characters are beautifully developed.', 5),
    ('Rangers Apprentice', 'John Flanagan', 'Great series for youngsters, but less enjoyable as you age.', 4),
    ('Wheel of Time', 'Robert Jordan', 'Fifteen books of incredible storytelling.  Not to be missed.', 5),
    ('Tree of Ages', 'Sarah C. Roethle', 'Wasted potential.  The premise is super interesting, but the writing falls short.', 3);