package br.com.munieri.stream;

import java.util.*;

public class App {

    public static char firstCommonChar(Stream stream) {

        Map<Character, Integer> chars = new LinkedHashMap();

        while (stream.hasNext()) {
            final char next = stream.getNext();
            int size = chars.getOrDefault(next, 0);
            ++size;
            chars.put(next, size);
        }

        boolean found = false;
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if(entry.getValue() == 1){
                found = true;
                return entry.getKey();
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Não foi encontrato caracter com apenas uma ocorrência.");
        }
        return 0;
    }
}
