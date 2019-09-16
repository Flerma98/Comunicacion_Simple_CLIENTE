import java.io.*;
import java.net.*;

public class Principal {

    static String ip;
    static int numsocket;
    static String texto;
    
    public static void main(String[] args) throws Exception{
        try{
        if(args[0]!=null){
            ip= args[0];
        }else{
            System.out.println("Escriba una ip valida");
            System.exit(0);
        }
        }catch (Exception e){System.out.println("Escriba una ip valida");
            System.exit(0);}
        try{
        if(args[1]!=null){
            try {
                numsocket= Integer.parseInt(args[1]);
            } catch (Exception e) {System.out.println("Escriba un socket valido");
            System.exit(1);}
        }else{
            System.out.println("Escriba un socket valido");
            System.exit(2);
        }
        }catch (Exception e){System.out.println("Escriba un socket valido");
            System.exit(1);}
        try{
        if(!args[2].isEmpty() || args[2]!=null){
            texto= args[2];
        }else{
            System.out.println("Escriba un mensaje valido");
            System.exit(3);
        }
        }catch (Exception e){System.out.println("Escriba un mensaje valido");
            System.exit(3);}
        try{
        Socket socket= new Socket(ip, numsocket);
        PrintWriter escritor= new PrintWriter(socket.getOutputStream(), true);
        if(!texto.isEmpty()){
            escritor.println(texto);
        }
        socket.close();
        }catch(IOException e){System.out.println("Error al crear el socket"); System.exit(4);}
    }
    
}