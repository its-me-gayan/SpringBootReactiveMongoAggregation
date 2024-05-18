package org.example.mongo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Gayan Sanjeewa
 * User: gayan
 * Date: 5/18/24
 * Time: 5:08 PM
 */
@Data
public class AbstractResponse {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime time;
    private HttpStatus httpStatus;
    private String message;
    private String messageDescription;
    private Integer responseCode;
    private Boolean isSuccess;
    private Object data;
}
