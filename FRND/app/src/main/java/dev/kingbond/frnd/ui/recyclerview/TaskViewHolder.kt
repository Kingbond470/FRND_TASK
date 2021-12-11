package dev.kingbond.frnd.ui.recyclerview

import androidx.recyclerview.widget.RecyclerView
import dev.kingbond.frnd.data.local.TaskDatabaseModel
import dev.kingbond.frnd.databinding.TaskLayoutBinding

class TaskViewHolder(val itemLayoutBinding: TaskLayoutBinding, val clickListener: ClickListener) :
    RecyclerView.ViewHolder(itemLayoutBinding.root) {

    fun setData(result: TaskDatabaseModel) {
        itemLayoutBinding.apply {
            tvTitle.text = result.title
            tvDescription.text = result.description
            tvDate.text = result.date

            ivDelete.setOnClickListener {
                clickListener.onClick(result, adapterPosition)
            }
        }
    }
}