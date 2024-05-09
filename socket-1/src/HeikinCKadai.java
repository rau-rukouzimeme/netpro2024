import java.util.Arrays;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {
        Random random = new Random();  // Randomクラスのインスタンス生成
        Kamoku[] kamokus = new Kamoku[100];  // 100人分のKamokuインスタンスの配列

        // 100人の学生にランダムな点数を割り当てる
        for (int i = 0; i < kamokus.length; i++) {
            kamokus[i] = new Kamoku(random.nextInt(101));  // 0から100までのランダムな点数
        }

        // 平均点の計算
        int totalScore = 0;
        for (Kamoku k : kamokus) {
            totalScore += k.getScore();
        }
        int average = totalScore / kamokus.length;
        System.out.println("平均点は" + average);

        // 合格者の点数を配列にコピーしてソート
        int[] passingScores = Arrays.stream(kamokus)
                                    .mapToInt(Kamoku::getScore)
                                    .filter(score -> score >= 80)
                                    .toArray();
        Arrays.sort(passingScores);

        // 合格者一覧の出力
        System.out.println("以下合格者の点数です。");
        for (int score : passingScores) {
            System.out.println(score);
        }
    }
}
