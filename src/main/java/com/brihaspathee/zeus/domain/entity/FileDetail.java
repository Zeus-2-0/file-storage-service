package com.brihaspathee.zeus.domain.entity;

import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import jakarta.persistence.*;

import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 29, June 2022
 * Time: 6:04 AM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file_storage_detail")
public class FileDetail {

    /**
     * Primary key of the table
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(Types.LONGVARCHAR)
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "file_storage_detail_sk", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID fileDetailSK;

    /**
     * The file control number generated by the file management service
     */
    @Column(name = "zfcn")
    private String zeusFileControlNumber;

    /**
     * Name of the file
     */
    @Column(name = "file_name")
    private String fileName;

    /**
     * Date and time when the file was received
     */
    @Column(name = "file_received_date")
    private LocalDateTime fileReceivedDate;

    /**
     * Trading partner id associated with the file
     */
    @Column(name = "trading_partner_id")
    private String tradingPartnerId;

    /**
     * The sender id received in the file
     * This is the sender id in the interchange segment
     */
    @Column(name = "sender_id")
    private String senderId;

    /**
     * The receiver id received in the file
     * This is the receiver id in the interchange segment
     */
    @Column(name = "receiver_id")
    private String receiverId;

    /**
     * The line of business associated with the file
     */
    @Column(name = "line_of_business_type_code")
    private String lineOfBusinessTypeCode;

    /**
     * The marketplace type code associated wit the file
     */
    @Column(name = "marketplace_type_code")
    private String marketplaceTypeCode;

    /**
     * The state for which the file was received
     */
    @Column(name = "state_type_code")
    private String stateTypeCode;

    /**
     * The data of the file
     */
    @Lob
    @JdbcTypeCode(Types.LONGVARCHAR)
    @Column(name = "file_data")
    private String fileData;

    /**
     * Date and time when the record was created
     */
    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    /**
     * Date and time when the record was updated
     */
    @Column(name = "updated_date")
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    /**
     * To string method to print the details of the file
     * @return
     */
    @Override
    public String toString() {
        return "FileDetail{" +
                "fileDetailSK=" + fileDetailSK +
                ", zeusFileControlNumber='" + zeusFileControlNumber + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileReceivedDate=" + fileReceivedDate +
                ", tradingPartnerId='" + tradingPartnerId + '\'' +
                ", senderId='" + senderId + '\'' +
                ", receiverId='" + receiverId + '\'' +
                ", lineOfBusinessTypeCode='" + lineOfBusinessTypeCode + '\'' +
                ", marketplaceTypeCode='" + marketplaceTypeCode + '\'' +
                ", stateTypeCode='" + stateTypeCode + '\'' +
                ", fileData='" + fileData + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    /**
     * Equal method
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileDetail that = (FileDetail) o;
        return fileDetailSK.equals(that.fileDetailSK);
    }

    /**
     * Hashcode method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(fileDetailSK);
    }
}
