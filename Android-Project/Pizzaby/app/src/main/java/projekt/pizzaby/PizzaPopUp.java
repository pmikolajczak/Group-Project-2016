package projekt.pizzaby;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import projekt.pizzaby.api.PizzeriaMapped;

/**
 * Created by robert on 15.02.2017.
 */

public class PizzaPopUp {

    public RecyclerView recyclerView1;
    public View dialogView;
    public TextView pizzeriaName;
    public TextView pizzeriaNumber;
    private Context context;
    private AlertDialog alertDialog;

    public PizzaPopUp(Context con, PizzeriaMapped pizzeriaInfo) {
        context = con;

        dialogView = View.inflate(context, R.layout.pizzas_popup, null);
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setView(dialogView);

        pizzeriaName = (TextView) dialogView.findViewById(R.id.pizzeria_name);
        pizzeriaName.setText("Pizzeria: " + pizzeriaInfo.getName());

        pizzeriaNumber = (TextView) dialogView.findViewById(R.id.pizzeria_number);
        pizzeriaNumber.setText("Telefon: " + pizzeriaInfo.getPhone());

        recyclerView1 = (RecyclerView) dialogView.findViewById(R.id.recycler4);
        recyclerView1.setLayoutManager(new LinearLayoutManager(context));
        recyclerView1.setAdapter(new PizzasAdapter(pizzeriaInfo.getPizzas()));
    }

    public void showDialog() {
        alertDialog.show();
    }

}
