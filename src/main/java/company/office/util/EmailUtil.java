package company.office.util;

import java.util.Date;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

/**
 * 带附件的简单邮件发送
 * @author 吴应平
 *
 */
public class EmailUtil {
	
	 private static final String from = "15207104346@163.com";// 用于给用户发送邮件的邮箱
	    private static final String password = "19950705*"; // 邮箱的密码
	    private static final String host = "smtp.163.com";// 发送邮件的服务器地址
	    private static final int port = 25; //发送邮箱的端口号

	    /**
	     * 发送邮件方法
	     * @param accept 接收者邮箱
	     * @param title  邮箱标题
	     * @param content 邮件内容
	     * @param path  附件
	     * @throws Exception
	     */
	    public static void sendAttachmentMail(String accept, String title, String content, String path) throws Exception {
	        try {
	            MultiPartEmail mail = new MultiPartEmail();
	            // 设置端口
	            mail.setSmtpPort(port);
	            // 设置邮件服务器地址
	            mail.setHostName(host);
	            // 设置密码验证
	            mail.setAuthentication(from, password);
	            // 邮件发送者
	            mail.setFrom(from);
	            // 邮件接收者
	            mail.addTo(accept);
	            // 邮件编码
	            mail.setCharset("UTF-8");
	            // 邮件主题
	            mail.setSubject(title);
	            //邮件内容
	            mail.setMsg(content);
	            // 创建附件
	            EmailAttachment attachment = new EmailAttachment();
	            attachment.setPath(path);
	            attachment.setDisposition(EmailAttachment.ATTACHMENT);
	            mail.attach(attachment);
	            // 设置邮件发送时间
	            mail.setSentDate(new Date());
	            // 发送邮件
	            mail.send();
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }

	    /**
	     * 主方法测试
	     * @param args
	     * @throws Exception
	     */
	    public static void main(String[] args) throws Exception {
	        sendAttachmentMail("XXXXXXXXXX@163.com", "带有附件的邮件", "这是一封带有附件的邮件！！","test.jpg");
	    }



}
