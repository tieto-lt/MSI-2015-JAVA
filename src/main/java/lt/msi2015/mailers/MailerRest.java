package lt.msi2015.mailers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailerRest {
	
	@Autowired
	MailSender sender;

	@RequestMapping(value = "/send", method = RequestMethod.GET)
	void sendMail() {
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("alch.marius@gmail.com");
        msg.setText("labas Mariau");
        msg.setSubject("Your Karma has increased");
        try{
            this.sender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
	}
	
}
