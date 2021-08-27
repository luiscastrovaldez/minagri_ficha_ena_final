package pe.gob.minagri.ena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.NumeroParcela;
import pe.gob.minagri.ena.sql.SqlHelper;
import pe.gob.minagri.ena.util.Constants;

public class ListadoFichasActivity extends AppCompatActivity {

    ListView listadoFichas;
    List<String> fichas;
    private String segmentoEmpresa, dni;
    private Intent mapIntent;
    private EditText totalParcelas;
    private Button generar;
    private TextView segmento;
    private SqlHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_fichas);
        listadoFichas = findViewById(R.id.listadoFichas);
        this.mapIntent = getIntent();
        this.dni = mapIntent.getStringExtra(Constants.DNI);
        this.segmentoEmpresa = mapIntent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        totalParcelas = findViewById(R.id.totalParcelas);
        segmento = findViewById(R.id.segmento);
        segmento.setText(this.segmentoEmpresa);
        this.sqlHelper = new SqlHelper(getApplicationContext());
        generar = findViewById(R.id.generarFichas);

        NumeroParcela numeroParcela = sqlHelper.getNumeroParcela(dni, segmentoEmpresa);
        if (numeroParcela != null) {
            totalParcelas.setText(String.valueOf(numeroParcela.getParcela()));
            fichas = new ArrayList<>();
            int size = Integer.parseInt(totalParcelas.getText().toString());
            for (int i = 0; i < size; i++) {
                fichas.add(i, "Encuesta " + (i + 1));
            }

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, fichas);
            listadoFichas.setAdapter(adapter);
        }


        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalParcelas.setError(null);
                if (totalParcelas.getText() != null && !totalParcelas.getText().toString().isEmpty()) {
                    int size = Integer.parseInt(totalParcelas.getText().toString());
                    if (size > 20) {
                        totalParcelas.setError("Maximo numero de Parcelas es 20");
                        //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                        return;
                    }

                    fichas = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        fichas.add(i, "Ficha " + (i + 1));
                    }

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1, android.R.id.text1, fichas);
                    listadoFichas.setAdapter(adapter);
                    NumeroParcela numeroParcela = new NumeroParcela();
                    numeroParcela = sqlHelper.getNumeroParcela(dni, segmentoEmpresa);
                    if (numeroParcela == null) {
                        numeroParcela = new NumeroParcela();
                    }

                    numeroParcela.setDni(dni);
                    numeroParcela.setParcela("" + size);
                    numeroParcela.setSegmento(segmentoEmpresa);
                    sqlHelper.saveNumeroParcela(numeroParcela);

                } else {
                    totalParcelas.setError("Total de Parcelas es obligatorio");
                    //Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });

        listadoFichas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition = position;
                String itemValue = (String) listadoFichas.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(), ListadoCapitulosActivity.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                int nroParcela = itemPosition + 1;
                intent.putExtra(Constants.NRO_PARCELA, String.valueOf(nroParcela));
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra("totalParcelas", totalParcelas.getText());

                //intent.putExtra("index", "" + itemPosition);


                startActivity(intent);
            }

        });

    }
}