class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        list = new ArrayList<>();
        sum(root, targetSum, new ArrayList<>());
        return list;
    }
    void sum(TreeNode root, int sum, List<Integer> curr){
        if(root == null) return;
        if(isLeaf(root)){
            if(sum==root.val){
                curr.add(root.val);
                list.add(new ArrayList<>(curr));
                curr.remove(curr.size()-1);
            }
            return;
        }
        curr.add(root.val);
        sum(root.left, sum-root.val, curr);
        sum(root.right, sum-root.val, curr);
        curr.remove(curr.size()-1);
    }
    static boolean isLeaf(TreeNode root){
        return root.left== root.right;
    }
}
