CREATE TABLE ORGANIZATIONS
(
    id                      SERIAL PRIMARY KEY,
    organizationName        VARCHAR(255),
    organizationDescription VARCHAR(255),
    organizationCode        VARCHAR(255),
    createdDate             timestamp
);