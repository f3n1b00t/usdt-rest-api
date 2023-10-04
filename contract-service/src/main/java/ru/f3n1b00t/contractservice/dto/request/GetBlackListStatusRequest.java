package ru.f3n1b00t.contractservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Get address blacklist status request")
public class GetBlackListStatusRequest {
    @JsonProperty("maker")
    @NotBlank(message = "owner is required")
    @Pattern(message = "owner is invalid", regexp = "^0x[a-fA-F0-9]{40}$")
    @Schema(name = "maker", description = "The address of the maker", example = "0x0000000000000000000000000000000000000000")
    private String maker;
}
