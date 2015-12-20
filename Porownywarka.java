import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

class KlasaTestowa implements Comparable<KlasaTestowa> {
	private int wartosc1;
	private int wartosc2;

	@Override
	public int compareTo(KlasaTestowa o) {
		return (int)(47 * (this.getWartosc1() - o.getWartosc1()) + 0.17 * (this.getWartosc2()
				- o.getWartosc2()));
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof KlasaTestowa) {
			KlasaTestowa obiekt = (KlasaTestowa) o;
			if (obiekt.getWartosc1() == this.getWartosc1()
					&& obiekt.getWartosc2() == this.getWartosc2()) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	public KlasaTestowa(int wartosc1, int wartosc2) {
		this.wartosc1 = wartosc1;
		this.wartosc2 = wartosc2;
	}

	@Override
	public int hashCode() {
		int result = 0;
		result += 31 * wartosc1;
		result += 17 * wartosc2;
		return result;
	}

	public int getWartosc1() {
		return wartosc1;
	}

	public int getWartosc2() {
		return wartosc2;
	}
}

public class Porownywarka {
	
	private PrintWriter writer;

	public void porownaj() throws FileNotFoundException, UnsupportedEncodingException {

		writer = new PrintWriter("wyniki.txt", "UTF-8");
		
		ArrayList<KlasaTestowa> arrayList = new ArrayList<>();
		LinkedList<KlasaTestowa> linkedList = new LinkedList<>();
		HashSet<KlasaTestowa> hashSet = new HashSet<>();
		LinkedHashSet<KlasaTestowa> linkedHashSet = new LinkedHashSet<>();
		TreeSet<KlasaTestowa> treeSet = new TreeSet<>();
		
		System.out.println("Dodawanie 500 000 elementów.");
		writer.println("Dodawanie 500 000 elementów.");
		arrayListAddTest(arrayList);
		linkedListAddTest(linkedList);
		hashSetAddTest(hashSet);
		linkedHashSetAddTest(linkedHashSet);
		treeSetAddTest(treeSet);
		System.out.println("Pobieranie 500 000 elementów.");
		writer.println("Pobieranie 500 000 elementów.");
		arrayListGetTest(arrayList);
		linkedListGetTest(linkedList);
		hashSetGetTest(hashSet);
		linkedHashSetGetTest(linkedHashSet);
		treeSetGetTest(treeSet);
		System.out.println("Sortowanie kolekcji.");
		writer.println("Sortowanie 500 000 elementów.");
		arrayListSortTest(arrayList);
		linkedListSortTest(linkedList);
		hashSetSortTest();
		linkedHashSetSortTest();
		treeSetSortTest();
		System.out.println("Usuwanie wszystkich elementów kolekcji.");
		writer.println("Usuwanie wszystkich elementów kolekcji.");
		arrayListDeleteTest(arrayList);
		linkedListDeleteTest(linkedList);
		hashSetDeleteTest(hashSet);
		linkedHashSetDeleteTest(linkedHashSet);
		treeSetDeleteTest(treeSet);
		
		writer.close();
	}

	private void arrayListAddTest(ArrayList<KlasaTestowa> arrayList) {
		Random rand = new Random(37);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			arrayList.add(new KlasaTestowa(rand.nextInt(50000000), rand
					.nextInt(50000000)));
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla ArrayList: " + sekundy);
		writer.println("Wynik dla ArrayList: " + sekundy);
	}

	private void linkedListAddTest(LinkedList<KlasaTestowa> linkedList) {
		Random rand = new Random(37);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			linkedList.add(new KlasaTestowa(rand.nextInt(50000000), rand
					.nextInt(50000000)));
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla LinkedList: " + sekundy);
		writer.println("Wynik dla LinkedList: " + sekundy);
	}

	private void hashSetAddTest(HashSet<KlasaTestowa> hashSet) {
		Random rand = new Random(37);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			hashSet.add(new KlasaTestowa(rand.nextInt(50000000), rand.nextInt(50000000)));
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla HashSet: " + sekundy);
		writer.println("Wynik dla HashSet: " + sekundy);
	}

	private void linkedHashSetAddTest(LinkedHashSet<KlasaTestowa> linkedHashSet) {
		Random rand = new Random(37);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			linkedHashSet.add(new KlasaTestowa(rand.nextInt(50000000), rand
					.nextInt(50000000)));
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla LinkedHashSet: " + sekundy);
		writer.println("Wynik dla LinkedHashSet: " + sekundy);

	}

	private void treeSetAddTest(TreeSet<KlasaTestowa> treeSet) {
		Random rand = new Random(37);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			treeSet.add(new KlasaTestowa(rand.nextInt(500000000), rand.nextInt(500000000)));
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla TreeSet: " + sekundy);
		writer.println("Wynik dla TreeSet: " + sekundy);
	}
	
	private void arrayListSortTest(ArrayList<KlasaTestowa> arrayList) {
		long start = System.currentTimeMillis();
		Collections.sort(arrayList);
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla ArrayList: " + sekundy);
		writer.println("Wynik dla ArrayList: " + sekundy);
	}

	private void linkedListSortTest(LinkedList<KlasaTestowa> linkedList) {
		long start = System.currentTimeMillis();
		Collections.sort(linkedList);
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla LinkedList: " + sekundy);
		writer.println("Wynik dla LinkedList: " + sekundy);
	}

	private void hashSetSortTest() {
		System.out.println("HashSet nie mo¿e zostaæ posortowany");
		writer.println("HashSet nie mo¿e zostaæ posortowany");
	}

	private void linkedHashSetSortTest() {
		System.out.println("LinkedHashSet nie mo¿e zostaæ posortowany");
		writer.println("LinkedHashSet nie mo¿e zostaæ posortowany");
	}

	private void treeSetSortTest() {
		System.out.println("Tree set automatycznie sortuje elementy");
		writer.println("Tree set automatycznie sortuje elementy");
	}
	
	private void arrayListGetTest(ArrayList<KlasaTestowa> arrayList) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			arrayList.get(i);
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla ArrayList: " + sekundy);
		writer.println("Wynik dla ArrayList: " + sekundy);
	}

	private void linkedListGetTest(LinkedList<KlasaTestowa> linkedList) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) {
			linkedList.get(i);
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla LinkedList: " + sekundy);
		writer.println("Wynik dla LinkedList: " + sekundy);
	}

	private void hashSetGetTest(HashSet<KlasaTestowa> hashSet) {
		long start = System.currentTimeMillis();
		Iterator iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			iterator.next();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla HashSet: " + sekundy);
		writer.println("Wynik dla HashSet: " + sekundy);
	}

	private void linkedHashSetGetTest(LinkedHashSet<KlasaTestowa> linkedHashSet) {
		long start = System.currentTimeMillis();
		Iterator iterator = linkedHashSet.iterator();
		while(iterator.hasNext()) {
			iterator.next();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla LinkedHashSet: " + sekundy);
		writer.println("Wynik dla LinkedHashSet: " + sekundy);
	}

	private void treeSetGetTest(TreeSet<KlasaTestowa> treeSet) {
		long start = System.currentTimeMillis();
		Iterator iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			iterator.next();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla TreeSet: " + sekundy);
		writer.println("Wynik dla TreeSet: " + sekundy);
	}
	
	private void arrayListDeleteTest(ArrayList<KlasaTestowa> arrayList) {
		long start = System.currentTimeMillis();
		Iterator iterator = arrayList.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla ArrayList: " + sekundy);
		writer.println("Wynik dla ArrayList: " + sekundy);
	}

	private void linkedListDeleteTest(LinkedList<KlasaTestowa> linkedList) {
		long start = System.currentTimeMillis();
		Iterator iterator = linkedList.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla LinkedList: " + sekundy);
		writer.println("Wynik dla LinkedList: " + sekundy);
	}

	private void hashSetDeleteTest(HashSet<KlasaTestowa> hashSet) {
		long start = System.currentTimeMillis();
		Iterator iterator = hashSet.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla HashSet: " + sekundy);
		writer.println("Wynik dla HashSet: " + sekundy);
	}

	private void linkedHashSetDeleteTest(LinkedHashSet<KlasaTestowa> linkedHashSet) {
		long start = System.currentTimeMillis();
		Iterator iterator = linkedHashSet.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla LinkedHashSet: " + sekundy);
		writer.println("Wynik dla LinkedHashSet: " + sekundy);
	}

	private void treeSetDeleteTest(TreeSet<KlasaTestowa> treeSet) {
		long start = System.currentTimeMillis();
		Iterator iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		long end = System.currentTimeMillis();
		long delta = end - start;
		double sekundy = delta / 10.0;
		System.out.println("Wynik dla TreeSet: " + sekundy);
		writer.println("Wynik dla TreeSet: " + sekundy);
	}
}