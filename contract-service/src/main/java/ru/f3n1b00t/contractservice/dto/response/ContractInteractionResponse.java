package ru.f3n1b00t.contractservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Schema(description = "Contract interaction response")
public class ContractInteractionResponse<T> {
    @JsonProperty("ok")
    @Schema(name = "ok", description = "Indicates whether the request was successful", example = "true")
    boolean isOk;
    @JsonProperty("result")
    @Schema(name = "result", description = "The result of the request", example = "true")
    T result;
}
