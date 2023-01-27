package com.picker.homework_62.gallery

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.picker.homework_62.databinding.GalleryItemBinding
import com.picker.homework_62.utils.loadImage
import kotlinx.coroutines.NonDisposableHandle.parent


class ImageAdapter: RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    private lateinit var listener : OnItemClick
    private val listImage = arrayListOf<ImageModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ImageViewHolder(
        GalleryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(listImage[position], position)
    }

    override fun getItemCount() = listImage.size

    inner class ImageViewHolder(private val binding: GalleryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel, position: Int) {
            binding.imgGallery.loadImage(imageModel.image)

            binding.imgDone.isVisible = imageModel.isSelected
            itemView.setOnClickListener {
                listener.onClicked(imageModel, position)
            }
        }

    }

    fun setListener(onItemClick: OnItemClick) {
        listener = onItemClick
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setImageList(img: List<ImageModel>) {
        listImage.clear()
        listImage.addAll(img)
        notifyDataSetChanged()
    }

    interface OnItemClick {
        fun onClicked(list: ImageModel, position: Int)

    }


}

