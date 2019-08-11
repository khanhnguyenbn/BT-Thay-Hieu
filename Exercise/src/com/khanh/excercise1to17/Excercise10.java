package com.khanh.excercise1to17;

import java.net.InetAddress;
import java.net.UnknownHostException;

// get IP address of computer
public class Excercise10 {
	
	public static void main(String[] args) {
		InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("IP  " + IP.getHostAddress());
	}

}
