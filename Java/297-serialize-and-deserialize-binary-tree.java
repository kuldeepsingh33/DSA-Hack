/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74417/Short-and-clear-recursive-Java-solution
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "#";

        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        
        return deser(new Scanner(data));
    }
    
    public TreeNode deser(Scanner sc){
        String itm = sc.next();
        if(itm.equals("#")) return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(itm));
        root.left = deser(sc);
        root.right = deser(sc);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));