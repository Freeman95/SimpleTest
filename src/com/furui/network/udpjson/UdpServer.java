package com.furui.network.udpjson;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.alibaba.fastjson.JSONObject;


public class UdpServer {

	public static void main(String[] args) throws Exception {
		// 定义一个接收端，并且指定了接收的端口号
		DatagramSocket socket = new DatagramSocket(6070);

		while (true) {
			byte[] buf = new byte[1024];
			// 解析数据包
			DatagramPacket packet = new DatagramPacket(buf, buf.length);

			socket.receive(packet);

			String ip = packet.getAddress().getHostAddress();

			buf = packet.getData();

			String data = new String(buf, 0, packet.getLength());

			System.out.println("收到 " + ip + " 发来的消息：" + data);

			// Person p = JSON.parseObject(data, new TypeReference<Person>() {});
			Person p = JSONObject.parseObject(data, Person.class);// JSON字符串转对象
			System.out.println(p.toString());
		}

	}
}