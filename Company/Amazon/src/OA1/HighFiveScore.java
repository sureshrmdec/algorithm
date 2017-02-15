//AMAZON OA VIP
//https://moonlightsd.gitbooks.io/road-to-amz/content/highfivescore.html
//https://vikyding.gitbooks.io/amazon/content/five_score.html
package OA1;
import java.util.*;
/**
 * What we want is to compute the average of the five highest score of each student.
 *
**/
class Result {
    int id;
    int value;

    public Result(int id, int value) {
        this.id = id;
        this.value = value;
    }
}

public class HighFiveScore {

    public static Map<Integer, Double> getFiveHigh(Result[] src) {
        if (src.length == 0 || src == null)
            return null;

        HashMap<Integer, Double> res = new HashMap<>();
        HashMap<Integer, PriorityQueue<Integer>> scores = new HashMap<>();

        for (int i = 0; i < src.length; i++) {
            if (scores.containsKey(src[i].id)) {
                scores.get(src[i].id).add(src[i].value);
            } else {
                PriorityQueue<Integer> studentScore = new PriorityQueue<>(5, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

                studentScore.add(src[i].value);
                scores.put(src[i].id, studentScore);
            }
        }


        for (int key: scores.keySet()) {
            PriorityQueue<Integer> studentScoreSum = scores.get(key);
            int sum = 0;
            double average;
            for (int i = 0; i < 5; i++) {
                sum += studentScoreSum.poll();
            }
            average = sum / 5.0;  //have to use 5.0, otherwise it would return integer.
            res.put(key, average);
        }

        return res;
    }


    public static void main(String[] args) {
        Result r1 = new Result(1, 100);
        Result r2 = new Result(1, 90);
        Result r3 = new Result(1, 40);
        Result r4 = new Result(1, 10);
        Result r5 = new Result(1, 30);
        Result r6 = new Result(1, 60);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);

        Result[] src = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};

        Map<Integer, Double> ans = getFiveHigh(src);

        for (int key: ans.keySet()) {
            System.out.println("id: " + key + ", value: " + ans.get(key));
        }
    }

}
