package per.owisho.javamail;

public interface MailService {

	void sendMail(String to,String subject,String htmlText) throws Exception;
	
}
