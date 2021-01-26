package src.file;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileTest {
    public static void main(String[] args) throws IOException {
//        File file=new File("C:\\Users\\260477\\Desktop\\file.txt");
//        try (InputStream inputStream=new FileInputStream(file)){
//            // 定义1000个字节大小的缓冲区:
//            byte[] buffer = new byte[1000];
//            int n;
//            while((n=inputStream.read(buffer))!=-1){
//
//            }
//            try (InputStream input = new ByteArrayInputStream(buffer)) {
//                int s;
//                while ((s = input.read()) != -1) {
//                    System.out.print((char)s);
//                }
//            }
//        }

        InputStream inputStream = new FileInputStream("C:\\Users\\260477\\Desktop\\file.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String t = bufferedReader.readLine();


        OutputStream outputStream=new FileOutputStream("C:\\Users\\260477\\Desktop\\file1.txt");
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
        outputStreamWriter.write(t);
        outputStreamWriter.flush();
        bufferedReader.close();
        outputStreamWriter.close();
        }
    }
