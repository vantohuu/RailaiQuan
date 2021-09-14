package com.example.foodgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Recyclerview extends RecyclerView.Adapter<Adapter_Recyclerview.Item_ViewHolder>{
    private Context mcontext;
    private List<monan> monanList;

    public Adapter_Recyclerview(Context mcontext, List<monan> monanList) {
        this.mcontext = mcontext;
        this.monanList = monanList;
    }

    @NonNull
    @Override
    public Item_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_recyclerview, parent, false);
        return new Item_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Item_ViewHolder holder, int position) {
        if (monanList == null) return;
        holder.ten.setText(monanList.get(position).getTen());
        holder.mota.setText(monanList.get(position).getMota());
        holder.gia.setText(monanList.get(position).getGia() + " đồng");
        holder.anh.setImageResource(monanList.get(position).getHinh());
        holder.soluong.setText(monanList.get(position).getSoluong()+"");

        holder.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = monanList.get(position).getSoluong();
                if (sl >= 0  && sl < 50)
                {
                    sl++;
                    monanList.get(position).setSoluong(sl);
                    holder.soluong.setText(monanList.get(position).getSoluong()+"");
                }

            }
        });
        holder.before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = monanList.get(position).getSoluong();
                if (sl > 0  && sl <= 50)
                {
                    sl--;
                    monanList.get(position).setSoluong(sl);
                    holder.soluong.setText(monanList.get(position).getSoluong()+"");
                }

            }
        });

        holder.mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                monan m = monanList.get(position);
                if (m.getSoluong() > 0)
                {
                    User_db item = new User_db(m.getTen(),m.getHinh(),m.getGia(),m.getSoluong());
                    AppDatabase.getInstance(mcontext.getApplicationContext()).userDao().insert(item);
                    Toast.makeText(mcontext.getApplicationContext(), "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                }
                 else Toast.makeText(mcontext.getApplicationContext(), "Vui lòng thêm số lượng", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return monanList.size();
    }

    public class Item_ViewHolder extends RecyclerView.ViewHolder {
        private ImageView anh, next, before;
        private TextView ten, mota, gia, soluong;
        private Button  mua;
        public Item_ViewHolder(@NonNull View itemView) {
            super(itemView);
            anh = itemView.findViewById(R.id.ryc_item_anh);
            ten = itemView.findViewById(R.id.ryc_item_ten);
            mota = itemView.findViewById(R.id.ryc_item_mota);
            gia = itemView.findViewById(R.id.ryc_item_gia);
            soluong = itemView.findViewById(R.id.ryc_item_count);
            next = itemView.findViewById(R.id.ryc_item_ic_next);
            before = itemView.findViewById(R.id.ryc_item_ic_before);
            mua = itemView.findViewById(R.id.ryc_item_store);
        }
    }
}
