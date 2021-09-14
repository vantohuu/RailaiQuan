package com.example.foodgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_RecyclerView_Thanhtoan extends RecyclerView.Adapter<Adapter_RecyclerView_Thanhtoan.ViewHolder> {
    private Context mcontext;
    private List<User_db> list;
    public Adapter_RecyclerView_Thanhtoan(Context mcontext) {
        this.mcontext = mcontext;
    }
    public void addList(List<User_db> dbList)
    {
        list = dbList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.custom_thanhtoan_item_ryc, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list == null) return;;
        User_db a = list.get(position);
        holder.img.setImageResource(a.getAnh());
        holder.ten.setText(a.getTen());
        holder.soluong.setText("Số lượng: " +a.getSoluong());
        holder.thanhtien.setText("Tổng: " + a.getGia() + "  x  " + a.getSoluong() +" = " + a.getGia()*a.getSoluong() + " đồng");
    }

    @Override
    public int getItemCount() {
        if (list == null) return 0;
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView ten, soluong, thanhtien;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.thanhtoan_ryc_item_img);
            ten = itemView.findViewById(R.id.thanhtoan_ryc_item_ten);
            soluong = itemView.findViewById(R.id.thanhtoan_ryc_item_soluong);
            thanhtien = itemView.findViewById(R.id.thanhtoan_ryc_item_thanhtien);
        }
    }
}
