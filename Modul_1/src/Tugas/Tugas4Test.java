package Tugas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tugas4Test {

    @Test
    void Skenario1() {
        assertEquals (3, Tugas4.findMin(1, 2, 3));
    }

    @Test
    void Skenario2() {
        assertEquals (-1, Tugas4.findMin(-1, -2, -3));
    }

    @Test
    void Skenario3() {
        assertEquals (0, Tugas4.findMin(0, 0, 1));
    }
}