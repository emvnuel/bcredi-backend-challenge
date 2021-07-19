package domain.model;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Proponent {

    private UUID id;
    private String name;
    @Min(value = 18)
    private Integer age;
    private BigDecimal monthlyIncome;
    private Boolean isMain;

    public Proponent(UUID id, String name, Integer age, BigDecimal income, Boolean isMain) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.monthlyIncome = income;
        this.isMain = isMain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proponent proponent = (Proponent) o;
        return Objects.equals(id, proponent.id);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }

    public Boolean getMain() {
        return isMain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
