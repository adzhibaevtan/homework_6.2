package com.picker.homework_62.selected


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.picker.homework_62.databinding.ActivitySelectedImagesBinding

import com.picker.homework_62.gallery.ImageModel
import com.picker.homework_62.gallery.MainActivity.Companion.IMAGE

class SelectedImagesActivity : AppCompatActivity() {

    private var selectedAdapter = SelectedAdapter()
    private lateinit var binding: ActivitySelectedImagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectedImagesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getImages()
        initClick()

    }

    private fun initClick() {
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun getImages() {
        val images = intent.getStringArrayListExtra(IMAGE) as ArrayList<ImageModel>
        selectedAdapter.setImageList(images)
        binding.selectedRecycler.adapter = selectedAdapter
    }

}
