import java.io.Serializable;

public interface ITask extends Serializable {
    void setExecNumber(int x); // クライアントで計算させる数字を入力
    void exec(); // サーバで計算を実行
    int getResult(); // クライアントで結果を取り出す
    int getExecNumber();
}
