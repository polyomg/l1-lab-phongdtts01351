package poly.edu.service;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

public interface MailService{
	@Data
	@Builder
	public static class Mail{
		@Default
		private String from = "phong <do.phong.152007@gmail.com>";
		private String to, cc, bcc, subject, body, filenames;
	}
	void send(Mail mail);
	void send2(Mail mail);
	void push(Mail mail);
	
	default void send(String to, String subject, String body) {
		Mail mail = Mail.builder().to(to).subject(subject).body(body).build();
		this.send(mail);
	}
	default void send2(String to, String subject, String body) {
		Mail mail = Mail.builder().to(to).subject(subject).body(body).build();
		this.send(mail);
	}
	
	 default void push(String to, String subject, String body) {
		 this.push(Mail.builder().to(to).subject(subject).body(body).build());
	 }
}