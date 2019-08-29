package company.office.util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import com.sun.mail.util.MailSSLSocketFactory;
import org.apache.commons.mail.EmailAttachment;

/**
 * 该类是多线程实现 邮件异步发送
 * @author 吴应平
 *
 */
public class SendMailThread extends Thread {
    private String mailAdr;//邮件接收者邮箱
    private String content;//邮件内容
    private String subject;//邮件标题
    private String annex;//邮件附件

    private static final  String  emailName="15207104346@163.com";//邮件发送者
    private static final  String  emailPassword="4555518@earb";//发送者密码
    private static final  String  emailEnable="gyenmagxtegsk";//邮箱授权码


    //利用构造器，进行初始化邮件接收者的信息和内容，以及附件
    /**
     * 发送邮件方法
     * @param mailAdr 接收者邮箱
     * @param subject 发送标题
     * @param content 发送内容
     * @param annex   发送附件
     */
    public SendMailThread(String mailAdr, String subject, String content ,String annex) {
        // TODO Auto-generated constructor stub
        super();
        this.mailAdr = mailAdr;
        this.subject = subject;
        this.content = content;
        this.annex = annex;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        try {
            sendMail(mailAdr, subject, content);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void sendMail(String mailAdr, String subject, String content) throws Exception {
        // 设置SSL为true
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);

        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.163.com");
        // 端口
        props.put("mail.smtp.port", 25);
        // smtp登陆的账号、密码 ；需开启smtp登陆
        props.setProperty("mail.debug", "true");
        props.put("mail.user", emailName);//发送者邮箱
        props.put("mail.password", emailEnable);//QQ/163邮箱授权码
        //特别需要注意，要将ssl协议设置为true,否则会报530错误
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        //设置发送者的邮箱和密码，使用上面的邮箱
        Authenticator authenticator = new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            //emailName发送者的邮箱, emailPassword邮箱密码
                return new PasswordAuthentication(emailName, emailPassword);

            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        try {
            InternetAddress form = new InternetAddress( props.getProperty("mail.user"));
            message.setFrom(form);

            // 设置收件人
            InternetAddress accept = new InternetAddress(mailAdr);
            message.setRecipient(RecipientType.TO, accept);

            // 设置抄送
            InternetAddress cc = new InternetAddress("luo_aaaaa@yeah.net");
            message.setRecipient(RecipientType.CC, cc);

            // 设置密送，其他的收件人不能看到密送的邮件地址
            InternetAddress bcc = new InternetAddress("aaaaa@163.com");
            message.setRecipient(RecipientType.CC, bcc);

            // 设置邮件标题
            message.setSubject(subject);
            //设置邮件附件
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(annex);
            // 设置邮件的内容体
            message.setContent(content, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SendMailThread d = new SendMailThread("接收者的邮箱" ,"测试邮件标题" ,"测试邮件001 <br>内容....","string");
        d.start();
        System.out.println("程序继续...");
    }

}
