package io.github.xjrga.snack.dataobject;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author jr
 */
public class Lhs {

    private final Integer rownum;
    private final String name;
    private final BigDecimal coefficient;

    public Lhs(Integer rownum, String name, BigDecimal c) {

        this.rownum = rownum;
        this.name = name;
        this.coefficient = c;
    }

    public Integer getRownum() {

        return rownum;
    }

    public String getName() {

        return name;
    }

    public BigDecimal getCoefficient() {

        return coefficient;
    }

    @Override
    public String toString() {

        return "Lhs{" + "rownum=" + rownum + ", name=" + name + ", c=" + coefficient + '}';
    }

    @Override
    public int hashCode() {

        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.rownum);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {

            return true;
        }

        if (obj == null) {

            return false;
        }

        if (getClass() != obj.getClass()) {

            return false;
        }

        final Lhs other = (Lhs) obj;
        return Objects.equals(this.rownum, other.rownum);
    }
}
