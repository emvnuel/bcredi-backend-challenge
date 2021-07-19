package domain.model;

import domain.validation.ValidProvince;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Warranty {

    private UUID uuid;
    private BigDecimal value;

    @ValidProvince
    private Province province;

    public Warranty(UUID uuid, BigDecimal value, Province province) {
        this.uuid = uuid;
        this.value = value;
        this.province = province;
    }

    public UUID getUuid() {
        return uuid;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Province getProvince() {
        return province;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warranty warranty = (Warranty) o;
        return Objects.equals(uuid, warranty.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
