package com.picker.homework_62.selected

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.picker.homework_62.databinding.GalleryItemBinding
import com.picker.homework_62.gallery.ImageModel
import com.picker.homework_62.utils.loadImage

class SelectedAdapter : RecyclerView.Adapter<SelectedAdapter.ImageViewHolder>() {
    private val listImage = arrayListOf<ImageModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            GalleryItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }


    fun setImageList(img: List<ImageModel>) {
        listImage.clear()
        listImage.addAll(img)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(listImage[position])
    }

    override fun getItemCount() = listImage.size

    inner class ImageViewHolder(private val binding: GalleryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.imgGallery.loadImage(imageModel.image)


        }
    }
}
