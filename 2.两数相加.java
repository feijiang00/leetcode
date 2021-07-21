import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //这里我本来想着因为链表是尾插法的，就不需要头文件，只需要声明一个
        //res结点，后面直接res = res.next即可，按理这样就可以形成一个链表
        //但是我忘记了函数返回的链表你需要给一个指向该链表的首结点，而我这
        //个结点则是直接指向了尾部，肯定不行
        
        ListNode res = new ListNode();
        //后续声明头结点
        ListNode head = null;

        int nextSum = 0;//相加后是否进位
        int thisSum = 0;//相加后的留位数字

        while(l1!=null || l2!=null){
            //这里开始忽略了一种情况，当一个链表空了，一个不空的时候，还
            //继续访问的时候，就会出现访问空链表的情况了，这时需要在其长度
            //不够的链表后补0

            int x = l1!=null ? l1.val : 0;//当l1不为空的时候取l1，否则取0
            int y = l2!=null ? l2.val : 0;

            int p = x + y + nextSum;

            thisSum = p %10;

            if(head ==null){
                res.val = thisSum;0
                head = res;

            }else{
                res.next = new ListNode(thisSum);
                res = res.next;
            }
            nextSum = p/10;
            //l1,l2链表向后移动

            if(l1!=null)
                l1 = l1.next;
            
            if(l2!=null)
                l2 = l2.next;
            
        }
        
        //最后进位，如果大于0，也就是1就进位保存
        if(nextSum>0)
                res.next = new ListNode(nextSum); 


        return head;


    }
}
// @lc code=end

