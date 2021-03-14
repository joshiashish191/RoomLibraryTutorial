package net.softglobe.roomtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ProductsDatabase db;
    public EditText etName, etDescription, etPrice;
    public TableLayout tl;
    public Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = ProductsDatabase.getInstance(this);

        etName = findViewById(R.id.name);
        etDescription = findViewById(R.id.desc);
        etPrice = findViewById(R.id.price);
        addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(etName.getText()) && !TextUtils.isEmpty(etDescription.getText()) && !TextUtils.isEmpty(etPrice.getText())) {
                    Products product = new Products(etName.getText().toString(), etDescription.getText().toString(), Integer.parseInt(etPrice.getText().toString()));
                    db.productsDao().insertProducts(product);
                    Toast.makeText(MainActivity.this, "Product added successfully!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(MainActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                getProducts();
            }
        });
        getProducts();
    }

    public void getProducts(){
        tl = findViewById(R.id.products_table);
        tl.removeAllViews();
        Products[] productsArr = db.productsDao().getProducts();
        for (Products prod: productsArr) {
            TextView tv_name = new TextView(this);
            tv_name.setText("Name: ");
            tv_name.setTextSize(20);

            TextView tv_name_val = new TextView(this);
            tv_name_val.setText(prod.getName());
            tv_name_val.setTextSize(20);

            TableRow row1 = new TableRow(this);
            row1.addView(tv_name);
            row1.addView(tv_name_val);
            tl.addView(row1);

            TextView tv_desc = new TextView(this);
            tv_desc.setText("Description: ");
            tv_desc.setTextSize(20);

            TextView tv_desc_val = new TextView(this);
            tv_desc_val.setText(prod.getDescription());
            tv_desc_val.setTextSize(20);

            TableRow row2 = new TableRow(this);
            row2.addView(tv_desc);
            row2.addView(tv_desc_val);
            tl.addView(row2);


            TextView tv_price = new TextView(this);
            tv_price.setText("Price: ");
            tv_price.setTextSize(20);

            TextView tv_price_val = new TextView(this);
            tv_price_val.setText(Integer.toString(prod.getPrice()));
            tv_price_val.setTextSize(20);

            TableRow row3 = new TableRow(this);
            row3.addView(tv_price);
            row3.addView(tv_price_val);
            tl.addView(row3);

            TextView tvLine = new TextView(this);
            tvLine.setBackgroundColor(getResources().getColor(R.color.black));
            tvLine.setHeight(1);
            tvLine.setPadding(5,5,5,5);
            tl.addView(tvLine);
        }
    }
}