package ru.f3n1b00t.contractservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "web3j")
public class Web3jProperties {
    private String privateKey;
    private String nodeUrl;
    private String contractAddress;
}
