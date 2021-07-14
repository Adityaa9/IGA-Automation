package utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class OutlookReader {

	public static String FOLDER_INBOX = "Inbox";

	private String host;
	private Store store;
	private List<String[]> emails;

	public OutlookReader(String host) {
		this.host = host;
		emails = new ArrayList<String[]>();
	}

	private void conncetPOP3Store(String userName, String password) throws MessagingException {
		Properties properties = new Properties();
		properties.setProperty("mail.imap.ssl.enable", "true");
		Session emailSession = Session.getDefaultInstance(properties);
		this.store = emailSession.getStore("imap");
		this.store.connect(this.host, userName, password);
	}

	private void closePOP3Store() throws MessagingException {
		this.store.close();
	}

	public OutlookReader readEmail(String userName, String password, String FolderName) throws MessagingException, IOException {
		this.conncetPOP3Store(userName, password);
		Folder emailFolder = this.store.getFolder(FolderName);
		emailFolder.open(Folder.READ_ONLY);
		Flags seen = new Flags(Flags.Flag.SEEN);
		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
		Message messages[] = emailFolder.search(unseenFlagTerm);
		for (int i = 0; i < messages.length; ++i) {
			Message message = messages[i];
			String From = message.getFrom()[0]+"";
			String subject = message.getSubject();String body = "";
			if (message.isMimeType("text/plain")) {
				body = message.getContent().toString();
		    } else if (message.isMimeType("multipart/*")) {
		        MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
		        body = getTextFromMimeMultipart(mimeMultipart);
		    }else {
		    	body = ">>NO EMAIL BODY FOUND<<";
		    }this.emails.add(new String[] {From, subject, body});
			
		}
		emailFolder.close(false);
		this.closePOP3Store();
		return this;
	}
	
	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException{
	    String result = "";
	    int count = mimeMultipart.getCount();
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        if (bodyPart.isMimeType("text/plain")) {
	            result = result + "\n" + bodyPart.getContent();
	            break;
	        } else if (bodyPart.isMimeType("text/html")) {
	            String html = (String) bodyPart.getContent();
	            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
	        } else if (bodyPart.getContent() instanceof MimeMultipart){
	            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	        }
	    }
	    return result;
	}
	
	public List<String[]> asList(int NumberOfEmail) {
		
		if(this.emails != null) {
			if(NumberOfEmail <= 0) {
				return this.emails;
			}else if(NumberOfEmail > this.emails.size()){
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
