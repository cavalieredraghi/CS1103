
public class RandomSentences {

	/*
	 * I am going with the lists of different words rather then have one list of all
	 * the words combined. I feel this will make the sentence structure a bit
	 * cleaner on the end result.
	 */

	static final String[] conjunction = { "and", "or", "but", "because" };

	static final String[] proper_nouns = { "Kallen", "Kirana", "DragKel", "Arokh", "Rynn", "Mal" };

	static final String[] common_nouns = { "human", "dragon", "centaur", "unicorn" };

	static final String[] determiner = { "a", "the" };

	static final String[] adjectives = { "pretty", "loyal", "sneaky", "proud" };

	static final String[] intransitive_verbs = { "runs", "jumps", "talks", "sleeps" };

	static final String[] transitive_verbs = { "loves", "sees", "knows", "looks for", "fights" };

	public static void main(String[] args) {

		sentence();
		System.out.println(". \n\n");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}

	}

	// making a verb generator I went with the second option of a transitive verb
	// plus a noun phrase.
	static void verb_phrase() {
		int in = (int) (Math.random() * intransitive_verbs.length);
		int tn = (int) (Math.random() * transitive_verbs.length);
		int a = (int) (Math.random() * adjectives.length);
		if (Math.random() > .3)
			System.out.print(transitive_verbs[tn]);
		noun_phrase();
		if (Math.random() < .2)
			System.out.print(intransitive_verbs[in]);
		if (Math.random() < .1)
			System.out.print(" is " + adjectives[a]);
		if (Math.random() < .05)
			System.out.print(" believes that ");
		simple_sentence();
	}

	static void noun_phrase() {
		int pn = (int) (Math.random() * proper_nouns.length);
		int cn = (int) (Math.random() * common_nouns.length);
		int d = (int) (Math.random() * determiner.length);
		int a = (int) (Math.random() * adjectives.length);
		if (Math.random() > .75)
			System.out.print(proper_nouns[pn]);
		if (Math.random() > 0.5)
			System.out.print(determiner[d] + " " + adjectives[a] + " " + common_nouns[cn] + " who ");
		verb_phrase();
	}

	static void simple_sentence() {
		noun_phrase();
		verb_phrase();

	}
	//I did not want the recursion to go on continually so I made it end with a simple sentence rather then another sentence.
	
	static void sentence() {
		simple_sentence();
		System.out.print(" and ");
		simple_sentence();
	}

}
