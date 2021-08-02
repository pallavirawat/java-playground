package KR1.HDDDrives;

import java.util.Set;
import java.util.TreeSet;

public class DiskSpace {
    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        if(occupiedSectors.isEmpty()){
            return fileSize <= blockSize;
        }
        Set<Integer> sortedOccupiedSectors = new TreeSet<Integer>(occupiedSectors);

        int minSector = 0;
        int maxSector = blockSize+1;

        int windowLeft = minSector;
        for (Integer value : sortedOccupiedSectors){
            if(availableFreeSectorSizeBetween(value, windowLeft) >= fileSize)
                return true;
            windowLeft = value;
        }
        if(availableFreeSectorSizeBetween(maxSector, windowLeft) >= fileSize)
            return true;
        return false;
    }

    private static int availableFreeSectorSizeBetween(int sectorStartIndex, int SectorEndIndex) {
        return sectorStartIndex - SectorEndIndex -1;
    }
}
