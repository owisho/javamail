package per.owisho.javamail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServiceImpl implements MailService{

	@Override
	public void sendMail(String to, String subject, String htmlText) throws Exception {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.126.com");
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("owisho2012@126.com", "wy19900821");
			}
		});
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("owisho2012@126.com", true));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to, true));
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(htmlText);
			Transport.send(msg);
		} catch (MessagingException mex) {
			System.out.println("send failed,exception:"+mex);
		}
	}
	
	public static void main(String[] args) throws Exception {
		MailServiceImpl impl = new MailServiceImpl();
		impl.sendMail("owisho2012@126.com", "JavaMail hello world example", "Hello, world!\n");
	}

}
