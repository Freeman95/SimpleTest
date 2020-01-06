package com.furui.network.udpjson;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.alibaba.fastjson.JSONObject;



public class UdpClient {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();

		String s = getJsonStr();
		byte[] buf = s.getBytes();
		// 将数据打包
		DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.111"), 6070);
		socket.send(packet);
		socket.close();

	}

	public static String getJsonStr() {
		Person p = new Person();
		p.setName("张三");
		p.setAge(18);
		p.setGender("男");
		return JSONObject.toJSONString(p);
	}
}