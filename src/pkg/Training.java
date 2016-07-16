package pkg;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jeffgoes on 6/7/16.
 */
public class Training {

    public static void main (String [] args) throws IOException{

        ServerSocket OUVIDO = new ServerSocket(8008);
        Socket SERVIDOR_SOCKET = OUVIDO.accept();

        BufferedReader RECEBE = new BufferedReader(new InputStreamReader(SERVIDOR_SOCKET.getInputStream()));

        PrintWriter ENVIA = new PrintWriter(new OutputStreamWriter(SERVIDOR_SOCKET.getOutputStream()));
        String str = "";
        while(str.compareTo("BYE") != 0){
            str = RECEBE.readLine();
            ENVIA.println("O servidor repete: \"" + str + "\"");
            ENVIA.flush();

        }
        RECEBE.close();
        ENVIA.close();
        SERVIDOR_SOCKET.close();

    }
}
