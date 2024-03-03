package com.brihaspathee.zeus.services.interfaces;

import com.brihaspathee.zeus.dto.transaction.FileDetailDto;
import com.brihaspathee.zeus.web.model.FileResponseDto;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, June 2022
 * Time: 7:14 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.services.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface FileStorageService {

    /**
     * Saves the file details in the database and returns the file response dto
     * @param fileDetailDto
     * @return
     */
    FileResponseDto saveFileDetail(FileDetailDto fileDetailDto);

    /**
     * Clean up the entire database
     */
    void deleteAll();
}
