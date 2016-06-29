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

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return 0;
    }
}
