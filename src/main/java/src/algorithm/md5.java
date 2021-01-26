package src.algorithm;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class md5 {
    public md5() throws UnsupportedEncodingException, GeneralSecurityException {
    }

    public static void main(String[] args) throws UnsupportedEncodingException, GeneralSecurityException {
        // 创建一个MessageDigest实例:
        // 注册BouncyCastle:
        Security.addProvider(new BouncyCastleProvider());
        // 按名称正常调用:
        //MessageDigest md = MessageDigest.getInstance("MD5");
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));

        /**
         * 对称加密
         */
     /*   // 原文:
        String message = "Hello, world!";
        System.out.println("Message: " + message);
        // 256位密钥 = 32 bytes Key:
        byte[] key = "1234567890abcdef1234567890abcdef".getBytes("UTF-8");
        // 加密:
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encrypt1(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt1(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));*/

        /**
         * 口令加密
         */
        // 原文:
        String message1 = "Hello, world!";
        // 加密口令:
        String password = "hello12345";
        // 16 bytes随机Salt:
        byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
        System.out.printf("salt: %032x\n", new BigInteger(1, salt));
        // 加密:
        byte[] data1 = message1.getBytes("UTF-8");
        byte[] encrypted1 = encrypt(password, salt, data1);
        System.out.println("encrypted1: " + Base64.getEncoder().encodeToString(encrypted1));
        // 解密:
        byte[] decrypted1 = decrypt(password, salt, encrypted1);
        System.out.println("decrypted: " + new String(decrypted1, "UTF-8"));

        /**
         * 密钥交换算法
         */
        // Bob和Alice:
       /* Person bob = new Person("Bob");
        Person alice = new Person("Alice");

        // 各自生成KeyPair:
        bob.generateKeyPair();
        alice.generateKeyPair();

        // 双方交换各自的PublicKey:
        // Bob根据Alice的PublicKey生成自己的本地密钥:
        bob.generateSecretKey(alice.publicKey.getEncoded());
        // Alice根据Bob的PublicKey生成自己的本地密钥:
        alice.generateSecretKey(bob.publicKey.getEncoded());

        // 检查双方的本地密钥是否相同:
        bob.printKeys();
        alice.printKeys();
        // 双方的SecretKey相同，后续通信将使用SecretKey作为密钥进行AES加解密...*/
    }


    /**
     *对称加密
     */
   /* // 加密:
    public static byte[] encrypt1(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        // CBC模式需要生成一个16 bytes的initialization vector:
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
        byte[] data = cipher.doFinal(input);
        // IV不需要保密，把IV和密文一起返回:
        return join(iv, data);
    }

    // 解密:
    public static byte[] decrypt1(byte[] key, byte[] input) throws GeneralSecurityException {
        // 把input分割成IV和密文:
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        // 解密:
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivps);
        return cipher.doFinal(data);
    }

    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }*/

    /**
     * 口令加密
     */
    // 加密:
    public static byte[] encrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.DECRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }
}

class Person {
    public final String name;

    public PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] secretKey;

    public Person(String name) {
        this.name = name;
    }

    /**
     * 密钥交换算法
     */
    // 生成本地KeyPair:
    public void generateKeyPair() {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
            kpGen.initialize(512);
            KeyPair kp = kpGen.generateKeyPair();
            this.privateKey = kp.getPrivate();
            this.publicKey = kp.getPublic();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateSecretKey(byte[] receivedPubKeyBytes) {
        try {
            // 从byte[]恢复PublicKey:
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("DH");
            PublicKey receivedPublicKey = kf.generatePublic(keySpec);
            // 生成本地密钥:
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(this.privateKey); // 自己的PrivateKey
            keyAgreement.doPhase(receivedPublicKey, true); // 对方的PublicKey
            // 生成SecretKey密钥:
            this.secretKey = keyAgreement.generateSecret();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public void printKeys() {
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
        System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
        System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey));
    }
}

