package com.example.reallyseriousapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.reallyseriousapp.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var countryInfoViewModel : CountryInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = countryInfoViewModel
        testViewModel()
    }

    private fun testViewModel() {
        countryInfoViewModel.getSingleTypeCountryByName("China")
    }

    override fun onDestroy() {
        super.onDestroy()
        countryInfoViewModel.clearDisposable()
    }
}
