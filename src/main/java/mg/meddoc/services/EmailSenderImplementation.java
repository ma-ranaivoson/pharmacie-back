package mg.meddoc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailSenderImplementation implements EmailSenderService{

	private JavaMailSender mailsender;
	public static final Logger log = LoggerFactory.getLogger(EmailSenderImplementation.class);
	
	@Override
    @Async
	public void send(String to, String email) {
		// TODO Auto-generated method stub
		try {
			MimeMessage mimeMessage = mailsender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Hello!\nMEDDOC Madagascar\nVeuillez confirmez votre Mail ");
            helper.setFrom("ramiandrasoaluca@gmail.com");
            mailsender.send(mimeMessage);
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Erreur d\'envoie mail",e);
			throw new IllegalStateException("failed to send email");
		}
	}
	
}
