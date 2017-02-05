import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
 static final int PORT = 8080;

 private static String who() {
  return System.getenv().getOrDefault("WHO", "World");
 }

 private static void responseWriter(DataOutputStream stream) throws IOException {
  stream.writeBytes("HTTP/1.0 200 OK\r\n");
  stream.writeBytes("Content-Type: text/html\r\n");
  stream.writeBytes("\r\n");
  stream.writeBytes("<h1>Hello " + who() + "</h1>\r\n");
 }

 public static void main(String[] args) throws IOException {
  ServerSocket server = new ServerSocket(PORT);
  System.out.println("listening on port: " + PORT);

  while (true) {
   Socket socket = server.accept();
   System.out.println(
    new BufferedReader(
     new InputStreamReader(
      socket.getInputStream())).readLine());
   responseWriter(new DataOutputStream(socket.getOutputStream()));
   socket.close();
  }
 }
}
