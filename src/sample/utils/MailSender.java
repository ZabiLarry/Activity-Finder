package sample.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {

    private static final String USER_NAME = "noreply.activityfinder";  // GMail user name (just the part before "@gmail.com")
    private static final String PASSWORD = "something713"; // GMail password
    private static final String HOST = "smtp.gmail.com";

    private static final String FORGOTTEN_PASSWORD = "Forgotten Password"; // Subject title for forgotten password


    public static void sendForgottenPassword(String destinationAddress, String firstName, String password) {
        String text = forgottenPasswordFormattedMessage(firstName, password);
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destinationAddress));


            message.setSubject(FORGOTTEN_PASSWORD);
            message.setContent(text, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(HOST, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static String forgottenPasswordFormattedMessage (String firstName, String password){
        return "<p>Dear <b>"+firstName+"</b>, <br/>" +
                "Your password is: <i>" + password + "</i><br/><br/>" +
                "Test Message v1.0</p>";
    }
}