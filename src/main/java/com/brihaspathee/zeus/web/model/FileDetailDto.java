package com.brihaspathee.zeus.web.model;

import lombok.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, March 2022
 * Time: 4:58 PM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDetailDto {

    private UUID fileDetailSK;

    private String fileId;

    private String fileName;

    @Override
    public String toString() {
        return "FileDetailDto{" +
                "fileDetailSK=" + fileDetailSK +
                ", fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
