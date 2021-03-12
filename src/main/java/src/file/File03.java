package src.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class File03 {
    public static void main(String[] args)  {
        try{
            readFileToAnother("C:\\Users\\260477\\Desktop\\input.txt","C:\\Users\\260477\\Desktop\\output1.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 原样读取多行文件
     *
     * @param fromFile 读文件
     * @param toFile 写文件
     * @throws IOException
     */
    public static void readFileToAnother(String fromFile, String toFile) throws IOException{
        // 读取input.txt，写入output.txt:
        try (InputStream input = new FileInputStream(fromFile);
             OutputStream output = new FileOutputStream(toFile);
             InputStreamReader inputStreamReader =new InputStreamReader(input, StandardCharsets.UTF_8);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(output, StandardCharsets.UTF_8);
             BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
             BufferedWriter bufferedWriter =new BufferedWriter(outputStreamWriter))
        {
            StringBuilder sb =new StringBuilder();
            while (bufferedReader.readLine()!=null) {
                bufferedWriter.write((sb.append(bufferedReader.readLine())+("\n")));
            }
            }
        }
    }
