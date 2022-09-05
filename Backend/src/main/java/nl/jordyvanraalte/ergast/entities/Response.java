package nl.jordyvanraalte.ergast.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MRData"
})
public class Response<T extends Table> {

    @JsonProperty("MRData")
    private MRData<T> mRData;

    @JsonProperty("MRData")
    public MRData<T> getMRData() {
        return mRData;
    }
}
