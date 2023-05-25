package com.fiham.needyfood.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fiham.needyfood.pojo.Meal
import com.fiham.needyfood.pojo.MealList
import com.fiham.needyfood.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel() : ViewModel() {

    private  var randomMealLivedata = MutableLiveData<Meal>()

    fun getRandomMeal() {

        RetrofitInstance.api.getRandomMeal().enqueue(object : Callback<MealList> {

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {

                    val randomMeal: Meal = response.body()!!.meals[0]
                    randomMealLivedata.value = randomMeal
                }else{
                    return
                }
            }
            override fun onFailure(call: Call<MealList>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun observeRandomMealLivedata () : LiveData <Meal> {
      return  randomMealLivedata
    }


}