import java.io.*;
import java.net.*;
import java.util.*;

public class TinyChatServer {
  private static final int port = 12410;
  private ArrayList<Socket> clients;
  private ServerSocket server;

  public static void main(String[] args) throws IOException {
    new TinyChatServer().startServer();
  }

  public TinyChatServer() {
    try {
      server = new ServerSocket(port);
      System.out.println("Server has started on port: " + port);
    } catch (BindException e) {
      System.out.println("Port " + port + " is already reserved");
      System.exit(0);
    } catch (IOException e) {
      System.err.println("Could not start accepting clients on port: " + port);
      e.printStackTrace();
    }
    clients = new ArrayList<Socket>();
  }

  public void startServer() throws IOException {
    System.out.println("Accepting clients on port: " + port);

    while (true) {
      Socket client = server.accept();
      clients.add(client);
      new Thread(new ClientHandler(client)).start();
    }
  }

  public synchronized void broadcast(String message, Socket sender) throws IOException {
    for (Socket client : clients) {
      if (!client.isClosed() && client != sender) {
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        pw.println(message);
        pw.flush();
      }
    }
  }

  private class ClientHandler implements Runnable {
    private Socket client;

    public ClientHandler(Socket client) {
      this.client = client;
    }

    @Override
    public void run() {
      try {
        Scanner inputStream = new Scanner(client.getInputStream());

        while (inputStream.hasNext()) {
          String message = inputStream.nextLine();
          System.out.println(message);
          TinyChatServer.this.broadcast(message, client);
        }

        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
