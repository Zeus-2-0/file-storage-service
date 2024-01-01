package com.brihaspathee.zeus.mapper.impl;

import com.brihaspathee.zeus.domain.entity.FileDetail;
import com.brihaspathee.zeus.dto.transaction.FileDetailDto;
import com.brihaspathee.zeus.mapper.interfaces.FileDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, June 2022
 * Time: 7:08 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
@RequiredArgsConstructor
public class FileDetailMapperImpl implements FileDetailMapper {

    /**
     * Converts the file detail dto object to the entity object FileDetail
     * @param fileDetailDto
     * @return
     */
    @Override
    public FileDetail fileDetailDtoToFileDetail(FileDetailDto fileDetailDto) {
        if(fileDetailDto == null){
            return null;
        }
        FileDetail fileDetail = FileDetail.builder()
                .fileDetailSK(fileDetailDto.getFileDetailSK())
                .zeusFileControlNumber(fileDetailDto.getZeusFileControlNumber())
                .fileName(fileDetailDto.getFileName())
                .fileReceivedDate(fileDetailDto.getFileReceivedDate())
                .tradingPartnerId(fileDetailDto.getTradingPartnerId())
                .senderId(fileDetailDto.getSenderId())
                .receiverId(fileDetailDto.getReceiverId())
                .lineOfBusinessTypeCode(fileDetailDto.getLineOfBusinessTypeCode())
                .stateTypeCode(fileDetailDto.getStateTypeCode())
                .marketplaceTypeCode(fileDetailDto.getMarketplaceTypeCode())
                .fileData(fileDetailDto.getFileData())
                .build();
        return fileDetail;
    }

    /**
     * Converts the entity object file detail to file detail dto
     * @param fileDetail
     * @return
     */
    @Override
    public FileDetailDto fileDetailToFileDetailDto(FileDetail fileDetail) {
        if(fileDetail == null){
            return null;
        }
        FileDetailDto fileDetailDto = FileDetailDto.builder()
                .fileDetailSK(fileDetail.getFileDetailSK())
                .zeusFileControlNumber(fileDetail.getZeusFileControlNumber())
                .fileName(fileDetail.getFileName())
                .fileReceivedDate(fileDetail.getFileReceivedDate())
                .tradingPartnerId(fileDetail.getTradingPartnerId())
                .senderId(fileDetail.getSenderId())
                .receiverId(fileDetail.getReceiverId())
                .lineOfBusinessTypeCode(fileDetail.getLineOfBusinessTypeCode())
                .stateTypeCode(fileDetail.getStateTypeCode())
                .marketplaceTypeCode(fileDetail.getMarketplaceTypeCode())
                .fileData(fileDetail.getFileData())
                .build();
        return fileDetailDto;
    }
}
