import java.net.*;
import java.io.*;

public class SimpleServer
    {
       public static void main(String[] args)
       {
          try
          {
             // buat serversocket dan buka layanan (listening)
             ServerSocket theServer = new ServerSocket(90);
             // loop infinite
             while(true)
             {   
                // terima koneksi dari client
                Socket connection = theServer.accept();
                  System.out.println("Ada Client Yang telah Terkoneksi");  
                // buka saluran data masuk dari client
                InputStream in = connection.getInputStream();
                
                // byte => char
                InputStreamReader in_reader =new InputStreamReader(in);
                
                // baca per baris
                BufferedReader pipa_masuk =
                new BufferedReader(in_reader);
                
                // buka saluran keluar
                OutputStream out = connection.getOutputStream();
                
                // Mengirim per baris
                PrintWriter pipa_keluar = new PrintWriter(out);
                
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
        String data_dari_client;
                while((data_dari_client = pipa_masuk.readLine()) != null)
                {
                // menerima data
                       // cetak
                  System.out.println("client message: "+data_dari_client);
                   System.out.print("send message: ");      
           String balas = input.readLine();
        
        
                  String balasan = balas;
                // kirim
                   pipa_keluar.println(balas);
                   pipa_keluar.flush();
                }
                
                
             }
             
          } catch (SocketException se) {
        System.err.println("Client Telah Keluar");
    }
        catch (IOException e) {
             System.out.println(e);
          }
       }

    } 