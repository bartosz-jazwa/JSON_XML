package CurrencyExchange;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDate;

public class Rate {
    @JacksonXmlProperty(localName = "EffectiveDate")
    String effectiveDate;
    @JacksonXmlProperty(localName = "Bid")
    String bid;
    @JacksonXmlProperty(localName = "Ask")
    String ask;

    public Float getBidRate(){
        return Float.parseFloat(bid);
    }
    public Float getAskRate(){
        return Float.parseFloat(bid);
    }
    public LocalDate getDate(){
        return LocalDate.parse(effectiveDate);
    }
}
