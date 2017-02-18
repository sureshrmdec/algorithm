package SocialOA;
import java.util.*;
// Time complexity : O(N) i guess
class Movie {
    int id;
    int rate;
    List<Movie> neighbors;

    public Movie(int id, int rate, List<Movie> neighbors) {
        this.id = id;
        this.rate = rate;
        this.neighbors = neighbors;
    }
}

public class MovieNetwork {

    private static List<Movie> findHighestMovieRates(Movie movie, int k) {
        if (movie == null || k == 0)
            return null;
        List<Movie> res = new ArrayList<>();
        HashSet<Movie> visited = new HashSet<>();
        PriorityQueue<Movie> minHeap = new PriorityQueue<Movie>(k, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.rate - o2.rate;
            }
        });

        Queue<Movie> queue = new LinkedList<>();
        queue.offer(movie);
        visited.add(movie); //node: I missed, make sure the first node will not be added twice.
        while(!queue.isEmpty()) {
            Movie cur = queue.poll();

            if (minHeap.size() < k)
                minHeap.add(cur);
            else if (cur.rate > minHeap.peek().rate) {
                minHeap.poll();
                minHeap.add(cur);
            }

            for (Movie neighbor : cur.neighbors) {
                if (visited.add(neighbor)) //note: use set.add() to control each node is reached just once.
                    queue.add(neighbor);

            }
        }

        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        Movie[] testArray = new Movie[10];
        testArray[0] = new Movie(9, 6, new ArrayList<Movie>());
        testArray[1] = new Movie(1, 3, new ArrayList<Movie>());
        testArray[2] = new Movie(2, 8, new ArrayList<Movie>());
        testArray[3] = new Movie(3, 9, new ArrayList<Movie>());
        testArray[4] = new Movie(4, 7, new ArrayList<Movie>());
        testArray[5] = new Movie(5, 1, new ArrayList<Movie>());
        testArray[6] = new Movie(6, 2, new ArrayList<Movie>());
        testArray[7] = new Movie(7, 3, new ArrayList<Movie>());
        testArray[8] = new Movie(8, 5, new ArrayList<Movie>());
        testArray[9] = new Movie(9, 4, new ArrayList<Movie>());
        testArray[0].neighbors.add(testArray[4]);
        testArray[0].neighbors.add(testArray[2]);
        testArray[0].neighbors.add(testArray[3]);
        testArray[0].neighbors.add(testArray[1]);
        testArray[1].neighbors.add(testArray[4]);
        testArray[1].neighbors.add(testArray[2]);
        testArray[1].neighbors.add(testArray[9]);
        testArray[2].neighbors.add(testArray[3]);
        testArray[2].neighbors.add(testArray[6]);
        testArray[3].neighbors.add(testArray[7]);
        testArray[3].neighbors.add(testArray[8]);
        testArray[3].neighbors.add(testArray[1]);
        testArray[4].neighbors.add(testArray[3]);
        testArray[4].neighbors.add(testArray[5]);
        testArray[4].neighbors.add(testArray[7]);
        testArray[4].neighbors.add(testArray[8]);
        testArray[5].neighbors.add(testArray[2]);
        testArray[5].neighbors.add(testArray[6]);
        testArray[6].neighbors.add(testArray[9]);
        testArray[6].neighbors.add(testArray[0]);
        testArray[7].neighbors.add(testArray[0]);
        testArray[7].neighbors.add(testArray[1]);
        testArray[7].neighbors.add(testArray[2]);
        testArray[8].neighbors.add(testArray[4]);
        testArray[8].neighbors.add(testArray[3]);
        testArray[8].neighbors.add(testArray[7]);
        testArray[9].neighbors.add(testArray[0]);
        testArray[9].neighbors.add(testArray[2]);
        testArray[9].neighbors.add(testArray[6]);

        List<Movie> res = findHighestMovieRates(testArray[3], 3);

        for (Movie item : res) {
            System.out.print(" Movie id : " + item.id + " rate: " + item.rate + "\n");
        }
    }
}
