package pe.gob.minagri.ena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.envio.Envio;
import pe.gob.minagri.ena.envio.capitulo5.P501;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;

public class Capitulo5Activity extends AppCompatActivity {


    private EnaForm enaForm;
    private SqlHelper sqlHelper;
    private Envio envio;
    private String segmentoEmpresa, nroParcela, dni;
    private List<P501> p501;

    private ListView modulosCapitulo5;

    private String[] titulos = {"Módulo V.A. POBLACIÓN  DE ESPECIES PECUARIAS EN LA UNIDAD AGRARIA AL DÍA DE LA ENTREVISTA ",
            "Módulo V.B. PRODUCCIÓN  DE GANADO VACUNO ENTRE ENERO A DICIEMBRE DE 2020", "Módulo V.C. PRODUCCIÓN  DE PORCINOS DESDE ENERO A DICIEMBRE DEL 2020",
            "Módulo V.D. PRODUCCIÓN  DE CUYES DESDE ENERO A DICIEMBRE DEL 2020", "Módulo V.E. PRODUCCIÓN DE OVINOS Y CAPRINOS DESDE ENERO A DICIEMBRE DEL 2020",
            "Módulo V.F. PRODUCCIÓN DE CAMÉLIDOS, DESDE ENERO A DICIEMBRE DEL 2020",
            "Módulo V.G. PRODUCCIÓN DE AVES ENTRE ENERO A DICIEMBRE DEL 2020", "Módulo V.H. PRODUCCIÓN PECUARIA; SUBPRODUCTOS  DESDE ENERO A DICIEMBRE 2020", "Módulo V.I.  BUENAS PRÁCTICAS PECUARIAS ENTRE ENERO DE 2020 HASTA EL DÍA DE ENTREVISTA ",
            "Módulo V.J. MANEJO SANITARIO DESDE ENERO DE 2020 HASTA EL DÍA DE LA ENTREVISTA",
            "Módulo V.K.  MEJORAMIENTO GENÉTICO DESDE ENERO DE 2020 HASTA EL DÍA DE LA ENTREVISTA. (No aplica para aves)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo5);

        this.sqlHelper = new SqlHelper(getApplicationContext());
        Intent intent = getIntent();
        int orientation = getResources().getConfiguration().orientation;
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);
        modulosCapitulo5 = findViewById(R.id.modulosCapitulo5);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, titulos);
        modulosCapitulo5.setAdapter(adapter);

        modulosCapitulo5.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;
                Intent intent = null;
                // ListView Clicked item value
                String itemValue = (String) modulosCapitulo5.getItemAtPosition(position);
                if (itemPosition == 0) {
                    intent = new Intent(getApplicationContext(), ModuloACapitulo5Activity.class);
                } else if (itemPosition == 1) {
                    intent = new Intent(getApplicationContext(), ModuloBCapitulo5Activity.class);
                } else if (itemPosition == 2) {
                    intent = new Intent(getApplicationContext(), ModuloCCapitulo5Activity.class);
                } else if (itemPosition == 3) {
                    intent = new Intent(getApplicationContext(), ModuloDCapitulo5Activity.class);
                } else if (itemPosition == 4) {
                    intent = new Intent(getApplicationContext(), ModuloECapitulo5Activity.class);
                } else if (itemPosition == 5) {
                    intent = new Intent(getApplicationContext(), ModuloFCapitulo5Activity.class);
                } else if (itemPosition == 6) {
                    intent = new Intent(getApplicationContext(), ModuloGCapitulo5Activity.class);
                } else if (itemPosition == 7) {
                    intent = new Intent(getApplicationContext(), ModuloHCapitulo5Activity.class);
                } else if (itemPosition == 8) {
                    intent = new Intent(getApplicationContext(), ModuloICapitulo5Activity.class);
                } else if (itemPosition == 9) {
                    intent = new Intent(getApplicationContext(), ModuloJCapitulo5Activity.class);
                } else if (itemPosition == 10) {
                    intent = new Intent(getApplicationContext(), ModuloKCapitulo5Activity.class);
                }

                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra("index", "" + itemPosition);

                startActivity(intent);
            }

        });

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked

        int index = 0;
        switch (view.getId()) {

        }
    }


}