import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Testy {

	@Test
	public void customowaListaTest1() {
		CustomowaLista<String> lista = new CustomowaLista<>();

		lista.add("Je¿");
		lista.add("Koñ");
		lista.add("Kaczka");

		assertEquals(lista.get(0), "Je¿");
		assertEquals(lista.get(1), "Koñ");
		assertEquals(lista.get(2), "Kaczka");
	}

	@Test
	public void customowaListaTest2() {
		CustomowaLista<String> lista = new CustomowaLista<>();

		lista.addAll("Je¿", "Koñ", "Kaczka");

		assertEquals(lista.get(0), "Je¿");
		assertEquals(lista.get(1), "Koñ");
		assertEquals(lista.get(2), "Kaczka");
	}

	@Test
	public void customowaListaTest3() {
		CustomowaLista<Integer> lista = new CustomowaLista<>();

		List<Integer> intLista = new ArrayList<>();

		intLista.add(42);
		intLista.add(41);
		intLista.add(44);
		intLista.add(46);

		lista.addAll(intLista);

		lista.remove(2);

		assertEquals(lista.get(2), new Integer(46));

	}

	@Test
	public void wiadomoscTest() {
		Wiadomosc wiadomoscUrg = new Wiadomosc("Wazna wiadomosc",
				Priority.URGENT);
		Wiadomosc wiadomoscNorm = new Wiadomosc("Wazna wiadomosc",
				Priority.NORMAL);
		Wiadomosc wiadomoscLow = new Wiadomosc("Wazna wiadomosc", Priority.LOW);

		assertEquals(wiadomoscUrg.compareTo(wiadomoscUrg), 0);
		assertEquals(wiadomoscUrg.compareTo(wiadomoscNorm), 1);
		assertEquals(wiadomoscUrg.compareTo(wiadomoscLow), 1);
		assertEquals(wiadomoscNorm.compareTo(wiadomoscUrg), -1);
		assertEquals(wiadomoscNorm.compareTo(wiadomoscNorm), 0);
		assertEquals(wiadomoscNorm.compareTo(wiadomoscLow), 1);
		assertEquals(wiadomoscLow.compareTo(wiadomoscUrg), -1);
		assertEquals(wiadomoscLow.compareTo(wiadomoscNorm), -1);
		assertEquals(wiadomoscLow.compareTo(wiadomoscLow), 0);

	}

	@Test
	public void fifoTest() {
		Kolejka<Wiadomosc> kolejka = new Kolejka<>(Typ.FIFO);

		int i = 0;
		while (i < 100) {

			Wiadomosc urg = new Wiadomosc(Priority.URGENT);
			urg.setTresc("Wazna wiadomosc");

			Wiadomosc norm = new Wiadomosc(Priority.NORMAL);
			norm.setTresc("Normalna wiadomosc");

			Wiadomosc low = new Wiadomosc(Priority.LOW);
			low.setTresc("Malo wazna wiadomosc");

			kolejka.push(urg);
			kolejka.push(norm);
			kolejka.push(low);

			i++;
		}
		
		assertEquals(kolejka.pop().getTresc(), "Wazna wiadomosc");
		assertEquals(kolejka.pop().getId()-kolejka.pop().getId() > 0, true);
	}

	@Test(expected = NoSuchElementException.class)
	public void queueExcTest() {
		Kolejka<Wiadomosc> kolejka = new Kolejka<>(Typ.FIFO);

		kolejka.pop();

	}

	@Test(expected = IllegalArgumentException.class)
	public void queueExcTest2() {
		Kolejka<Wiadomosc> kolejka = new Kolejka<>(null);
	}
	
	@Test
	public void emptyQueueTest() {
		Kolejka<Wiadomosc> kolejka = new Kolejka<>(Typ.FIFO);
		
		assertEquals(kolejka.isEmpty(), true);
		
		kolejka.push(new Wiadomosc("Nowa wiadomosc", Priority.NORMAL));
		
		assertEquals(kolejka.isEmpty(), false);
		
		
	}

	@Test
	public void lifoTest() {
		Kolejka<Wiadomosc> kolejka = new Kolejka<>(Typ.LIFO);

		int i = 0;
		while (i < 100) {

			Wiadomosc urg = new Wiadomosc(Priority.URGENT);
			urg.setTresc("Wazna wiadomosc");

			Wiadomosc norm = new Wiadomosc(Priority.NORMAL);
			norm.setTresc("Normalna wiadomosc");

			Wiadomosc low = new Wiadomosc(Priority.LOW);
			low.setTresc("Malo wazna wiadomosc");

			kolejka.push(urg);
			kolejka.push(norm);
			kolejka.push(low);

			i++;
		}
		
		System.out.println(kolejka);

		assertEquals(kolejka.pop().getTresc(), "Malo wazna wiadomosc");
		assertEquals(kolejka.pop().getId()-kolejka.pop().getId() < 0, true);
	}
	
	@Test
	public void porownywarkaTest() throws FileNotFoundException, UnsupportedEncodingException {
		Porownywarka porownywarka = new Porownywarka();
		
		porownywarka.porownaj();
	}

	// lepiej uzywac eclipsowego pluginu i odpalac jako unit testy zamiast java
	// application
	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(Testy.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}