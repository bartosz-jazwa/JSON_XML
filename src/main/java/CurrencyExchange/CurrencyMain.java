package CurrencyExchange;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.net.URL;

public class CurrencyMain {
    public static void main(String[] args) throws IOException {
        URL tabelaNbp = new URL("http://api.nbp.pl/api/exchangerates/rates/a/eur/2018-12-12/?format=xml");
        ObjectMapper objectMapper =  new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        ExchangeRatesSeries tabelaKursowSr = objectMapper.readValue(tabelaNbp,ExchangeRatesSeries.class);

        URL tabela = new URL("http://api.nbp.pl/api/exchangerates/rates/c/eur/2018-12-12/?format=xml");
        objectMapper =  new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        ExchangeRates tabelaKursow = objectMapper.readValue(tabela,ExchangeRates.class);

        System.out.println(tabelaKursowSr.code+": "+
                tabelaKursowSr.rates.get(0).getDate()+ " "
                + tabelaKursow.rates.get(0).ask+" "+
                tabelaKursow.rates.get(0).bid+" "+
                tabelaKursowSr.rates.get(0).getRate());

    }
}
