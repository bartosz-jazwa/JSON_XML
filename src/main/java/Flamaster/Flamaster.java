package Flamaster;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flamaster {

    public static void main(String[] args) throws IOException {

        String s = flamasterString("AAbCCCdd");
        Path path = Paths.get("litery.txt");
        List<String> litery = Files.lines(path).collect(Collectors.toList());

        List<String> resultString = new ArrayList<>();
        int loopCounter = Integer.parseInt(litery.get(0));
        for (int i = 1; i <= loopCounter; i++) {
            resultString.add(flamasterString(litery.get(i)));
        }

        Files.write(path, resultString, StandardOpenOption.APPEND);
    }


    public static String flamasterString(String s) {

        char[] characters = s.toCharArray();
        int counter = 1;
        StringBuilder stringBuilder = new StringBuilder();


        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == characters[i + 1]) {
                counter++;
            } else {
                stringBuilder.append(characters[i]);
                if (counter > 1) {
                    stringBuilder.append(counter);
                }
                counter = 1;
            }
            if (i == characters.length - 2) {
                stringBuilder.append(characters[i + 1]);
                if (counter > 1) {
                    stringBuilder.append(counter);
                }
            }

        }
        return stringBuilder.toString();

    }
}
