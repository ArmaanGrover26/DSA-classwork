public class onesixty {

    // Definition of Linked List Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode a = headA;
            ListNode b = headB;

            while (a != b) {

                if (a == null) {
                    a = headB;
                } else {
                    a = a.next;
                }

                if (b == null) {
                    b = headA;
                } else {
                    b = b.next;
                }
            }

            return a;
        }
    }

    public static void main(String[] args) {

        /*
                4 -> 1
                      \
                       8 -> 4 -> 5
                      /
                5 -> 6
        */

        // Common part
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);

        // List A
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;

        // List B
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;

        Solution sol = new Solution();

        ListNode intersection = sol.getIntersectionNode(headA, headB);

        if (intersection != null) {
            System.out.println("Intersection at node: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}