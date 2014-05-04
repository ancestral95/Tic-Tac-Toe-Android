package com.DavideBasciano.tris;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
 
public class server {
 
	public int px=0;
	public int py=0;
	String stringa;
	private int port;
	 private ServerSocket server;

	 public server (int port)
	 {
	  this.port = port;
	  if(!IniziaServer())
	   System.err.println("Errore durante la creazione del Server");
	 }

	 private boolean IniziaServer()
	 {
	  try
	  {
	   server = new ServerSocket(port);   
	  }
	  catch (IOException ex)
	  {
	   ex.printStackTrace();
	   return false;
	  }
	  return true;
	 }
	 
	 public String AvviaServer()
	 {
	  while (true)
	  {
	   try
	   {
	    Socket s1 = server.accept();
	    BufferedInputStream ib = new
		BufferedInputStream(s1.getInputStream());
		DataInputStream is = new DataInputStream(ib);
		BufferedOutputStream ob = new
		BufferedOutputStream(s1.getOutputStream());
		PrintStream os = new PrintStream(ob,false);
		String line;
		line = new String(is.readLine());
		//La stringa inizia dopo il secondo carattere
		stringa=line.substring(2);
		os.close(); is.close();
	    s1.close();
	    return stringa;
	   }
	   catch (IOException ex)
	   {
	    ex.printStackTrace();
	   }
	  }
	 }

	public static String main ()
	 {
	  server ss = new server(7654);  
	  return (ss.AvviaServer());
	 }
}