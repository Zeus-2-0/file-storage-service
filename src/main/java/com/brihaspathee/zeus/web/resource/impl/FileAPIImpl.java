package com.brihaspathee.zeus.web.resource.impl;

import com.brihaspathee.zeus.constants.ApiResponseConstants;
import com.brihaspathee.zeus.dto.transaction.FileDetailDto;
import com.brihaspathee.zeus.services.interfaces.FileStorageService;
import com.brihaspathee.zeus.web.model.FileResponseDto;
import com.brihaspathee.zeus.web.resource.interfaces.FileAPI;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, March 2022
 * Time: 4:57 PM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.web.resource.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class FileAPIImpl implements FileAPI {

    /**
     * Service that contains the methods to store and retrieve the details of the file
     */
    private final FileStorageService fileStorageService;

    /**
     * Method to get the details of the file by file id
     * @param fileId
     * @return
     */
    @Override
    public ResponseEntity<ZeusApiResponse<FileDetailDto>> getFileDetail(String fileId) {
        FileDetailDto fileDetailDto = FileDetailDto.builder().fileName("Test").build();
        ZeusApiResponse<FileDetailDto> apiResponse = ZeusApiResponse.<FileDetailDto>builder()
                .response(fileDetailDto)
                .build();
        return ResponseEntity.ok(apiResponse);
    }

    /**
     * The method that is invoked to receive the file information from file management service
     * @param fileDetailDto
     * @return
     * @throws JsonProcessingException
     */
    @Override
    public ResponseEntity<ZeusApiResponse<FileResponseDto>> postFileDetails(FileDetailDto fileDetailDto)
            throws JsonProcessingException {
        log.info("Got the file details:{}", fileDetailDto);
        FileResponseDto fileResponseDto = fileStorageService.saveFileDetail(fileDetailDto);
        ZeusApiResponse<FileResponseDto> apiResponse = ZeusApiResponse.<FileResponseDto>builder()
                .response(fileResponseDto)
                .message(ApiResponseConstants.SUCCESS)
                .status(HttpStatus.CREATED)
                .statusCode(201)
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
