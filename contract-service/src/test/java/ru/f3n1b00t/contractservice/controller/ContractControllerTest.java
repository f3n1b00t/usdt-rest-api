package ru.f3n1b00t.contractservice.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.f3n1b00t.contractservice.dto.request.GetAllowanceRequest;
import ru.f3n1b00t.contractservice.dto.request.GetBalanceOfRequest;
import ru.f3n1b00t.contractservice.dto.request.GetBlackListStatusRequest;
import ru.f3n1b00t.contractservice.dto.response.ContractInteractionResponse;
import ru.f3n1b00t.contractservice.service.ContractService;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContractControllerTest {
    @Mock
    private ContractService contractService;
    @InjectMocks
    private ContractController contractController;

    @Test
    public void testGetName_callServiceAndIsOk() {
        String name = "Tether USD";
        when(contractService.getName()).thenReturn(name);

        ContractInteractionResponse<String> response = contractController.getName();
        assertTrue(response.isOk());
        assertEquals(name, response.getResult());

        verify(contractService).getName();
    }

    @Test
    public void testIsDeprecated_callServiceAndIsOk() {
        boolean deprecated = false;
        when(contractService.isDeprecated()).thenReturn(deprecated);

        ContractInteractionResponse<Boolean> response = contractController.isDeprecated();
        assertTrue(response.isOk());
        assertEquals(deprecated, response.getResult());

        verify(contractService).isDeprecated();
    }

    @Test
    public void testGetUpgradedAddress_callServiceAndIsOk() {
        String address = "0x0000000000000000000000000000000000000000";
        when(contractService.getUpgradedAddress()).thenReturn(address);

        ContractInteractionResponse<String> response = contractController.getUpgradedAddress();

        assertTrue(response.isOk());
        assertEquals(address, response.getResult());

        verify(contractService).getUpgradedAddress();
    }

    @Test
    public void testGetBalances_callServiceAndIsOk() {
        BigInteger balance = BigInteger.valueOf(381305839);
        String address = "0x0000000000000000000000000000000000000000";

        when(contractService.getBalances(address)).thenReturn(balance);

        GetBalanceOfRequest request = GetBalanceOfRequest.builder()
                .owner(address)
                .build();

        ContractInteractionResponse<BigInteger> response = contractController.getBalances(request);

        assertTrue(response.isOk());
        assertEquals(balance, response.getResult());

        verify(contractService).getBalances(address);
    }

    @Test
    public void testGetDecimals_callServiceAndIsOk() {
        BigInteger decimals = BigInteger.valueOf(6);
        when(contractService.getDecimals()).thenReturn(decimals);

        ContractInteractionResponse<BigInteger> response = contractController.getDecimals();

        assertTrue(response.isOk());
        assertEquals(decimals, response.getResult());

        verify(contractService).getDecimals();
    }

    @Test
    public void testGetMaximumFee_callServiceAndIsOk() {
        BigInteger maximumFee = BigInteger.valueOf(0);
        when(contractService.getMaximumFee()).thenReturn(maximumFee);

        ContractInteractionResponse<BigInteger> response = contractController.getMaximumFee();

        assertTrue(response.isOk());
        assertEquals(maximumFee, response.getResult());

        verify(contractService).getMaximumFee();
    }

    @Test
    public void testGetTotalSupply_callServiceAndIsOk() {
        BigInteger totalSupply = BigInteger.valueOf(39025187376288180L);
        when(contractService.getTotalSupply()).thenReturn(totalSupply);

        ContractInteractionResponse<BigInteger> response = contractController.getTotalSupply();

        assertTrue(response.isOk());
        assertEquals(totalSupply, response.getResult());

        verify(contractService).getTotalSupply();
    }

    @Test
    public void testGet_TotalSupply_callServiceAndIsOk() {
        BigInteger _totalSupply = BigInteger.valueOf(39025187376288180L);
        when(contractService.get_TotalSupply()).thenReturn(_totalSupply);

        ContractInteractionResponse<BigInteger> response = contractController.get_TotalSupply();

        assertTrue(response.isOk());
        assertEquals(_totalSupply, response.getResult());

        verify(contractService).get_TotalSupply();
    }

    @Test
    public void testGetBlackListStatus_callServiceAndIsOk() {
        boolean isBlackListed = false;
        String address = "0x000000000000000000000000000000000000000";
        when(contractService.getBlackListStatus(address)).thenReturn(isBlackListed);

        GetBlackListStatusRequest request = GetBlackListStatusRequest.builder()
                .maker(address)
                .build();

        ContractInteractionResponse<Boolean> response = contractController.getBlackListStatus(request);

        assertTrue(response.isOk());
        assertEquals(isBlackListed, response.getResult());

        verify(contractService).getBlackListStatus(address);
    }

    @Test
    public void testGetAllowed_callServiceAndIsOk() {
        BigInteger allowed = BigInteger.valueOf(0);
        String owner = "0x000000000000000000000000000000000000000";
        String spender = "0x000000000000000000000000000000000000000";

        when(contractService.getAllowed(owner, spender)).thenReturn(allowed);

        GetAllowanceRequest request = GetAllowanceRequest.builder()
                .owner(owner)
                .spender(spender)
                .build();

        ContractInteractionResponse<BigInteger> response = contractController.getAllowed(request);

        assertTrue(response.isOk());
        assertEquals(allowed, response.getResult());

        verify(contractService).getAllowed(owner, spender);
    }

    @Test
    public void testIsPaused_callServiceAndIsOk() {
        boolean isPaused = false;
        when(contractService.isPaused()).thenReturn(isPaused);

        ContractInteractionResponse<Boolean> response = contractController.isPaused();
        assertTrue(response.isOk());
        assertEquals(isPaused, response.getResult());

        verify(contractService).isPaused();
    }

    @Test
    public void testGetBalanceOf_callServiceAndIsOk() {
        String address = "0x000000000000000000000000000000000000000";
        BigInteger balance = BigInteger.valueOf(381305839);
        when(contractService.getBalanceOf(address)).thenReturn(balance);

        GetBalanceOfRequest request = GetBalanceOfRequest.builder()
                .owner(address)
                .build();

        ContractInteractionResponse<BigInteger> response = contractController.getBalanceOf(request);
        assertTrue(response.isOk());
        assertEquals(balance, response.getResult());

        verify(contractService).getBalanceOf(address);
    }

    @Test
    public void testGetOwner_callServiceAndIsOk() {
        String owner = "0xc6cde7c39eb2f0f0095f41570af89efc2c1ea828";
        when(contractService.getOwner()).thenReturn(owner);

        ContractInteractionResponse<String> response = contractController.getOwner();
        assertTrue(response.isOk());
        assertEquals(owner, response.getResult());

        verify(contractService).getOwner();
    }

    @Test
    public void testGetSymbol_callServiceAndIsOk() {
        String symbol = "TUSD";
        when(contractService.getSymbol()).thenReturn(symbol);

        ContractInteractionResponse<String> response = contractController.getSymbol();
        assertTrue(response.isOk());
        assertEquals(symbol, response.getResult());

        verify(contractService).getSymbol();
    }

    @Test
    public void testGetAllowance_callServiceAndIsOk() {
        BigInteger allowance = BigInteger.valueOf(0);
        String owner = "0x000000000000000000000000000000000000000";
        String spender = "0x000000000000000000000000000000000000000";

        when(contractService.getAllowance(owner, spender)).thenReturn(allowance);

        GetAllowanceRequest request = GetAllowanceRequest.builder()
                .owner(owner)
                .spender(spender)
                .build();

        ContractInteractionResponse<BigInteger> response = contractController.getAllowance(request);

        assertTrue(response.isOk());
        assertEquals(allowance, response.getResult());

        verify(contractService).getAllowance(owner, spender);
    }

    @Test
    public void testGetBasicPointsRate_callServiceAndIsOk() {
        BigInteger basicPointsRate = BigInteger.valueOf(0);
        when(contractService.getBasisPointsRate()).thenReturn(basicPointsRate);

        ContractInteractionResponse<BigInteger> response = contractController.getBasisPointsRate();
        assertTrue(response.isOk());
        assertEquals(basicPointsRate, response.getResult());

        verify(contractService).getBasisPointsRate();
    }

    @Test
    public void testIsBlackListed_callServiceAndIsOk() {
        boolean isBlackListed = false;
        String address = "0x000000000000000000000000000000000000000";

        when(contractService.isBlackListed(address)).thenReturn(isBlackListed);

        GetBlackListStatusRequest request = GetBlackListStatusRequest.builder()
                .maker(address)
                .build();

        ContractInteractionResponse<Boolean> response = contractController.isBlackListed(request);

        assertTrue(response.isOk());
        assertEquals(isBlackListed, response.getResult());

        verify(contractService).isBlackListed(address);
    }

    @Test
    public void testGetMaxUint_callServiceAndIsOk() {
        BigInteger maxUint = BigInteger.valueOf(123);
        when(contractService.getMaxUint()).thenReturn(maxUint);

        ContractInteractionResponse<BigInteger> response = contractController.getMaxUint();
        assertTrue(response.isOk());
        assertEquals(maxUint, response.getResult());

        verify(contractService).getMaxUint();
    }
}
