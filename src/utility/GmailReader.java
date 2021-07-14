package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeBodyPart;

public class GmailReader {

	public static String HOST_IMAP = "IMAP.gmail.com";
	public static String PORT_IMAP = "993";
	public static String FOLDER_INBOX = "Inbox";

	private String host;
	private String port;
	private Store store;
	private List<String[]> emails;

	public GmailReader(String host, String port) {
		this.host = host;
		this.port = port;
		emails = new ArrayList<String[]>();
	}

	private void conncetPOP3Store(String userName, String password) throws MessagingException {
		// create properties field
		Properties properties = new Properties();

		properties.put("mail.pop3.host", this.host);
		properties.put("mail.pop3.port", this.port);
		properties.put("mail.pop3.starttls.enable", "true");
		Session emailSession = Session.getDefaultInstance(properties);

		// create the POP3 store object and connect with the pop server
		this.store = emailSession.getStore("pop3s");
		this.store.connect(this.host, userName, password);
	}

	private void closePOP3Store() throws MessagingException {
		this.store.close();
	}

	public GmailReader readEmail(String userName, String password, String FolderName) throws MessagingException, IOException {

		// pop3 connection
		this.conncetPOP3Store(userName, password);

		// Create In-box folder
		Folder emailFolder = this.store.getFolder(FolderName);

		emailFolder.open(Folder.READ_ONLY);

		// retrieve the messages from the folder in an array and print it
		Message[] messages = emailFolder.getMessages();
		
		for (int i = 0; i < messages.length; ++i) {
			Message message = messages[i];
			
			String From = message.getFrom()[0]+"";
			String subject = message.getSubject();
			
			
			/*******************************************************/
			String body = null;
			String contentType = message.getContentType();
			if (contentType.contains("multipart")) {
		        Multipart multiPart = (Multipart) message.getContent();
		        int numberOfParts = multiPart.getCount();
		        for (int partCount = 0; partCount < numberOfParts; partCount++) {
		            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
		            body = part.getContent().toString();
		        }
		    }else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
		        Object content = message.getContent();
		        if (content != null) {
		        	body = content.toString();
		        	//body.replaceAll("\\<[^>]*>","");
		        }
		    }else {
		    	body = ">>NO EMAIL BODY FOUND<<";
		    }
			/********************************************************/
			
			this.emails.add(new String[] {From, subject, body});
			
		}

		// close the store and folder objects
		emailFolder.close(false);

		// pop3 disconnection
		this.closePOP3Store();
		
		return this;
	}
	
	public List<String[]> asList(int NumberOfEmail) {
		
		if(this.emails != null) {
			if(NumberOfEmail <= 0) {
				//return all email
				return this.emails;
			}else if(NumberOfEmail > this.emails.size()){
				//return all email
				return this.emails;
			}else {
				int bound = this.emails.size() - NumberOfEmail;
				List<String[]> tempList = new ArrayList<String[]>();
				for(int i=this.emails.size()-1; i>=bound; --i) {
					tempList.add(this.emails.get(i));
				}
				return tempList;
			}
		}else {
			return null;
		}	
	}

}
