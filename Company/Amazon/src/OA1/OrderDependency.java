//Amazon OA
//Topological Sorting
//Time Complexity : BFS/DFS: O(V + E)  BRUTE: O(V^2 + E)
//reference : https://segmentfault.com/a/1190000007064872
//https://vikyding.gitbooks.io/amazon/content/order_dependency.html
//http://www.jiuzhang.com/solutions/topological-sorting/

package OA1;

import java.util.*;

class Order {
    String orderName;
    public Order(String string){
        this.orderName = string;
    }
}
class OrderPair {
    Order pre;
    Order pos;
    public OrderPair(Order pre, Order pos){
        this.pre = pre;
        this.pos = pos;
    }
}

public class OrderDependency {
    public static ArrayList<Order> findOrderDependency(ArrayList<OrderPair> orderPairs){
        if (orderPairs == null)
            return null;

        ArrayList<Order> result = new ArrayList<>();
        HashMap<Order, Integer> inDegreeMap = new HashMap<>();
        HashMap<Order, ArrayList<Order>> NeighborListMap = new HashMap<>();

        for (OrderPair orderPair : orderPairs) {
            Order pre = orderPair.pre;
            Order pos = orderPair.pos;

            if (inDegreeMap.containsKey(pos)) {
                inDegreeMap.put(pos, inDegreeMap.get(pos) + 1);
            } else {
                inDegreeMap.put(pos, 1);
            }

            if (NeighborListMap.containsKey(pre)) {
                NeighborListMap.get(pre).add(pos);
            } else {
                ArrayList<Order> neighborList = new ArrayList<>();
                neighborList.add(pos);
                NeighborListMap.put(pre, neighborList);
            }
        } //O(E)

        Queue<Order> q = new LinkedList<>();

        //put the node with 0 inDegree into the inDegreeMap
        for(Order key : inDegreeMap.keySet()) {
            if (!inDegreeMap.containsKey(key)) {
                q.offer(key);
            }
        }

        //dequeue the node with 0 inDegree, and reduce 1 degree from its neighbors, put its neighbor with 0 degree into queue
        while(!q.isEmpty()) {
            Order cur = q.poll();
            result.add(cur);
            if (NeighborListMap.containsKey(cur)) {
                ArrayList<Order> neighbors = NeighborListMap.get(cur);
                for (Order neighbor : neighbors) {
                    inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) - 1);
                    if (inDegreeMap.get(neighbor) == 0) {
                        q.offer(neighbor);
                    }
                }
            }
        } //O(V) using queue to keep recording the zero degree nodes, otherwise we need another inner loop to search for 0 degree nodes, it would O(V * V)
        //O(E + V)
        return result;
    }

    public static void main(String[] args) {
        Order o1 = new Order("泡面");
        Order o2 = new Order("开车");
        Order o3 = new Order("LV");
        Order o4 = new Order("租车");
        Order o5 = new Order("LA");
        Order o6 = new Order("划船");
        Order o7 = new Order("唱歌");
        Order o8 = new Order("SF");
        Order o9 = new Order("爽(每个行为只输出了一次对吧)");
        OrderPair od1 = new OrderPair(o1, o3);
        OrderPair od2 = new OrderPair(o2, o7);
        OrderPair od3 = new OrderPair(o3, o9);
        OrderPair od4 = new OrderPair(o4, o3);
        OrderPair od5 = new OrderPair(o6, o9);
        OrderPair od6 = new OrderPair(o8, o9);
        OrderPair od7 = new OrderPair(o2, o5);
        //OrderPair od8 = new OrderPair(o3, o9);  we assume it doesn't exists same pair.

        ArrayList<OrderPair> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);
        list.add(od4);
        list.add(od5);
        list.add(od6);
        list.add(od7);

        ArrayList<Order> res = findOrderDependency(list);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i).orderName);
            if (i+1 < res.size()){
                System.out.print(" -> ");
            }
        }
    }
}

