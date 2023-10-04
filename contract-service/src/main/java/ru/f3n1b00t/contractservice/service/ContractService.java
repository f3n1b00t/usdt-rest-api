package ru.f3n1b00t.contractservice.service;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.f3n1b00t.contractservice.contract.USDTContract;

import java.math.BigInteger;

@Service
public class ContractService {
    private final USDTContract contract;
    private final Tracer tracer;

    @Autowired
    public ContractService(USDTContract contract, Tracer tracer) {
        this.contract = contract;
        this.tracer = tracer;
    }

    @Observed(name = "contract.name", contextualName = "get contract name")
    public String getName() {
        return contract.getName();
    }

    @Observed(name = "contract-service.deprecated", contextualName = "is contract deprecated")
    public boolean isDeprecated() {
        return contract.isDeprecated();
    }

    @Observed(name = "contract-service.total-supply", contextualName = "get contract total supply")
    public BigInteger getTotalSupply() {
        return contract.getTotalSupply();
    }

    @Observed(name = "contract-service.upgraded-address", contextualName = "get contract upgraded address")
    public String getUpgradedAddress() {
        return contract.getUpgradedAddress();
    }

    @Observed(name = "contract-service.balances", contextualName = "get contract balances")
    public BigInteger getBalances(String address) {
        tracer.currentSpan().tag("address", address);
        return contract.getBalances(address);
    }

    @Observed(name = "contract-service.decimals", contextualName = "get contract decimals")
    public BigInteger getDecimals() {
        return contract.getDecimals();
    }

    @Observed(name = "contract-service.maximum-fee", contextualName = "get contract maximum fee")
    public BigInteger getMaximumFee() {
        return contract.getMaximumFee();
    }

    @Observed(name = "contract-service._total-supply", contextualName = "get contract total supply")
    public BigInteger get_TotalSupply() {
        return contract.get_TotalSupply();
    }

    @Observed(name = "contract-service.black-list-status", contextualName = "get contract black list status")
    public boolean getBlackListStatus(String maker) {
        tracer.currentSpan().tag("maker", maker);
        return contract.getBlackListStatus(maker);
    }

    @Observed(name = "contract-service.allowed", contextualName = "get contract allowed")
    public BigInteger getAllowed(String from, String to) {
        tracer.currentSpan().tag("from", from)
                .tag("to", to);
        return contract.getAllowed(from, to);
    }

    @Observed(name = "contract-service.paused", contextualName = "is contract paused")
    public boolean isPaused() {
        return contract.isPaused();
    }

    @Observed(name = "contract-service.balance-of", contextualName = "get contract balance of")
    public BigInteger getBalanceOf(String address) {
        tracer.currentSpan().tag("address", address);
        return contract.getBalanceOf(address);
    }

    @Observed(name = "contract-service.owner", contextualName = "get contract owner")
    public String getOwner() {
        return contract.getOwner();
    }

    @Observed(name = "contract-service.symbol", contextualName = "get contract symbol")
    public String getSymbol() {
        return contract.getSymbol();
    }

    @Observed(name = "contract-service.allowance", contextualName = "get contract allowance")
    public BigInteger getAllowance(String owner, String spender) {
        tracer.currentSpan().tag("owner", owner)
                .tag("spender", spender);
        return contract.getAllowance(owner, spender);
    }

    @Observed(name = "contract-service.basis-points-rate", contextualName = "get contract basis points rate")
    public BigInteger getBasisPointsRate() {
        return contract.getBasisPointsRate();
    }

    @Observed(name = "contract-service.is-black-listed", contextualName = "is contract blacklisted")
    public boolean isBlackListed(String address) {
        tracer.currentSpan().tag("address", address);
        return contract.isBlackListed(address);
    }

    @Observed(name = "contract-service.max-uint", contextualName = "get contract max uint")
    public BigInteger getMaxUint() {
        return contract.getMaxUint();
    }
}
