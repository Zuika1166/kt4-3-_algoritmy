package com.example.kt4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlgorithmsTest {
    @Test
    void nextGreaterPriceHandlesStrictComparison() {
        assertArrayEquals(
            new int[]{2, 1, 0},
            Task1NextGreaterPrice.daysUntilHigher(new int[]{5, 5, 6})
        );
    }

    @Test
    void nextGreaterPriceHandlesMixedSequence() {
        assertArrayEquals(
            new int[]{1, 2, 1, 1, 0, 0},
            Task1NextGreaterPrice.daysUntilHigher(new int[]{2, 4, 3, 5, 7, 6})
        );
    }

    @Test
    void gridShortestPathFindsMinimum() {
        assertEquals(
            5,
            Task2GridShortestPath.shortestPath(
                new String[]{
                    "S..#",
                    ".#..",
                    "...T"
                }
            )
        );
    }

    @Test
    void gridShortestPathReturnsMinusOneWhenBlocked() {
        assertEquals(
            -1,
            Task2GridShortestPath.shortestPath(
                new String[]{
                    "S#T",
                    "###",
                    "..."
                }
            )
        );
    }

    @Test
    void functionalGraphDetectsCycle() {
        assertTrue(
            Task3FunctionalGraphCycle.hasRepeatedNode(
                new int[]{2, 3, 4, 2},
                1
            )
        );
    }

    @Test
    void functionalGraphDetectsTermination() {
        assertFalse(
            Task3FunctionalGraphCycle.hasRepeatedNode(
                new int[]{2, 3, 4, -1},
                1
            )
        );
    }

    @Test
    void functionalGraphDetectsSelfLoop() {
        assertTrue(
            Task3FunctionalGraphCycle.hasRepeatedNode(
                new int[]{1},
                1
            )
        );
    }

    @Test
    void maximalRectangleFindsBestArea() {
        assertEquals(
            6,
            Task4MaximalRectangle.maximalRectangle(
                new String[]{
                    "10100",
                    "10111",
                    "11111",
                    "10010"
                }
            )
        );
    }

    @Test
    void maximalRectangleHandlesAllZerosAndAllOnes() {
        assertEquals(
            0,
            Task4MaximalRectangle.maximalRectangle(
                new String[]{"000", "000"}
            )
        );

        assertEquals(
            6,
            Task4MaximalRectangle.maximalRectangle(
                new String[]{"111", "111"}
            )
        );
    }

    @Test
    void keysAndDoorsUsesCollectedKey() {
        assertEquals(
            4,
            Task5KeysAndDoors.shortestPath(
                new String[]{
                    "S.a",
                    "##A",
                    "..T"
                }
            )
        );
    }

    @Test
    void keysAndDoorsRejectsLockedPathWithoutKey() {
        assertEquals(
            -1,
            Task5KeysAndDoors.shortestPath(
                new String[]{"SAT"}
            )
        );
    }

    @Test
    void keysAndDoorsFindsDirectPathWithoutKeys() {
        assertEquals(
            2,
            Task5KeysAndDoors.shortestPath(
                new String[]{"S.T"}
            )
        );
    }

    @Test
    void findDuplicateWorksForDifferentCycleShapes() {
        assertEquals(
            2,
            Task6FindDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2})
        );

        assertEquals(
            3,
            Task6FindDuplicate.findDuplicate(new int[]{3, 1, 3, 4, 2})
        );
    }

    @Test
    void findDuplicateHandlesSmallestInput() {
        assertEquals(
            1,
            Task6FindDuplicate.findDuplicate(new int[]{1, 1})
        );
    }
}
