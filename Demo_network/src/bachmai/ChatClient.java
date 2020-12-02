package bachmai;


import java.net.Socket;
import java.io.*;
import java.net.*;

public class ChatClient {
Socket client;
DataInputStream in;
DataOutputStream ou;
String host = "localhost";
int serverPort = 4321;

public ChatClient() {
makeConnectToServer();
}

public void makeConnectToServer() {

try {
client = new Socket(host, serverPort);
ou = new DataOutputStream(client.getOutputStream());
in = new DataInputStream(client.getInputStream());
} catch (UnknownHostException e) {
System.err.println(host + ": unknown host.");
} catch (IOException e) {
System.err.println("I/O error with " + host);
e.printStackTrace();
}
}

public void sendToServer(String s) {
try {
ou.writeBytes(s + "\n");
} catch (IOException e) {
System.err.println("I/O error with host");
}
}

public String receiveFromServer() {
String s = null;
try {
s = in.readLine();
} catch (IOException e) {
System.out.println("IO Error in streams " + e);
}
return (s);
}

public void sendReceiveWithServer() throws Exception {
String sTo, sFro;
while (true) {
BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
System.out.print("\n Enter a string to be sent to the server: ");
sTo = bu.readLine();
sendToServer(sTo);
sFro = receiveFromServer();
if (sFro.equalsIgnoreCase(".bye")) {
break;
}
System.out.println("A string received from the server: " + sFro);
}

}

public void finalize() {
try {
ou.close();
in.close();
client.close();
} catch (IOException e) {
System.out.println("IO Error in streams " + e);
}
}
}

