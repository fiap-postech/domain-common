package br.com.fiap.tech.challenge.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Strings {

	public static final String SPACE = " ";
	public static final String COLON = ":";
	public static final String COMMA = ",";
	public static final String DOT = ".";
	public static final String DASH = "-";
	public static final String UNDERSCORE = "_";
	public static final String EMPTY = "";
	public static final String NEW_LINE = "\n";
	public static final String LINE_BREAK = "<br>";
	public static final String SLASH = "/";
	public static final String PERCENTAGE = "%";
	public static final String SEMICOLON = ";";
	public static final String PIPE = "|";
	public static final String AT = "@";
	public static final String CARET = "^";
	public static final String DOLLAR = "$";
	public static final String ASTERISK = "*";
	public static final String BACK_SLASH = "\\";
	public static final String SHARP = "#";
	public static final String AND = "&";
	public static final String QUESTION_MARK = "?";
	public static final String EXCLAMATION_MARK = "!";
	public static final String OPEN_BRACE = "{";
	public static final String CLOSE_BRACE = "}";
	public static final String OPEN_CLOSE_BRACES = OPEN_BRACE + CLOSE_BRACE;

	public static String formatMessage(String message, Object... parameters) {
		int i = 0;
		while(message.contains(OPEN_CLOSE_BRACES)) {
			message = message.replaceFirst(Pattern.quote(OPEN_CLOSE_BRACES), OPEN_BRACE+ i++ + CLOSE_BRACE);
		}
		return MessageFormat.format(message, parameters);
	}
}