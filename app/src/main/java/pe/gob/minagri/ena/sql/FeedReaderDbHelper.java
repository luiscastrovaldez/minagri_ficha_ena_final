package pe.gob.minagri.ena.sql;

import android.content.Context;

import java.io.File;

import pe.gob.minagri.ena.entity.DaoMaster;
import pe.gob.minagri.ena.util.Constants;

public class FeedReaderDbHelper extends DaoMaster.DevOpenHelper {

	public static final String DATABASE_NAME = Constants.PATH_MINAGRI_DB + File.separator + "enadb7.db";

	public FeedReaderDbHelper(Context context) {
		super(context, DATABASE_NAME);
	}

}
