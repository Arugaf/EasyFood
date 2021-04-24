package com.eternity.easyfood.utils.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eternity.easyfood.R;
import com.eternity.easyfood.utils.Product;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class EatingListAdapter extends RecyclerView.Adapter<EatingListAdapter.EatingViewHolder> {
    private ArrayList<Product> mProducts = new ArrayList<>();
    private Context mContext;

    Product mRecentlyDeletedItem;
    int mRecentlyDeletedItemPosition;

    public EatingListAdapter(ArrayList<Product> products) {
        mProducts = products;
    }

    public class EatingViewHolder extends RecyclerView.ViewHolder {
        public final TextView secondary;

        public EatingViewHolder(@NonNull View itemView) {
            super(itemView);
            this.secondary = (TextView) itemView.findViewById(R.id.eating_line_secondary_text);
        }

        public void hide() {
            itemView.setVisibility(View.GONE);
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.height = 0;
            params.width = 0;
            itemView.setLayoutParams(params);
        }
        public void show() {
            itemView.setVisibility(View.VISIBLE);
            ViewGroup.LayoutParams params = itemView.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.width = ViewGroup.LayoutParams.MATCH_PARENT;
            itemView.setLayoutParams(params);
        }
    }

    @Override
    public EatingListAdapter.EatingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View productView = inflater.inflate(R.layout.eating_line, parent, false);

        // Return a new holder instance
        return new EatingViewHolder(productView);
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EatingListAdapter.EatingViewHolder holder, int position) {
        // Get the data model based on position
        Product product = mProducts.get(position);

        holder.show();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                holder.hide();
            }
        });

        // Set item views based on your views and data model
        TextView textView = holder.secondary;
//        textView.setText(product.getKcal());
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public void deleteItem(int position) {
        Product mRecentlyDeletedItem = mProducts.get(position);
        int mRecentlyDeletedItemPosition = position;
        mProducts.remove(position);
        notifyItemRemoved(position);
    }
}
