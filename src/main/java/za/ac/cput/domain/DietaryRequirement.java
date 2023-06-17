/**
 * DietaryRequirement.java
 * Entity for the Dietary Requirement
 * Author: Monique Casey Smith (217041701)
 * Date: 06 April 2023
 */

package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

public class DietaryRequirement implements Serializable {
    private String dietaryRequirementID;
    private String name;
    private String specialRequirements;

    private DietaryRequirement() {
    }

    private DietaryRequirement(Builder builder) {
        this.dietaryRequirementID = builder.dietaryRequirementID;
        this.name = builder.name;
        this.specialRequirements = builder.specialRequirements;
    }

    public String getDietaryRequirementID() {
        return dietaryRequirementID;
    }

    public void setDietaryRequirementID(String dietaryRequirementID) {
        this.dietaryRequirementID = dietaryRequirementID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialRequirements() {
        return specialRequirements;
    }

    public void setSpecialRequirements(String specialRequirements) {
        this.specialRequirements = specialRequirements;
    }

    public static class Builder {
        private String dietaryRequirementID;
        private String name;
        private String specialRequirements;

        public Builder setDietaryRequirementID(String dietaryRequirementID) {
            this.dietaryRequirementID = dietaryRequirementID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSpecialRequirements(String specialRequirements) {
            this.specialRequirements = specialRequirements;
            return this;
        }

        public Builder copy(DietaryRequirement dietaryRequirement) {
            this.dietaryRequirementID = dietaryRequirement.dietaryRequirementID;
            this.name = dietaryRequirement.name;
            this.specialRequirements = dietaryRequirement.specialRequirements;
            return this;
        }

        public DietaryRequirement build() {
            return new DietaryRequirement(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DietaryRequirement that = (DietaryRequirement) o;
        return dietaryRequirementID.equals(that.dietaryRequirementID) && name.equals(that.name) && specialRequirements.equals(that.specialRequirements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dietaryRequirementID, name, specialRequirements);
    }

    @Override
    public String toString() {
        return "domain.DietaryRequirement{" +
                "dietaryRequirementID='" + dietaryRequirementID + '\'' +
                ", name='" + name + '\'' +
                ", specialRequirements='" + specialRequirements + '\'' +
                '}';
    }
}
