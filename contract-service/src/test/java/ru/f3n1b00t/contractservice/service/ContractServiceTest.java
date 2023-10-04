package ru.f3n1b00t.contractservice.service;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.f3n1b00t.contractservice.contract.USDTContract;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContractServiceTest {
    @Mock
    private USDTContract contract;
    @Mock
    private Tracer tracer;
    @InjectMocks
    private ContractService contractService;

    @Test
    public void testGetName_callServiceAndIsOk() {
        String name = "Tether USD";
        when(contract.getName()).thenReturn(name);

        String result = contractService.getName();
        assertEquals(name, result);

        verify(contract).getName();
    }

    @Test
    public void testIsDeprecated_callServiceAndIsOk() {
        boolean deprecated = false;
        when(contract.isDeprecated()).thenReturn(deprecated);

        boolean result = contractService.isDeprecated();
        assertEquals(deprecated, result);

        verify(contract).isDeprecated();
    }

    @Test
    public void testGetUpgradedAddress_callServiceAndIsOk() {
        String upgradedAddress = "0x0000000000000000000000000000000000000000";
        when(contract.getUpgradedAddress()).thenReturn(upgradedAddress);

        String result = contractService.getUpgradedAddress();
        assertEquals(upgradedAddress, result);

        verify(contract).getUpgradedAddress();
    }

    @Test
    public void testGetBalances_callServiceAndIsOk() {
        BigInteger balance = BigInteger.valueOf(381305839);
        String address = "0x0000000000000000000000000000000000000000";
        Span span = mock(Span.class);

        when(contract.getBalances(address)).thenReturn(balance);
        when(tracer.currentSpan()).thenReturn(span);
        when(span.tag("address", address)).thenReturn(span);

        BigInteger result = contractService.getBalances(address);
        assertEquals(balance, result);

        verify(contract).getBalances(address);
        verify(tracer).currentSpan();
        verify(span).tag("address", address);
    }

    @Test
    public void testGetDecimals_callServiceAndIsOk() {
        BigInteger decimals = BigInteger.valueOf(6);
        when(contract.getDecimals()).thenReturn(decimals);

        BigInteger result = contractService.getDecimals();
        assertEquals(decimals, result);

        verify(contract).getDecimals();
    }

    @Test
    public void testGetMaximumFee_callServiceAndIsOk() {
        BigInteger maximumFee = BigInteger.valueOf(0);
        when(contract.getMaximumFee()).thenReturn(maximumFee);

        BigInteger result = contractService.getMaximumFee();
        assertEquals(maximumFee, result);

        verify(contract).getMaximumFee();
    }

    @Test
    public void testGetTotalSupply_callServiceAndIsOk() {
        BigInteger totalSupply = BigInteger.valueOf(39025187376288180L);
        when(contract.getTotalSupply()).thenReturn(totalSupply);

        BigInteger result = contractService.getTotalSupply();
        assertEquals(totalSupply, result);

        verify(contract).getTotalSupply();
    }

    @Test
    public void testGet_TotalSupply_callServiceAndIsOk() {
        BigInteger _totalSupply = BigInteger.valueOf(39025187376288180L);
        when(contract.get_TotalSupply()).thenReturn(_totalSupply);

        BigInteger result = contractService.get_TotalSupply();
        assertEquals(_totalSupply, result);

        verify(contract).get_TotalSupply();
    }

    @Test
    public void testGetBlackListStatus_callServiceAndIsOk() {
        boolean isBlackListed = false;
        String address = "0x000000000000000000000000000000000000000";
        Span span = mock(Span.class);

        when(contract.getBlackListStatus(address)).thenReturn(isBlackListed);
        when(tracer.currentSpan()).thenReturn(span);
        when(span.tag("maker", address)).thenReturn(span);

        boolean result = contractService.getBlackListStatus(address);
        assertEquals(isBlackListed, result);

        verify(contract).getBlackListStatus(address);
        verify(tracer).currentSpan();
        verify(span).tag("maker", address);
    }

    @Test
    public void testGetAllowed_callServiceAndIsOk() {
        BigInteger allowed = BigInteger.valueOf(0);
        String owner = "0x000000000000000000000000000000000000000";
        String spender = "0x000000000000000000000000000000000000000";
        Span span = mock(Span.class);

        when(contract.getAllowed(owner, spender)).thenReturn(allowed);
        when(tracer.currentSpan()).thenReturn(span);
        when(span.tag(anyString(), anyString())).thenReturn(span);

        BigInteger result = contractService.getAllowed(owner, spender);
        assertEquals(allowed, result);

        verify(contract).getAllowed(owner, spender);
        verify(tracer).currentSpan();
        verify(span, times(2)).tag(anyString(), anyString());
    }

    @Test
    public void testIsPaused_callServiceAndIsOk() {
        boolean isPaused = false;
        when(contract.isPaused()).thenReturn(isPaused);

        boolean result = contractService.isPaused();
        assertEquals(isPaused, result);

        verify(contract).isPaused();
    }

    @Test
    public void testGetBalanceOf_callServiceAndIsOk() {
        String address = "0x000000000000000000000000000000000000000";
        String spanTag = "address";
        BigInteger balance = BigInteger.valueOf(381305839);
        Span span = mock(Span.class);

        when(contract.getBalanceOf(address)).thenReturn(balance);
        when(tracer.currentSpan()).thenReturn(span);
        when(span.tag(spanTag, address)).thenReturn(span);

        BigInteger result = contractService.getBalanceOf(address);
        assertEquals(balance, result);

        verify(contract).getBalanceOf(address);
        verify(tracer).currentSpan();
        verify(span).tag(spanTag, address);
    }

    @Test
    public void testGetOwner_callServiceAndIsOk() {
        String owner = "0xc6cde7c39eb2f0f0095f41570af89efc2c1ea828";
        when(contract.getOwner()).thenReturn(owner);

        String result = contractService.getOwner();
        assertEquals(owner, result);

        verify(contract).getOwner();
    }

    @Test
    public void testGetSymbol_callServiceAndIsOk() {
        String symbol = "TUSD";
        when(contract.getSymbol()).thenReturn(symbol);

        String result = contractService.getSymbol();
        assertEquals(symbol, result);

        verify(contract).getSymbol();
    }

    @Test
    public void testGetAllowance_callServiceAndIsOk() {
        BigInteger allowance = BigInteger.valueOf(0);
        String owner = "0x000000000000000000000000000000000000000";
        String spender = "0x000000000000000000000000000000000000000";
        Span span = mock(Span.class);

        when(contract.getAllowance(owner, spender)).thenReturn(allowance);
        when(tracer.currentSpan()).thenReturn(span);
        when(span.tag(anyString(), anyString())).thenReturn(span);

        BigInteger result = contractService.getAllowance(owner, spender);
        assertEquals(allowance, result);

        verify(contract).getAllowance(owner, spender);
        verify(tracer).currentSpan();
        verify(span, times(2)).tag(anyString(), anyString());
    }

    @Test
    public void testGetBasicPointsRate_callServiceAndIsOk() {
        BigInteger basicPointsRate = BigInteger.valueOf(0);
        when(contract.getBasisPointsRate()).thenReturn(basicPointsRate);

        BigInteger result = contractService.getBasisPointsRate();
        assertEquals(basicPointsRate, result);

        verify(contract).getBasisPointsRate();
    }

    @Test
    public void testIsBlackListed_callServiceAndIsOk() {
        boolean isBlackListed = false;
        String address = "0x000000000000000000000000000000000000000";
        Span span = mock(Span.class);

        when(contract.isBlackListed(address)).thenReturn(isBlackListed);
        when(tracer.currentSpan()).thenReturn(span);
        when(span.tag("address", address)).thenReturn(span);

        boolean result = contractService.isBlackListed(address);
        assertEquals(isBlackListed, result);

        verify(contract).isBlackListed(address);
        verify(tracer).currentSpan();
        verify(span).tag("address", address);
    }

    @Test
    public void testGetMaxUint_callServiceAndIsOk() {
        BigInteger maxUint = BigInteger.valueOf(123);
        when(contract.getMaxUint()).thenReturn(maxUint);

        BigInteger result = contractService.getMaxUint();
        assertEquals(maxUint, result);

        verify(contract).getMaxUint();
    }
}
