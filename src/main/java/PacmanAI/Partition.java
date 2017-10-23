package PacmanAI;

import dataRecording.DataTuple;

import java.util.LinkedList;

/**
 * @author Kalk88 & Kemaldev
 *
 * Container class for a filtered set of Data tuples.
 *
 *
*/
public class Partition {
    private LinkedList<DataTuple> tuples;

    public Partition(LinkedList<DataTuple> subpartion) {
        this.tuples = subpartion;
    }

    /**
     * Creates a new Partition on the given attribute and value.
     * @param attribute
     * @param value
     * @return Partition
     */
    public Partition createNewPartitionOn(String attribute, String value) {
        return null;
    }
}