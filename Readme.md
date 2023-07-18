## Problem Statement - 1
Customer model is as follows

Customer Number
First Name
Last Name
Spending Limit
Many addresses

Address
Address Type
Street
City
State Zip


Need a API to create customers

Need an API to get Customers
Query by Name , city , state
If no parameter is supplied get all customers


Kafka
After customer creation drop message into Kafka


# API Documentation

This document provides an overview of the APIs available in the application and instructions for deploying the application.

## APIs

### Create Customers

Endpoint: `POST /customer-service/customer`

Description: Create a new customer in the system.

Request Body:
```json
{
  "firstName": "Umang",
  "lastName": "Rastogi",
  "age": 30,
  "spendingLimit": 450000.001244,
  "mobileNumber": "123455",
  "address": [
    {
      "type": "home",
      "address1": "cdcc",
      "address2": "ccc",
      "city": "erer",
      "state": "ccc",
      "zipCode": "rtrt"
    }
  ]
}
```

Response Body:
```json
{
  "customerId": 3,
  "firstName": "Umang",
  "lastName": "Rastogi",
  "age": 30,
  "spendingLimit": 450000.001244,
  "mobileNumber": "123455",
  "address": [
    {
      "id": 3,
      "type": "home",
      "address1": "cdcc",
      "address2": "ccc",
      "city": "erer",
      "zipCode": "rtrt",
      "state": "ccc"
    }
  ]
}
```

### Get Customers by Name, City, or Zipcode

Endpoint: `GET /customer-service/customer`

Description: Get customers based on their name, city, or state. If no parameter is supplied, all customers will be returned.

### Parameters:

firstName: Filter customers by first name.
city: Filter customers by city.
zipCode: Filter customers by state.

Response Body:
```json
[
  {
    "customerId": 1,
    "firstName": "Umang",
    "lastName": "Rastogi",
    "age": 30,
    "spendingLimit": 450000.001244,
    "mobileNumber": "123455",
    "address": [
      {
        "id": 1,
        "type": "home",
        "address1": "cdcc",
        "address2": "ccc",
        "city": "erer",
        "zipCode": "rtrt",
        "state": "ccc"
      }
    ]
  },
  {
    "customerId": 2,
    "firstName": "Umang",
    "lastName": "Rastogi",
    "age": 30,
    "spendingLimit": 450000.001244,
    "mobileNumber": "123455",
    "address": [
      {
        "id": 2,
        "type": "home",
        "address1": "cdcc",
        "address2": "ccc",
        "city": "erer",
        "zipCode": "rtrt",
        "state": "ccc"
      }
    ]
  },
  {
    "customerId": 3,
    "firstName": "Umang",
    "lastName": "Rastogi",
    "age": 30,
    "spendingLimit": 450000.001244,
    "mobileNumber": "123455",
    "address": [
      {
        "id": 3,
        "type": "home",
        "address1": "cdcc",
        "address2": "ccc",
        "city": "erer",
        "zipCode": "rtrt",
        "state": "ccc"
      }
    ]
  }
]
```

## Deployment

Follow the steps below to deploy the application:

1. Prerequisites:
    - Java 8 or higher is installed.
    - Apache Kafka is installed and running.

2. Unzip the folder:

3. Build the application:
   ```
   cd <project-directory>
   mvn clean package
   ```

4. Run the application:
   ```
   java -jar target/ROOT.jar
   ```

5. The application will start, and the APIs will be available at the specified endpoints.

Note:- By default kafka connections is disabled through the kafka.enabled property in application.property,
if you want to enable it modify it to true and modify the spring.kafka.bootstrap-servers property accordingly.

## Problem Statement  - 2
You are provided with two lists of Customers

A and B as below

List<Customer> A , List<Customer> B


Please code the for the following questions


1) Customers only in list A
2) Customers only List B
3) Customers in both A and B

Refer file Question2ServiceImpl.java for the solution




## Troubleshooting

If you encounter any issues during deployment or while using the APIs, please refer to the application logs for more information. Additionally, ensure that Kafka is running and properly configured to establish a connection between the application and the Kafka broker.
In case of kafka broker is not available application will just publish a warning log.

---
This README provides an overview of the available APIs and deployment instructions for the application. For more detailed information on each API endpoint, request, and response, refer to the specific sections in this document. If you need any further assistance, please don't hesitate to reach out to our support team. Happy coding!