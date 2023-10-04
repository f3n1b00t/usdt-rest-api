package ru.f3n1b00t.contractservice.contract;

import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.Tracer;
import lombok.SneakyThrows;
import lombok.val;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.List;

public class USDTContractImpl extends Contract implements USDTContract {
    private final Tracer tracer;

    public USDTContractImpl(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, Tracer tracer) {
        super("", contractAddress, web3j, credentials, contractGasProvider);
        this.tracer = tracer;
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.name", contextualName = "send contract call")
    public String getName() {
        val function = new Function("name",
                List.of(),
                List.of(new TypeReference<Utf8String>() {})
        );

        return executeRemoteCallSingleValueReturn(function, String.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.deprecated", contextualName = "send contract call")
    public boolean isDeprecated() {
        val function = new Function("deprecated",
                List.of(),
                List.of(new TypeReference<Bool>() {})
        );

        return executeRemoteCallSingleValueReturn(function, Boolean.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.total-supply", contextualName = "send contract call")
    public BigInteger getTotalSupply() {
        val function = new Function("totalSupply",
                List.of(),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.upgraded-address", contextualName = "send contract call")
    public String getUpgradedAddress() {
        val function = new Function("upgradedAddress",
                List.of(),
                List.of(new TypeReference<Address>() {})
        );

        return executeRemoteCallSingleValueReturn(function, String.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.balances", contextualName = "send contract call")
    public BigInteger getBalances(String address) {
        tracer.currentSpan().tag("address", address);

        val function = new Function("balances",
                List.of(new Address(address)),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.decimals", contextualName = "send contract call")
    public BigInteger getDecimals() {
        val function = new Function("decimals",
                List.of(),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.maximum-fee", contextualName = "send contract call")
    public BigInteger getMaximumFee() {
        val function = new Function("maximumFee",
                List.of(),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract._total-supply", contextualName = "send contract call")
    public BigInteger get_TotalSupply() {
        val function = new Function("_totalSupply",
                List.of(),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.black-list-status", contextualName = "send contract call")
    public boolean getBlackListStatus(String maker) {
        tracer.currentSpan().tag("maker", maker);

        val function = new Function("getBlackListStatus",
                List.of(new Address(maker)),
                List.of(new TypeReference<Bool>() {})
        );

        return executeRemoteCallSingleValueReturn(function, Boolean.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.allowed", contextualName = "send contract call")
    public BigInteger getAllowed(String from, String to) {
        tracer.currentSpan().tag("from", from)
                .tag("to", to);

        val function = new Function("allowed",
                List.of(new Address(from), new Address(to)),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.paused", contextualName = "send contract call")
    public boolean isPaused() {
        val function = new Function("paused",
                List.of(),
                List.of(new TypeReference<Bool>() {})
        );

        return executeRemoteCallSingleValueReturn(function, Boolean.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.balance-of", contextualName = "send contract call")
    public BigInteger getBalanceOf(String address) {
        tracer.currentSpan().tag("address", address);

        val function = new Function("balanceOf",
                List.of(new Address(address)),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.owner", contextualName = "send contract call")
    public String getOwner() {
        val function = new Function("owner",
                List.of(),
                List.of(new TypeReference<Address>() {})
        );

        return executeRemoteCallSingleValueReturn(function, String.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.symbol", contextualName = "send contract call")
    public String getSymbol() {
        val function = new Function("symbol",
                List.of(),
                List.of(new TypeReference<Utf8String>() {})
        );

        return executeRemoteCallSingleValueReturn(function, String.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.allowance", contextualName = "send contract call")
    public BigInteger getAllowance(String owner, String spender) {
        tracer.currentSpan().tag("owner", owner)
                .tag("spender", spender);

        val function = new Function("allowance",
                List.of(new Address(owner), new Address(spender)),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.basis-points-rate", contextualName = "send contract call")
    public BigInteger getBasisPointsRate() {
        val function = new Function("basisPointsRate",
                List.of(),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.is-black-listed", contextualName = "send contract call")
    public boolean isBlackListed(String address) {
        tracer.currentSpan().tag("address", address);

        val function = new Function("isBlackListed",
                List.of(new Address(address)),
                List.of(new TypeReference<Bool>() {})
        );

        return executeRemoteCallSingleValueReturn(function, Boolean.class).send();
    }

    @Override
    @SneakyThrows
    @Observed(name = "contract.max-uint", contextualName = "send contract call")
    public BigInteger getMaxUint() {
        val function = new Function("MAX_UINT",
                List.of(),
                List.of(new TypeReference<Uint256>() {})
        );

        return executeRemoteCallSingleValueReturn(function, BigInteger.class).send();
    }
}
