package src.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextTest {

    public static void main(String[] args) throws IOException {
        System.out.println(writeToFile("dhuqhdueu","C:\\Users\\260477\\Desktop\\file.txt",true));
        System.out.println(writeToFile("C:\\Users\\260477\\Desktop\\file.txt","C:\\Users\\260477\\Desktop\\file1.txt"));
        System.out.println(readFromFile("C:\\Users\\260477\\Desktop\\file.txt"));
        for(int i=7;i<10;i++) {
            System.out.println(createFile("C:\\Users\\260477\\Desktop\\file.txt"+i));
        }
    }

    /**
     * 创建文件
     *
     * @param filePath
     * @return
     */
    private static boolean createFile(String filePath) {
        File file=new File(filePath);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.getStackTrace();
            }
            return true;
        }
        return false;
    }

    /**
     * 从指定文件读取文件内容
     * @param filePath
     * @return
     * @throws IOException
     */
    private static String readFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        String result = "";
        if (!file.exists()) {
            file.createNewFile();
        }
        if (file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
                result = bufferedReader.readLine();
            }
            return result;
        }
        return null;
    }

    /**
     * 从指定文件读取文件内容到另一个文件
     * @param fromFile
     * @param toFile
     * @return
     * @throws IOException
     */
    private static boolean writeToFile(String fromFile,String toFile) throws IOException {
        File file = new File(fromFile);
        File file1 = new File(toFile);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!file1.exists()) {
            file1.createNewFile();
        }
        if (file.isFile() && file1.isFile()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                String s = bufferedReader.readLine();
                OutputStream outputStream = new FileOutputStream(file1);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(s);
                bufferedWriter.flush();
                fileInputStream.close();
                inputStreamReader.close();
                return true;
            }
        }
        return false;
    }

    /**
     * 将指定内容追加到指定文件中
     * @param content
     * @param toFile
     * @param append
     * @return
     * @throws IOException
     */
    private static boolean writeToFile(String content,String toFile,boolean append) throws IOException{
        File file=new File(toFile);
        if(!file.exists()){
            file.createNewFile();
        }
        try(FileWriter fileWriter=new FileWriter(file,append)){
            fileWriter.write(content);
            return true;
        }
    }
}
