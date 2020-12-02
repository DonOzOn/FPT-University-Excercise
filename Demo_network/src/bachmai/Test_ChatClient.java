package bachmai;


import bachmai.ChatClient;


    public class Test_ChatClient {

public static void main(String[] args) throws Exception {
ChatClient t = new ChatClient();
try {
t.sendReceiveWithServer();
} catch (Exception e) {
e.printStackTrace();
}
}
}

