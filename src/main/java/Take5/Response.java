package Take5;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Response {
    @JacksonXmlElementWrapper(useWrapping = true)
    @JacksonXmlProperty(localName = "row")
    List<Row> rows;

    public Response(List<Row> rows) {
        this.rows = rows;
    }

    public Response() {
    }
}
