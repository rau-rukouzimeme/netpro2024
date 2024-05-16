import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class KadaiTCPClient {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("ゴーストを送りこみます");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("送霊者の名前を入力してください ↓");
            String from = scanner.next();
            System.out.println("受霊者の名前を入力してください ↓");
            String to = scanner.next();
            System.out.println("ゴーストの種類を入力してください(例:Scary Ghost) ↓");
            String ghostType = scanner.next();
            scanner.close();

            MyGhost ghost = new MyGhost(from, to, ghostType);

            oos.writeObject(ghost);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            MyGhost responseGhost = (MyGhost) ois.readObject();

            responseGhost.printGhoastInfo();

            ois.close();
            oos.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
