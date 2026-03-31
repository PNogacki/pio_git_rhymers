package edu.kis.vh.nursery;

/**
 * Klasa DefaultCountingOutRhymer implementuje prosty licznik oparty na stosie
 * o stałej pojemności.
 */
public class DefaultCountingOutRhymer {

    public static final int CAPACITY = 12;
    public static final int EMPTY = -1;

    private final int[] numbers = new int[CAPACITY];
    private int total = EMPTY;

    public int getTotal() {
        return total;
    }

    /**
     * Dodaje nową wartość do licznika, jeśli nie został osiągnięty limit
     * pojemności.
     * 
     * @param in Wartość całkowita do dodania.
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * Sprawdza, czy licznik jest pusty.
     * 
     * @return true, jeśli licznik nie zawiera żadnych elementów; w przeciwnym razie
     *         false.
     */
    public boolean callCheck() {
        return total == EMPTY;
    }

    /**
     * Sprawdza, czy licznik osiągnął maksymalną pojemność.
     * 
     * @return true, jeśli tablica jest pełna; w przeciwnym razie false.
     */
    public boolean isFull() {
        return total == CAPACITY - 1;
    }

    /**
     * Pozwala podejrzeć ostatnio dodaną wartość bez jej usuwania.
     * 
     * @return Ostatnia wartość w liczniku lub {@value #EMPTY}, jeśli licznik jest
     *         pusty.
     */
    protected int peekaboo() {
        if (callCheck())
            return EMPTY;
        return numbers[total];
    }

    /**
     * Pobiera i usuwa ostatnio dodaną wartość z licznika.
     * 
     * @return Ostatnia wartość lub {@value #EMPTY}, jeśli nie ma elementów do
     *         pobrania.
     */
    public int countOut() {
        if (callCheck())
            return EMPTY;
        return numbers[total--];
    }

}
