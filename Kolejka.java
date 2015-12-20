
import java.util.LinkedList;
import java.util.NoSuchElementException;

interface iKolejka<E extends Comparable<E>> {
	void push(E obj);

	E pop();

	boolean isEmpty();
}

enum Typ {
	FIFO, LIFO
}

enum Priority {
	URGENT,
	NORMAL,
	LOW
}

class Wiadomosc implements Comparable<Wiadomosc> {
	private int id;
	private static int number = 0;
	private String tresc;
	private Priority priority;
	
	public Wiadomosc(String tresc, Priority priority) {
		id = ++number;
		this.tresc = tresc;
		this.priority = priority;
	}
	
	public Wiadomosc(Priority priority) {
		id = ++number;
		this.priority = priority;
	}

	public int getId() {
		return id;
	}

	public String getTresc() {
		return tresc;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

	@Override
	public int compareTo(Wiadomosc o) {
		if(this.getPriority() == o.getPriority()) {
			return 0;
		}
		else if(this.getPriority() == Priority.URGENT && (o.getPriority() == Priority.NORMAL || o.getPriority() == Priority.LOW)) {
			return 1;
		}
		else if(this.getPriority() == Priority.NORMAL && o.getPriority() == Priority.LOW) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	@Override
	public String toString() {
		return tresc;
	}
	
}

public class Kolejka<E extends Comparable<E>> implements iKolejka<E> {
	iKolejka<E> kolejka;

	public Kolejka(Typ typ) {
		if (typ == Typ.FIFO) {
			this.kolejka = new KolejkaFIFO<E>();
		} else if (typ == Typ.LIFO) {
			this.kolejka = new KolejkaLIFO<E>();
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void push(E obj) {
		kolejka.push(obj);
	}

	@Override
	public E pop() {
		return kolejka.pop();
	}

	@Override
	public boolean isEmpty() {
		return kolejka.isEmpty();
	}
	
	@Override
	public String toString() {
		return kolejka.toString();
	}
}

class KolejkaFIFO<E extends Comparable<E>> implements iKolejka<E> {
	private LinkedList<E> lista = new LinkedList<>();

	@Override
	public void push(E obj) {
		
		if(lista.isEmpty()) {
			lista.add(obj);
		}
		else {
			for(int i=0;i<lista.size();i++) {
				if(obj.compareTo(lista.get(i)) < 0) {
					lista.add(i, obj);
					break;
				}
				else if(lista.size()-i == 1) {
					lista.add(i+1, obj);
					break;
				}
			}
		}
	}

	@Override
	public E pop() {
		if (!this.isEmpty()) {
			return lista.removeLast();
		}
		else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder();
		for(E p : lista) {
			temp.append("[" + p.toString() + "] ");
		}
		return temp.toString();
	}
}

class KolejkaLIFO<E extends Comparable<E>> implements iKolejka<E> {
	private LinkedList<E> lista = new LinkedList<>();

	@Override
	public void push(E obj) {
		if(lista.isEmpty()) {
			lista.add(obj);
		}
		else {
			for(int i=0;i<lista.size();i++) {
				if(obj.compareTo(lista.get(i)) < 0) {
					lista.add(i, obj);
					break;
				}
				else if(lista.size()-i == 1) {
					lista.add(i+1, obj);
					break;
				}
			}
		}
	}

	@Override
	public E pop() {
		if (!this.isEmpty()) {
			return lista.removeFirst();
		}
		else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder();
		for(E p : lista) {
			temp.append("[" + p.toString() + "] ");
		}
		return temp.toString();
	}
}