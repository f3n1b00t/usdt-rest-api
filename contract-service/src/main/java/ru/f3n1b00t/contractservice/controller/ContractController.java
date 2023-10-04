package ru.f3n1b00t.contractservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.f3n1b00t.contractservice.dto.request.GetAllowanceRequest;
import ru.f3n1b00t.contractservice.dto.request.GetBalanceOfRequest;
import ru.f3n1b00t.contractservice.dto.request.GetBlackListStatusRequest;
import ru.f3n1b00t.contractservice.dto.response.ContractInteractionErrorResponse;
import ru.f3n1b00t.contractservice.dto.response.ContractInteractionResponse;
import ru.f3n1b00t.contractservice.service.ContractService;

import java.math.BigInteger;

@RestController
@RequestMapping("/v1/contract/usdt")
@Tag(name = "Contract", description = "The USDT Contract API")
public class ContractController {
    private final ContractService contractService;

    @Autowired
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping("/name")
    @Operation(summary = "Get name", description = "Retrieves the name of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": \"Tether USD\" }")
                )
            }
    )
    public ContractInteractionResponse<String> getName() {
        return ContractInteractionResponse.<String>builder()
                .isOk(true)
                .result(contractService.getName())
                .build();
    }

    @GetMapping("/deprecated")
    @Operation(summary = "Is deprecated", description = "Retrieves whether the contract is deprecated.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": false }")
                )
            }
    )
    public ContractInteractionResponse<Boolean> isDeprecated(){
        return ContractInteractionResponse.<Boolean>builder()
                .isOk(true)
                .result(contractService.isDeprecated())
                .build();
    }

    @GetMapping("/upgraded-address")
    @Operation(summary = "Get upgraded address", description = "Retrieves the upgraded address.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": \"0x0000000000000000000000000000000000000000\" }")
                )
            }
    )
    public ContractInteractionResponse<String> getUpgradedAddress() {
        return ContractInteractionResponse.<String>builder()
                .isOk(true)
                .result(contractService.getUpgradedAddress())
                .build();
    }

    @PostMapping("/balances")
    @Operation(summary = "Get balance of address", description = "Retrieves the balance of an address.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request was successful",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": true, \"result\": 239502373 }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"JSON parse error\" }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"Something went wrong...\" }")
                            )
                    }
            )
    })
    public ContractInteractionResponse<BigInteger> getBalances(
            @Parameter(description = "DTO for get balance", required = true, schema = @Schema(implementation = GetBalanceOfRequest.class))
            @Valid @RequestBody GetBalanceOfRequest request
    ) {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getBalances(request.getOwner()))
                .build();
    }

    @GetMapping("/decimals")
    @Operation(summary = "Get decimals", description = "Retrieves the decimals.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": 6 }")
                )
            }
    )
    public ContractInteractionResponse<BigInteger> getDecimals() {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getDecimals())
                .build();
    }

    @GetMapping("/maximum-fee")
    @Operation(summary = "Get maximum fee", description = "Retrieves the maximum fee of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": 0 }")
                )
            }
    )
    public ContractInteractionResponse<BigInteger> getMaximumFee() {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getMaximumFee())
                .build();
    }

    @GetMapping("/total-supply")
    @Operation(summary = "Get total supply", description = "Retrieves the total supply of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": 39025187376288180 }")
                )
            }
    )
    public ContractInteractionResponse<BigInteger> getTotalSupply() {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getTotalSupply())
                .build();
    }

    @GetMapping("/_total-supply")
    @Operation(summary = "Get _total supply", description = "Retrieves the total supply of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": 39025187376288180 }")
                )
            }
    )
    public ContractInteractionResponse<BigInteger> get_TotalSupply() {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.get_TotalSupply())
                .build();
    }

    @PostMapping("/get-blacklist-status")
    @Operation(summary = "Is address blacklisted", description = "Retrieves whether the address is blacklisted.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request was successful",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": true, \"result\": false }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"JSON parse error\" }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"Something went wrong...\" }")
                            )
                    }
            )
    })
    public ContractInteractionResponse<Boolean> getBlackListStatus(
            @Parameter(description = "DTO for get black list status", required = true, schema = @Schema(implementation = GetBlackListStatusRequest.class))
            @Valid @RequestBody GetBlackListStatusRequest request
    ) {
        return ContractInteractionResponse.<Boolean>builder()
                .isOk(true)
                .result(contractService.getBlackListStatus(request.getMaker()))
                .build();
    }

    @PostMapping("/allowed")
    @Operation(summary = "Get allowance", description = "TODO")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request was successful",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": true, \"result\": 0 }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"JSON parse error\" }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"Something went wrong...\" }")
                            )
                    }
            )
    })
    public ContractInteractionResponse<BigInteger> getAllowed(
            @Parameter(description = "DTO for get allowance", required = true, schema = @Schema(implementation = GetAllowanceRequest.class))
            @Valid @RequestBody GetAllowanceRequest request
    ) {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getAllowed(
                        request.getOwner(),
                        request.getSpender()
                ))
                .build();
    }

    @GetMapping("/paused")
    @Operation(summary = "Is paused", description = "Retrieves whether the contract is paused")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": false }")
                )
            }
    )
    public ContractInteractionResponse<Boolean> isPaused() {
        return ContractInteractionResponse.<Boolean>builder()
                .isOk(true)
                .result(contractService.isPaused())
                .build();
    }

    @PostMapping("/balance-of")
    @Operation(summary = "Get balance of address", description = "Retrieves the balance of the address.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request was successful",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": true, \"result\": 239502373 }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"JSON parse error\" }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"Something went wrong...\" }")
                            )
                    }
            )
    })
    public ContractInteractionResponse<BigInteger> getBalanceOf(
            @Parameter(description = "DTO for get balance of", required = true, schema = @Schema(implementation = GetBalanceOfRequest.class))
            @Valid @RequestBody GetBalanceOfRequest request
    ) {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getBalanceOf(request.getOwner()))
                .build();
    }

    @GetMapping("/owner")
    @Operation(summary = "Get owner", description = "Retrieves the owner of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": \"0xc6cde7c39eb2f0f0095f41570af89efc2c1ea828\" }")
                )
            }
    )
    public ContractInteractionResponse<String> getOwner() {
        return ContractInteractionResponse.<String>builder()
                .isOk(true)
                .result(contractService.getOwner())
                .build();
    }

    @GetMapping("/symbol")
    @Operation(summary = "Get symbol", description = "Retrieves the symbol of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": \"USDT\" }")
                )
            }
    )
    public ContractInteractionResponse<String> getSymbol() {
        return ContractInteractionResponse.<String>builder()
                .isOk(true)
                .result(contractService.getSymbol())
                .build();
    }

    @PostMapping("/allowance")
    @Operation(summary = "Get allowance", description = "TODO")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request was successful",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": true, \"result\": 0 }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"JSON parse error\" }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"Something went wrong...\" }")
                            )
                    }
            )
    })
    public ContractInteractionResponse<BigInteger> getAllowance(
            @Parameter(description = "DTO for get allowance", required = true, schema = @Schema(implementation = GetAllowanceRequest.class))
            @Valid @RequestBody GetAllowanceRequest request
    ) {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getAllowance(
                        request.getOwner(),
                        request.getSpender()
                ))
                .build();
    }

    @GetMapping("/basis-points-rate")
    @Operation(summary = "Get basis points rate", description = "Retrieves the basis points rate of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": 0 }")
                )
            }
    )
    public ContractInteractionResponse<BigInteger> getBasisPointsRate() {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getBasisPointsRate())
                .build();
    }

    @PostMapping("/is-blacklisted")
    @Operation(summary = "Is address blacklisted", description = "Retrieves whether the address is blacklisted.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Request was successful",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": true, \"result\": false }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"JSON parse error\" }")
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = ContractInteractionErrorResponse.class),
                                    mediaType = "application/json",
                                    examples = @ExampleObject("{ \"ok\": false, \"message\": \"Something went wrong...\" }")
                            )
                    }
            )
    })
    public ContractInteractionResponse<Boolean> isBlackListed(
            @Parameter(description = "DTO for get black list status", required = true, schema = @Schema(implementation = GetBlackListStatusRequest.class))
            @Valid @RequestBody GetBlackListStatusRequest request
    ) {
        return ContractInteractionResponse.<Boolean>builder()
                .isOk(true)
                .result(contractService.isBlackListed(request.getMaker()))
                .build();
    }

    @GetMapping("/max-uint")
    @Operation(summary = "Get MAX_UINT", description = "Retrieves the MAX_UINT of the contract.")
    @ApiResponse(
            responseCode = "200",
            description = "Request was successful",
            content = {
                @Content(
                        schema = @Schema(implementation = ContractInteractionResponse.class),
                        mediaType = "application/json",
                        examples = @ExampleObject("{ \"ok\": true, \"result\": 1.157920892373162e+77 }")
                )
            }
    )
    public ContractInteractionResponse<BigInteger> getMaxUint() {
        return ContractInteractionResponse.<BigInteger>builder()
                .isOk(true)
                .result(contractService.getMaxUint())
                .build();
    }
}
