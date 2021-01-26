package socket;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;


public class UdpServer {
    public static void main(String[] args) throws IOException {

        DatagramSocket ds = new DatagramSocket(6666);

        for (; ; ) {
            byte[] buffer = new byte[1024];
            DatagramPacket data = new DatagramPacket(buffer, buffer.length);
            ds.receive(data); // 收取一个UDP数据包
            // 收取到的数据存储在buffer中，由packet.getOffset(), packet.getLength()指定起始位置和长度
            // 将其按UTF-8编码转换为String:
            String s = new String(data.getData(), data.getOffset(), data.getLength(), StandardCharsets.UTF_8);
            // 发送数据:
            byte[] send = "ACK".getBytes(StandardCharsets.UTF_8);
            data.setData(send);
            ds.send(data);
        }
    }
}
