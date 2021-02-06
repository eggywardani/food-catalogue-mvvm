package com.eggy.foodapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.eggy.foodapp.R
import com.eggy.foodapp.adapter.FoodAdapter
import com.eggy.foodapp.databinding.ActivityMainBinding
import com.eggy.foodapp.model.ResultsItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvShimmer.startShimmer()
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]
        viewModel.setData().observe(this, Observer {
            binding.rvShimmer.stopShimmer()
            binding.listFood.visibility = View.VISIBLE
            binding.rvShimmer.visibility = View.INVISIBLE
            showData(it.results)

        })


    }


    private fun showData(data: List<ResultsItem?>?) {
        binding.listFood.adapter = FoodAdapter(data, object : FoodAdapter.OnClickListener {
            override fun detail(item: ResultsItem?) {
                showDetail(item)
            }
        })
    }

    private fun showDetail(item: ResultsItem?) {
        val dialogView =
            LayoutInflater.from(this@MainActivity).inflate(R.layout.dialog_layout, null)
        val thumb = dialogView.findViewById<ImageView>(R.id.thumb_food)
        val nama = dialogView.findViewById<TextView>(R.id.nama_makanan)
        val porsi = dialogView.findViewById<TextView>(R.id.porsi_makanan)
        val durasi = dialogView.findViewById<TextView>(R.id.durasi_masak)
        val tingkat = dialogView.findViewById<TextView>(R.id.tingkat_kesulitan)


        Glide.with(this@MainActivity)
            .load(item?.thumb)
            .into(thumb)
        nama.text = item?.title
        porsi.text = "Porsi ${item?.portion}"
        durasi.text = "Durasi ${item?.times}"
        tingkat.text = "Tingkat Kesulitasn ${item?.dificulty}"


        val dialogBuilder = AlertDialog.Builder(this@MainActivity)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        dialogBuilder.show()
    }
}