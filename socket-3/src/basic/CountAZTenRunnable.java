package basic;
public class CountAZTenRunnable implements Runnable {
    private char myChar;

    public void setChar(char c) {
        this.myChar = c;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                synchronized(System.out) {
                    System.out.println(myChar + String.valueOf(i + 1));
                }
                Thread.sleep(1000); // 1000ミリ秒（1秒）間隔で出力
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[26];
        
        // 'a'から'z'までのアルファベットを使用するスレッドを作成
        for (char c = 'a'; c <= 'z'; c++) {
            CountAZTenRunnable ct = new CountAZTenRunnable();
            ct.setChar(c);
            Thread th = new Thread(ct, "th-" + c);
            threads[c - 'a'] = th;
        }

        // スレッドをアルファベット順に開始
        for (Thread th : threads) {
            th.start();
            try {
                // 各スレッドがスタートして最初の出力が終わるまで少し待つ
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }

        // メインスレッドもカウントを表示
        try {
            for (int i = 0; i < 10; i++) {
                synchronized(System.out) {
                    System.out.println("main:i=" + (i + 1));
                }
                Thread.sleep(1000); // 500ミリ秒間隔で出力
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
