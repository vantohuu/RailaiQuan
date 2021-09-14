package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodgo.Adapter_Recyclerview;
import com.example.foodgo.Adapter_ViewPager;
import com.example.foodgo.Data;
import com.example.foodgo.R;
import com.example.foodgo.monan;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Bia extends Fragment {
    RecyclerView recyclerView;
    View view;
    List<monan> list;
    Adapter_Recyclerview adapter_recyclerview;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bia, container, false);
        unit();
        return view;
    }
    private void unit()
    {
        Data data = new Data();
        list = new ArrayList<>();
        ViewFlipper flipper;
        flipper = view.findViewById(R.id.ryc_view_flipper_bia);
        flipper.setInAnimation(getContext(),android.R.anim.slide_in_left);
        flipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
        list = data.getBia();
        recyclerView = view.findViewById(R.id.ryc_view_bia);
        adapter_recyclerview = new Adapter_Recyclerview(getContext(), list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter_recyclerview);
    }
}
