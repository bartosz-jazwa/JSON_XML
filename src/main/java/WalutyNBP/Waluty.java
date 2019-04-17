package WalutyNBP;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.net.URL;

public class Waluty {

    public static void main(String[] args) throws IOException {
        URL tabelaNbp = new URL("https://www.nbp.pl/kursy/xml/a244z181217.xml");
        ObjectMapper objectMapper =  new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        TabelaKursow tabelaKursow = objectMapper.readValue(tabelaNbp,TabelaKursow.class);



    }

}
