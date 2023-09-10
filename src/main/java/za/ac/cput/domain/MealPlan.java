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

    public static int nextMealPlanId = 1;
    @Enumerated(EnumType.STRING)
    @Column(name = "dietary_requirement")
    private DietaryRequirementEnum dietaryRequirementEnum;

    protected MealPlan() {
    }

    private MealPlan(Builder builder) {
        this.mealPlanID = builder.mealPlanID;
        this.name = builder.name;
        this.description = builder.description;
        this.mealType = builder.mealType;
        this.price = builder.price;
        this.dietaryRequirementEnum = builder.dietaryRequirementEnum;
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

    public DietaryRequirementEnum getDietaryRequirementEnum() {
        return dietaryRequirementEnum;
    }

    public void setDietaryRequirementEnum(DietaryRequirementEnum dietaryRequirementEnum) {
        this.dietaryRequirementEnum = dietaryRequirementEnum;
    }


    public static class Builder {

        private String mealPlanID;
        private String name;
        private String description;
        private String mealType;
        private double price;
        private DietaryRequirementEnum  dietaryRequirementEnum;

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

        public Builder setDietaryRequirementEnum(DietaryRequirementEnum dietaryRequirementEnum) {
            this.dietaryRequirementEnum = dietaryRequirementEnum;
            return this;
        }

        public Builder copy(MealPlan mealPlan) {
            this.mealPlanID = mealPlan.mealPlanID;
            this.name = mealPlan.name;
            this.description = mealPlan.description;
            this.mealType = mealPlan.mealType;
            this.price = mealPlan.price;
            this.dietaryRequirementEnum = mealPlan.dietaryRequirementEnum;
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
        return Double.compare(mealPlan.price, price) == 0 && Objects.equals(mealPlanID, mealPlan.mealPlanID) && Objects.equals(name, mealPlan.name) && Objects.equals(description, mealPlan.description) && Objects.equals(mealType, mealPlan.mealType) && dietaryRequirementEnum == mealPlan.dietaryRequirementEnum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealPlanID, name, description, mealType, price, dietaryRequirementEnum);
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "mealPlanID='" + mealPlanID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mealType='" + mealType + '\'' +
                ", price=" + price +
                ", dietaryRequirementEnum=" + dietaryRequirementEnum +
                '}';
    }
}
