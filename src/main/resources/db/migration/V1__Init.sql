CREATE TABLE user
(
    username      VARCHAR(255) NOT NULL,
    created_at    datetime     NULL,
    updated_at    datetime     NULL,
    is_deleted    BIT(1)       NOT NULL,
    email         VARCHAR(255) NULL,
    password      VARCHAR(255) NULL,
    first_name    VARCHAR(255) NULL,
    last_name     VARCHAR(255) NULL,
    mobile_number VARCHAR(255) NULL,
    CONSTRAINT pk_user PRIMARY KEY (username)
);