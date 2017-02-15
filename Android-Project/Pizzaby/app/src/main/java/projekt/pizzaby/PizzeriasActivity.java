package projekt.pizzaby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import projekt.pizzaby.api.PizzeriaMapped;

/**
 * Created by robert on 06.12.2016.
 */

public class PizzeriasActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public List<PizzeriaMapped> pizzeriaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pizzerias);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        pizzeriaList = PizzeriasListSingleton.getInstance().getList();
        System.out.println("");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PizzeriasAdapter(pizzeriaList, this));

    }

}
