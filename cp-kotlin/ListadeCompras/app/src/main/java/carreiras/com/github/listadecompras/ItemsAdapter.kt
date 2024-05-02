package carreiras.com.github.listadecompras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()


    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val textViewDesc = view.findViewById<TextView>(R.id.textViewItemDesc)
        val button = view.findViewById<ImageButton>(R.id.imageButton)
        
        fun bind(item: ItemModel) {
            textView.text = item.name
            textViewDesc.text = item.desc

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}