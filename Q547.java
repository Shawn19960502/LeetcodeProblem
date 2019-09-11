/*
* @Author: Shawn Yang
* @Date:   2019-09-12 02:33:40
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-12 02:33:50
*/
class Solution {
    public int[] friends;
    public int numComponents;
    public int findCircleNum(int[][] M) {
        friends = new int[M.length];
        numComponents = friends.length;
        for(int i = 0; i < friends.length; i++) {
            friends[i] = i;
        }
        for(int i = 0; i < friends.length - 1; i++) {
            for(int j = i + 1; j < friends.length; j++) {
                if(M[i][j] == 1) {
                    unify(i, j);
                }
            }
        }
        return numComponents;
        
    }
    public void unify(int p, int q) {
        int root1 = find(p);
        int root2 = find(q);
        if(root1 == root2) return;
        else {
            friends[root1] = root2;
            numComponents -= 1;
            return;
        }
    }
    public int find(int p) {
        int original = p;
        int root = friends[p];
        while(root != p) {
            p = root;
            root = friends[p];
        }
        p = original;
        while(friends[p] != root) {
            int temp = friends[p];
            friends[p] = root;
            p = temp;
        }
        return root;
    }
    
}