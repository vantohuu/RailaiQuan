package com.example.foodgo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity_thanhtoan extends AppCompatActivity {
    private static final String CHANNEL_ID = "channel_id" ;
    List<User_db> list;
    Adapter_RecyclerView_Thanhtoan adapter_recyclerView_thanhtoan;
    RecyclerView recyclerView;
    TextView tongtien;
    Button btn_thanhtoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanhtoan);
        recyclerView = findViewById(R.id.thanhtoan_ryc);
        tongtien = findViewById(R.id.thanhtoan_txt_tongtien);
        btn_thanhtoan = findViewById(R.id.thanhtoan_btn);
        ////
        createNotificationChannel();
        adapter_recyclerView_thanhtoan = new Adapter_RecyclerView_Thanhtoan(this);
        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list = AppDatabase.getInstance(this).userDao().getAll();
        adapter_recyclerView_thanhtoan.addList(list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter_recyclerView_thanhtoan);
        tongtien.setText(tinhtongtien(list) + " đồng");
        ///
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int p = viewHolder.getAdapterPosition();
                User_db item = list.get(p);
                list.remove(p);
                AppDatabase.getInstance(recyclerView.getContext()).userDao().delete(item);
                adapter_recyclerView_thanhtoan.notifyItemRemoved(p);
                tongtien.setText(tinhtongtien(list) + " đồng");
                Snackbar.make(recyclerView,"Bạn có muốn hoàn tác xóa " + item.getTen() + " không? ",Snackbar.LENGTH_LONG).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.add(item);
                        adapter_recyclerView_thanhtoan.notifyDataSetChanged();
                        AppDatabase.getInstance(recyclerView.getContext()).userDao().insert(item);
                        tongtien.setText(tinhtongtien(list) + " đồng");
                    }
                }).show();
            }
        }).attachToRecyclerView(recyclerView);
        btn_thanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Activity_thanhtoan.this, CHANNEL_ID);
                builder.setSmallIcon(R.drawable.ic_baseline_flutter_dash_24);
                builder.setContentTitle("Đặt món thành công");
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
                builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Chúng tôi sẽ gửi hóa đơn cho bạn với thành tiền là : " + tinhtongtien(list) + " đồng."));
                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(Activity_thanhtoan.this);
                notificationManagerCompat.notify((int) new Date().getTime(),builder.build());
            }
        });
    }
    //
    private long tinhtongtien(List<User_db> list)
    {
        long s = 0;
        if (list != null)
        for (int  i = 0; i < list.size(); i++ )
            s += list.get(i).getGia() * list.get(i).getSoluong();
        return s;
    }
    //
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}