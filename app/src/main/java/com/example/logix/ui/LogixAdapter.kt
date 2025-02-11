package com.example.logix.ui

//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.logix.data.LogixItem
//
//class LogixItemAdapter(private val logixItems: List<LogixItem>) :
//    RecyclerView.Adapter<LogixItemAdapter.LogixItemViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogixItemViewHolder {
//        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return LogixItemViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: LogixItemViewHolder, position: Int) {
//        holder.bind(logixItems[position])
//    }
//
//    override fun getItemCount(): Int = logixItems.size
//
//    inner class LogixItemViewHolder(private val binding: ItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item: LogixItem) {
//            binding.item = item
//            binding.executePendingBindings()
//        }
//    }
//}
