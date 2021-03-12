package src.file;

import java.io.File;
import java.util.Objects;

public class File02 {

    public static void main(String[] args) {
        File file =new File("D:\\");
        printFile(file,0);
    }


    /**
     *
     * @param file 文件对象
     * @param count 统计文件总个数(没有解压的文件算一个文件)
     */
    public static void printFile(File file,int count){
        if(file !=null && file.isDirectory()) {
            System.out.println(file);
            File[] files = file.listFiles();
            if (Objects.nonNull(files)) {
                for (File file1 : files) {
                    if (file1.isFile()) {
                        System.out.println(file1);
                        count+=1;
                    } else if (file1.isDirectory()) {
                       printFileIfDirectory(file1,count);
                        }
                    }
                }
            }
        System.out.println(count);
        }

    /**
     * 递归统计并打印文件信息
     * @param file 文件对象
     * @param count 统计文件总个数(没有解压的文件算一个文件)
     */
    public static void printFileIfDirectory(File file,int count){
        if(file !=null && file.isDirectory()) {
            System.out.println(file);
            File[] files = file.listFiles();
            if (Objects.nonNull(files)) {
                for (File file1: files) {
                    if(file1 !=null && file1.isFile()) {
                        System.out.println(file1);
                        count=count+1;
                    }else if (file1 !=null && file1.isDirectory()){
                        printFileIfDirectory(file1,count);
                    }
                }
            }
        }
    }
}
