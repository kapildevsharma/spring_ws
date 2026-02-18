# Spring Kafka Tutorial 


## 1. Import source code into Eclipse

Menu **File –> Import –> Maven –> Existing Maven Projects**

Browse to your source code location

Click **Finish** button to finish the importing


## 2. Run the example


Open the **SpringKafkaMultipleConsumptionTests.java** 


Create Topic in docker container : 
docker exec broker kafka-topics --create --bootstrap-server localhost:9092 --partitions 4 --replication-factor 1 --topic SpringKafka