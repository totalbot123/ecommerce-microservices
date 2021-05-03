# Project Title

Pet project for learning microservices in Java, using Spring framework.
Project is build using Eureka, Hystrix and Zipkin.

# Core microservices

### Catalog

Catalog application: holds online store product data in-memory from the product data set above. 
The application exposes REST API for retrieving products by ‘uniq_id’ and list of products by ‘sku’.

### Inventory

Inventory application: holds online store product availability data.
Generate random availability status for each product from the product data set above and keep it in an in-memory data structure. 
The application exposes REST API for retrieving product availability by a list of ‘uniq_id’.

### Product

Product application: returns product data to end-clients.
The application exposes REST API for retrieving available products data by ‘uniq_id’ and by ‘sku’ (multiple products are returned).
The REST service makes REST call to catalog application to get product data by ‘uniq_id’ or by ‘sku’and make a call to the inventory application to get product availability and filter out only available product before returning.

## Authors

* **Milan Jecmenica** - *Initial work* - [totalbot123](https://github.com/totalbot123)
