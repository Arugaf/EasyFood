package com.eternity.easyfood.utils.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eternity.easyfood.MainActivity;
import com.eternity.easyfood.R;
import com.eternity.easyfood.ui.product_info.ProductInfoFragment;
import com.eternity.easyfood.utils.Product;

import java.util.ArrayList;

public class SearchProductAdapter extends RecyclerView.Adapter<SearchProductAdapter.SearchViewHolder> {
    private ArrayList<Product> mResults = new ArrayList<>();
    private ProductClickListener mListener;

    public interface ProductClickListener {
        void addProductClicked();
    }

    public SearchProductAdapter(ArrayList<Product> products, ProductClickListener productClickListener) {
        mResults = products;
        mListener = productClickListener;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        public final TextView productName;
        public final TextView secondary;
        public final TextView kcal;
        public final Button btnAdd;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            this.productName = (TextView) itemView.findViewById(R.id.product_line_name);
            this.secondary = (TextView) itemView.findViewById(R.id.product_line_secondary);
            this.kcal = (TextView) itemView.findViewById(R.id.product_line_kcal);
            this.btnAdd = (Button) itemView.findViewById(R.id.product_line_btn_add);
        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View searchProductView = inflater.inflate(R.layout.search_product_line, parent, false);

        return new SearchViewHolder(searchProductView);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        Product product = mResults.get(position);

        holder.productName.setText("Banana hey!");

        holder.itemView.setOnClickListener(v -> mListener.addProductClicked());
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }
}
