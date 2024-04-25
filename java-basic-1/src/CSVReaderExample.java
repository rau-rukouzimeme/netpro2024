import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderExample {
public static void main(String[] args) {
String csvFile = "C:/Users/a.asuki/OneDrive - 東京電機大学/デスクトップ/visual studio/netpro2024/java-basic-1/number-name-prefecture.csv"; // ファイルのパスを指定してください

String line = "";
String csvSplitBy = ","; // CSVファイルの区切り文字を指定してください

  try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        while ((line = br.readLine()) != null) {
            // 1行をカンマで分割して単語の配列を取得
            String[] words = line.split(csvSplitBy);

            // 単語を一つずつ出力
                // 区の部分を出力
                if (words.length >= 4) {
                    System.out.println(words[3]);
                }
        }//while end
    } catch (IOException e) {
        e.printStackTrace();
    }
  }//main end
}//class end
