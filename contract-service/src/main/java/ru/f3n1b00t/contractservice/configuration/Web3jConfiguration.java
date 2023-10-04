package ru.f3n1b00t.contractservice.configuration;

import io.micrometer.tracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import ru.f3n1b00t.contractservice.contract.USDTContract;
import ru.f3n1b00t.contractservice.contract.USDTContractImpl;

@Configuration
@EnableConfigurationProperties(Web3jProperties.class)
public class Web3jConfiguration {
    private final Web3jProperties properties;

    @Autowired
    public Web3jConfiguration(Web3jProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(properties.getNodeUrl()));
    }

    @Bean
    public Credentials credentials() {
        return Credentials.create(properties.getPrivateKey());
    }

    @Bean
    public USDTContract contract(Web3j web3j, Credentials credentials, Tracer tracer) {
        return new USDTContractImpl(
                properties.getContractAddress(),
                web3j,
                credentials,
                new DefaultGasProvider(),
                tracer
        );
    }
}
