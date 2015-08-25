package lt.msi2015.mailers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lt.msi2015.pointsTransferInfo.PointsTransferInfoDto;
import lt.msi2015.user.UserRepository;

@Service
public class MailerService {
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	UserRepository userRep;

	public void sendMail(PointsTransferInfoDto info) {
		
		String email = userRep.findById(info.toUserID).getEmail();
		
		String content;
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper;
		
		try {
			content = readFile(new File(".").getCanonicalPath() + "/src/main/webapp/Email.html", Charset.defaultCharset());
			helper = new MimeMessageHelper(message, true);
			helper.setTo(email);
			helper.setSubject("Your Karma has increased");
			helper.setText(content, true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sender.send(message);
	}
	
	private String readFile(String path, Charset encoding) 
	throws IOException {
	  byte[] encoded = Files.readAllBytes(Paths.get(path));
	  return new String(encoded, encoding);
	}
	
}
