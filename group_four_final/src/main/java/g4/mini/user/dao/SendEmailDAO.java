package g4.mini.user.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailDAO {
	
	public String service(String email) { 
		String host = "smtp.naver.com";
		final String user = "네이버아이디";
		final String password = "네이버비밀번호";
		
		String to = email; // 받는사람 이메일
		
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// 메세지 제목
			message.setSubject("비트캠프 점심메뉴 임시비밀번호 입니다.");

			// (10자리의 임시비밀번호 생성)
			String temPass = new GetRandomPass().service(10);
			
			
			// 메세지 내용
			message.setText("임시비밀 번호 : " + temPass);

			Transport.send(message);
			System.out.println("이메일 발송 성공");
			
			return temPass; // 임시비밀번호 내보낸다.

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	
	
	
	}

