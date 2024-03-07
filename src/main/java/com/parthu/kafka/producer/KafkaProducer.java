package com.parthu.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessage(String msg) {
		log.info(format("sending message to john Topic",msg));
		kafkaTemplate.send("john",msg);
	}
}
