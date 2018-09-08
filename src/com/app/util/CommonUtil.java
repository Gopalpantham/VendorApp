package com.app.util;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class CommonUtil {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail(String to,String subject,String text){
		return sendEmail(to, subject, text, null);
	}
	
	public boolean sendEmail(String to,String subject,String text,final CommonsMultipartFile cmf){
		boolean flag=false;
		try {
			//1. creating Message Object
			MimeMessage message=mailSender.createMimeMessage();

			//2. construct Message object
			MimeMessageHelper helper=new MimeMessageHelper(message, cmf!=null?true:false);

			helper.setTo(to);
			helper.setSubject(subject);
			/*helper.setBcc(bcc);
			helper.setCc(cc);*/
			helper.setText(text);
			helper.setFrom("springgopal223@gmail.com");

			if(cmf!=null){
				//add attachment if file is provided
				helper.addAttachment(cmf.getOriginalFilename(), new InputStreamSource() {
					@Override
					public InputStream getInputStream() throws IOException {
						return cmf.getInputStream();
					}
				});
			}

			//3. send email
			mailSender.send(message);

			flag=true;
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}




}
