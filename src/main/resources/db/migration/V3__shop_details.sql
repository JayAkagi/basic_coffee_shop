CREATE TABLE shop_details(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    open_hours TIME NOT NULL,
    close_hours TIME NOT NULL,
    instagram TEXT,
    facebook TEXT,
    twitter TEXT
);