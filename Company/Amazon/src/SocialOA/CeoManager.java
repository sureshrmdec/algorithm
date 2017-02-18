package SocialOA;

import java.lang.reflect.Array;
import java.util.ArrayList;


class Employee {
    int id;
    ArrayList<Employee> children;
    Employee(int id, ArrayList<Employee> children) {
        this.id = id;
        this.children = children;
    }
}

public class CeoManager {
    /*
    //version 1 : assume e1 and e2 exists in the tree, and e1 could not be the parent of e2, vise verse.
    Employee findLeastCommon(Employee ceo, Employee e1, Employee e2) {
        if (ceo == null || ceo == e1 || ceo == e2)
            return root;

        Employee potentialChild = null;
        int count = 0;

        for (Employee child : ceo.children) {
            Employee res = findLeastCommon(child, e1, e2);
            if (res != null) {
                potentialChild = res;
                count++;
            }
        }

        if (count == 2)
            return ceo;
        else if (count == 1)
            return potentialChild;
        else
            return null;
    }
    */

    //version 2 : assume e1 and e2 may not exist in the tree, and e1 could be the parent of e2, vise verse.
    Employee findLeastCommon(Employee ceo, Employee e1, Employee e2) {
        if (ceo == null || ceo == e1 || ceo == e2)
            return ceo;
        Boolean found[] = new Boolean[1];
        // we set a public variable found for the case that e1 or e2 may not exist in the tree.
        found[0] = false;

        Employee res = helper(ceo, e1, e2, found);
        if(found[0])
            return res;
        else
            return null;


    }

    private Employee helper(Employee ceo, Employee e1, Employee e2, Boolean[] found) {
        if (ceo == null)
            return null;

        Employee potentialChild = null;
        int count = 0;

        for (Employee child : ceo.children) {
            Employee res = findLeastCommon(child, e1, e2);
            if (res != null) {
                potentialChild = res;
                count++;
            }
        }

        //case 1 : found e1 and e2 in cur node's two children separately
        if (count == 2 && (ceo != e1 && ceo != e2)) {
            found[0] = true;
            return ceo;
        }
        //case 2 : found e1 or e2 in one of its children, and ceo == e1 or e2, thus one node is another node's parent
        else if (count == 1 && (ceo == e1 || ceo == e2)) {
            found[0] = true;
            return ceo;
        }
        //case 3: general case, found one in one of its children
        else if (count == 1) {
            return potentialChild;
        }
        //case 4: general case, found one node in cur node
        else if (ceo == e1 || ceo == e2)
            return ceo;
        else
            return null;

    }


}
