## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


////////////////////////////////////
MyGhost クラス
このクラスはゴーストオブジェクトを定義する。プロパティは以下

from: 送信者の名前
to: 受信者の名前
ghostType: ゴーストの種類
メソッドは以下

printGhoastInfo():送霊者、受霊者、ゴーストの種類を出力する。
changeGhoastType: ゴーストの種類を新しいタイプに変更する。
swapFromTo(): 送霊者と受霊者を入れ替える。

KadaiTCPServ クラス
特定のポートでクライアントからの接続を待ち受ける。
受信したゴーストの種類を "Friendly Ghost" に変更。
ゴーストの種類を一定回数繰り返した文字列として加工し、新しい MyGhost オブジェクトとしてクライアントに返送。
KadaiTCPClient クラス
特定のポートでサーバーに接続を要求。
ユーザーから送霊者、受霊者、ゴーストの種類の入力を受け取り、それを基に MyGhost オブジェクトを作成する。
作成した MyGhost オブジェクトをサーバーに送信する。
サーバーから返信された MyGhost オブジェクトを受信し、その情報を表示。