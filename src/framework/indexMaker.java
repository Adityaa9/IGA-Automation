package framework;

import java.io.FileWriter;
import java.io.IOException;

public class indexMaker {

	private String filePath;
	private String content;

	public indexMaker(String filePath) {
		this.filePath = filePath;
		this.content = "";
		this.top();
	}

	private void top() {
		this.content = this.content + "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "<title>Automation Report</title>\r\n"
				+ "<meta charset=\"utf-8\">\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "<script type=\"text/javascript\">\r\n"
				+ "function linkclick(val){\r\n"
				+ "	var val = document.getElementById(val).innerText;\r\n"
				+ "	document.getElementById(\"resultNameType\").innerText = val;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "function loadeer(){\r\n"
				+ "	document.getElementById(\"hyper_0\").click();\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "</script>\r\n"
				+ "<style>\r\n"
				+ "* {\r\n"
				+ "	box-sizing: border-box;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "body {\r\n"
				+ "	margin: 0;\r\n"
				+ "	font-family: Arial, Helvetica, sans-serif;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Style the side navigation */\r\n"
				+ ".sidenav {\r\n"
				+ "	height: 100%;\r\n"
				+ "	width: 200px;\r\n"
				+ "	position: fixed;\r\n"
				+ "	z-index: 1;\r\n"
				+ "	top: 0;\r\n"
				+ "	left: 0;\r\n"
				+ "	background-color: #111;\r\n"
				+ "	overflow-x: hidden;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Side navigation links */\r\n"
				+ ".sidenav a {\r\n"
				+ "	color: white;\r\n"
				+ "	padding: 16px;\r\n"
				+ "	text-decoration: none;\r\n"
				+ "	display: block;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Change color on hover */\r\n"
				+ ".sidenav a:hover {\r\n"
				+ "	background-color: #ddd;\r\n"
				+ "	color: black;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "/* Style the content */\r\n"
				+ ".content {\r\n"
				+ "	margin-left: 200px;\r\n"
				+ "	padding-left: 20px;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body onload=\"loadeer();\">\r\n"
				+ "	<div id=\"links\" class=\"sidenav\">";
	}

	private void bottom() {
		this.content = this.content + "</div>\r\n"
				+ "	<div id=\"content\"></div>\r\n"
				+ "	<div class=\"content\">\r\n"
				+ "		<h2>Automation Report for <span id=\"resultNameType\"></span> </h2>\r\n"
				+ "		<iframe src=\"\" name=\"iframe_a\" title=\"Automation Report\" height=\"750px\" width=\"100%\"></iframe>\r\n"
				+ "</body>\r\n"
				+ "</html>";
	}

	public void addLink(String id, String link, String linkName) {
		this.content = this.content + "" + "<a href=\""+link+"\" target=\"iframe_a\" id=\""+id+"\" onclick=\"linkclick(this.id)\">"+linkName+"</a>";
	}

	public void saveFile() {
		this.bottom();
		try {
			FileWriter myWriter = new FileWriter(this.filePath);
			myWriter.write(this.content);
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
