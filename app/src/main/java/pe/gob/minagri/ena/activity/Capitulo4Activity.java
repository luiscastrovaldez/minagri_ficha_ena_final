package pe.gob.minagri.ena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.util.Constants;

public class Capitulo4Activity extends AppCompatActivity {

    private ListView lotesView;
    private List<String> lotes;
    private String segmentoEmpresa, nroParcela, dni;
    private Intent intent;
    private FloatingActionButton salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo4);
        lotesView = findViewById(R.id.lotesView4);
        lotes = new ArrayList<>();
        intent = getIntent();
        segmentoEmpresa = intent.getStringExtra(Constants.SEGMENTO_EMPRESA);
        nroParcela = intent.getStringExtra(Constants.NRO_PARCELA);
        dni = intent.getStringExtra(Constants.DNI);

        salir = (FloatingActionButton) findViewById(R.id.salirCapitulo4);

        for (int i = 0; i < 20; i++) {
            lotes.add(i, "Lote " + (i + 1));
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, lotes);
        lotesView.setAdapter(adapter);

        lotesView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) lotesView.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), LoteActivity4.class);
                intent.putExtra(Constants.SEGMENTO_EMPRESA, segmentoEmpresa);
                intent.putExtra(Constants.NRO_PARCELA, nroParcela);
                intent.putExtra(Constants.DNI, dni);
                intent.putExtra("index", "" + itemPosition);


                startActivity(intent);
            }

        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}