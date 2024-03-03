package com.brihaspathee.zeus.services.impl;

import com.brihaspathee.zeus.domain.entity.FileDetail;
import com.brihaspathee.zeus.domain.repository.FileDetailRepository;
import com.brihaspathee.zeus.dto.transaction.FileDetailDto;
import com.brihaspathee.zeus.mapper.interfaces.FileDetailMapper;
import com.brihaspathee.zeus.services.interfaces.FileStorageService;
import com.brihaspathee.zeus.web.model.FileResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, June 2022
 * Time: 7:22 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.services.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    /**
     * Repository to perform database operations on the file detail entity
     */
    private final FileDetailRepository fileDetailRepository;

    /**
     * Mapper that converts file detail to DTO and vice-versa
     */
    private final FileDetailMapper fileDetailMapper;

    /**
     * Saves the file details in the data base and returns the file response dto
     * @param fileDetailDto
     * @return
     */
    @Override
    public FileResponseDto saveFileDetail(FileDetailDto fileDetailDto) {
        FileDetail fileDetail = fileDetailMapper.fileDetailDtoToFileDetail(fileDetailDto);
        fileDetail = fileDetailRepository.save(fileDetail);
        FileResponseDto fileResponseDto = FileResponseDto.builder()
                .fileReceiptAck(fileDetail.getFileDetailSK().toString())
                .serviceName("FILE_STORAGE_SERVICE")
                .zeusFileControlNumber(fileDetail.getZeusFileControlNumber())
                .build();
        return fileResponseDto;
    }

    /**
     * Clean up the entire database
     */
    @Override
    public void deleteAll() {
        fileDetailRepository.deleteAll();
    }
}
