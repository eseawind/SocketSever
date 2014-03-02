import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
//import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

public class MainServer {
  private static final int PORT = 9999;  
  public static void main(String[] args) throws HeadlessException, AWTException, IOException {
    
    String ip = null;
    ip = InetAddress.getLocalHost().getHostAddress();
    System.out.println(ip);

    for(;;){
//      BufferedImage screencapture = new Robot().createScreenCapture(
//          new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );

      BufferedImage screencapture = new Robot().createScreenCapture(
          new Rectangle(0,67,1280,720));
      
      // compress the picture using thumbnailator-0.4.2.jar
      screencapture = Thumbnails.of(screencapture).scale(0.5f).asBufferedImage();

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ImageIO.write(screencapture, "jpg", out);
      byte[] b = out.toByteArray();
      
      // save in local
//      File file = new File("screencapture.jpg");
//      ImageIO.write(screencapture, "jpg", file);

      try {
        ServerSocket server = new ServerSocket(PORT);
        Socket socket = server.accept();
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        dos.writeInt(b.length);
        dos.write(b);

        dos.flush();
        dos.close();
        socket.close();
        server.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}