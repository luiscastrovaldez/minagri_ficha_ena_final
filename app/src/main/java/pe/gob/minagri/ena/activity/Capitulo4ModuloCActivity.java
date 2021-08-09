package pe.gob.minagri.ena.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.R;
import pe.gob.minagri.ena.entity.Combo;

public class Capitulo4ModuloCActivity extends AppCompatActivity {

    private Spinner p432_rpta, p433b, p434, p435a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo4_modulo_c);
        p432_rpta = findViewById(R.id.p432_rpta);
        p433b = findViewById(R.id.p433b);
        p434 = findViewById(R.id.p434);
        p435a2 = findViewById(R.id.p435a2);
        agregarP432();
        agregarP432b();
        agregarP434();
        agregarP435a2();
    }

    public void agregarP432() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "Cultivo 1"));
        list.add(new Combo("2", "Cultivo 2"));
        list.add(new Combo("3", "Cultivo 3"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p432_rpta.setAdapter(dataAdapter);
    }

    public void agregarP432b() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "KILOS"));
        list.add(new Combo("2", "SACOS"));
        list.add(new Combo("3", "SAQUILLO"));
        list.add(new Combo("4", "CIENTOS"));
        list.add(new Combo("5", "QUINTALE"));
        list.add(new Combo("6", "UNIDADES"));
        list.add(new Combo("7", "BALDES"));
        list.add(new Combo("8", "CANASTAS"));
        list.add(new Combo("9", "RACIMOS"));
        list.add(new Combo("10", "ARROBAS"));
        list.add(new Combo("11", "CARGAS"));
        list.add(new Combo("12", "LATAS"));
        list.add(new Combo("13", "JABAS"));
        list.add(new Combo("14", "TERCIOS"));
        list.add(new Combo("15", "TONELADA"));
        list.add(new Combo("16", "LIBRA"));
        list.add(new Combo("17", "ATADOS"));
        list.add(new Combo("18", "MANOJOS"));
        list.add(new Combo("19", "PORCION"));
        list.add(new Combo("20", "FANEGAS"));
        list.add(new Combo("21", "BANDEJAS"));
        list.add(new Combo("22", "BOLSAS"));
        list.add(new Combo("23", "CAJAS"));
        list.add(new Combo("24", "CABEZAS"));
        list.add(new Combo("25", "TINAS"));
        list.add(new Combo("26", "QUINTALES"));
        list.add(new Combo("27", "VARAS"));
        list.add(new Combo("28", "CAJONES"));
        list.add(new Combo("29", "PAQUETES"));
        list.add(new Combo("30", "CORTES"));
        list.add(new Combo("31", "FARDOS"));
        list.add(new Combo("32", "LOTE"));
        list.add(new Combo("33", "MANTADAS"));
        list.add(new Combo("34", "MANTAS"));
        list.add(new Combo("35", "DOCENAS"));
        list.add(new Combo("36", "MALLAS"));
        list.add(new Combo("37", "MATAS"));
        list.add(new Combo("38", "BOLA"));
        list.add(new Combo("39", "RAMO"));
        list.add(new Combo("40", "CAMIONES"));
        list.add(new Combo("41", "CARRETA"));
        list.add(new Combo("42", "TALLOS"));
        list.add(new Combo("43", "TABLAS"));
        list.add(new Combo("44", "PACAS"));
        list.add(new Combo("45", "MAZOS"));
        list.add(new Combo("46", "AMARRE"));
        list.add(new Combo("47", "ARCOS"));
        list.add(new Combo("48", "MANOS"));
        list.add(new Combo("49", "TAPAS"));
        list.add(new Combo("50", "MONTON"));
        list.add(new Combo("51", "RACIONES"));
        list.add(new Combo("52", "BRAZADAS"));
        list.add(new Combo("53", "HECTAREA"));
        list.add(new Combo("51", "CESTA"));
        list.add(new Combo("55", "MILLARES"));
        list.add(new Combo("56", "BATEAS"));
        list.add(new Combo("57", "CUARTILL"));
        list.add(new Combo("58", "PANEROS"));
        list.add(new Combo("59", "MACETAS"));
        list.add(new Combo("60", "ROLLOS"));
        list.add(new Combo("61", "BUGGY"));
        list.add(new Combo("62", "CENADA"));
        list.add(new Combo("63", "CALCHA"));
        list.add(new Combo("64", "CHALLCAS"));
        list.add(new Combo("65", "CHOCCOS"));
        list.add(new Combo("66", "CHULLAS"));
        list.add(new Combo("67", "PILONAS"));
        list.add(new Combo("68", "PIRHUA"));
        list.add(new Combo("69", "GAJOS"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p433b.setAdapter(dataAdapter);
    }

    public void agregarP434() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "SI"));
        list.add(new Combo("2", "NO"));

        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p434.setAdapter(dataAdapter);
    }

    public void agregarP435a2() {

        List<Combo> list = new ArrayList<>();
        list.add(new Combo("0", "Seleccionar"));
        list.add(new Combo("1", "KILOS"));
        list.add(new Combo("2", "SACOS"));
        list.add(new Combo("3", "SAQUILLO"));
        list.add(new Combo("4", "CIENTOS"));
        list.add(new Combo("5", "QUINTALE"));
        list.add(new Combo("6", "UNIDADES"));
        list.add(new Combo("7", "BALDES"));
        list.add(new Combo("8", "CANASTAS"));
        list.add(new Combo("9", "RACIMOS"));
        list.add(new Combo("10", "ARROBAS"));
        list.add(new Combo("11", "CARGAS"));
        list.add(new Combo("12", "LATAS"));
        list.add(new Combo("13", "JABAS"));
        list.add(new Combo("14", "TERCIOS"));
        list.add(new Combo("15", "TONELADA"));
        list.add(new Combo("16", "LIBRA"));
        list.add(new Combo("17", "ATADOS"));
        list.add(new Combo("18", "MANOJOS"));
        list.add(new Combo("19", "PORCION"));
        list.add(new Combo("20", "FANEGAS"));
        list.add(new Combo("21", "BANDEJAS"));
        list.add(new Combo("22", "BOLSAS"));
        list.add(new Combo("23", "CAJAS"));
        list.add(new Combo("24", "CABEZAS"));
        list.add(new Combo("25", "TINAS"));
        list.add(new Combo("26", "QUINTALES"));
        list.add(new Combo("27", "VARAS"));
        list.add(new Combo("28", "CAJONES"));
        list.add(new Combo("29", "PAQUETES"));
        list.add(new Combo("30", "CORTES"));
        list.add(new Combo("31", "FARDOS"));
        list.add(new Combo("32", "LOTE"));
        list.add(new Combo("33", "MANTADAS"));
        list.add(new Combo("34", "MANTAS"));
        list.add(new Combo("35", "DOCENAS"));
        list.add(new Combo("36", "MALLAS"));
        list.add(new Combo("37", "MATAS"));
        list.add(new Combo("38", "BOLA"));
        list.add(new Combo("39", "RAMO"));
        list.add(new Combo("40", "CAMIONES"));
        list.add(new Combo("41", "CARRETA"));
        list.add(new Combo("42", "TALLOS"));
        list.add(new Combo("43", "TABLAS"));
        list.add(new Combo("44", "PACAS"));
        list.add(new Combo("45", "MAZOS"));
        list.add(new Combo("46", "AMARRE"));
        list.add(new Combo("47", "ARCOS"));
        list.add(new Combo("48", "MANOS"));
        list.add(new Combo("49", "TAPAS"));
        list.add(new Combo("50", "MONTON"));
        list.add(new Combo("51", "RACIONES"));
        list.add(new Combo("52", "BRAZADAS"));
        list.add(new Combo("53", "HECTAREA"));
        list.add(new Combo("51", "CESTA"));
        list.add(new Combo("55", "MILLARES"));
        list.add(new Combo("56", "BATEAS"));
        list.add(new Combo("57", "CUARTILL"));
        list.add(new Combo("58", "PANEROS"));
        list.add(new Combo("59", "MACETAS"));
        list.add(new Combo("60", "ROLLOS"));
        list.add(new Combo("61", "BUGGY"));
        list.add(new Combo("62", "CENADA"));
        list.add(new Combo("63", "CALCHA"));
        list.add(new Combo("64", "CHALLCAS"));
        list.add(new Combo("65", "CHOCCOS"));
        list.add(new Combo("66", "CHULLAS"));
        list.add(new Combo("67", "PILONAS"));
        list.add(new Combo("68", "PIRHUA"));
        list.add(new Combo("69", "GAJOS"));


        ArrayAdapter<Combo> dataAdapter = new ArrayAdapter<Combo>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        p435a2.setAdapter(dataAdapter);
    }
}