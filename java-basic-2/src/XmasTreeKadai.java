import java.util.Scanner;

public class XmasTreeKadai {
    public static void main(String[] args) {
        int i = 0;
        Scanner scan = new Scanner(System.in);

        while (i < 10) {
            System.out.println("----次の数字の入力をお願いします ");
            String str = scan.next();
            System.out.println("最初のトークンは: " + str);
            System.out.println("文字を分割すると・・・");
            String[] word = str.split(",");
            for (String w : word) {
                System.out.println(w);
            }
            System.out.println("word[0]: " + word[0]);
            System.out.println("word[1]: " + word[1]);
            System.out.println("word[2]: " + word[2]);
            System.out.println("word[3]: " + word[3]);

            // 入力された値を整数に変換して drawXmasTree メソッドに渡す
            int width = Integer.parseInt(word[0]);
            int trunkWidth = Integer.parseInt(word[1]);
            int trunkLength = Integer.parseInt(word[2]);
            String snow = word[3];
            drawXmasTree(width, trunkWidth, trunkLength,snow);

            i++;
        }

        scan.close();
    }

    public static void drawXmasTree(int width, int trunkWidth, int trunkLength, String snow) {
        // 木の葉部分を描画
        for (int i = 0; i < width; i++) {
            if(i%2 ==0){
            for (int j = 0; j < width - i- 1; j+=2) {
                System.out.print((snow));
                System.out.print(" ");
            }
            System.out.print((snow));
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            for (int j = 0; j < width - i - 1; j+=2) {
                System.out.print((snow));
                System.out.print(" ");
            }
            
            System.out.println();
        }else{
            for (int j = 0; j < width - i-1; j+=2) {
                System.out.print(" ");
                System.out.print((snow));
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                System.out.print("*");
            }
            for (int j = 0; j < width - i - 1; j+=2) {
                System.out.print((snow));
                System.out.print(" ");
            }
            
            System.out.println();
        }
        
    }
        // 木の幹部分を描画
        for (int i = 0; i < trunkLength; i++) {
            for (int j = 0; j < width - trunkWidth / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < trunkWidth; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
