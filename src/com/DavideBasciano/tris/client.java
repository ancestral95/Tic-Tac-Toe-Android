package com.DavideBasciano.tris;

import java.net.*;
import java.io.*;

import android.widget.EditText;

public class client {
	
	public static void main(final int x, final int y) {
		/*
		 * Utilizzo un tread perchè il costrutto try/catch funziona solo così
		 */
		new Thread(){
	    	public void run() {
				try {
					int px=x;
					int py=y;
					DataOutputStream dataOutputStream = null;
					DataInputStream dataInputStream = null;
					Socket s1 = new Socket ("192.168.1.3", 7654);
					dataOutputStream = new DataOutputStream(s1.getOutputStream());
					dataInputStream = new DataInputStream(s1.getInputStream());
					dataOutputStream.writeUTF(String.valueOf(px).concat(";").concat(String.valueOf(py)));
					s1.close();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
		}.start();
	}
} 