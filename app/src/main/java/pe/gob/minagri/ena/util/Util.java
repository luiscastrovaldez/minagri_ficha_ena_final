package pe.gob.minagri.ena.util;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.entity.Combo;
import pe.gob.minagri.ena.entity.Ubigeo;

public final class Util {

    public static List<Ubigeo> readCsvFile(String path) {
        List<Ubigeo> records = new ArrayList<Ubigeo>();
        Ubigeo ubigeo = null;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                ubigeo = new Ubigeo();

                if (!line.startsWith("IDDPTO")) {
                    //IDDPTO;DEP;IDPROV;PROV;IDDIST;DIST;
                    ubigeo.setCod_departamento(values[0]);
                    ubigeo.setDepartamento(values[1]);
                    ubigeo.setCod_provincia(values[2]);
                    ubigeo.setProvincia(values[3]);
                    ubigeo.setCod_distrito(values[4]);
                    ubigeo.setDistrito(values[5]);
                    //REG_NAT;REGION_NATURAL;PISO_ECO;PISO_ECOLOGICO;
                    ubigeo.setCod_region_natural(values[6]);
                    ubigeo.setRegion_natural(values[7]);
                    ubigeo.setCod_piso_ecologico(values[8]);
                    ubigeo.setPiso_ecologico(values[9]);
                    //SUBESTRATO;TIPO_GRILLA;SERPENTIN;
                    ubigeo.setCod_subestrato(values[10]);
                    ubigeo.setCod_tipo_grilla(values[11]);
                    ubigeo.setCod_serpentin(values[12]);
                    //GEOCODIGO;COD_CC;COMUNIDAD_CAMPESINA;
                    ubigeo.setCod_geocodigo(values[13]);
                    ubigeo.setCod_cc(values[14]);
                    ubigeo.setCc(values[15]);
                    //COD_CN;COMUNIDAD_NATIVA; pendiente
                    ubigeo.setCod_cn(values[16]);
                    ubigeo.setCn(values[17]);
                    // NRO_SEGMENTO_EMPRESA;NUM_TOTAL_PARCELAS;NOMBRE_CENTRO_POBLADO;COD_CENTRO_POBLADO;NUM_PARCELA
                    ubigeo.setCod_segmento_empresa(values[18]);
                    ubigeo.setNum_total_parcelas_sm(values[19]);
                    ubigeo.setCcpp(values[20]);
                    ubigeo.setCod_ccpp(values[21]);
                    ubigeo.setNum_parcela_sm(values[22]);

                    records.add(ubigeo);
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    public static void validarFolder() throws Exception {
        File mediaStorageDir = null;
        String[] files = Constants.FILES;
        for (int i = 0; i < files.length; i++) {
            mediaStorageDir = new File(files[i]);
            if (!mediaStorageDir.exists()) {
                throw new Exception("Carpeta no existe " + mediaStorageDir.getName());
            }
        }
    }

    public static int getIndex(Spinner spinner, String myString) {
        for (int i = 0; i < spinner.getCount(); i++) {
            Combo combo = (Combo) spinner.getItemAtPosition(i);
            if (combo.getId().equalsIgnoreCase(myString)) {
                return i;
            }
        }
        return 0;
    }

    public static String loadData(AssetManager assetManager, String inFile) {
        String tContents = "";

        try {
            InputStream stream = assetManager.open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tContents;

    }

    public static void setearInformacion(Resources resources, View view, String formulario) {
        String name = null;
        try {
            JSONObject coderollsJSONObject = new JSONObject(formulario);

            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                name = resources.getResourceEntryName(editText.getId());
                System.out.println("name edite = " + name);
                String valor = coderollsJSONObject.getString(name);
                if (!valor.contains("_value")) {
                    editText.setText(valor);
                }
            }

            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                name = resources.getResourceEntryName(textView.getId());
                String valor = coderollsJSONObject.getString(name);
                if (!valor.contains("_value")) {
                    textView.setText(valor);
                }
            }

            if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                name = resources.getResourceEntryName(spinner.getId());
                System.out.println("name spinner = " + name);
                String valor = coderollsJSONObject.getString(name);
                spinner.setSelection(Util.getIndex(spinner, valor));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getJsonValue(String formulario, String name) {
        String valor = "";
        try {
            JSONObject coderollsJSONObject = new JSONObject(formulario);
            valor = coderollsJSONObject.getString(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valor;
    }

    public static void setearInformacionArray(Resources resources, View view, String formulario, String seccion) {
        String name = null;
        JSONObject help;
        try {
            JSONObject coderollsJSONObject = new JSONObject(formulario);
            JSONArray seccionJson = coderollsJSONObject.getJSONArray(seccion);
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                name = resources.getResourceEntryName(editText.getId());
                for (int i = 0; i < seccionJson.length(); i++) {
                    help = seccionJson.getJSONObject(i);
                    try {
                        String valor = help.getString(name);
                        if (!valor.contains("_value")) {
                            editText.setText(valor);
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }

            }

            if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                name = resources.getResourceEntryName(spinner.getId());
                for (int i = 0; i < seccionJson.length(); i++) {
                    help = seccionJson.getJSONObject(i);
                    try {
                        String valor = help.getString(name);
                        spinner.setSelection(Util.getIndex(spinner, valor));
                    } catch (Exception e) {
                        continue;
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generarJson(Resources resources, View view, String formulario) {
        String name = null;
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            name = resources.getResourceEntryName(editText.getId());
            name = name.concat("_value");
            System.out.println("name edite = " + name);
            if (editText.getText() != null && !editText.getText().toString().isEmpty()) {
                formulario = formulario.replace(name, editText.getText());
            }

        }
        if (view instanceof CheckBox) {
            name = resources.getResourceEntryName(((CheckBox) view).getId());
            System.out.println("name = " + name);
            System.out.println(((CheckBox) view).getId());
            System.out.println(((CheckBox) view).isChecked());

        }

        if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            name = resources.getResourceEntryName(spinner.getId());
            System.out.println("name spinner = " + name);
            name = name.concat("_value");
            Combo combo = ((Combo) (spinner).getSelectedItem());
            formulario = formulario.replace(name, combo.getId());

        }
        return formulario;
    }
}
