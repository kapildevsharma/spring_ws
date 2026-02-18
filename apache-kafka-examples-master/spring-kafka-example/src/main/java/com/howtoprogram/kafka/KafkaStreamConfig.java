package com.howtoprogram.kafka;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.StreamsException;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.ValueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;


@Configuration
@EnableKafkaStreams
public class KafkaStreamConfig {

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    KafkaStreamsConfiguration kStreamsConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "my-kafka-streams-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        return new KafkaStreamsConfiguration(props);
    }
	
    private static final Serde<String> STRING_SERDE = Serdes.String();


	@Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> messageStream = streamsBuilder
          .stream("input-topic", Consumed.with(STRING_SERDE, STRING_SERDE));

        KTable<String, Long> wordCounts = messageStream
          .mapValues((ValueMapper<String, String>) String::toLowerCase)
          .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
          .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
          .count();

        wordCounts.toStream().to("output-topic");
        
    	// Define the stream to read from Kafka topic
    	KStream<String, String> sourceStream = streamsBuilder.stream("input-topic");

    	// Apply a transformation (e.g., convert all values to upperCase)
    	KStream<String, String> transformedStream = sourceStream.mapValues(value -> value.toUpperCase());

    	// Write the transformed data to a new Kafka topic
    	transformedStream.to("output-topic");

    	Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "my-kafka-streams-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

    	try (// Build and start the Kafka Streams application
		KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), props)) {
			streams.start();
		} catch (StreamsException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	
}
