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
@Schema(description = "Get balance of address request")
public class GetBalanceOfRequest {
    @JsonProperty("owner")
    @NotBlank(message = "owner is required")
    @Pattern(message = "owner is invalid", regexp = "^0x[a-fA-F0-9]{40}$")
    @Schema(name = "owner", description = "The address of the owner", example = "0x0000000000000000000000000000000000000000")
    private String owner;
}
