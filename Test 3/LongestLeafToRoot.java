import java.util.ArrayList;

public class LongestLeafToRoot {

    static BinaryTreeNode<Integer> deepest_leaf;
    static int depth = 0;
    static ArrayList<Integer> result = new ArrayList<>();

    public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		findDeepestLeaf(root, 0);
        fillArrayList(root);

        return result;
	}
    private static void findDeepestLeaf(BinaryTreeNode<Integer> root, int k){
        if(root == null) return;
        if(root.left == null && root.right == null && k >= depth){
            deepest_leaf = root;
            depth = k;
        }
        findDeepestLeaf(root.left, k+1);
        findDeepestLeaf(root.right, k+1);
    }
    private static boolean fillArrayList(BinaryTreeNode<Integer> root){
        if(root == null) return false;
        if(root == deepest_leaf){
            result.add(root.data);
            return true;
        }
        
        boolean leftOutput = fillArrayList(root.left);
        boolean rightOutput = fillArrayList(root.right);

        if(leftOutput || rightOutput){
            result.add(root.data);
            return true;
        }
        
        return false;
    }
}
 