// https://leetcode.com/problems/add-two-numbers/
// T: O(max(|l1|, |l2|))
// S: O(max(|l1|, |l2|))

const addTwoNumbers = (l1, l2) => {
  let p1 = l1;
  let p2 = l2;
  let carry = 0;
  let result_node = new ListNode(-1);
  let pointer = result_node;
  while (p1 || p2 || carry !== 0) {
    let sum = 0;
    if (p1 !== null && p2 !== null) {
      sum = p1.val + p2.val;
      p1 = p1.next;
      p2 = p2.next;
    } else if (p1 !== null) {
      sum = p1.val;
      p1 = p1.next;
    } else if (p2 !== null) {
      sum = p2.val;
      p2 = p2.next;
    }

    if (carry !== 0) {
      sum = sum + carry;
      carry = 0;
    }

    if (sum > 9) {
      carry = Math.floor(sum / 10);
      sum = sum % 10;
    }

    pointer.next = new ListNode(sum);
    pointer = pointer.next;
  }
  return result_node.next;
};
