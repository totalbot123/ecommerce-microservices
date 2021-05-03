-- Inventory application: holds online store product availability data.
-- Generate random availability status for each product from the product data set above and
-- keep it in an in-memory data structure. 
-- The application exposes REST API for retrieving product availability by a list of ‘uniq_id’.

DROP TABLE IF EXISTS product_availability;

CREATE TABLE product_availability (
  uniq_id VARCHAR(250)  PRIMARY KEY,
  inventory INT NOT NULL
);

INSERT INTO product_availability (uniq_id, inventory) VALUES
  ('b6c0b6bea69c722939585baeac73c13d', 50),
  ('93e5272c51d8cce02597e3ce67b7ad0a', 0),
  ('013e320f2f2ec0cf5b3ff5418d688528', 100),
  ('8ffd0ef4fcaf1a82fb514aba5d20e05b', 50), 
  ('11fc82f52d6cf669df141ca67d61ac20', 30),
  ('44f8f8f108c6856acf9630dd1d78516d', 20),
  ('8d1d057f5f808c10ce243c222ab0ef6e', 0),
  ('f3e02c48f16b56e8c1f126c8fe762812', 1000);