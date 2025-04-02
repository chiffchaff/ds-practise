package com.sumit.actualInterview.adyen.problem1;

class AdyenLoadBalancer {
    public int getReceivingHost(int n, int msAfterMidnight) {
        // Calculate the total time span for one complete cycle (forward and backward)
        int cycleTime = 2 * (n - 1);

        // Find the position in the current cycle
        int positionInCycle = msAfterMidnight % cycleTime;

        // Determine the host based on the position in the cycle
        if (positionInCycle < n) {
            // Forward direction
            return positionInCycle + 1;
        } else {
            // Backward direction
            return 2 * n - positionInCycle - 1;
        }
    }
}
