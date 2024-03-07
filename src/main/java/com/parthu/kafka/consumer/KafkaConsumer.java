package com.parthu.kafka.consumer;

import static java.lang.String.format;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.parthu.kafka.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics="john", groupId = "myGroup")
	public void consumeMsg(String msg) {
		log.info(format("consuming the message form john Topic",msg));
	}
	
	@KafkaListener(topics="john", groupId = "myGroup")
	public void consumeJsonMsg(Student student) {
		log.info(format("consuming the message form john Topic",student.toString()));
	}
}
