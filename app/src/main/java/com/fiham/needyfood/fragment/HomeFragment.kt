package com.fiham.needyfood.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.fiham.needyfood.R
import com.fiham.needyfood.databinding.FragmentHomeBinding
import com.fiham.needyfood.pojo.Meal
import com.fiham.needyfood.pojo.MealList
import com.fiham.needyfood.retrofit.RetrofitInstance
import com.fiham.needyfood.viewmodel.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private  lateinit var  binding: FragmentHomeBinding
    private  lateinit var  homeMvvm : HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        homeMvvm = ViewModelProviders.of(this)[HomeViewModel::class.java]


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeMvvm.getRandomMeal()
        observerRandomMeal ()

    }

    private fun observerRandomMeal() {
       homeMvvm.observeRandomMealLivedata().observe(viewLifecycleOwner, object : Observer<Meal> {
           override fun onChanged(value: Meal) {
               Glide.with(this@HomeFragment)
                   .load(value.strMealThumb)
                   .into(binding.imgRandomMeal)

           }
       })
    }

}