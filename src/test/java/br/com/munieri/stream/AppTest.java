package br.com.munieri.stream;

import org.testng.annotations.Test;

import java.util.Date;

import static org.testng.Assert.*;

public class AppTest {

    private char firstUniqueChar(Stream stream) {
        Long timeStart = new Date().getTime();
        char result = App.firstCommonChar(stream);
        Long timeEnd = new Date().getTime();
        System.out.println("Time[" + (timeEnd - timeStart) + "]ms");
        return result;
    }

    @Test
    public void should_return_b() {
        String input = "aAbBABac";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'b');

    }

    @Test
    public void should_return_A() {
        String input = "ABB";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'A');

    }

    @Test
    public void should_return_1() {
        String input = "ABCDEFABCDEF1";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, '1');

    }

    @Test
    public void should_return_Z() {
        String input = "AAAAAAAAAAAAAAAAAAAAAAAAAAZ";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'Z');

    }

    @Test
    public void should_return_X() {
        String input = "XAAAAAAAAAAAAAAAAAAAAAAAAAA";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'X');

    }

    @Test
    public void should_return_first_char_from_all_uniques() {
        String input = "QWERTYUIOPASDFGHJKLZXCVBNM!@#$%^&*()1234567890_+-=";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);
        assertEquals(result, 'Q');

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void should_throw_exception(){
        String input = "AABB";
        Stream stream = new StreamImpl(input);

        char result = firstUniqueChar(stream);

    }
}