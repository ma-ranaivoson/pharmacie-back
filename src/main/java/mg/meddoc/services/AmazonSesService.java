package mg.meddoc.services;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.meddoc.models.Email;

@Service
public class AmazonSesService {

	ObjectMapper om=new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(AmazonSesService.class);
	
	@Value("${email.accessKey}")
    private String ACCESS_KEY;

    @Value("${email.secretKey}")
    private String SECRET_KEY;
    
	public void sendMail(Email email) throws AddressException, MessagingException, IOException {
	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "email-smtp.us-west-2.amazonaws.com");
	   props.put("mail.smtp.port", "587");
	   
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication(ACCESS_KEY, SECRET_KEY);
	      }
	   });
	   Message msg = new MimeMessage(session);
	   msg.setFrom(new InternetAddress(email.getFrom(), false));

	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
	   msg.setSubject(email.getSubject());
	   msg.setContent(email.getBody(), "text/plain");
	   msg.setText(email.getBody());
	   msg.setSentDate(new Date(Calendar.getInstance().getTimeInMillis()));

	   MimeBodyPart messageBodyPart = new MimeBodyPart();
	   messageBodyPart.setContent(msg, "text/plain");
	   Transport.send(msg);
	}
}
