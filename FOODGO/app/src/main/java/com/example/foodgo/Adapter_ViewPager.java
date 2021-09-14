package com.example.foodgo;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

import fragment.FragmentHome;
import fragment.Fragment_Bbq;
import fragment.Fragment_Bia;
import fragment.Fragment_Giaikhat;
import fragment.Fragment_Lau;
import fragment.Fragment_Monxao;
import fragment.Fragment_Sup;
import fragment.Fragment_Trangmieng;

public class Adapter_ViewPager extends FragmentStateAdapter {

    public Adapter_ViewPager(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
            {
                return new Fragment_Bbq();

            }
            case 1:
            {
                return new Fragment_Lau();
            }
            case 2:
            {
                return new Fragment_Monxao();
            }
            case 3:
            {
                return new Fragment_Sup();
            }
            case 4:
            {
                return new Fragment_Bia();
            }
            case 5:
            {
                return new Fragment_Giaikhat();
            }
            default: return new Fragment_Bbq();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
