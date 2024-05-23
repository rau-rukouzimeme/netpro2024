import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TaskServerOnce {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートで待機します");

            try (ServerSocket server = new ServerSocket(port)) {
                while (true) {
                    try (Socket socket = server.accept();
                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())) {
                        
                        System.out.println("接続しました。相手の入力を待っています......");

                        ITask task = (ITask) ois.readObject();

                        task.exec();

                        oos.writeObject(task);
                        oos.flush();
                    } 
                }
            } catch (BindException be) {
                be.printStackTrace();
                System.out.println("ポート番号が不正、ポートが使用中です");
                System.err.println("別のポート番号を指定してください(6000など)");
            } catch (Exception e) {
                System.err.println("エラーが発生したのでプログラムを終了します");
                throw new RuntimeException(e);
            }
        } 
    }
}
