package src.file;

import java.io.*;

public class File04 {

    public static void main(String[] args) throws Exception {
        String oldFile ="src/main/java/src/file/File04.java";
        String nowFile = "C:\\Users\\260477\\Desktop\\output.txt";
        readOriginFile(oldFile,nowFile);
    }

    public static void readOriginFile(String oldFile, String nowFile) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(oldFile));
        String s;
        StringBuffer sb = new StringBuffer();
        while((s=read.readLine())!=null) {
            sb.append(s + "\n");
        }
        read.close();
//            System.out.println(sb);
//            System.out.println("==============================================");
        StringReader sr = new StringReader(sb.toString());
        int c;
        while((c=sr.read())!=-1)

        {
            //    System.out.print((char) c);
        }
        sr.close();

        //       System.out.println("==============================================");

        BufferedReader br = new BufferedReader(new StringReader(sb.toString()));
        File file1 = new File(nowFile);
        if (!file1.exists()) {
            boolean flag=file1.createNewFile();
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nowFile)));

        int lineCount = 1;
        String ss;
        while((ss=br.readLine())!=null)

        {
            pw.println(lineCount + ":  " + ss);
            lineCount++;
        }
        pw.close();
    }
}
