package id.indosw.musicplayer.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.jetbrains.annotations.NotNull;

import id.indosw.musicplayer.R;
import id.indosw.musicplayer.app.model.ModelListLagu;

import java.util.List;

public class ListLaguAdapter extends RecyclerView.Adapter<ListLaguAdapter.ViewHolder> {

    private final List<ModelListLagu> items;
    private final ListLaguAdapter.onSelectData onSelectData;
    private final Context mContext;

    public interface onSelectData {
        void onSelected(ModelListLagu modelListLagu);
    }

    public ListLaguAdapter(Context context, List<ModelListLagu> items, ListLaguAdapter.onSelectData xSelectData) {
        this.mContext = context;
        this.items = items;
        this.onSelectData = xSelectData;
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_music, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ModelListLagu data = items.get(position);

        //Get Image
        Glide.with(mContext)
                .load(data.strCoverLagu)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .placeholder(R.drawable.ic_no_image)
                .into(holder.imgCover);

        holder.tvBand.setText(data.strNamaBand);
        holder.tvTitleMusic.setText(data.strJudulMusic);
        holder.cvListMusic.setOnClickListener(v -> onSelectData.onSelected(data));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Class Holder
    static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvBand;
        public TextView tvTitleMusic;
        public CardView cvListMusic;
        public ImageView imgCover;

        public ViewHolder(View itemView) {
            super(itemView);
            cvListMusic = itemView.findViewById(R.id.cvListMusic);
            imgCover = itemView.findViewById(R.id.imgCover);
            tvBand = itemView.findViewById(R.id.tvBand);
            tvTitleMusic = itemView.findViewById(R.id.tvTitleMusic);
        }
    }

}
