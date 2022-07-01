package com.brihaspathee.zeus.mapper.interfaces;

import com.brihaspathee.zeus.domain.entity.FileDetail;
import com.brihaspathee.zeus.web.model.FileDetailDto;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, June 2022
 * Time: 7:07 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface FileDetailMapper {

    /**
     * Converts the file detail dto object to the entity object FileDetail
     * @param fileDetailDto
     * @return
     */
    FileDetail fileDetailDtoToFileDetail(FileDetailDto fileDetailDto);

    /**
     * Converts the entity object file detail to file detail dto
     * @param fileDetail
     * @return
     */
    FileDetailDto fileDetailToFileDetailDto(FileDetail fileDetail);
}
