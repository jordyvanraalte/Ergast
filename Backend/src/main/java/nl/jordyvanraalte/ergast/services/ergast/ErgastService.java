package nl.jordyvanraalte.ergast.services.ergast;

import nl.jordyvanraalte.ergast.entities.Response;
import nl.jordyvanraalte.ergast.entities.Table;
import org.springframework.core.ParameterizedTypeReference;

import java.util.ArrayList;

public interface ErgastService<T extends Table>  {

    public T Fetch(String endpoint, ParameterizedTypeReference<Response<T>> ref) throws NullPointerException, Exception;
    public ArrayList<T> FetchALL(String endpoint,  ParameterizedTypeReference<Response<T>> ref) throws NullPointerException, Exception;
}
