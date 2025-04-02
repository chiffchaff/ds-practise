package com.sumit.actualInterview.adyen.problem2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CardNetworkCacheTest {

    private CardNetworkCache cardNetworkCache;

    @BeforeEach
    public void setUp() {
        List<CardRange> cardRanges = new ArrayList<>();
        cardRanges.add(new CardRange("410000000000", "419999999999", "visa"));
        cardRanges.add(new CardRange("420008000000", "420008999999", "amex"));
        cardRanges.add(new CardRange("435000000000", "435000999999", "visa"));
        cardRanges.add(new CardRange("540000000000", "599999999999", "mc"));

        cardNetworkCache = new CardNetworkCache(cardRanges);
    }

    @Test
    public void testCardInFirstRange() {
        String cardNumber = "411111111111";
        String expectedNetwork = "visa";
        assertEquals(expectedNetwork, cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardInSecondRange() {
        String cardNumber = "420008123456";
        String expectedNetwork = "amex";
        assertEquals(expectedNetwork, cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardInThirdRange() {
        String cardNumber = "435000123456";
        String expectedNetwork = "visa";
        assertEquals(expectedNetwork, cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardInFourthRange() {
        String cardNumber = "550000123456";
        String expectedNetwork = "mc";
        assertEquals(expectedNetwork, cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardOutsideAnyRange() {
        String cardNumber = "600000123456";
        assertNull(cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardExactlyAtRangeStart() {
        String cardNumber = "540000000000";
        String expectedNetwork = "mc";
        assertEquals(expectedNetwork, cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardExactlyAtRangeEnd() {
        String cardNumber = "599999999999";
        String expectedNetwork = "mc";
        assertEquals(expectedNetwork, cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardAtGapBetweenRanges() {
//        String cardNumber = "420009000000";
        String cardNumber = "420006000000";
        assertNull(cardNetworkCache.get(cardNumber));
    }

    @Test
    public void testCardNumberWithMoreThan12Digits() {
        // The first 12 digits "411111111111" fall in the first range for "visa"
        String cardNumber = "4111111111111234";
        String expectedNetwork = "visa";
        assertEquals(expectedNetwork, cardNetworkCache.get(cardNumber));
    }

}
