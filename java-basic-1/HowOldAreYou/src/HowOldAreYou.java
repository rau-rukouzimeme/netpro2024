

// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

	public static void main(String[] args) { 

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			try {
				System.out.println("現在の年齢を入力してください(qまたはeで終了):");
				String input = reader.readLine();

				if(input.equals("q") || input.equals("e")) {
					System.out.println("終了します。");
					break;
				}

				int age = Integer.parseInt(input);

				if(age < 0 || age >= 120) {
					System.out.println("年齢が正しくありません。再入力してください。");
					continue;
				}

				int birthYear = 2024 - age;
				String era = getEra(birthYear);

				System.out.println("2030年のあなたの年齢は" + (age + 6) + "歳です。");
				System.out.println("あなたが誕生した年は" + era + (birthYear - getEraStartYear(era)) + "年です。");
			}
			catch(IOException e) {
				System.out.println("入力エラーが発生しました。再入力してください。");
			}
			catch(NumberFormatException e) {
				System.out.println("数値を入力してください。");
			}
		}
	}

	// 西暦から元号を返すメソッド
	private static String getEra(int year) {
		if(year >= 2019) {
			return "令和";
		} else if(year >= 1989) {
			return "平成";
		} else if(year >= 1926) {
			return "昭和";
		} else if(year >= 1912) {
			return "大正";
		} else {
			return "明治";
		}
	}

	// 元号の開始年を返すメソッド
	private static int getEraStartYear(String era) {
		switch(era) {
			case "令和":
				return 2019;
			case "平成":
				return 1989;
			case "昭和":
				return 1926;
			case "大正":
				return 1912;
			case "明治":
				return 1868;
			default:
				return 0;
		}
	}
}

