package WalutyNBP;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Pozycja {
    @JacksonXmlProperty(localName = "nazwa_waluty")
    String nazwaWaluty;
    @JacksonXmlProperty(localName = "przelicznik")
    int przelicznik;
    @JacksonXmlProperty(localName = "kod_waluty")
    String kodWaluty;
    @JacksonXmlProperty(localName = "kurs_sredni")
    String kursSredni;

    public Pozycja() {
    }
}
