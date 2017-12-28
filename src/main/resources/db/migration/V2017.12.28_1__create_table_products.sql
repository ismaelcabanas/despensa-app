CREATE TABLE IF NOT EXISTS PRODUCTS
( P_ID uuid NOT NULL,
  P_NAME VARCHAR(100) NOT NULL,
  P_QUANTITY BIGINT NOT NULL,
  CONSTRAINT PK_PRODUCTS PRIMARY KEY (P_ID));

  COMMENT ON COLUMN PRODUCTS.P_ID IS 'Product identifier';
  COMMENT ON COLUMN PRODUCTS.P_NAME IS 'Product name';
  COMMENT ON COLUMN PRODUCTS.P_QUANTITY IS 'Quantity of product';
