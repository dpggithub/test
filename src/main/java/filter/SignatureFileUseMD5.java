package filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.MessageDigest;

public class SignatureFileUseMD5 {

    /**
     * java计算文件32位md5值
     * @param fis 输入流
     * @return
     */
    public static String md5HashCode32(InputStream fis) {
        try {
            //拿到一个MD5转换器,如果想使用SHA-1或SHA-256，则传入SHA-1,SHA-256
            MessageDigest md = MessageDigest.getInstance("MD5");

            //分多次将一个文件读入，对于大型文件而言，比较推荐这种方式，占用内存比较少。
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fis.read(buffer, 0, 1024)) != -1) {
                md.update(buffer, 0, length);
            }
            fis.close();

            //转换并返回包含16个元素字节数组,返回数值范围为-128到127
            byte[] md5Bytes  = md.digest();
            return toHexString(md5Bytes);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // 将byte[]转换为hex string:
    public static String toHexString(byte[] digest) {
        StringBuilder hexValue = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            int val = ((int) digest[i]) & 0xff;//解释参见最下方
            if (val < 16) {
                /**
                 * 如果小于16，那么val值的16进制形式必然为一位，
                 * 因为十进制0,1...9,10,11,12,13,14,15 对应的 16进制为 0,1...9,a,b,c,d,e,f;
                 * 此处高位补0。
                 */
                hexValue.append("0");
            }
            //这里借助了Integer类的方法实现16进制的转换
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


    /**
     * 保证文件的MD5值为32位
     * @param filePath	文件路径
     * @return
     * @throws FileNotFoundException
     */
    public static String md5HashCode32(String filePath) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        return md5HashCode32(fis);
    }
}
