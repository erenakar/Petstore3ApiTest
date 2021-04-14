package io.swagger.model.store;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderShipDate {
    private String timeStamp;

    @JsonCreator
    public OrderShipDate(@JsonProperty("shipDate") String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public OrderShipDate(Date date) {
        this.timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+00:00'").format(date);
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public OrderShipDate setTimeStamp(Date date) {
        this.timeStamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+00:00'").format(date);

        return this;
    }
}
