import PacmanAI.Partition;
import PacmanAI.Utility.Parser;
import dataRecording.DataTuple;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;

public class PartitonTests {
    private Partition partition;
    private static LinkedList<DataTuple> tuples;

    @BeforeClass
    public static void preSetup()
    {
        Parser p = new Parser();
        tuples = p.parseTrainingData("src/test/resources/trainingData.txt");
        Assert.assertTrue(tuples.size() > 0);
    }
    @Before
    public void setup() {
        partition = new Partition(tuples);
        Assert.assertTrue(partition.getTuples() != null);
    }

    @Test
    public void shouldCreateASubPartition()
    {
        Partition other = partition.createNewPartitionOn("isBlinkyEdible", "true");
        other.getTuples().forEach( tuple -> {
           Assert.assertTrue(!tuple.getAttribute("isBlinkyEdible").equals("false"));
        });

    }





}
