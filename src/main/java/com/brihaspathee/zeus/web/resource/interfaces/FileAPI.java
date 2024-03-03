package com.brihaspathee.zeus.web.resource.interfaces;

import com.brihaspathee.zeus.dto.transaction.FileDetailDto;
import com.brihaspathee.zeus.web.model.FileResponseDto;
import com.brihaspathee.zeus.web.response.ZeusApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 06, March 2022
 * Time: 4:57 PM
 * Project: Zeus
 * Package Name: com.brihaspathee.zeus.web.resource.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/file-storage")
@Validated
public interface FileAPI {
    /**
     *
     * @param fileId
     * @return
     */
    @Operation(
            method = "GET",
            description = "Get the details of the file by its id",
            tags = {"file-mgmt"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved the details of the file",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ZeusApiResponse.class))
                            }
                    )
            }
    )
    @GetMapping(path="/{fileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ZeusApiResponse<FileDetailDto>> getFileDetail(@PathVariable("fileId") String fileId);

    /**
     * This method will receive the details of the file with the transactions.
     * @param fileDetailDto
     * @return
     * @throws JsonProcessingException
     */
    @Operation(
            method = "POST",
            description = "Receive the details of the file with all the transactions in the file",
            tags = {"transaction-origination"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successfully received the details of the file and started to process",
                            content = {
                                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ZeusApiResponse.class))
                            }
                    )
            }
    )
    @PostMapping
    ResponseEntity<ZeusApiResponse<FileResponseDto>> postFileDetails(@RequestBody FileDetailDto fileDetailDto) throws JsonProcessingException;

    /**
     * Clean up the entire db
     * @return
     */
    @Operation(
            operationId = "Delete all data",
            method = "DELETE",
            description = "Delete all data",
            tags = {"file-mgmt"}
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Data deleted successfully",
                    content = {
                            @Content(mediaType = "application/json",schema = @Schema(implementation = ZeusApiResponse.class))
                    })
    })
    @DeleteMapping("/delete")
    ResponseEntity<ZeusApiResponse<String>> cleanUp();
}
