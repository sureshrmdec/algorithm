//Amazon OA2 VIP
//https://vikyding.gitbooks.io/amazon/content/mst.html
//Using the Krustal to find the minimum spanning tree, and using Union/Find to detect cycle in an undirected graph
package OA1;

import java.util.*;

class Connection{
    String node1;
    String node2;
    int cost;
    public Connection(String a, String b, int c){
        node1 = a;
        node2 = b;
        cost = c;
    }
}
public class MST {




    public static ArrayList<Connection> getLowCost(ArrayList<Connection> connections) {
        if (connections == null || connections.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Connection> res = new ArrayList<>();

        Set<String> set = new HashSet<>();
        Map<String, String> map = new HashMap<>();

        for (Connection c : connections) {
            String node1 = c.node1;
            String node2 = c.node2;
            //at first each node points at itself
            set.add(node1);
            map.put(node1, node1);
            set.add(node2);
            map.put(node2, node2);

        }

        Collections.sort(connections, new Comparator<Connection>(){
            @Override
            public int compare(Connection o1, Connection o2) {
                return o1.cost - o2.cost;
            }
        });

        for (Connection c : connections) {
            String node1 = c.node1;
            String node2 = c.node2;
            if (union(map, node1, node2)) {
                res.add(c);
            }
        }

        if ((set.size() - 1) != res.size()) {  //N vertices using N - 1 edges to connect them
            return null;
        }

        Collections.sort(res, new Comparator<Connection>() {
            public int compare(Connection o1, Connection o2) {
                if (o1.node1.equals(o2.node1)) {
                    return o1.node2.compareTo(o2.node2);
                } else {
                    return o1.node1.compareTo(o2.node1);
                }
            }
        });

        return res;

    }

    private static boolean union(Map<String, String> map, String a, String b) {
        String endChild_a = findEndChild(map, a);
        String endChild_b = findEndChild(map, b);

        if (endChild_a.equals(endChild_b)) {
            return false;
        } else {
            map.put(endChild_a, endChild_b);
            return true;
        }
    }

    private static String findEndChild(Map<String, String> map, String a) {
        if (map.get(a).equals(a)) {
            return a;
        }
        String endChild = findEndChild(map, map.get(a));
        return endChild;
    }



    private static void printConnection(Connection temp) {
        System.out.print(temp.node1 + " -> " + temp.node2  + "    " );

    }
    public static void main(String[] args) {
        Connection[] cities = new Connection[10];
        cities[0] = new Connection("A", "B", 6);
        cities[1] = new Connection("A", "D", 1);
        cities[2] = new Connection("A", "E", 5);
        cities[3] = new Connection("B", "C", 3);
        cities[4] = new Connection("B", "D", 5);
        cities[5] = new Connection("C", "D", 6);
        cities[6] = new Connection("C", "F", 6);
        cities[7] = new Connection("D", "F", 4);
        cities[8] = new Connection("D", "E", 5);
        cities[9] = new Connection("E", "F", 2);
        ArrayList<Connection> list = new ArrayList<>();
        for (Connection temp : cities) {
            list.add(temp);
        }

        for (Connection temp : getLowCost(list)) {
            printConnection(temp);
        }


    }
}
