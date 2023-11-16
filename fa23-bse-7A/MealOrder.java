/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.labmidobserver;

/**
 *
 * @author Ashar's Book
 */
import java.util.ArrayList;
import java.util.List;

// Component interface
interface MealItem {
    float cost();
    String description();
}

// Concrete Component class
class BasicMealItem implements MealItem {
    @Override
    public float cost() {
        return 10; // Basic cost
    }

    @Override
    public String description() {
        return "Basic Meal Item";
    }
}

// Decorator class
abstract class MealDecorator implements MealItem {
    protected MealItem mealItem;

    public MealDecorator(MealItem mealItem) {
        this.mealItem = mealItem;
    }

    @Override
    public float cost() {
        return mealItem.cost();
    }

    @Override
    public String description() {
        return mealItem.description();
    }
}

// Concrete Decorator class
class DecorationDecorator extends MealDecorator {
    public DecorationDecorator(MealItem mealItem) {
        super(mealItem);
    }

    @Override
    public float cost() {
        return mealItem.cost() + 5; // Additional cost for decoration
    }

    @Override
    public String description() {
        return mealItem.description() + " with Decoration";
    }
}

// Client code
public class MealOrder {
    public static void main(String[] args) {
        MealItem basicItem = new BasicMealItem();
        MealItem decoratedItem = new DecorationDecorator(basicItem);

        System.out.println("Meal Order:");
        displayItem(basicItem);
        displayItem(decoratedItem);

        float totalCost = calculateCost(basicItem, decoratedItem);
        System.out.println("\nTotal Cost: $" + totalCost);
    }

    private static void displayItem(MealItem item) {
        System.out.println(item.description() + ", Cost: $" + item.cost());
    }

    private static float calculateCost(MealItem... items) {
        float totalCost = 0;
        for (MealItem item : items) {
            totalCost += item.cost();
        }
        return totalCost;
    }
}
