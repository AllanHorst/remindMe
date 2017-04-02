package br.edu.unisep.remindme.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.edu.unisep.remindme.helper.RemindMeHelper;
import br.edu.unisep.remindme.vo.LembreteVO;

/**
 * Created by Allan Horst on 02/04/2017.
 */

public class LembreteDAO {

    private RemindMeHelper helper;

    public LembreteDAO(Context context) {
        this.helper = new RemindMeHelper(context);
    }

    public Cursor listar () {
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor crs = db.rawQuery("select * from " + LembreteVO.NOME_TABELA, null);

        return crs;
    }

    public void excluir (Long id) {
        SQLiteDatabase db = helper.getWritableDatabase();

        db.delete(LembreteVO.NOME_TABELA, "_id = "+id, null);
    }

    public void inserir(LembreteVO vo) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("descricao", vo.getDescricao());
        values.put("status", vo.getStatus());

        db.insert(LembreteVO.NOME_TABELA, null, values);
    }

    public void alterar(LembreteVO vo) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("descricao", vo.getDescricao());
        values.put("status", vo.getStatus());

        db.update(LembreteVO.NOME_TABELA, values, "_id = "+ vo.getId(), null);
    }

}
