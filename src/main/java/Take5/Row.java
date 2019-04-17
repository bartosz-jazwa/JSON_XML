package Take5;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Row {
    @JacksonXmlProperty(localName = "winning_numbers")
    String winningNumber;

    public Row(String winningNumber) {
        this.winningNumber = winningNumber;
    }

    public Row() {
    }
}
