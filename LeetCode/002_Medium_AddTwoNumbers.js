/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
function ListNode(val) {
    this.val = val;
    this.next = null;
}

var addTwoNumbers = function(l1, l2) {
    if (l1 === null || l2 === null)
        return;
    let resultListHead = new ListNode();
    //let resultListPointer = Object.assign({}, resultListHead);
    let resultListPointer = resultListHead;
    let p1 = l1,
        p2 = l2;

    let plus = false;
    while (1) {
        let sum;
        // general cases
        if (p1 !== null && p2 !== null) {
            sum = p1.val + p2.val;
            if (plus)
                sum++;

            if (sum >= 10) {
                sum -= 10; //assume that each digit is less than 10
                plus = true;
            }
            else {
                plus = false;
            }

            resultListPointer.val = sum;

            //prepare for next loop
            if (p1.next === null && p2.next === null && !plus)
                break;
            if (p1.next)
                p1 = p1.next;
            else
                p1 = null;
            if (p2.next)
                p2 = p2.next;
            else
                p2 = null;

            let resultListNode = new ListNode(0);
            resultListPointer.next = resultListNode;
            resultListPointer = resultListPointer.next;


        }
        // for the case: input list has just one element, eg: [5], [5] => [0, 1], [4]
        else if (p1 === null && p2 === null) {
            if (plus)
                resultListPointer.val = 1;
            break;
        }
        // for the case: just one list has digit, eg: [1, 8], [0] => [1, 8] even [2,7],[8] =>[0, 8]even[2,7,6],[8] =>[0, 8, 6]
        //[2, 9],[8] => [0, 0, 1]
        else if (p1 !== null || p2 !== null) {
            if (p1)
                resultListPointer.val = p1.val;
            else if (p2)
                resultListPointer.val = p2.val;
            if (plus)
                resultListPointer.val++;
            //reset plus
            if (resultListPointer.val == 10) {
                resultListPointer.val = 0;
                plus = true;
            }
            else
                plus = false;
            //prepare for next pointers
            if (p1) {
                //[2,7,6],[8] =>[0, 8, 6] when p1 is 7
                if (p1.next)
                    p1 = p1.next;
                //[2, 9],[8] => [0, 0, 1] when p1 is 9
                else if (p1.next === null && plus)
                    p1 = null;
                else
                    break;
            }
            else if (p2) {
                if (p2.next)
                    p2 = p2.next;
                else if (p2.next === null && plus)
                    p2 = null;
                else
                    break;
            }
            let resultListNode = new ListNode(0);
            resultListPointer.next = resultListNode;
            resultListPointer = resultListPointer.next;

        }
        else
            throw new Error("should not be here!");
    }
    return resultListHead;
};
