package br.com.dextra.estagio2015.atv08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Mudamos o try, a porta e funcionou (se não gravar no arquivo)
 * Criamos método para salvar mensagens no arquivo (apagamos o método usado)
 * Alteramos os nomes das classes, pois não faziam sentido
 * @author laura.boscolo
 *
 */
public class KnockCliente {
	public static void main(String[] args) throws IOException {

		String hostName = "localhost";
		int portNumber = 5128;

		try{
			Socket socket = new Socket(hostName, portNumber);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));

			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));
			
			String fromServer;
			String fromUser;

			while ((fromServer = in.readLine()) != null) {
				System.out.println("Server: " + fromServer);
				if (fromServer.equals("Bye."))
					break;

				fromUser = stdIn.readLine();
				if (fromUser != null) {
					System.out.println("Client: " + fromUser);

					saveToFile(fromUser,"a.txt");
					out.println(fromUser);
				}
			}
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for the connection to "
					+ hostName);
			System.exit(1);
		}
	}
	
	private static void saveToFile(String content, String filename) {
		try {
			File arquivo = new File(filename);  
		    FileOutputStream fos = new FileOutputStream(arquivo);  
		    fos.write(content.getBytes());    
		    fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		
	}
}
