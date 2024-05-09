import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyExceptionHoliday {

	public static void main(String[] args) {

		MyExceptionHoliday myE=new MyExceptionHoliday();

	}

	MyExceptionHoliday(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader というのは、データ読み込みのクラス(型)
		// クラスの変数を作るには、new を使う。

		// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
		//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
			System.out.println("何日ですか?");
			String line = reader.readLine();
			int theday = Integer.parseInt(line);
			System.out.println("日付" + theday + "日ですね。");

			test(theday);

		}
		catch(IOException e) {
			System.out.println(e);
		} catch (NoHolidayException e) {
			e.printStackTrace();
		}
	}

	void test(int theday) throws NoHolidayException{
		if(theday==6){
			throw new NoHolidayException();
		}
	}

}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MyExceptionHoliday {

    public static void main(String[] args) {
        new MyExceptionHoliday().run();
    }

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> holidays = new HashSet<>();
        // 例として5月の土日および固定の祝日を設定します。
        // 実際の休日は毎年変わることがあるため、年度によって更新が必要です。
        for (int i = 1; i <= 31; i++) {
            if (i % 7 == 0 || i % 7 == 1) { // 例として毎週土曜(7の倍数)と日曜(7の倍数+1)を休日とする
                holidays.add(i);
            }
        }
        holidays.add(3);  // 5月3日憲法記念日
        holidays.add(4);  // 5月4日みどりの日
        holidays.add(5);  // 5月5日こどもの日

        while (true) {
            try {
                System.out.println("5月の何日ですか？（終了するには「exit」と入力）");
                String line = reader.readLine();
                if ("exit".equalsIgnoreCase(line)) {
                    System.out.println("プログラムを終了します。");
                    break;
                }
                int theday = Integer.parseInt(line);
                if (theday < 1 || theday > 31) {
                    System.out.println("1から31の間で入力してください。");
                    continue;
                }
                System.out.println("日付" + theday + "日ですね。");
                test(theday, holidays);

            } catch (IOException e) {
                System.out.println("入力エラーが発生しました: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("数値を入力してください。");
            } catch (NoHolidayException e) {
                e.printStackTrace();
            }
        }
    }

    void test(int theday, Set<Integer> holidays) throws NoHolidayException {
        if (!holidays.contains(theday)) {
            throw new NoHolidayException("5月" + theday + "日は休日ではありません。");
        }
    }
}

class NoHolidayException extends Exception {
    public NoHolidayException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("エラーメッセージ: " + getMessage());
    }
}
*/