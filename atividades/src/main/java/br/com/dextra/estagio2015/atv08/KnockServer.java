package br.com.dextra.estagio2015.atv08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockServer {
	public static void main(String[] args) throws IOException {

		int portNumber = 5128;

		try {
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket clientSocket = serverSocket.accept();
			
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
			
			String inputLine, outputLine;
			ProtocoloDeMensagens pMsg = new ProtocoloDeMensagens();
			
			outputLine = pMsg.processaEntrada(null);
			out.println(outputLine);
			
			while ((inputLine = in.readLine()) != null) {
				outputLine = pMsg.processaEntrada(inputLine);
				out.println(outputLine);
			}

		} catch (IOException e) {
			System.out
					.println("Exception caught when trying to listen on port "
							+ portNumber + " or listening for a connection");
			System.out.println(e.getMessage());
		}
	}
}
