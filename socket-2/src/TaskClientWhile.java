import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TaskClientWhile {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();

            while (true) {
                System.out.print("計算する最大の数を入力してください (終了するには1以下の値を入力) → ");
                int number = scanner.nextInt();

                if (number <= 1) {
                    System.out.println("i以下の数値が入力されたため、終了します");
                    break;
                }

                System.out.println("localhostの" + port + "番ポートに接続を要求します");
                try (Socket socket = new Socket("localhost", port);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

                    System.out.println("接続されました");

                    ITask task = new TaskObject();
                    task.setExecNumber(number);

                    oos.writeObject(task);
                    oos.flush();

                    task = (ITask) ois.readObject();

                    int result = task.getResult();
                    System.out.println("計算結果: " + result);
                } catch (Exception e) {
                    System.err.println("サーバとの通信中にエラーが発生しました");
                    e.printStackTrace();
                }
            }

            scanner.close();

        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            e.printStackTrace();
        }
    }
}
