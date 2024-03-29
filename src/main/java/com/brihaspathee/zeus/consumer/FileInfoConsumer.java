package com.brihaspathee.zeus.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, March 2022
 * Time: 3:08 PM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileInfoConsumer {

    private final ObjectMapper objectMapper;

    //@KafkaListener(topics = "ZEUS.FILE.STORAGE.TOPIC",groupId = "file-storage-group")
    public void consumeFileInfo(String fileDetailDto) throws JsonProcessingException {
        log.info("Message from the topic: {}", fileDetailDto);
        // FileDetailDto fileDetail = objectMapper.readValue(fileDetailDto, FileDetailDto.class);
        // log.info("File Detail Object: {}", fileDetail);

    }
}
