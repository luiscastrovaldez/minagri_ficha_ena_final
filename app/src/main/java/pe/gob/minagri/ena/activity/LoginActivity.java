package pe.gob.minagri.ena.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.util.Constants;

public class LoginActivity extends AppCompatActivity {

    private Spinner tipo_role;
    private EditText dni;
    private Button ir;
    private Intent mapIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tipo_role = findViewById(R.id.tipo_role);
        dni = findViewById(R.id.dni);
        ir = findViewById(R.id.ir);
        ir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Combo tipo_role_value = (Combo) tipo_role.getSelectedItem();
                if (tipo_role_value.getId().equals("0")) {
                    ((TextView) tipo_role.getSelectedView()).setError("Tipo Usuario es Obligatorio");
                    Toast.makeText(getApplicationContext(), "Tipo Usuario es Obligatorio", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (dni.getText() == null || dni.getText().toString().isEmpty()) {
                    dni.setError("Dni es Obligatorio");
                    Toast.makeText(getApplicationContext(), "Dni es Obligatorio", Toast.LENGTH_SHORT).show();
                    return;
                } else if (dni.getText() != null && !dni.getText().toString().isEmpty() && dni.getText().toString().length() != 8) {
                    dni.setError("Dni debe tener 8 numeros");
                    Toast.makeText(getApplicationContext(), "Dni debe tener 8 numeros", Toast.LENGTH_SHORT).show();
                    return;
                }

                mapIntent = new Intent(getApplicationContext(), MapaActivity.class);
                mapIntent.putExtra(Constants.DNI, dni.getText().toString());
                startActivity(mapIntent);
            }
        });
        agregarRole();
    }

    public void agregarRole() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Encuestador"));
        list.add(new Combo("2", "Supervisor"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_role.setAdapter(dataAdapter);
    }
}