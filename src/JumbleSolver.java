import java.util.HashSet;

public class JumbleSolver {
	final WordTrie wordTrie;

	public static void main(String[] args) {
		new JumbleSolver();
	}

	public JumbleSolver() {
		wordTrie = WordTrie.buildDictionary();

		HashSet<String> validWords = jumbleSolver("kelsey");
		for (String str : validWords) {
			System.out.println(str);
		}

	}

	public HashSet<String> jumbleSolver(String input) {
		HashSet<String> validWords = new HashSet<String>();
		boolean[] isIndexUsed = new boolean[input.length()];
		StringBuffer tempStrBuf = new StringBuffer(input.length());

		helper(input, tempStrBuf, isIndexUsed, validWords);

		validWords.remove(input);
		return validWords;
	}

	private void helper(String input, StringBuffer tempStrBuf, boolean[] isIndexUsed,
			HashSet<String> validWords) {

		String currStr = tempStrBuf.toString();
		if (wordTrie.hasWord(currStr)) {
			validWords.add(currStr);
		} else if (!wordTrie.isValidPrefix(currStr)) {
			return; // if this isn't the start of a valid word, don't continue
		}

		for (int i = 0; i < isIndexUsed.length; i++) {
			if (!isIndexUsed[i]) {
				isIndexUsed[i] = true;
				tempStrBuf.append(input.charAt(i));
				helper(input, tempStrBuf, isIndexUsed, validWords);
				tempStrBuf.deleteCharAt(tempStrBuf.length() - 1);
				isIndexUsed[i] = false;
			}
		}

	}

}
