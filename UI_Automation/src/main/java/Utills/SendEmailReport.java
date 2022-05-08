package Utills;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendEmailReport 
{
	public static void sentReport_via_Mail() throws EmailException, MalformedURLException
	{
		 // Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("./Reports/automationTestReport.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Automation Test Report");


		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(465);
		  email.setSSLOnConnect(true);
		  email.setAuthenticator(new DefaultAuthenticator("saurabhsoni9532@gmail.com", ""));
		  email.setFrom("saurabhsoni9532@gmail.com");
		  email.setSubject("Automation Test Report");
		  email.addTo("saurabhsoni868@gmail.com");

		  // add the attachment
		  email.attach(attachment);
		  // send the email
		  email.send();
	}

}
