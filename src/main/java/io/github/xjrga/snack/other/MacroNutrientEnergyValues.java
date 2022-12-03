/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.xjrga.snack.other;

/**
 *
 * @author Jorge R Garcia de Alba &lt;jorge.r.garciadealba@gmail.com&gt;
 */
public class MacroNutrientEnergyValues {

    private double protein = -1.0;
    private double fat = -1.0;
    private double digestibleCarbohydrate = -1.0;
    private double alcohol = -1.0;

    public MacroNutrientEnergyValues( Builder builder ) {
        this.protein = builder.protein;
        this.fat = builder.fat;
        this.digestibleCarbohydrate = builder.digestibleCarbohydrate;
        this.alcohol = builder.alcohol;
    }

    public double getProteinEnergy() {
        return protein * 4;
    }

    public double getFatEnergy() {
        return fat * 9;
    }

    public double getDigestibleCarbohydrateEnergy() {
        return digestibleCarbohydrate * 4;
    }

    public double getAlcoholEnergy() {
        return alcohol * 6.93;
    }

    public double getEnergyDigestible() {
        return getProteinEnergy() + getFatEnergy() + getDigestibleCarbohydrateEnergy() + getAlcoholEnergy();
    }

    public double getFoodQuotient() {
        double fq = (getProteinEnergy() / getEnergyDigestible()) * 0.81
                + (getFatEnergy() / getEnergyDigestible()) * 0.71
                + (getDigestibleCarbohydrateEnergy() / getEnergyDigestible()) * 1
                + (getAlcoholEnergy() / getEnergyDigestible()) * 0.667;
        return fq;
    }

    public double get_energy_fat_and_carbohydrate() {
        return getFatEnergy() + getDigestibleCarbohydrateEnergy();
    }

    public static class Builder {

        private double protein = -1;
        private double fat = -1;
        private double digestibleCarbohydrate = -1;
        private double alcohol = -1;

        public Builder() {
        }

        public Builder protein( double protein ) {
            this.protein = protein;
            return this;
        }

        public Builder fat( double fat ) {
            this.fat = fat;
            return this;
        }

        public Builder digestibleCarbohydrate( double digestibleCarbohydrate ) {
            this.digestibleCarbohydrate = digestibleCarbohydrate;
            return this;
        }

        public Builder alcohol( double alcohol ) {
            this.alcohol = alcohol;
            return this;
        }

        private boolean isComplete() {
            boolean isComplete = false;
            if ( protein != -1 && fat != -1 && digestibleCarbohydrate != -1 && alcohol != -1 ) {
                isComplete = true;
            }
            return isComplete;
        }

        public MacroNutrientEnergyValues build() {
            if ( isComplete() ) {
                return new MacroNutrientEnergyValues( this );
            } else {
                throw new UnsupportedOperationException( "Not all parameters are set." );
            }

        }
    }

}
