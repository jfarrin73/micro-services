CREATE TABLE ORGANIZATIONS
(
    id                      SERIAL PRIMARY KEY,
    organization_name        VARCHAR(255),
    organization_description VARCHAR(255),
    organization_code        VARCHAR(255),
    created_date             timestamp
);