package com.example.mati.ejemploejerciciorecopilatorio;

import android.app.Activity;
import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Lista para el spinner
    private Coche[] datos = new Coche[]{
            new Coche("Megane: ", "Seat", 20, R.drawable.megan1 ),
            new Coche("X-11: ", "Ferrari", 100, R.drawable.ferrari1),
            new Coche("Leon: ", "Seat", 30, R.drawable.leon1),
            new Coche("Fiesta", "Ford", 40, R.drawable.fiesta1)
    };

    private Object[] calculos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para rellenear el spinner
        AdaptadorZonas adaptador = new AdaptadorZonas(this);
        final Spinner zonas = (Spinner) findViewById(R.id.zonas);
        zonas.setAdapter(adaptador);

        Button calcular = (Button)findViewById(R.id.calcular);
        final RadioGroup tarifas = (RadioGroup)findViewById(R.id.tarifas);
        final Button urgente = (Button)findViewById(R.id.urgente);
        final Button normal = (Button)findViewById(R.id.normal);
        final EditText peso = (EditText)findViewById(R.id.peso);
        final CheckBox caja = (CheckBox)findViewById(R.id.regalo);
        final CheckBox tarjeta = (CheckBox)findViewById(R.id.tarjeta);
        final CheckBox radio =  (CheckBox)findViewById(R.id.radio);
        final TextView textView = (TextView)findViewById(R.id.textView3);

        //Obtener el precio y pasar pantalla
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Para empezar a pasar de pagina
                Intent paso = new Intent(MainActivity.this, Factura.class);

                //Para pasar objetos
                Bundle pasoobjetos = new Bundle();
                //Precio de la zona y pasar el objeto
                double preciozona = datos[zonas.getSelectedItemPosition()].getPrecio();
                Coche Destino = new Coche (datos[zonas.getSelectedItemPosition()].getzona(),
                        datos[zonas.getSelectedItemPosition()].getcontinente(),
                        datos[zonas.getSelectedItemPosition()].getPrecio(),
                        datos[zonas.getSelectedItemPosition()].getInt());
                pasoobjetos.putSerializable("destino", Destino);
                paso.putExtras(pasoobjetos);

                //Precio del peso y pasarlo
                double preciopeso = 0;

                if (peso.getText().toString().isEmpty()){
                    peso.setText("0");
                    preciopeso = 0;
                }
                if (Double.parseDouble(peso.getText().toString()) > 0){
                    preciopeso = Double.parseDouble(peso.getText().toString());

                }

                textView.setText(""+preciopeso+"*"+datos[zonas.getSelectedItemPosition()].getPrecio());
                paso.putExtra("peso", peso.getText().toString());
                paso.putExtra("preciopeso", String.valueOf(preciopeso));
                double total =  preciozona + preciopeso;

                //Precio de tarifa y pasarlo
                double tarifa = 0;
                String ntarifa = " ";
                if (tarifas.getCheckedRadioButtonId() == R.id.regalo){
                    ntarifa = caja.getText().toString();
                    tarifa = (total + 50 );
                    ntarifa = caja.getText().toString();
                }
                if (tarifas.getCheckedRadioButtonId() == R.id.tarjeta ){
                    ntarifa = tarjeta.getText().toString();
                    tarifa = (total + 50 );
                    ntarifa = tarjeta.getText().toString();
                }
                if( tarifas.getCheckedRadioButtonId() == R.id.radio ){
                    ntarifa = radio.getText().toString();
                    tarifa = (total + 50 );
                    ntarifa = radio.getText().toString();
                }


                if(urgente.isActivated()){
                    paso.putExtra("seguro", urgente.getText().toString());
                }

                //Tipo de envoltorio
                boolean checked = false;
                if(caja.isChecked()){
                    ntarifa = caja.getText().toString();
                    tarifa += 50;
                    ntarifa = caja.getText().toString();
                    checked = true;
                    paso.putExtra("cajaregalo", caja.getText().toString());
                    paso.putExtra("checked", checked);
                }
                if(tarjeta.isChecked()){
                    ntarifa = tarjeta.getText().toString();
                    tarifa +=  50;
                    ntarifa = tarjeta.getText().toString();
                    checked = true;
                    paso.putExtra("tarjeta", tarjeta.getText().toString());
                    paso.putExtra("checked", checked);
                }
                if(radio.isChecked()){
                    ntarifa = radio.getText().toString();
                    tarifa += 50;
                    ntarifa = radio.getText().toString();
                    checked = true;
                    paso.putExtra("tarjeta", tarjeta.getText().toString());
                    paso.putExtra("checked", checked);
                }
                paso.putExtra("nombretarifa", ntarifa);
                paso.putExtra("tarifa", String.valueOf(tarifa));
                total = tarifa;
                paso.putExtra("total", String.valueOf(total));
                startActivity(paso);
                //String mensaje = "Total = " + total;
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
    //Menu de Arcerca DE y dibujar
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem item){
        switch (item.getItemId()){
            case R.id.acerca:
                Intent acerca = new Intent(MainActivity.this, acercade.class);
                startActivity(acerca);
                return true;
            case R.id.dibujar:
                Intent dibujo = new Intent(MainActivity.this, dibujar.class);
                startActivity(dibujo);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Rellenando el spinner
    public class AdaptadorZonas extends ArrayAdapter<Coche> {
        Activity context;

        AdaptadorZonas(Activity context){
            super(context, R.layout.listitem_destino, datos);
            this.context = context;
        }
        public  View getDropDownView (int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position, convertView, parent);
            return  vistaDesplegada;

        }

        public View getView(int i, View convertView, ViewGroup parent){
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_destino, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblZona);
            lblTitulo.setText(datos[i].getzona());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblContinente);
            lblSubtitulo.setText(datos[i].getcontinente());

            TextView lblPrecio = (TextView)item.findViewById(R.id.LblPrecio);
            lblPrecio.setText(String.valueOf(datos[i].getPrecio()) + "€");

            ImageView imagen = (ImageView) item.findViewById(R.id.Imagen);
            imagen.setBackground(getDrawable(datos[i].getInt()));

            return (item);
        }

    }
}
