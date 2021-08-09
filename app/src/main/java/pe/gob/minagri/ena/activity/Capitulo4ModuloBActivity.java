package pe.gob.minagri.ena.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;

public class Capitulo4ModuloBActivity extends AppCompatActivity {

    private Spinner p428_rpta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo4_modulo_b);
        p428_rpta = findViewById(R.id.p428_rpta);

    }

    public void agregarP428() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Cultivo 1"));
        list.add(new Combo("2", "Cultivo 2"));
        list.add(new Combo("3", "Cultivo 3"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p428_rpta.setAdapter(dataAdapter);
    }
}