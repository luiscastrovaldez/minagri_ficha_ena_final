package pe.gob.minagri.ena.sql;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pe.gob.minagri.ena.entity.DaoMaster;
import pe.gob.minagri.ena.entity.DaoSession;
import pe.gob.minagri.ena.entity.EnaForm;
import pe.gob.minagri.ena.entity.EnaFormDao;
import pe.gob.minagri.ena.entity.Lote3;
import pe.gob.minagri.ena.entity.Lote3Dao;
import pe.gob.minagri.ena.entity.Point;
import pe.gob.minagri.ena.entity.PointDao;
import pe.gob.minagri.ena.entity.Polygon;
import pe.gob.minagri.ena.entity.PolygonDao;
import pe.gob.minagri.ena.entity.Ubigeo;
import pe.gob.minagri.ena.entity.UbigeoDao;


public class SqlHelper {

    private Context context;
    private FeedReaderDbHelper feedReaderDbHelper;
    private SQLiteDatabase db;

    public SqlHelper(Context context) {
        this.context = context;
        this.feedReaderDbHelper = new FeedReaderDbHelper(context);
    }

    public void reCreateDb() {
        this.feedReaderDbHelper.onUpgrade(db, 0, 0);
    }

    public long saveInformation(EnaForm info) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getEnaFormDao().insertOrReplace(info);
            newRowId = info.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public long saveLote(Lote3 lote) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getLote3Dao().insertOrReplace(lote);
            newRowId = lote.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }


    public Lote3 getLote(int index, String dni, String parcela, String segmento) {
        List<Lote3> resultado;
        Lote3 lote = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getLote3Dao().queryBuilder()
                    .where(Lote3Dao.Properties.Dni.eq(dni))
                    .where(Lote3Dao.Properties.Index.eq(index))
                    .where(Lote3Dao.Properties.Parcela.eq(parcela))
                    .where(Lote3Dao.Properties.Segmento.eq(segmento)).list();
            if (resultado != null && !resultado.isEmpty()) {
                lote = resultado.get(0);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return lote;
    }


    public long updateInformation(EnaForm info) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getEnaFormDao().update(info);
            newRowId = info.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }


    public long savePolygon(Polygon polygon) {
        long newRowId = -1;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getPolygonDao().insert(polygon);
            newRowId = polygon.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }


    public long savePoint(Point point) {
        long newRowId = -1;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getPointDao().insert(point);
            newRowId = point.getId();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public long saveUbigeo(List<Ubigeo> ubigeos) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getUbigeoDao().insertInTx(ubigeos);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public void deleteAllUbigeo() {
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getUbigeoDao().deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    /*
    public void deleteEna(String nroEmpresa, String nroParcela) {
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            EnaForm ena = obtenerEnaFormByNroEmpresaAndParcela(nroEmpresa, nroParcela);
            if (ena != null) {
                session.getEnaFormDao().delete(ena);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }
    */

    public List<Polygon> getPoligonsByDni(String dni) {
        List<Polygon> resultado;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getPolygonDao().queryBuilder()
                    .where(PolygonDao.Properties.Dni.eq(dni))
                    .list();


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultado;
    }

    public List<Point> getPointsByPolygonId(Long idPolygon) {
        List<Point> resultado;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getPointDao().queryBuilder()
                    .where(PointDao.Properties.IdPolygon.eq(idPolygon)).list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultado;
    }


    public long countUbigeo() {

        long count;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            count = session.getUbigeoDao().count();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    public List<Ubigeo> obtenerEmpresa() {
        List<Ubigeo> resultado;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            resultado = session.getUbigeoDao().queryBuilder().list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultado;
    }

    public Ubigeo obtenerEmpresaByNroEmpresa(String nroEmpresa, String nroParcela) {
        List<Ubigeo> resultado;
        Ubigeo retornar = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            resultado = session.getUbigeoDao().queryBuilder()
                    .where(UbigeoDao.Properties.Cod_segmento_empresa.eq(nroEmpresa))
                    .where(UbigeoDao.Properties.Num_parcela_sm.eq(nroParcela)).list();
            if (resultado != null && !resultado.isEmpty()) {
                retornar = resultado.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return retornar;
    }

    public EnaForm obtenerEnaFormByNroEmpresaAndParcela(String NroEmpresa, String nroParcela, String dni) {
        List<EnaForm> resultado;
        EnaForm retornar = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            resultado = session.getEnaFormDao().queryBuilder()
                    .where(EnaFormDao.Properties.SegmentoEmpresa.eq(NroEmpresa))
                    .where(EnaFormDao.Properties.Dni.eq(dni))
                    .where(EnaFormDao.Properties.NroParcela.eq(nroParcela)).list();
            if (resultado != null && !resultado.isEmpty()) {
                retornar = resultado.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return retornar;
    }

    public List<EnaForm> obtenerFormularios() {
        List<EnaForm> resultado;
        EnaForm retornar = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            resultado = session.getEnaFormDao().queryBuilder().list();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultado;
    }


    public List<Ubigeo> buscarDepartamentos() {
        List<Ubigeo> listado = null;
        Ubigeo ubigeo = null;
        Cursor c = null;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            String SQL_DISTINCT_ENAME = "SELECT DISTINCT COD_DEPARTAMENTO,DEPARTAMENTO FROM Ubigeo order by departamento asc  ";
            listado = new ArrayList<>();
            c = session.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
            if (c.moveToFirst()) {
                do {
                    ubigeo = new Ubigeo();
                    ubigeo.setCod_departamento(c.getString(0));
                    ubigeo.setDepartamento(c.getString(1));
                    listado.add(ubigeo);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (c != null)
                c.close();

        }
        return listado;
    }

    public List<Ubigeo> buscarProvincias(String codDepartamento) {
        List<Ubigeo> listado = null;
        Ubigeo ubigeo = null;
        Cursor c = null;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            String SQL_DISTINCT_ENAME = "SELECT DISTINCT COD_PROVINCIA,PROVINCIA FROM Ubigeo WHERE COD_DEPARTAMENTO = " + codDepartamento + " order by PROVINCIA asc  ";
            listado = new ArrayList<>();
            c = session.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
            if (c.moveToFirst()) {
                do {
                    ubigeo = new Ubigeo();
                    ubigeo.setCod_provincia(c.getString(0));
                    ubigeo.setProvincia(c.getString(1));
                    listado.add(ubigeo);
                } while (c.moveToNext());
            }
            return listado;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (c != null)
                c.close();
        }
    }

    public List<Ubigeo> buscarDistritos(String codDepartamento, String codProvincia) {
        List<Ubigeo> listado = null;
        Ubigeo ubigeo = null;
        Cursor c = null;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            String SQL_DISTINCT_ENAME = "SELECT DISTINCT COD_DISTRITO,DISTRITO FROM Ubigeo WHERE COD_DEPARTAMENTO = " + codDepartamento + " AND COD_PROVINCIA = " + codProvincia + " order by DISTRITO asc  ";
            listado = new ArrayList<>();
            c = session.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
            if (c.moveToFirst()) {
                do {
                    ubigeo = new Ubigeo();
                    ubigeo.setCod_distrito(c.getString(0));
                    ubigeo.setDistrito(c.getString(1));
                    listado.add(ubigeo);
                } while (c.moveToNext());
            }
            return listado;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (c != null)
                c.close();
        }
    }


    public List<Ubigeo> buscarCentroPoblados(String codDepartamento, String codProvincia, String codDistrito, String cod_segmento_empresa) {
        List<Ubigeo> listado = null;
        Ubigeo ubigeo = null;
        Cursor c = null;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            String SQL_DISTINCT_ENAME = "SELECT DISTINCT cod_ccpp,ccpp FROM Ubigeo WHERE cod_segmento_empresa = " + cod_segmento_empresa + " and COD_DEPARTAMENTO = " + codDepartamento + " AND COD_PROVINCIA = " + codProvincia + " AND cod_distrito= " + codDistrito + " order by DISTRITO asc  ";
            listado = new ArrayList<>();
            c = session.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
            if (c.moveToFirst()) {
                do {
                    ubigeo = new Ubigeo();
                    ubigeo.setCod_ccpp(c.getString(0));
                    ubigeo.setCcpp(c.getString(1));
                    listado.add(ubigeo);
                } while (c.moveToNext());
            }


            return listado;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (c != null)
                c.close();
        }
    }

    public List<Ubigeo> buscarComunidadCampesina(String codDepartamento, String codProvincia, String codDistrito, String cod_segmento_empresa) {
        List<Ubigeo> listado = null;
        Ubigeo ubigeo = null;
        Cursor c = null;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            String SQL_DISTINCT_ENAME = "SELECT DISTINCT cod_cc,cc FROM Ubigeo WHERE cod_segmento_empresa = " + cod_segmento_empresa + " and COD_DEPARTAMENTO = " + codDepartamento + " AND COD_PROVINCIA = " + codProvincia + " AND cod_distrito= " + codDistrito + " order by DISTRITO asc  ";
            listado = new ArrayList<>();
            c = session.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
            if (c.moveToFirst()) {
                do {
                    ubigeo = new Ubigeo();
                    ubigeo.setCod_cc(c.getString(0));
                    ubigeo.setCc(c.getString(1));
                    listado.add(ubigeo);
                } while (c.moveToNext());
            }

            return listado;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (c != null)
                c.close();
        }
    }

    public List<Ubigeo> buscarComunidadNativa(String codDepartamento, String codProvincia, String codDistrito, String cod_segmento_empresa) {
        List<Ubigeo> listado = null;
        Ubigeo ubigeo = null;
        Cursor c = null;
        try {
            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            String SQL_DISTINCT_ENAME = "SELECT DISTINCT cod_cn,cn FROM Ubigeo WHERE cod_segmento_empresa = " + cod_segmento_empresa + " and COD_DEPARTAMENTO = " + codDepartamento + " AND COD_PROVINCIA = " + codProvincia + " AND cod_distrito= " + codDistrito + " order by DISTRITO asc  ";
            listado = new ArrayList<>();
            c = session.getDatabase().rawQuery(SQL_DISTINCT_ENAME, null);
            if (c.moveToFirst()) {
                do {
                    ubigeo = new Ubigeo();
                    ubigeo.setCod_cn(c.getString(0));
                    ubigeo.setCn(c.getString(1));
                    listado.add(ubigeo);
                } while (c.moveToNext());
            }

            return listado;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (c != null)
                c.close();
        }
    }


}
