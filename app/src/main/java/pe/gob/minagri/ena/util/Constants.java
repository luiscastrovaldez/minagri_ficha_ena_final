package pe.gob.minagri.ena.util;

import android.Manifest;
import android.os.Environment;

import java.io.File;

public class Constants {

    private Constants() {

    }

    public static final String PATH_MINAGRI = Environment.getExternalStorageDirectory() + File.separator + "ena";
    public static final String PATH_MINAGRI_KML = PATH_MINAGRI + File.separator + "kml";
    public static final String PATH_MINAGRI_CARGA = PATH_MINAGRI + File.separator + "csv";
    public static final String PATH_MINAGRI_CARGA_CENTROS_POBLADOS = PATH_MINAGRI + File.separator + "csv" + File.separator + "datos.csv";
    public static final String PATH_MINAGRI_DB = PATH_MINAGRI + File.separator + "db";
    public static final String PATH_MINAGRI_FOTOS = PATH_MINAGRI + File.separator + "fotos";

    public static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;
    public static final int GPS_STORAGE_REQUEST_CODE = 2;

    public static final int CAMERA_REQUEST_CODE = 100;
    public static final int FICHA_REQUEST_CODE = 10;
    public static final int LISTADO_REQUEST_CODE = 20;
    public static final int ARCHIVOS_REQUEST_CODE = 30;
    public static final int MAPAS_REQUEST_CODE = 40;

    public static final int PERMISSION_ALL = 1;

    public static final String[] FILES = {
            PATH_MINAGRI,
            PATH_MINAGRI_KML,
            PATH_MINAGRI_CARGA,
            PATH_MINAGRI_DB,
            PATH_MINAGRI_FOTOS
    };

    public static final String[] PERMISSIONS = {

            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_NETWORK_STATE

    };

    public static final String NUMERO_DNI_ENCUESTADOR = "numeroDniEncuestador";
    public static final String NOMBRE_ENCUESTADOR = "nombreEncuestador";
    public static final String DEPARTAMENTO = "departamento";
    public static final String PROVINCIA = "provincia";
    public static final String DISTRITO = "distrito";
    public static final String ID = "id";

    public static final String SPLIT = "#-#";
    public static final String SEGMENTO_EMPRESA = "segmentoEmpresa";
    public static final String NRO_PARCELA = "nroParcela";
    public static final String DNI = "dni";
    public static final String INDEX = "index";
    public static final String SIZE = "size";
    public static final String FORMULARIO_JSON = "formulario.json";
    public static final String UBICACION_FORMULARIO_JSON = "ubicaciongeografica.json";
    public static final String CAPITULO1_FORMULARIO_JSON = "capitulo1.json";
    public static final String CAPITULO2_FORMULARIO_JSON = "capitulo2.json";
    public static final String CAPITULO3_FORMULARIO_JSON = "capitulo3.json";
    public static final String LOTE3_FORMULARIO_JSON = "lote3.json";
    public static final String LOTE4_FORMULARIO_JSON = "lote4.json";
    public static final String CAPITULO4_FORMULARIO_JSON = "capitulo4.json";
    public static final String CAPITULO5_FORMULARIO_JSON = "capitulo5.json";
    public static final String CAPITULO6_FORMULARIO_JSON = "capitulo6.json";
    public static final String CAPITULO7_FORMULARIO_JSON = "capitulo7.json";
    public static final String CAPITULO8_FORMULARIO_JSON = "capitulo8.json";
    public static final String CAPITULO9_FORMULARIO_JSON = "capitulo9.json";
    public static final String CAPITULO10_FORMULARIO_JSON = "capitulo10.json";
    public static final String CAPITULO11_FORMULARIO_JSON = "capitulo11.json";
    public static final String CAPITULO12_FORMULARIO_JSON = "capitulo12.json";
    public static final String EQUIPO_FORMULARIO_JSON = "equipo.json";
    public static final String INFRAESTRUCTURA_FORMULARIO_JSON = "infraestructura.json";
    public static final String PERSONA_FORMULARIO_JSON = "persona.json";
    public static final String VISITA_FORMULARIO_JSON = "visita.json";

    public static final String ORDENB_FORMULARIO_JSON = "ordenb.json";
    public static final String ORDENC_FORMULARIO_JSON = "ordenc.json";


}
