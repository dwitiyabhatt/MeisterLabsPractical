package com.example.darshanpractical.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.darshanpractical.MeisterApp
import com.example.darshanpractical.R
import com.example.darshanpractical.databinding.RawStatusBinding
import com.example.darshanpractical.models.pojo.Status


class StatusFilterAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface Interaction {
        fun onFilterTagSelected(position: Int, item: Status, view : View)
    }

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Status>() {

        override fun areItemsTheSame(oldItem: Status, newItem: Status): Boolean {
            return oldItem.statusId == newItem.statusId
        }

        override fun areContentsTheSame(oldItem: Status, newItem: Status): Boolean {
            return oldItem.equals(newItem)
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val mBinder: RawStatusBinding

        mBinder = DataBindingUtil.inflate(
            LayoutInflater
                .from(parent.context), R.layout.raw_status, parent, false
        )

        return ViewHolderItemVH(mBinder,interaction)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolderItemVH -> {
                holder.bind(differ.currentList.get(position),position)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Status>) {
        differ.submitList(list)
    }


    class ViewHolderItemVH constructor(
        binding: RawStatusBinding,
        private val interaction: Interaction?,
        private val lastSelectedPost: Int = 0,
    ) : RecyclerView.ViewHolder(binding.root) {


        var mBinder: RawStatusBinding = binding

        fun bind(item: Status, pos : Int) {

            if(item.isSelected){
                mBinder.linRoot.background = ContextCompat.getDrawable(MeisterApp.activityFromApp,R.drawable.rounded_blue_bg)
                mBinder.tvTag.setTextColor(ContextCompat.getColor(MeisterApp.activityFromApp,R.color.font_light_black))
            }else{
                mBinder.linRoot.background = ContextCompat.getDrawable(MeisterApp.activityFromApp,R.drawable.rounded_10_gray_bg)
                mBinder.tvTag.setTextColor(ContextCompat.getColor(MeisterApp.activityFromApp,R.color.font_light_black))
            }

            mBinder.tvTag.setText(item.statusName)
            //mBinder.tvNumbers.setText("("+item.numbers+")");
            mBinder.linRoot.setOnClickListener(View.OnClickListener {
                interaction?.onFilterTagSelected(pos, item, mBinder.root)
            })
        }
    }

}
