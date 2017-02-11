package com.example.sujic.proyectofinal_susana;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sujic on 23/01/2017.
 */
public class Inicio  extends AppCompatActivity {

    String BD_NAME = "BaseDatos1";
    String posibilidad = "";

    int precioP = 0;
    int precioE = 0;
    int precioMascarilla= 0;
    int precioFacial = 0;
    int precioCejas = 0;
    int precioTotal = 0;

    private Tratamiento[] datos;
    String tratamientoss;
    int precioss;
    String tratamientoName, tratamientoPrecio;

    boolean isEco = false;
    boolean isFacial = false;
    boolean isSensor = false;
    boolean isEmascarilla = false;
    boolean isEfacial = false;
    boolean isEcejas = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);


        final RadioButton RBEco = (RadioButton) findViewById(R.id.RBEcologico);
        final RadioButton RBDeluze = (RadioButton) findViewById(R.id.RBDeluxe);
        final RadioButton RBSensor = (RadioButton) findViewById(R.id.RBSensor);

        final CheckBox EMascarilla = (CheckBox) findViewById(R.id.extraMascarilla);
        final CheckBox EFacial = (CheckBox) findViewById(R.id.extraFacial);
        final CheckBox ECejas = (CheckBox) findViewById(R.id.extraCejas);

        Button BPedido = (Button) findViewById(R.id.botonPedido);

        RBEco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                posibilidad = "Linea Ecológica";
                precioP = 10;

            }
        });

        RBDeluze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                posibilidad = "Linea Deluxe";
                precioP = 10;

            }
        });

        RBSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                posibilidad = "Linea Sensorial";
                precioP = 10;

            }
        });

        ///**************************** EXTRAS ****************************

        EMascarilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cont = 0;
                if(cont == 0){
                    precioMascarilla = 7;
                }

            }
        });

        EFacial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cont = 0;
                if (cont == 0){
                    precioFacial = 10;
                }

            }
        });

        ECejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cont = 0;
                if (cont == 0){
                    precioCejas = 5;
                }

            }
        });

        precioE = precioCejas + precioFacial + precioMascarilla;

        BPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    if(EMascarilla.isChecked()){
                        precioTotal += precioMascarilla;
                        isEmascarilla = true;
                    }
                    if(ECejas.isChecked()){
                        precioTotal += precioCejas;
                        isEcejas = true;
                    }
                    if(EFacial.isChecked()){
                        precioTotal += precioFacial;
                        isEfacial = true;
                    }

                    if(RBEco.isChecked()){
                        isEco = true;
                        precioTotal += precioP;
                    }
                    if(RBDeluze.isChecked()){
                        isFacial = true;
                        precioTotal += precioP;
                    }
                    if(RBSensor.isChecked()){
                        isSensor = true;
                        precioTotal += precioP;
                    }

                    if(!RBEco.isChecked() && !RBDeluze.isChecked() && !RBSensor.isChecked()){

                        // Nos aseguramos de el pedido no se hacec si no hay ningun tratamiento seleccionado
                        Toast aviso = Toast.makeText(getApplicationContext(),"Por favor, selecciona algún tratamiento.", Toast.LENGTH_SHORT);
                        aviso.show();
                    }else{

                        precioE = precioCejas + precioFacial + precioMascarilla;

                        Intent pedido = new Intent(Inicio.this, Pedido.class);
                        //pedido.putExtra("Total", precioTotal).toString();
                        //pedido.putExtra("Total extras", precioE).toString();

                        // Paso informacion con Bundle

                        Bundle informacion = new Bundle();
                        informacion.putSerializable("precioT", precioTotal);
                        informacion.putSerializable("precioE", precioE);

                        if(isEmascarilla){informacion.putSerializable("extraMascarilla", isEfacial);}
                        if(isEcejas){informacion.putSerializable("extraCejas", isEcejas);}
                        if(isEfacial){informacion.putSerializable("extraFacial", isEfacial);}


                        if(isFacial){informacion.putSerializable("linea",posibilidad );}
                        if(isSensor){informacion.putSerializable("linea",posibilidad );}
                        if(isEco){informacion.putSerializable("linea",posibilidad );}

                        pedido.putExtras(informacion);
                        startActivity(pedido);


                    }


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"ERROR", Toast.LENGTH_SHORT);
                }

            }
        });

        BDTratamientos admin = new BDTratamientos(Inicio.this, BD_NAME, null, 1);
        SQLiteDatabase db = admin.getReadableDatabase();

        // Spinner de los tratamientos

        if (db != null ){

            String [] campos = new String[]{"nombre","precio"};

            Cursor cursor = db.query("Tratamientos", campos, null, null, null, null, null);
            datos = new Tratamiento[cursor.getCount()];
            int i = 0;
            //Nos aseguramos de que exista al menos un registro

            if (cursor.moveToFirst()) {
                // Recorremos el cursor hasta que no haya más registros
                do {

                    tratamientoss = cursor.getString(0);
                    precioss = cursor.getInt(1);

                    datos[i] = new Tratamiento(tratamientoss, precioss);

                    i++;

                } while (cursor.moveToNext());
            }

            AdaptadorTratamientos adaptador = new AdaptadorTratamientos(this);
            Spinner spinnerTratamiento = (Spinner) findViewById(R.id.spinner);
            spinnerTratamiento.setAdapter(adaptador);

            spinnerTratamiento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                    String menasje = "Tratamiento: " + datos[position].getNombre()+" Precio: " +datos[position].getPrecio();

                    tratamientoName = datos[position].getNombre();
                    tratamientoPrecio = datos[position].toStrigPrecio();


                    BDTratamientos basedatos=new BDTratamientos(Inicio.this,BD_NAME,null,1);
                    SQLiteDatabase db=basedatos.getWritableDatabase();

                    // Spinner de tratamientos


                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            db.close();
        }




        // Menu Acerca De y Información

    /**    public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.activity_menu, menu);
            return true;
        }
        public boolean onOptionItemSelected(MenuItem item){
            switch(item.getItemId()){
                case R.id.acerca:
                    Intent acerca = new Intent(Inicio.this, acercade.class);
                    startActivity(acerca);
                    return true;
                case R.id.informacion:
                    Intent info = new Intent(Inicio.this, informacion.class);
                    startActivity(info);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }
     **/
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;

    }

    public  boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.informacion:
                DialogFragment newFragment = MyDialogFragment.newInstance("Ejemplo ejemplo ejemplo");
                newFragment.show(getFragmentManager(), "Informacion");
                return true;
            case R.id.acerca:
                Intent ventana = new Intent(Inicio.this,acercade.class);
                startActivity(ventana);MyDialogFragment.newInstance("Cadena de ejemplo como parámetro");
                return true;
            default:
                return true;
        }
    }

    public class AdaptadorTratamientos extends ArrayAdapter {

        Activity context;

        AdaptadorTratamientos(Activity context) {

            super(context, R.layout.activity_tratamiento, datos);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_tratamiento, null);


            TextView tratamiento = (TextView) item.findViewById(R.id.tratamiento);
            tratamiento.setText(datos[i].getNombre());


            return (item);
        }
    }

}
