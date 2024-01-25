package com.example.primera_api_reset.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;
@Embeddable
@Data
public class ResultKey implements Serializable {
    private Long raceid;
    private Long driverid;

    //metodo equals y hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultKey)) return false;
        ResultKey that = (ResultKey) o;
        return Objects.equals(raceid, that.raceid) &&
                Objects.equals(driverid, that.driverid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceid, driverid);
    }


}
