package Take5;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByValue;

public class Take5 {

    public static void main(String[] args) throws IOException {

        URL lotteryUrl = new URL("https://data.ny.gov/api/views/dg63-4siq/rows.xml?accessType=DOWNLOAD");
        //URLConnection connection = lotteryUrl.openConnection();

        ObjectMapper objectMapper =  new XmlMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        Response response;

        response = objectMapper.readValue(lotteryUrl,Response.class);
        //response = objectMapper.readValue(new FileInputStream("rows.xml"),Response.class);

        Map<Integer, Long> stats =  response.rows.stream()
                .map(row -> row.winningNumber)
                .flatMap(row -> Stream.of(row.split(" ")))
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        Map<Integer, Long> sortStat = stats.entrySet().stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(i, l)->l+i, LinkedHashMap::new));
        sortStat.entrySet().forEach(System.out::println);
    }
}
