DROP TABLE IF EXISTS `filestoragedb`.`file_storage_detail`;
CREATE TABLE IF NOT EXISTS `filestoragedb`.`file_storage_detail` (
    `file_storage_detail_sk` VARCHAR(36) NOT NULL COMMENT 'Primary key for the table',
    `zfcn` VARCHAR(45) NOT NULL COMMENT 'Unique file id that was created by the file management service for the file',
    `file_name` VARCHAR(100) NOT NULL COMMENT 'The name of the file',
    `file_received_date` DATETIME NOT NULL COMMENT 'The date when the file was received',
    `trading_partner_id` VARCHAR(100) NULL COMMENT 'The trading partner id associated with the file',
    `marketplace_type_code` VARCHAR(100) NULL COMMENT 'The marketplace type for which the file was received',
    `line_of_business_type_code` VARCHAR(100) NULL COMMENT 'The lob type for which the file was received',
    `state_type_code` VARCHAR(100) NULL COMMENT 'State for which the file is received',
    `file_data` LONGTEXT NULL COMMENT 'The data of the file stored as a blob',
    `created_date` DATETIME NULL,
    `updated_date` DATETIME NULL,
    `sender_id` VARCHAR(45) NULL COMMENT 'The sender id received in the file. This is the sender id in the interchange segment',
    `receiver_id` VARCHAR(45) NULL COMMENT 'The receiver id received in the file. This is the receiver id in the interchange segment',
    PRIMARY KEY (`file_storage_detail_sk`))
    ENGINE = InnoDB
    COMMENT = 'Contains the data of the file as a blob'