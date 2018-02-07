import java.util.*;
class MaximumPath{
	public static void main(String args[]){
		TreeNode root = createTree(root, a, e);
	}
	public class TreeNode{
		int label;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			label = x;
		}
	}
	//List<Integer, Integer> result = new ArrayList<Integer>();
	int result = 0;
    public int maxPath(TreeNode root) {
        if(root == null){
        	return result;
        } 
        traverse(root);
        return result;
    }
    public void traverse(TreeNode root) {
        if(root == null){
        	return;
        }  
        int temp = count(root.left, root.label) + count(root.right,root.label);
        result = Math.max(result, temp);
        traverse(root.left);
        traverse(root.right);
    }
    public int count(TreeNode root,int label) {
        if(root == null || root.label != label){
        	return 0;	
        } 
        int left = count(root.left, label) + 1;
        int right = count(root.right, label) + 1;
        
        return Math.max(left, right);                                                  
    }
    int j = 0, k = 0;
    public static TreeNode createTree(TreeNode x, int[] a, int[] e){
    	x.val = a[j];
    	if()
    }

    public void add(Node parent, Node child, String orientation)
    {
        if (orientation.equals("left"))
        {
           parent.setLeft(child);
        }
        else
        {
            parent.setRight(child);
        }
    }

    

}