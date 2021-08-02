package KR1.HDDDrives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;

public class DiskSpaceTest {

    @Test
    public void shouldReturnTrueWhenSectorOccupationIsZeroANdFileSizeEqualToBlockSize() {
        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
    }


    @Test
    public void shouldReturnFalseWhenSectorOccupationIsZeroANdFileSizeGreaterToBlockSize() {
        assertFalse(DiskSpace.isWritable(1, 3, new HashSet<>()));
    }


    @Test
    public void shouldReturnTrueWhenSpaceIsAvailableAfterTheLastOccupiedSector() {
        assertTrue(DiskSpace.isWritable(10, 2, new HashSet<>(Arrays.asList(1,3,4,6,8))));
    }

    @Test
    public void shouldReturnTrueWhenSpaceIsAvailableFromBeginningToFirstOccupiedSector() {
        assertTrue(DiskSpace.isWritable(10, 2, new HashSet<>(Arrays.asList(3,4,6,8,10))));
    }

    @Test
    public void shouldReturnTrueWhenSpaceIsAvailableInBetweenOccupiedSectors() {
        assertTrue(DiskSpace.isWritable(10, 2, new HashSet<>(Arrays.asList(1,3,4,7,9,10))));
    }

    @Test
    public void shouldReturnFalseWhenNoSpaceIsAvailableForTheFile() {
        assertFalse(DiskSpace.isWritable(10, 2, new HashSet<>(Arrays.asList(1,3,4,6,7,9,10))));
    }


}