package com.example.darshanpractical.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.darshanpractical.R
import com.example.darshanpractical.databinding.RawTaskBinding
import com.example.darshanpractical.models.pojo.task_list_response.TasksItem


class TaskAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface Interaction {
        fun onTaskSelected(position: Int, item: TasksItem, view : View)
    }

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TasksItem>() {

        override fun areItemsTheSame(oldItem: TasksItem, newItem: TasksItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TasksItem, newItem: TasksItem): Boolean {
            return oldItem.equals(newItem)
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val mBinder: RawTaskBinding = DataBindingUtil.inflate(
            LayoutInflater
                .from(parent.context), R.layout.raw_task, parent, false
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

    fun submitList(list: List<TasksItem>) {
        differ.submitList(list)
    }


    class ViewHolderItemVH constructor(
        binding: RawTaskBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {


        var mBinder: RawTaskBinding = binding

        fun bind(item: TasksItem, pos : Int) {

            mBinder.tvProjectName.text = item.name

            mBinder.cardRoot.setOnClickListener(View.OnClickListener {
                interaction?.onTaskSelected(pos, item, mBinder.root)
            })
        }
    }

}
