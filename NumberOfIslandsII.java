import java.util.*;

public class NumberOfIslandsII {

    static class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            count = 0;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void add(int x) {
            parent[x] = x;
            count++;
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);

            if (px != py) {
                parent[px] = py;
                count--;
            }
        }
    }

    static List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] pos : positions) {

            int r = pos[0], c = pos[1];
            int index = r * n + c;

            if (uf.parent[index] != -1) {
                result.add(uf.count);
                continue;
            }

            uf.add(index);

            for (int[] d : dirs) {

                int nr = r + d[0], nc = c + d[1];
                int ni = nr * n + nc;

                if (nr >= 0 && nc >= 0 && nr < m && nc < n
                        && uf.parent[ni] != -1) {

                    uf.union(index, ni);
                }
            }

            result.add(uf.count);
        }

        return result;
    }
            }
