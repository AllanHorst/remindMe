package br.edu.unisep.remindme.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import br.edu.unisep.remindme.R;

/**
 * Created by Allan Horst on 02/04/2017.
 */

public class LembretesAdapter extends CursorAdapter {

    private LayoutInflater inflater;

    public LembretesAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View item = inflater.inflate(R.layout.item_lembrete, null);
        return item;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView lblObjetivo = (TextView) view.findViewById(R.id.lbl_descricao);

        String objetivo = cursor.getString(cursor.getColumnIndex("descricao"));
        lblObjetivo.setText(objetivo);
    }
}
