import java.util.Random;

public class NetproLabMember {
    public static final int years = 15;
    public static final int columns = 3;

    public static void main(String[] args) {
        int[][] members = new int[years][columns];
        Random random = new Random();
        double totalRatio = 1;
        int femaleRatio = 20; // 初期の女子学生の割合(%)
        int iwaiRatio = 10; // 初期の岩井研の配属人数

        for (int i = 0; i < years; i++) {
            // 学生の総数
            members[i][0] = 110 + (random.nextInt(21) - 10); // 110±10人のランダム性
            // 女性の割合(%)
            members[i][1] = femaleRatio;
            // 岩井研の人数
            members[i][2] = iwaiRatio + (random.nextInt(7) - 3); // 10±3人のランダム性

            // 男性数を求める
            int men = members[i][0] - (int) (members[i][0] * ((float) members[i][1] / 100));
            // 総数から岩井研の人数を取り出す組み合わせ
            long cpsRatio = combination(members[i][0], members[i][2]);
            // 男性の中から岩井研のメンバーを取り出す組み合わせ
            long menRatio = combination(men, members[i][2]);
            // 岩井研の人数に男性しか入らない割合
            totalRatio *= (double) menRatio / cpsRatio;

            // 次年度の女子学生の割合を更新
            femaleRatio++;
            // 次年度の岩井研の配属人数を更新
            iwaiRatio = members[i][2];
        }
        System.out.println("15年間岩井研に女性の学生が来ない確率: " + totalRatio);
    }

    // Combination
    public static final long combination(final int n, int r) {
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}
