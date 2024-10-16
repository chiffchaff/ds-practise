package com.sumit.adyen.problem2;

import java.math.BigInteger;
import java.util.List;
import java.util.TreeMap;

final class CardRange {
    final String start;
    final String end;
    final String cardNetwork;

    CardRange(String start, String end, String cardNetwork) {
        this.start = start;
        this.end = end;
        this.cardNetwork = cardNetwork;
    }
}

final class CardNetworkCache {
    private final TreeMap<BigInteger, CardRange> cardRangeMap;

    public CardNetworkCache(List<CardRange> cardRanges) {
        cardRangeMap = new TreeMap<>();
        for (CardRange range : cardRanges) {
            cardRangeMap.put(new BigInteger(range.start), range);
        }
    }

        public String get (String cardNumber){
            // Extract the first 12 digits of the card number as the network identifier
            String networkIdentifier = cardNumber.substring(0, 12);

            BigInteger cardNum = new BigInteger(networkIdentifier);

            // Find the closest range start that is less than or equal to the card number
            BigInteger floorKey = cardRangeMap.floorKey(cardNum);

            if (floorKey == null) {
                return null;  // No matching range
            }

            // Get the associated range
            CardRange range = cardRangeMap.get(floorKey);
            BigInteger start = new BigInteger(range.start);
            BigInteger end = new BigInteger(range.end);

            // Check if the networkIdentifier falls within the range
            if (cardNum.compareTo(start) >= 0 && cardNum.compareTo(end) <= 0) {
                return range.cardNetwork;
            }

            return null;  // No valid range found
        }
    }

