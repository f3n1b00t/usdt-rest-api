package ru.f3n1b00t.contractservice.contract;

import java.math.BigInteger;

/**
 * This class represents the USDTContract.
 * It provides methods to interact with the USDT contract on the blockchain.
 */
public interface USDTContract {
    /**
     * Gets the name of the contract.
     *
     * @return the name of the contract
     */
    String getName();
    /**
     * Checks if the contract is marked as deprecated.
     *
     * @return true if the contract is marked as deprecated, false otherwise
     */
    boolean isDeprecated();
    /**
     * Retrieves the total supply of the contract.
     *
     * @return the total supply of the contract
     */
    BigInteger getTotalSupply();
    /**
     * Retrieves the upgraded address of the contract.
     *
     * @return the upgraded address of the contract
     */
    String getUpgradedAddress();
    /**
     * Retrieves the balances for a given address.
     *
     * @param  address   the address for which to retrieve the balances
     * @return           the balances associated with the given address
     */
    BigInteger getBalances(String address);
    /**
     * Retrieves the decimals of the contract.
     *
     * @return the decimals of the contract
     */
    BigInteger getDecimals();
    /**
     * Retrieves the maximum fee of the contract.
     *
     * @return the maximum fee of the contract
     */
    BigInteger getMaximumFee();
    /**
     * Retrieves the total supply of the contract.
     *
     * @return the total supply value of the contract
     */
    BigInteger get_TotalSupply();
    /**
     * Retrieves the blacklist status for a given address.
     *
     * @param  maker  the address to check the blacklist status for
     * @return        true if the address is blacklisted, false otherwise
     */
    boolean getBlackListStatus(String maker);
    /**
     * Retrieves the allowed for a given from address and to address.
     *
     * @param  from   the address of the owner
     * @param  to the address of the spender
     * @return         the allowed amount
     */
    BigInteger getAllowed(String from, String to);
    /**
     * Returns whether the contract is paused or not.
     *
     * @return   true if the contract is paused, false otherwise
     */
    boolean isPaused();
    /**
     * Retrieves the balance of the specified address.
     *
     * @param  address the address to retrieve the balance for
     * @return         the balance of the specified address
     */
    BigInteger getBalanceOf(String address);
    /**
     * Retrieves the owner of the contract.
     *
     * @return  the owner of the contract
     */
    String getOwner();
    /**
     * Retrieves the symbol associated with the contract.
     *
     * @return  the contract symbol
     */
    String getSymbol();
    /**
     * Retrieves the allowance for a given owner and spender.
     *
     * @param  owner   the address of the owner
     * @param  spender the address of the spender
     * @return         the allowance amount
     */
    BigInteger getAllowance(String owner, String spender);
    /**
     * Retrieves the basis points rate of the contract.
     *
     * @return the basis points rate of the contract
     */
    BigInteger getBasisPointsRate();
    /**
     * Determines if the given address is blacklisted.
     *
     * @param  address  the address to check
     * @return          true if the address is blacklisted, false otherwise
     */
    boolean isBlackListed(String address);
    /**
     * Retrieves the maximum value of an unsigned integer.
     *
     * @return the maximum unsigned integer value
     */
    BigInteger getMaxUint();
}
