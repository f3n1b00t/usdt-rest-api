package ru.f3n1b00t.contractservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(description = "Contract interaction error response")
public class ContractInteractionErrorResponse {
    @JsonProperty("ok")
    @Schema(name = "ok", description = "Indicates whether the request was successful", example = "false")
    boolean isOk;
    @JsonProperty("message")
    @Schema(name = "message", description = "The error message", example = "Something went wrong!")
    String message;
}
