import java.util.Arrays;import java.util.Collection;public class CustomowaLista<E> { private Object tab[]; private int wielkosc = 0; public CustomowaLista() { tab = new Object[10]; } public void add(E obj) { if (wielkosc == tab.length) {tab = Arrays.copyOf(tab, tab.length +1);} tab[wielkosc++] = obj;}public void addAll(Collection<E> kolekcja) {for(E p : kolekcja) {this.add(p);}}@SuppressWarnings("unchecked") public void addAll(E... args) {for(E p : args) {	this.add(p);}}@SuppressWarnings("unchecked")public E get(int index) {	if (index < 0 || index >= wielkosc) {throw new ArrayIndexOutOfBoundsException();}		return (E)tab[index];}@SuppressWarnings("unchecked")public E remove(int index) {	if (index < 0 || index >= wielkosc) {		throw new ArrayIndexOutOfBoundsException();	}Object removedElement = tab[index];for (int i = index; i < wielkosc;) {	tab[i] = tab[++i];}wielkosc--;return (E)removedElement;}public boolean isEmpty() {return wielkosc==0;}public int size() {	return wielkosc;}@Override public String toString() {StringBuilder temp = new StringBuilder();for(int i=0;i<wielkosc;i++) {temp.append("[" + tab[i].toString() + "]");if(wielkosc-i!=1) {temp.append(", ");}else {temp.append(".");}}return temp.toString();}}