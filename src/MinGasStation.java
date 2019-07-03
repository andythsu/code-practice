import java.util.Arrays;

/**
 * Find minimum trips gas stations that will get to last gas station
 * Copyright © 2019, Oracle and/or its affiliates. All rights reserved.
 *
 * @author tsu
 * @since 2019-07-02
 */
public class MinGasStation {
    /**
     * @param gasStations  is the distance away from prev gas station
     * @param gasAvailable is how much gas available at the station
     * @param tankCapacity is how much gas the tank can hold
     * @return
     */
    public int solution(int[] gasStations, int[] gasAvailable, int tankCapacity) {
        // prepend an origin (our startng point)
        int[] newGasStations = new int[gasStations.length + 1];
        newGasStations[0] = 0;
        for (int i = 0; i < gasStations.length; i++) {
            newGasStations[i + 1] = gasStations[i];
        }
        // keeps track of how long the car needs to travel to get to that gas station from origin
        int[] gasFromOriginal = new int[newGasStations.length];
        gasFromOriginal[0] = 0;
        for (int i = 1; i < gasFromOriginal.length; i++) {
            gasFromOriginal[i] = newGasStations[i] + gasFromOriginal[i - 1];
        }
        // keeps track of remaining gas after the car is fueled at that station
        int[] gasRemaining = new int[newGasStations.length];
        // assuming car is at full tank at the beginning
        gasRemaining[0] = tankCapacity;
        // keeps track of how many trips the car needs to make to get to that station
        int[] trips = new int[newGasStations.length];
        Arrays.fill(trips, Integer.MAX_VALUE);
        trips[0] = 0;

        for (int i = 1; i < newGasStations.length; i++) {
            for (int j = 0; j < i; j++) {
                // if I can go to i from j
                if ((j == 0 && gasRemaining[j] >= gasFromOriginal[i]) || j != 0 && (gasRemaining[j] >= (gasFromOriginal[i] - gasFromOriginal[j]))) {
                    int oldTrip = trips[i];
                    trips[i] = Math.min(trips[i], trips[j] + 1);
                    if (oldTrip != trips[i]) {
                        int gasRemain = gasRemaining[j] + gasAvailable[i - 1] - gasFromOriginal[i];
                        gasRemaining[i] = gasRemain >= tankCapacity ? tankCapacity : gasRemain;
                    }
                }
            }
        }
        return trips[gasStations.length] == Integer.MAX_VALUE ? -1 : trips[gasStations.length];
    }
}
