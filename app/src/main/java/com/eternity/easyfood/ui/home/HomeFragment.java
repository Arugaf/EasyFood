package com.eternity.easyfood.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eternity.easyfood.ProductAddActivity;
import com.eternity.easyfood.R;
import com.eternity.easyfood.utils.Product;
import com.eternity.easyfood.utils.adapters.EatingListAdapter;
import com.eternity.easyfood.utils.adapters.SwipeToDeleteItem;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private int progress = 60;

    // TODO: to ViewModel?
    //       need to create func with calcs of kcals and percents from products for day
    public void updateProgress(View root) {
        final ProgressBar cirlce = root.findViewById(R.id.home_circle_bar);
        final TextView text = root.findViewById(R.id.home_circle_bar_progress);

        cirlce.setProgress(progress);
        text.setText(String.format("%d", progress));
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final ProgressBar cirlce = root.findViewById(R.id.home_circle_bar);
        final TextView all = root.findViewById(R.id.home_circle_bar_all);

        all.setText("Всего 2100");
        updateProgress(root);

        RecyclerView rvProducts = (RecyclerView) root.findViewById(R.id.recyclerView2);
        // init products for example
        ArrayList<Product> pr;
        pr = Product.createProductsList(3);
        // init adapter
        EatingListAdapter adapter = new EatingListAdapter(pr);
        //init callback to delete
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteItem(adapter, root.getContext()));
        //setup recyclerview
        rvProducts.setAdapter(adapter);
        rvProducts.setLayoutManager(new LinearLayoutManager(root.getContext()));
        itemTouchHelper.attachToRecyclerView(rvProducts);


        return root;
    }
}