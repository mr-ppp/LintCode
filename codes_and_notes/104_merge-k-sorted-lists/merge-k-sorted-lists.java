/*
@Copyright:LintCode
@Author:   mr_p
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 17-01-20 23:47
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> listNodeComparator = 
            new Comparator<ListNode>(){
                public int compare(ListNode left, ListNode right){
                    if(left == null)
                        return 1;
                    if(right == null)
                        return -1;
                    return (left.val - right.val);
                }
            };
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists == null || lists.size() == 0)
            return null;
            Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), listNodeComparator);
        for(int i = 0; i < lists.size(); i++)
        {
            if(lists.get(i) != null)
            {
                heap.add(lists.get(i));
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(!heap.isEmpty())
        {
            ListNode head  = heap.poll();
            tail.next = head;
            tail = head;
            if(head.next != null){
                heap.add(head.next);
            }
        }
        return dummy.next;
        
    }
}
