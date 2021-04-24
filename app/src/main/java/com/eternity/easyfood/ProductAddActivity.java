package com.eternity.easyfood;

import android.content.Intent;
import android.os.Bundle;

import com.eternity.easyfood.utils.Product;
import com.eternity.easyfood.utils.adapters.EatingListAdapter;
import com.eternity.easyfood.utils.adapters.SearchProductAdapter;
import com.eternity.easyfood.utils.adapters.SwipeToDeleteItem;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.app.SearchManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class ProductAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("<ПРИЕМ ПИЩИ>");

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }

        RecyclerView rv = (RecyclerView) findViewById(R.id.results);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Product> pr;
        pr = Product.createProductsList(8);
        SearchProductAdapter adapter = new SearchProductAdapter(pr);
        rv.setAdapter(adapter);

//        SearchView searchView = (SearchView) findViewById(R.id.searchbar);
//        search(searchView);

        EditText searchInput = (EditText) findViewById(R.id.search_bar_edittext);
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//               do things
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

//    private void search(SearchView searchView) {
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                mAdapter.getFilter().filter(newText);
//                return true;
//            }
//        });
//    }

    public void goToBarcodeScanActivity(View view) {
        Intent intent = new Intent(this, BarcodeScanActivity.class);
        startActivity(intent);
    }
}