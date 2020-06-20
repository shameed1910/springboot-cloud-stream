package com.example.kafka.springbootcloudstream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class Producer {
    @Autowired
    Source source;
@PostMapping("/publish")
    public String pubilsh(@RequestBody Employee employee){
        source.output().send(MessageBuilder.withPayload(employee).build());
        return "Message sent";
    }
}
