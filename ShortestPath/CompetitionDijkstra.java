/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CompetitionDijkstra {
    private int sA = 0, sB=0, sC=0;

    private EdgeWeightedDigraph cityGraph = null;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    CompetitionDijkstra (String filename, int sA, int sB, int sC){
        try {
            cityGraph = new EdgeWeightedDigraph(filename);
        } catch (Exception e) {
            System.out.println("Error when creating graph object: " + e);
        }

        this.sA = sA;
        this.sB = sB;
        this.sC = sC;
    }


    /**
     * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){

        if (cityGraph == null) return -1;

        if (sA < 50 || sB < 50 || sC <50
                ||sA > 100 || sB > 100 || sC >100) return -1;

        DijkstraSP[] all = new DijkstraSP[cityGraph.V()];
        ArrayList<Double> allShortestPathsValues = new ArrayList<Double>();
        double longestSP=Double.POSITIVE_INFINITY;
        for (int s = 0; s < cityGraph.V(); s++) {
            DijkstraSP vsp = new DijkstraSP(cityGraph, s);

            for (int v = 0; v < cityGraph.V(); v++) {
                if(!vsp.hasPathTo(v)){
                    return -1;
                }
                allShortestPathsValues.add(vsp.distTo(v));
            }
        }
        if(!allShortestPathsValues.isEmpty()){ longestSP = Collections.max(allShortestPathsValues);}
        else return -1;

        System.out.println("longestSP: " + longestSP);

        int[] speeds = {sA,sB,sC};
        int slowest = Arrays.stream(speeds).min().getAsInt();
        System.out.println("Slowest: " + slowest);
        System.out.println("Minimun time: " + (int)Math.ceil(longestSP*1000/slowest));

        return (int)Math.ceil(longestSP*1000/slowest);
    }


}