import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class CompetitionTests {


    @Test
    public void testDijkstraConstructor() {
        CompetitionDijkstra cd1 = new CompetitionDijkstra("not_found.txt", 50, 80, 60);

        assertEquals("expect -1 for file not found", -1, cd1.timeRequiredforCompetition());

        CompetitionDijkstra cd2 = new CompetitionDijkstra("tinyEWD.txt", 101, 80, 60);

        assertEquals("expect -1 for speed > 100 .", -1, cd2.timeRequiredforCompetition());

        CompetitionDijkstra cd3 = new CompetitionDijkstra("tinyEWD.txt", -50, 80, 60);
        assertEquals("expect -1 for speed < 50 .", -1, cd3.timeRequiredforCompetition());

        CompetitionDijkstra cd4 = new CompetitionDijkstra("tinyEWD.txt", 50, -50, 60);
        assertEquals("expect -1 for speed <50 .", -1, cd4.timeRequiredforCompetition());

        CompetitionDijkstra cd5 = new CompetitionDijkstra("tinyEWD.txt", 50, 80, -50);
        assertEquals("expect -1 for speed <50 .", -1, cd5.timeRequiredforCompetition());

        CompetitionDijkstra cd6 = new CompetitionDijkstra("tinyEWD.txt", 50, 101, 60);
        assertEquals("expect -1 for speed > 100 .", -1, cd6.timeRequiredforCompetition());

        CompetitionDijkstra cd7 = new CompetitionDijkstra("tinyEWD.txt", 50, 80, 101);
        assertEquals("expect -1 for speed > 100 .", -1, cd7.timeRequiredforCompetition());

    }

    @Test
    public void testFWConstructor() {
        CompetitionFloydWarshall cd1 = new CompetitionFloydWarshall("not_found.txt", 50, 80, 60);
        assertEquals("expect -1 for file not found", -1, cd1.timeRequiredforCompetition());

        CompetitionFloydWarshall c2 = new CompetitionFloydWarshall("tinyEWD.txt", -50, 50, 50);

        assertEquals("expect -1 for speed < 50 .", -1, c2.timeRequiredforCompetition());

        CompetitionFloydWarshall c3 = new CompetitionFloydWarshall("tinyEWD.txt", 50, -50, 50);

        assertEquals("expect -1 for speed < 50 .", -1, c3.timeRequiredforCompetition());

        CompetitionFloydWarshall c4 = new CompetitionFloydWarshall("tinyEWD.txt", 50, 50, -50);

        assertEquals("expect -1 for speed < 50 .", -1, c4.timeRequiredforCompetition());
    }

    @Test
    public void testCompetitionDijkstra() {
        CompetitionDijkstra c1 = new CompetitionDijkstra("tinyEWD.txt", 50, 80, 60);
        assertEquals("Expect 38 minutes for contest with walking speed = 50.", 38, c1.timeRequiredforCompetition());

        CompetitionDijkstra c2 = new CompetitionDijkstra("1000EWD.txt", 50, 80, 60);
        assertEquals("Expect 28 minutes for contest with walking speed = 50.", 28, c2.timeRequiredforCompetition());
    }

    @Test
    public void testCompetitionFloydWarshall() {
        CompetitionFloydWarshall c1 = new CompetitionFloydWarshall("tinyEWD.txt", 50, 80, 60);
        assertEquals("Expect 38 minutes for contest with walking speed = 55.", 38, c1.timeRequiredforCompetition());

    }


    @Test
    public void testCompetitionWebcat() {
        CompetitionDijkstra c1 = new CompetitionDijkstra("input-B.txt", 60, 80, 50);
        assertEquals("Expect 10000 minutes for contest with walking speed = 50.", 10000, c1.timeRequiredforCompetition());

        CompetitionFloydWarshall c2 = new CompetitionFloydWarshall("input-B.txt", 60, 80, 50);
        assertEquals("Expect 10000 minutes for contest with walking speed = 50.", 10000, c1.timeRequiredforCompetition());
    }

    @Test
    public void testCompetitionWebcat1() {
        CompetitionDijkstra c1 = new CompetitionDijkstra("input-A.txt", 60, 50, 75);
        assertEquals("Expect -1 for contest with walking speed = 50.", -1, c1.timeRequiredforCompetition());

        CompetitionFloydWarshall c2 = new CompetitionFloydWarshall("input-A.txt", 60, 50, 75);
        assertEquals("Expect -1 for contest with walking speed = 50.", -1, c2.timeRequiredforCompetition());
    }

    @Test
    public void testCompetitionWebcat2() {
        CompetitionDijkstra c1 = new CompetitionDijkstra("input-B.txt", 60, 50, 75);
        assertEquals("Expect 10000 for contest with walking speed = 50.", 10000, c1.timeRequiredforCompetition());

        CompetitionDijkstra c2 = new CompetitionDijkstra("input-C.txt", 60, 50, 75);
        assertEquals("Expect -1 for contest with walking speed = 50.", -1, c2.timeRequiredforCompetition());
    }

    @Test
    public void testCompetitionWebcat3() {
        CompetitionDijkstra c1 = new CompetitionDijkstra("input-J.txt", 60, 75, 61);
        assertEquals("Expect -1 for contest with walking speed = 60.", -1, c1.timeRequiredforCompetition());
        CompetitionDijkstra c2 = new CompetitionDijkstra("input-J.txt", 98, 70, 84);
        assertEquals("Expect -1 for contest with walking speed = 70.", -1, c2.timeRequiredforCompetition());

        CompetitionFloydWarshall c3 = new CompetitionFloydWarshall("input-J.txt", 98, 70, 84);
        assertEquals("Expect -1 for contest with walking speed = 70.", -1, c3.timeRequiredforCompetition());
    }

    @Test
    public void testAdjMatrixEdgeWeightedDigraphNegativeV() {
        try {
            File myObj = new File("filename.txt");

            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("-1 -1");
            myWriter.close();
            try {
                new AdjMatrixEdgeWeightedDigraph("filename.txt");
                fail("Number of vertices in a Digraph must be nonnegative");
            } catch (IllegalArgumentException e) {
                //assert ExceptionType e
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }

    @Test
    public void testAdjMatrixEdgeWeightedDigraphNegativeE() {
        try {
            File myObj = new File("filename2.txt");

            FileWriter myWriter = new FileWriter("filename2.txt");
            myWriter.write("0 -1");
            myWriter.close();
            try {
                new AdjMatrixEdgeWeightedDigraph("filename2.txt");
                fail("Number of edges must be nonnegative");
            } catch (IllegalArgumentException e) {
                //assert ExceptionType e
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }

    @Test
    public void testAdjMatrixEdgeWeightedDigraphNegativeNull() {
        try {
            new AdjMatrixEdgeWeightedDigraph(null);
            fail("fileName is null");

        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void EdgeWeightedDigraphNegativeNull() {
        try {
            new EdgeWeightedDigraph(null);
            fail("fileName is null");

        } catch (IllegalArgumentException e) {

        }

    }
    @Test
    public void EdgeWeightedDigraphNegativeV() {
        try {
            new EdgeWeightedDigraph("filename.txt");
            fail("Number of vertices in a Digraph must be nonnegative");

        } catch (IllegalArgumentException e) {

        }

    }
    @Test
    public void EdgeWeightedDigraphNegativeE() {
        try {
            new EdgeWeightedDigraph("filename2.txt");
            fail("Number of edges must be nonnegative");

        } catch (IllegalArgumentException e) {

        }

    }

    @Test
    public void testAdjMatrixEdgeWeightedDigraphNegativeNumberOfEdges() {
        assertEquals("Expect 15", 15, new AdjMatrixEdgeWeightedDigraph("tinyEWD.txt").E());
    }

    @Test
    public void testBag() {
        Bag bag = new Bag<Integer>();
        assertEquals("Test Bag empty", true, bag.isEmpty());
        assertEquals("Test Bag size empty", 0, bag.size());
        Iterator i = bag.iterator();
        try {
            i.remove();
        } catch (UnsupportedOperationException e) {

        }
        try {
            i.next();
        } catch (NoSuchElementException e) {

        }

    }

    @Test
    public void testDijkstraSPNegativeWeights() {

        try {
            File myObj = new File("filename1.txt");

            FileWriter myWriter = new FileWriter("filename1.txt");
            myWriter.write("1 0  -3.0 ");
            myWriter.close();

            EdgeWeightedDigraph edge = new EdgeWeightedDigraph("filename1.txt");
            try {
                DijkstraSP sp = new DijkstraSP(edge, 1);

            } catch (IllegalArgumentException e) {

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }

    @Test
    public void testDijkstraSPValidateVertex() {
        EdgeWeightedDigraph edge = new EdgeWeightedDigraph("input-A.txt");
        DijkstraSP sp = new DijkstraSP(edge, 0);
        try{
            sp.hasPathTo(-1);
        }catch(IllegalArgumentException e){

        }
        try{
            sp.hasPathTo(5);
        }catch(IllegalArgumentException e1){

        }
    }
}