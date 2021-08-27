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
import pe.gob.minagri.ena.entity.Lote4;
import pe.gob.minagri.ena.entity.Lote4Dao;
import pe.gob.minagri.ena.entity.ModuloACapitulo5;
import pe.gob.minagri.ena.entity.ModuloACapitulo5Dao;
import pe.gob.minagri.ena.entity.ModuloBCCapitulo5;
import pe.gob.minagri.ena.entity.ModuloBCCapitulo5Dao;
import pe.gob.minagri.ena.entity.NumeroParcela;
import pe.gob.minagri.ena.entity.NumeroParcelaDao;
import pe.gob.minagri.ena.entity.OrdenB;
import pe.gob.minagri.ena.entity.OrdenBDao;
import pe.gob.minagri.ena.entity.OrdenC;
import pe.gob.minagri.ena.entity.OrdenCDao;
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

    public long saveLote3(Lote3 lote) {
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

    public NumeroParcela getNumeroParcela(String dni, String segmento) {
        List<NumeroParcela> resultado;
        NumeroParcela numeroParcela = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getNumeroParcelaDao().queryBuilder()
                    .where(NumeroParcelaDao.Properties.Dni.eq(dni))
                    .where(NumeroParcelaDao.Properties.Segmento.eq(segmento)).list();
            if (resultado != null && !resultado.isEmpty()) {
                numeroParcela = resultado.get(0);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return numeroParcela;
    }

    public long saveNumeroParcela(NumeroParcela numeroParcela) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getNumeroParcelaDao().insertOrReplace(numeroParcela);
            newRowId = numeroParcela.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public long saveOrdenB(OrdenB ordenB) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getOrdenBDao().insertOrReplace(ordenB);
            newRowId = ordenB.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public long saveOrdenC(OrdenC ordenC) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getOrdenCDao().insertOrReplace(ordenC);
            newRowId = ordenC.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public long saveLote4(Lote4 lote) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getLote4Dao().insertOrReplace(lote);
            newRowId = lote.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public long saveModuloACapitulo5(ModuloACapitulo5 moduloACapitulo5) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getModuloACapitulo5Dao().insertOrReplace(moduloACapitulo5);
            newRowId = moduloACapitulo5.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public ModuloACapitulo5 getModuloACapitulo5(String dni, String parcela, String segmento) {
        List<ModuloACapitulo5> resultado;
        ModuloACapitulo5 moduloACapitulo5 = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getModuloACapitulo5Dao().queryBuilder()
                    .where(ModuloACapitulo5Dao.Properties.Dni.eq(dni))
                    //.where(ModuloACapitulo5Dao.Properties.Index.eq(index))
                    .where(ModuloACapitulo5Dao.Properties.Parcela.eq(parcela))
                    .where(ModuloACapitulo5Dao.Properties.Segmento.eq(segmento)).list();
            if (resultado != null && !resultado.isEmpty()) {
                moduloACapitulo5 = resultado.get(0);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return moduloACapitulo5;
    }

    public long saveModuloBCCapitulo5(ModuloBCCapitulo5 moduloBCCapitulo5) {
        long newRowId = -1;
        try {

            db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            session.getModuloBCCapitulo5Dao().insertOrReplace(moduloBCCapitulo5);
            newRowId = moduloBCCapitulo5.getId();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return newRowId;
    }

    public ModuloBCCapitulo5 getModuloBCCapitulo5(String dni, String parcela, String segmento) {
        List<ModuloBCCapitulo5> resultado;
        ModuloBCCapitulo5 moduloBCCapitulo5 = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getModuloBCCapitulo5Dao().queryBuilder()
                    .where(ModuloBCCapitulo5Dao.Properties.Dni.eq(dni))
                    //.where(ModuloACapitulo5Dao.Properties.Index.eq(index))
                    .where(ModuloBCCapitulo5Dao.Properties.Parcela.eq(parcela))
                    .where(ModuloBCCapitulo5Dao.Properties.Segmento.eq(segmento)).list();
            if (resultado != null && !resultado.isEmpty()) {
                moduloBCCapitulo5 = resultado.get(0);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return moduloBCCapitulo5;
    }


    public Lote3 getLote3(int index, String dni, String parcela, String segmento) {
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

    public OrdenB getOrdenB(int index, String dni, String parcela, String segmento) {
        List<OrdenB> resultado;
        OrdenB ordenB = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getOrdenBDao().queryBuilder()
                    .where(OrdenBDao.Properties.Dni.eq(dni))
                    .where(OrdenBDao.Properties.Index.eq(index))
                    .where(OrdenBDao.Properties.Parcela.eq(parcela))
                    .where(OrdenBDao.Properties.Segmento.eq(segmento)).list();
            if (resultado != null && !resultado.isEmpty()) {
                ordenB = resultado.get(0);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ordenB;
    }

    public OrdenC getOrdenC(int index, String dni, String parcela, String segmento) {
        List<OrdenC> resultado;
        OrdenC ordenC = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getOrdenCDao().queryBuilder()
                    .where(OrdenCDao.Properties.Dni.eq(dni))
                    .where(OrdenCDao.Properties.Index.eq(index))
                    .where(OrdenCDao.Properties.Parcela.eq(parcela))
                    .where(OrdenCDao.Properties.Segmento.eq(segmento)).list();
            if (resultado != null && !resultado.isEmpty()) {
                ordenC = resultado.get(0);
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ordenC;
    }

    public Lote4 getLote4(int index, String dni, String parcela, String segmento) {
        List<Lote4> resultado;
        Lote4 lote = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();

            resultado = session.getLote4Dao().queryBuilder()
                    .where(Lote4Dao.Properties.Dni.eq(dni))
                    .where(Lote4Dao.Properties.Index.eq(index))
                    .where(Lote4Dao.Properties.Parcela.eq(parcela))
                    .where(Lote4Dao.Properties.Segmento.eq(segmento)).list();
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


    public Ubigeo obtenerEmpresaByNroEmpresa(String nroEmpresa) {
        List<Ubigeo> resultado;
        Ubigeo retornar = null;
        try {
            feedReaderDbHelper = new FeedReaderDbHelper(context);
            SQLiteDatabase db = feedReaderDbHelper.getWritableDatabase();
            DaoSession session = new DaoMaster(db).newSession();
            resultado = session.getUbigeoDao().queryBuilder()
                    .where(UbigeoDao.Properties.Cod_segmento_empresa.eq(nroEmpresa))
                    //.where(UbigeoDao.Properties.Num_parcela_sm.eq(nroParcela))
                    .list();
            if (resultado != null && !resultado.isEmpty()) {
                retornar = resultado.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return retornar;
    }

/*


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

    */


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
