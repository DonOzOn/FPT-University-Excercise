package bachmai;
import java.io.*;
import java.net.*;

public class ChatServer {

ServerSocket server;
Socket client;
DataInputStream in;
DataOutputStream ou;
int serverPort = 4321;

public ChatServer() {
makeConnectToClient();
}

public void makeConnectToClient() {
server = null;
try {
server = new ServerSocket(serverPort);
} catch (IOException e) {
System.out.println("Error on port: " + serverPort + ", " + e);
System.exit(1);
}
System.out.println("Server already setup and waiting for client connection ...");

client = null;
try {
client = server.accept();
ou = new DataOutputStream(client.getOutputStream());
in = new DataInputStream(client.getInputStream());
} catch (IOException e) {
System.out.println("Did not accept connection: " + e);
System.exit(1);
}
}

public void sendToClient(String s) {
try {
ou.writeBytes(s + "\n");
} catch (IOException e) {
System.err.println("I/O error with client");
e.printStackTrace();
}
}

public String receiveFromClient() {
String s = null;
try {
s = in.readLine();
} catch (IOException e) {
System.out.println("IO Error in streams " + e);
}
return (s);
}

public void sendReceiveWithClient() throws Exception {
String sTo, sFro;
while (true) {
sFro = receiveFromClient();
if (sFro.equalsIgnoreCase(".bye")) {
break;
}
System.out.println("A string received from the client: " + sFro);

BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
System.out.print("\n Enter a string to be sent to the client s = ");
sTo = bu.readLine();
sendToClient(sTo);
}

}

public void finalize() {
try {
in.close();
client.close();
server.close();
} catch (IOException e) {
System.out.println("IO Error in streams " + e);
}
}

}