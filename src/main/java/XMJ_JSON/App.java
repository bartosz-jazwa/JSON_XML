package XMJ_JSON;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static String imie;
    static String nazwisko;
    static String pesel;
    final static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new XmlMapper();
        People people;
        try {
            people = objectMapper.readValue(new FileInputStream("people.xml"), People.class);
        } catch (JsonParseException e) {
            people = new People();
        }


        String kolejnaOsoba = "T";
        do {

            logger.error("Podano osobe o istniejacym Peslu");
            getUserData();
            boolean jumpOut= false;
            for (Person p: people.getPeople()) {
                if (p.getPesel().equals(pesel)){
                    System.out.println("Osoba o takim peselu juz istnieje, popraw dane");

                    jumpOut = true;
                    break;
                }
            }
            if (jumpOut){
                continue;
            }

            if (PESEL.isValidPesel(pesel)) {
                people.getPeople().add(new Person(imie, nazwisko, pesel));
                System.out.println("Czy chcesz dodać kolejna osobe? T/N");
                kolejnaOsoba = scanner.nextLine();
            } else {

                System.out.println("Nieprawidłowy pesel, popraw dane");
                continue;
            }


        } while (kolejnaOsoba.equalsIgnoreCase("T"));


        objectMapper.writeValue(new FileOutputStream("people.xml"), people);

        //readJson(objectMapper);


    }

    private static void readJson(ObjectMapper objectMapper) throws IOException {
        People newPeople = objectMapper.readValue(new FileInputStream("output.xml"), People.class);

        System.out.println(newPeople);

        ObjectMapper jsonMapper = new ObjectMapper();
        //jsonMapper.writeValue(new FileOutputStream("output.json"),people);

        People jsonPeople = jsonMapper.readValue(new FileInputStream("output.json"), People.class);

        System.out.println(jsonPeople);
    }

    public static void getUserData() {
        System.out.println("Podaj imię");
        imie = scanner.nextLine();
        System.out.println("Podaj nazwisko");
        nazwisko = scanner.nextLine();
        System.out.println("Podaj pesel");
        pesel = scanner.nextLine();
    }

}
