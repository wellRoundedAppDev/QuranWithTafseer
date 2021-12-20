import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elraedaelkobra.R

class VersesAdapter : RecyclerView.Adapter<VersesAdapter.ViewHolder>() {

    var items: List<String>? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val verseTextView: TextView = itemView.findViewById(R.id.verse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    var onItemCLickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val verse: String = items?.get(position) as String
        holder.verseTextView.text = verse

        if (onItemCLickListener != null) {

            holder.itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View?) {

                    onItemCLickListener?.onItemClick(position, verse)
                }
            })
        }
    }

    override fun getItemCount(): Int {

        return items?.size ?: 0
    }

    fun changeData(verses: List<String>) {

        this.items = verses
        notifyDataSetChanged()
    }

    interface OnItemClickListener {

        fun onItemClick(position: Int, item: String)
    }
}