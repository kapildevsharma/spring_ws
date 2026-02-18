package com.howtoprogram.kafka;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

public class Listener {

	public final CountDownLatch countDownLatch1 = new CountDownLatch(3);
    private static final String TOPIC = "users";

	@KafkaListener(id = "foo", topics = TOPIC, groupId = "group1")
	public void listen(ConsumerRecord<?, ?> record) {
		System.out.println(record);
		countDownLatch1.countDown();
	}
	
	// read message with topic and partitions
	@KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = TOPIC, partitions = { "0" }) }, groupId = "group1")
	public void listenPartition0(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id0, Thread ID: " + Thread.currentThread().getId());
		System.out.println("Received: " + record);
	}
	
	// read message with topic and partitions
	@KafkaListener(id = "id1", topicPartitions = { @TopicPartition(topic = TOPIC, partitions = { "0" }) }, groupId = "group2")
	public void listenSamePartitionWithDiffernet(ConsumerRecord<?, ?> record) {
		System.out.println("Listener Id0, Thread ID: " + Thread.currentThread().getId());
		System.out.println("Received: " + record);
	}


}