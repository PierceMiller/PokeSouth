package pokesouth.com.pokesouthapp;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context mContext;
    List<Pokemon> mData;
    Dialog myDialog;

    public RecycleViewAdapter(Context mContext, List<Pokemon> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_pokemon,viewGroup, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.pokemon_dialog);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.item_pokemon.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                TextView dialog_name_tv = (TextView) myDialog.findViewById(R.id.dialog_name);
                TextView dialog_max_cp = (TextView) myDialog.findViewById(R.id.dialog_max_cp);
                ImageView dialog_pokemon_img = (ImageView) myDialog.findViewById(R.id.dialog_photo);
                ImageView dialog_pokemon_stats = (ImageView) myDialog.findViewById(R.id.dialog_stats);

                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_max_cp.setText(mData.get(vHolder.getAdapterPosition()).getCP());
                dialog_pokemon_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());
                dialog_pokemon_stats.setImageResource(mData.get(vHolder.getAdapterPosition()).getStatPhoto());

                myDialog.show();
            }

        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_cp.setText(mData.get(position).getCP());
        holder.img.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_pokemon;
        private TextView tv_name;
        private TextView tv_cp;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            item_pokemon = (LinearLayout) itemView.findViewById(R.id.pokemon_item_id);
            tv_name = (TextView) itemView.findViewById(R.id.name_pokemon);
            tv_cp = (TextView) itemView.findViewById(R.id.max_cp);
            img = (ImageView) itemView.findViewById(R.id.img_pokemon);
        }
    }
}
