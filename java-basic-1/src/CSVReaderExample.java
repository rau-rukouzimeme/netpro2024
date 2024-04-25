import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class CSVReaderExample {

        public static void main(String[] args) {
            String csvData = "社員番号,名前,都道府県,区,住所\n" +
                    "001,田中太郎,東京都,渋谷区,神南1-1-1 ロイヤルマンション101号室\n" +
                    "002,山田花子,東京都,目黒区,上目黒2-2-2 ガーデンハイツ301号室\n" +
                    "003,鈴木健太,東京都,新宿区,西新宿3-3-3 パークタワー202号室\n" +
                    "004,佐藤美香,東京都,港区,六本木4-4-4 パレスマンション401号室\n" +
                    "005,渡辺悟,東京都,千代田区,永田町5-5-5 キャピタルハイツ601号室\n" +
                    "006,小林真理子,東京都,中央区,銀座6-6-6 ゴールドビル501号室\n" +
                    "007,伊藤隆,東京都,渋谷区,代々木7-7-7 シャインアパートメント301号室\n" +
                    "008,高橋直人,東京都,渋谷区,恵比寿8-8-8 パークサイドマンション102号室\n" +
                    "009,中村さゆり,東京都,港区,青山9-9-9 ハイライフタワー201号室\n" +
                    "010,林太一,東京都,渋谷区,代々木10-10-10 グリーンハイツ401号室";
    
            try (BufferedReader br = new BufferedReader(new StringReader(csvData))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String district = fields[3]; // 区の情報を取得
                    System.out.println(district);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
