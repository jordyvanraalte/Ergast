package nl.jordyvanraalte.ergast.services.impl.ergast;

import nl.jordyvanraalte.ergast.entities.Response;
import nl.jordyvanraalte.ergast.entities.Table;
import nl.jordyvanraalte.ergast.services.ergast.ErgastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Objects;

public abstract class ErgastServiceImpl<T extends Table> implements ErgastService<T> {
    @Value( "${ergast.url}" )
    private String ergastUrl;

    @Autowired
    RestTemplate restTemplate;

    public T Fetch(String endpoint, ParameterizedTypeReference<Response<T>> ref) throws NullPointerException, Exception {
        ResponseEntity<Response<T>> response =
                restTemplate.exchange(
                        String.format("%s%s", ergastUrl, endpoint),
                        HttpMethod.GET,
                        null,
                        ref);

        if(!response.getStatusCode().is2xxSuccessful())
            throw new Exception("Error fetching data from Ergast API");

        return Objects.requireNonNull(response.getBody()).getMRData().getTable();
    }

    public ArrayList<T> FetchALL(String endpoint, ParameterizedTypeReference<Response<T>> ref) throws NullPointerException, Exception {
        ResponseEntity<Response<T>> firstResponse =
                restTemplate.exchange(
                        String.format("%s%s", ergastUrl, endpoint),
                        HttpMethod.GET,
                        null,
                        ref);

        if(!firstResponse.getStatusCode().is2xxSuccessful())
            throw new Exception("Error fetching data from Ergast API");

        ArrayList<T> tables = new ArrayList<>();
        int offset = Integer.parseInt(Objects.requireNonNull(firstResponse.getBody()).getMRData().getLimit());
        int total = Integer.parseInt(firstResponse.getBody().getMRData().getTotal());
        tables.add(firstResponse.getBody().getMRData().getTable());

        while(offset < total) {
            ResponseEntity<Response<T>> response =
                    restTemplate.exchange(
                            String.format("%s%s?offset=%d", ergastUrl, endpoint, offset),
                            HttpMethod.GET,
                            null,
                           ref);

            if(!firstResponse.getStatusCode().is2xxSuccessful())
                throw new Exception("Error fetching data from Ergast API through offset");

            tables.add(Objects.requireNonNull(response.getBody()).getMRData().getTable());

            offset += Integer.parseInt(response.getBody().getMRData().getLimit());
        }

        return tables;
    }

}
