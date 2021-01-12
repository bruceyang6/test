package com.example.demo.nutrition;

/**
 * @Author: bruce
 * @Version: V1.0
 * @Package: com.example.demo.nutrition
 * @Description:
 * @Dept: 星创产品部
 * @Date: Created in 2020/9/9 17:04
 */
public class NutritionFactory {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int calbohydrate;


    public static class Builder{
        //Required Parameters
        private final int servingSize;
        private final int servings;

        //Optional Parameters
        private int calories     = 0;
        private int fat          = 0;
        private int sodium       = 0;
        private int calbohydrate = 0;

        public Builder(int servingSize,int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int val){
            calories = val;
            return this;
        }
        public Builder fat(int val){
            fat = val;
            return this;
        }
        public Builder sodium(int val){
            sodium = val;
            return this;
        }
        public Builder calbohydrate(int val){
            calbohydrate = val;
            return this;
        }
        public NutritionFactory builder(){
            return new NutritionFactory(this);
        }
    }

    public NutritionFactory(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        calbohydrate = builder.calbohydrate;
    }



}
