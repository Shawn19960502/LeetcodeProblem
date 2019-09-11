/*
* @Author: Shawn Yang
* @Date:   2019-09-12 00:58:29
* @Last Modified by:   Shawn Yang
* @Last Modified time: 2019-09-12 00:58:36
*/
class Solution {
    // Union Find.
    public int[] id;
    public int numComponents;
    public int regionsBySlashes(String[] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int length = grid.length;
        id = new int[length * length * 4];
        numComponents = length * length * 4;
        for(int i = 0; i < id.length; i++) {
            id[i] = i; // First the root is it self
        }
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(i > 0) {
                    unify((i * length + j) * 4, ((i - 1) * length+ j) * 4 + 2);
                }
                if(j > 0) {
                    unify((i * length+ j) * 4 + 3, (i * length+ j) * 4 - 3);
                }
                if(grid[i].charAt(j) == '/') {
                    unify((i * length + j) * 4, (i * length+ j) * 4 + 3);
                    unify((i * length + j) * 4 + 1, (i * length+ j) * 4 + 2);
                }
                else if(grid[i].charAt(j) == '\\') {
                    unify((i * length + j) * 4, (i * length + j) * 4 + 1);
                    unify((i * length+ j) * 4 + 3, (i * length+ j) * 4 + 2);
                } else {
                    unify((i * length + j) * 4, (i * length + j) * 4 + 1);
                    unify((i * length+ j) * 4 + 3, (i * length+ j) * 4 + 2);
                    unify((i * length + j) * 4 + 1, (i * length+ j) * 4 + 2);
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
            id[root1] = root2;
            numComponents -= 1;
            return;
        }
    }
    public int find(int p) {
        int original = p;
        int root = id[p];
        while(root != p) {
            p = root;
            root = id[p];
        }
        p = original;
        int temp;
        // path compression.
        while(p != root) {
            temp = id[p];
            id[p] = root;
            p = temp;
        }
        return root;
    }
}