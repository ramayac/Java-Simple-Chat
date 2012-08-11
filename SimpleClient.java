import java.net.*;
import java.io.*;

public class SimpleClient
{
   public static void main(String[] args)
   {
   
      try
      {
         // buat object socket dan buka koneksi
         Socket client = new Socket("127.0.0.1", 90);
         
         // remote address dan port
         System.out.println("Remote server: "+client.getInetAddress());
         System.out.println("Remote port: "+client.getPort());
         System.out.println("Port Dinamis client: "+client.getLocalPort());
         
         
         // buka saluran data masuk dari jar
         InputStream in = client.getInputStream();
         
         // ubah byte => char
         InputStreamReader in_reader = new InputStreamReader(in);
         
         // bufferedReader
         BufferedReader pipa_masuk = new BufferedReader(in_reader);
         
         // buka saluran data ke jar
         OutputStream out = client.getOutputStream();
         
         // PrintWriter
         PrintWriter pipa_keluar = new PrintWriter(out);
         
         // Data
         BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
   
    String data_client = "";
    do {      
           System.out.print("send message: ");
         
            data_client = userIn.readLine(); 
    // Data kita siapkan di saluran keluar
            pipa_keluar.println(data_client);
         // Kirim
            pipa_keluar.flush();
         // menerima balasan
            String balasan = pipa_masuk.readLine();
         // cetak
            System.out.println("server message: "+ balasan);
    } while (!data_client.equalsIgnoreCase("close"));
    Thread.sleep(1000);
      }catch (InterruptedException e) {
		e.printStackTrace();
	}
	  catch (IOException e) {
         System.out.println(e);
      }
   }
} 