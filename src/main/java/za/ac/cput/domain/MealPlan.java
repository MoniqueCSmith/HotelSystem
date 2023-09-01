/**
 * MealPlan.java
 * Entity for the Meal Plan
 * Author: Monique Casey Smith (217041701)
 * Date: 06 April 2023
 */

package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class MealPlan implements Serializable {

    @Id
    private String mealPlanID;
    private String name;
    private String description;
    private String mealType;
    private double price;
    @Embedded
    private DietaryRequirement dietaryRequirement;

    protected MealPlan() {
    }

    private MealPlan(Builder builder) {
        this.mealPlanID = builder.mealPlanID;
        this.name = builder.name;
        this.description = builder.description;
        this.mealType = builder.mealType;
        this.price = builder.price;
        this.dietaryRequirement = builder.dietaryRequirement;
    }

    public String getMealPlanID() {
        return mealPlanID;
    }

    public void setMealPlanID(String mealPlanID) {
        this.mealPlanID = mealPlanID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DietaryRequirement getDietaryRequirement() {
        return dietaryRequirement;
    }

    public void setDietaryRequirement(DietaryRequirement dietaryRequirement) {
        this.dietaryRequirement = dietaryRequirement;
    }

    public static class Builder {
        private String mealPlanID;
        private String name;
        private String description;
        private String mealType;
        private double price;
        private DietaryRequirement  dietaryRequirement;

        public Builder setMealPlanID(String mealPlanID) {
            this.mealPlanID = mealPlanID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setMealType(String mealType) {
            this.mealType = mealType;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setDietaryRequirement(DietaryRequirement dietaryRequirement) {
            this.dietaryRequirement = dietaryRequirement;
            return this;
        }

        public Builder copy(MealPlan mealPlan) {
            this.mealPlanID = mealPlan.mealPlanID;
            this.name = mealPlan.name;
            this.description = mealPlan.description;
            this.mealType = mealPlan.mealType;
            this.price = mealPlan.price;
            this.dietaryRequirement = mealPlan.dietaryRequirement;
            return this;
        }

        public MealPlan build() {
            return new MealPlan(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealPlan mealPlan = (MealPlan) o;
        return Double.compare(mealPlan.price, price) == 0 && mealPlanID.equals(mealPlan.mealPlanID) && name.equals(mealPlan.name) && description.equals(mealPlan.description) && mealType.equals(mealPlan.mealType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealPlanID, name, description, mealType, price);
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "mealPlanID='" + mealPlanID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mealType='" + mealType + '\'' +
                ", price=" + price +
                ", dietaryRequirement=" + dietaryRequirement +
                '}';
    }
}
