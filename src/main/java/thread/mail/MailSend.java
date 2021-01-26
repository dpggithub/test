package thread.mail;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.util.Properties;

public class MailSend {
    public static void main(String[] args) throws MessagingException, IOException {
// 服务器地址:
        String smtp = "smtp.qq.com";
// 登录用户名:
        String username = "970908343@qq.com";
// 登录口令:
        String password = "dwmyxxxxpnpwbddh";
// 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "587"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
// 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
// 设置debug模式便于调试:
        session.setDebug(true);


        MimeMessage message = new MimeMessage(session);
// 设置发送方地址:
        message.setFrom(new InternetAddress("970908343@qq.com"));
// 设置接收方地址:
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("13260639250@163.com"));
// 设置邮件主题:
        message.setSubject("Hello", "UTF-8");
// 设置邮件正文:发送HTML邮件
        //message.setText("<h1>Hello</h1><p>Hi,这是一封HTML邮件</p>", "UTF-8","html");
// 发送:



        // 发送附件
        Multipart multipart = new MimeMultipart();
        // 添加text:
        BodyPart textpart = new MimeBodyPart();
        textpart.setContent("附件", "text/plain;charset=utf-8");
        multipart.addBodyPart(textpart);
        // 添加image:
        BodyPart imagepart = new MimeBodyPart();
        imagepart.setFileName("http://mmbiz.qpic.cn/mmbiz_jpg/5UEicfkNtkLobXVSZibl51QVHpSS9yibTKhlnKlDXrCrmo66d5EOjDzRRUamsJ1sZfBpMzwSXZ053W0Hubj0iawC1Q/0?wx_fmt=jpeg");
        imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource("C:\\Users\\260477\\Desktop\\新建 Microsoft Word 文档.docx", "application/msword")));
        multipart.addBodyPart(imagepart);
// 设置邮件内容为multipart:
        message.setContent(multipart);
        Transport.send(message);
    }
}
