package WalutyNBP;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class TabelaKursow {
    @JacksonXmlProperty(localName = "data_publikacji")
    String  dataPublikacji;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "pozycja")
    List<Pozycja> pozycje;

    public TabelaKursow() {
    }
}
