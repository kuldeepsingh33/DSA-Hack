/*
explanation: bst iterator using cached inorder, the program works by first creating a values list from inorder traversal and then simply using the list and maintaining index that has been consumed!

testcase:
["BSTIterator","next","next","hasNext","next","hasNext","next","hasNext","next","hasNext"]
[[[7,3,15,null,null,9,20]],[],[],[],[],[],[],[],[],[]] -> Works

Time & Space Complexity: O(n) & O(n): First time building the inorder list cache takes linear time complexity, also since we are storing a list therefore the space complexity is also linear.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    List<Integer> values = new ArrayList<Integer>();
    int indx = 0;
    
    public void buildInorder(TreeNode root){
        if(root == null) return;
        
        buildInorder(root.left);
        values.add(root.val);
        buildInorder(root.right);
    }
    
    public BSTIterator(TreeNode root) {
        buildInorder(root);
    }
    
    public int next() {
        return values.get(indx++);
    }
    
    public boolean hasNext() {
        return indx != values.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */