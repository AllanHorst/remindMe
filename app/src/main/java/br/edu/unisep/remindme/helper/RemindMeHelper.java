package br.edu.unisep.remindme.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Allan Horst on 02/04/2017.
 */

public class RemindMeHelper extends SQLiteOpenHelper {

    public RemindMeHelper(Context context) {
        super(context, "remind-me", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder builder = new StringBuilder();

        builder.append("create table lembretes ( ");
        builder.append("    _id INTEGER PRIMARY KEY, ");
        builder.append("    descricao TEXT, ");
        builder.append("    status TEXT);");

        sqLiteDatabase.execSQL(builder.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
