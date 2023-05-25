package com.fiham.needyfood.retrofit

import com.fiham.needyfood.pojo.MealList
import retrofit2.Call
import retrofit2.http.GET

interface MealApi {
    @GET ("random.php")
    fun getRandomMeal() : Call <MealList>


}