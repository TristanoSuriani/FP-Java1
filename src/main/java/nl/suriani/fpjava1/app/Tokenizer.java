package nl.suriani.fpjava1.app;

import nl.suriani.fpjava1.app.functions.PrintConsumer;
import nl.suriani.fpjava1.lib.F;
import nl.suriani.fpjava1.lib.LinkedList;
import nl.suriani.fpjava1.lib.Node;

public class Tokenizer {
	public static final String EMPTY_STRING = "";
	private static LinkedList delimiters =
			LinkedList.empty()
				.append('(')
				.append(')');

	private static LinkedList separators =
			LinkedList.empty()
				.append(' ')
				.append(',')
				.append('\t')
				.append('\r')
				.append('\n');

	public LinkedList tokenize(String source) {
		return tokenize(stringToCharList(source), EMPTY_STRING);
	}

	private LinkedList tokenize(LinkedList sourceList, String currentToken) {
		if (sourceList.isEmpty()) {
			return LinkedList.empty();
		} else {
			char currentChar = (char) sourceList.first().getValue();
			if (separators.contains(currentChar)) {
				return consIfCurrentTokenNotEmpty(currentToken,
						tokenize(sourceList.rest(), EMPTY_STRING));
			} else {
				if (delimiters.contains(currentChar)) {
					return consIfCurrentTokenNotEmpty(currentToken,
							consIfCurrentTokenNotEmpty(EMPTY_STRING + currentChar,
									tokenize(sourceList.rest(), EMPTY_STRING)));
				} else {
					return tokenize(sourceList.rest(), currentToken + currentChar);
				}
			}
		}
	}

	private LinkedList consIfCurrentTokenNotEmpty(String currentToken, LinkedList linkedList) {
		if (currentToken.equals(EMPTY_STRING)) {
			return linkedList;
		} else {
			return LinkedList.cons(new Node(currentToken), linkedList);
		}
	}

	private LinkedList stringToCharList(String source) {
		if (source.isEmpty()) {
			return LinkedList.empty();
		} else {
			return LinkedList.cons(new Node(source.charAt(0)),
					stringToCharList(source.substring(1)));
		}
	}

	public static void main(String[] args) {
		String source = "MULTIPOINT((120,-124) (16, 255) (-132, -12))";
		Tokenizer tokenizer = new Tokenizer();
		F.forEach(new PrintConsumer(), tokenizer.tokenize(source));
	}
}
