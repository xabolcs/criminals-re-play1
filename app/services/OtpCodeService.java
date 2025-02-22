package services;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import play.libs.Mail;

import javax.inject.Singleton;

@Singleton
public class OtpCodeService {
  public String generateOtpLabel() {
    return "ABC";
  }

  public String generateOtpCode() {
    return RandomStringUtils.randomNumeric(4);
  }

  public void sendOtpCode(String username, String otpCode) throws Exception {
    Email mail = new SimpleEmail();
    mail.setCharset("UTF-8");
    //mail.setHostName(config.domain());
    //String domain = config.domain();
    mail.setFrom("login@superservice.com");
    mail.setMsg("Хочешь залогиниться? Введи этот код: " + otpCode);
    mail.setSubject("Логин в суперсервис");
    mail.addTo(username); // usernames are emails
    Mail.send(mail);
  }
}
