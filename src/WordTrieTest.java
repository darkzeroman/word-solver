import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordTrieTest {

	@Test
	public void testSimple() {
		WordTrie wordTrie = new WordTrie();
		wordTrie.addWord("racecar");
		assertFalse(wordTrie.hasWord("race"));
		assertTrue(wordTrie.hasWord("racecar"));
	}

	@Test
	public void testCheckWord() {
		WordTrie wordTrie = new WordTrie();
		wordTrie.addWord("at");
		wordTrie.addWord("attack");
		assertFalse(wordTrie.hasWord("att"));
		assertTrue(wordTrie.hasWord("attack"));
		assertTrue(wordTrie.hasWord("at"));
		assertTrue(wordTrie.isValidPrefix("atta"));
		assertFalse(wordTrie.isValidPrefix("abb"));
	}
}
