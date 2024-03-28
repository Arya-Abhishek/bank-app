package com.bank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold Error Response information"
)
@Data @AllArgsConstructor
public class ErrorResponseDto {
    // Not mentioning default or example values, since the error will keep on changing
    @Schema(
            description = "API Path where the error occurred"
    )
    private String apiPath;

    @Schema(
            description = "HTTP Status code of the error"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message of the error"
    )
    private String errorMessage;

    @Schema(
            description = "Time when the error occurred"
    )
    private LocalDateTime errorTime;
}
