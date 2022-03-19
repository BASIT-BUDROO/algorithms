package TownJudge;

public class TownJudgeSolution {
    public int findJudge(int n, int[][] trust) {
        int[] hash_table = new int[n + 1];
        for (int[] pair : trust) {
            hash_table[pair[1]]++;
        }
        int max = -1;
        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (hash_table[i] > max) {
                max = hash_table[i];
                judge = i;
            }

        }
        if (max == n - 1) {
            return judge;
        }
        return -1;

    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] trust = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int n = 2;
        int[][] trust = {{1, 2}};
        TownJudgeSolution sol = new TownJudgeSolution();
        int op = sol.findJudge(n, trust);
        System.out.println(op);
    }
}