package com.parthu.kafka.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parthu.kafka.payload.Student;
import com.parthu.kafka.producer.KafkaJsonProducer;
import com.parthu.kafka.producer.KafkaProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
	
	private final KafkaProducer kafkaProducer;
	private final KafkaJsonProducer kafkaJsonProducer;
	
	@PostMapping
	public ResponseEntity<String> sendMessage(@RequestBody String msg){
		kafkaProducer.sendMessage(msg);
		return ResponseEntity.ok("Message queued successfully");
	}
	
	@PostMapping("/json")
	public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
		kafkaJsonProducer.sendMessage(student);
		return ResponseEntity.ok("Message queued successfully");
	}

}
