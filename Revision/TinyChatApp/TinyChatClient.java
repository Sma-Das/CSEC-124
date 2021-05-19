import java.io.*;
import java.net.*;
import java.util.*;

public class TinyChatClient implements Runnable {
  private static final int port = 12410;
  String IP = "localhost";
  private Scanner inputStream;
  private PrintWriter outputStream;
  private Socket client;
  private String name;

  public static void main(String[] args) throws Exception {
    new TinyChatClient();
  }

  public TinyChatClient() throws IOException {
    initializeClient();
  }

  public void initializeClient() throws IOException {
    Scanner keyIn = new Scanner(System.in);

    System.out.print("What is your name? ");
    name = keyIn.next();

    try {
      client = new Socket(IP, port);
    } catch (IOException e) {
      System.out.println("Failed to connect to port: " + port);
      System.exit(0);
    }

    inputStream = new Scanner(client.getInputStream());
    outputStream = new PrintWriter(client.getOutputStream());
    outputStream.println(name + " has joined the chat!");
    outputStream.flush();

    new Thread(this).start();

    do {

      String message = keyIn.nextLine();
      if (message.equalsIgnoreCase("Quit")) {
        outputStream.println(name + " is quitting the server");
        outputStream.flush();
        System.exit(0);
      }
      if (message.length() == 0) continue;

      outputStream.println(name + ": " + message);
      outputStream.flush();

    } while (keyIn.hasNextLine());

    keyIn.close();
  }

  @Override
  public void run() {
    while (true) {
      if (inputStream.hasNextLine()) {
        System.out.println(inputStream.nextLine());
      }
    }
  }
}
