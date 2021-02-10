package id.indosw.musicplayer.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import id.indosw.musicplayer.R
import id.indosw.musicplayer.app.`interface`.InterfaceOnSelected
import id.indosw.musicplayer.app.model.ModelListLagu

class ListLaguAdapter(
    private val mContext: Context,
    private val items: List<ModelListLagu>,
    private var onSelectData: InterfaceOnSelected
) : RecyclerView.Adapter<ListLaguAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list_music, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        //Get Image
        Glide.with(mContext)
            .load(data.strCoverLagu)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .placeholder(R.drawable.ic_no_image)
            .into(holder.imgCover)
        holder.tvBand.text = data.strNamaBand
        holder.tvTitleMusic.text = data.strJudulMusic
        holder.cvListMusic.setOnClickListener { onSelectData.onSelected(data) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    //Class Holder
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvBand: TextView = itemView.findViewById(R.id.tvBand)
        var tvTitleMusic: TextView = itemView.findViewById(R.id.tvTitleMusic)
        var cvListMusic: CardView = itemView.findViewById(R.id.cvListMusic)
        var imgCover: ImageView = itemView.findViewById(R.id.imgCover)

    }

    companion object
}