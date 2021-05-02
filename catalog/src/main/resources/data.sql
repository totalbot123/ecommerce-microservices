-- Catalog application: holds online store product data in-memory from the product data set above. 
-- The application exposes REST API for retrieving products by ‘uniq_id’ and list of products by ‘sku’.

DROP TABLE IF EXISTS product_catalog;

CREATE TABLE product_catalog (
  uniq_id VARCHAR(250) PRIMARY KEY,
  sku VARCHAR(250) NOT NULL,
  name_title VARCHAR(250) NOT NULL,
  color VARCHAR(250) DEFAULT NULL,
  category VARCHAR(250) NOT NULL
);

INSERT INTO product_catalog (uniq_id, sku, name_title, color, category) VALUES
  ('b6c0b6bea69c722939585baeac73c13d','pp5006380337', 'Alfred Dunner® Essential Pull On Capri Pant', 'red', 'alfred dunner'),
  ('93e5272c51d8cce02597e3ce67b7ad0a','pp5006380337', 'Alfred Dunner® Essential Pull On Capri Pant', 'green', 'alfred dunner'),
  ('013e320f2f2ec0cf5b3ff5418d688528','pp5006380337', 'Alfred Dunner® Essential Pull On Capri Pant', 'gray', 'alfred dunner'),
  ('8ffd0ef4fcaf1a82fb514aba5d20e05b', 'pp5006790247', 'Alfred Dunner® Feels Like Spring 3/4 Sleeve Leaf Print Top', 'black', 'alfred dunner'),
  ('11fc82f52d6cf669df141ca67d61ac20', 'pp5005031025', 'Dearfoams® Microfiber Terry Quilted Clog Slippers', 'black', 'view all brands'),
  ('44f8f8f108c6856acf9630dd1d78516d', 'pp5007080134', 'Alfred Dunner® Feels Like Spring 3/4-Sleeve Watercolor Print Shirt or Pull-On Cargo Capris', 'gray', 'alfred dunner'),
  ('8d1d057f5f808c10ce243c222ab0ef6e', 'pp5007080134', 'Alfred Dunner® Feels Like Spring 3/4-Sleeve Watercolor Print Shirt or Pull-On Cargo Capris', 'pink', 'alfred dunner'),
  ('f3e02c48f16b56e8c1f126c8fe762812', 'pp5007080134', 'Alfred Dunner® Feels Like Spring 3/4-Sleeve Watercolor Print Shirt or Pull-On Cargo Capris', 'blue', 'alfred dunner');