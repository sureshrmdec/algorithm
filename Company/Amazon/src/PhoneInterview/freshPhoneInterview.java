
// Environment: You have a ring of nodes that you can traverse clockwise or counter clockwise. There is a distance between each node.
// Given an origin node and a destination node, determine the shortest distance from start to destination 
// and whether this requires traversing clockwise or counter clockwise.

// Given the time constraints, focus on the logical correctness of the algorithm, clarity of the code, and integrity of the code

// What is the Big(O) order of your algorithim?

public class RingNode 
{
	public RingEdge	m_clockwiseEdge;
	public RingEdge	m_counterClockwiseEdge;
};

public class RingEdge
{
	public RingNode	m_next;
	public double	m_distance;
}

public class RingResult
{
	public double		m_totalDistance;
	public int		m_direction; // 0 indicates clockwise, 1 indicates counterclockwise
}

public class Ring
{
	public RingResult findShortestPath(RingNode origin, RingNode destination)
    {
	// implement this method
	    //pass one - clockwise
	    double distance_clockwiseEdge;
	    RingNode cur;
	    cur = origin;
	    while (cur != destination) {
	        distance_clockwiseEdge += cur.m_clockwiseEdge.m_distance;
	        cur = origin.m_clockwiseEdge.m_next;
	    }
	    
	    //pass two - counterclockwise
	    double distance_counterclockwiseEdge;
	    cur = origin;
	    while (cur != destination) {
	        distance_counterclockwiseEdge += cur.m_counterClockwiseEdge.m_distance;
	        cur = origin.m_counterClockwiseEdge.m_next;
	    }
	    
	    //compare
	    int m_totalDistance = distance_clockwiseEdge < distance_counterclockwiseEdge ? distance_clockwiseEdge : distance_counterclockwiseEdge;
	    int m_direction =  1 : 0 ? distance_clockwiseEdge > distance_counterclockwiseEdge;
	    
	    RingResult res = new RingResult(m_totalDistance, m_direction);
	    return res;

    }
}

O(n)  
O(nlogn)
O(n^2)
O(1)

Assuming that the ring structure and distance between nodes rarely changes, can you do better?
