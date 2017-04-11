package br.edu.unisep.remindme;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import br.edu.unisep.remindme.adapter.LembretesAdapter;
import br.edu.unisep.remindme.dao.LembreteDAO;

public class ListaLembretesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listaLembretes;

    private LembretesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_lembretes);

        this.listaLembretes = (ListView) findViewById(R.id.list_lembretes);

        LembreteDAO dao = new LembreteDAO(this);
        Cursor crs = dao.listar();

        this.adapter = new LembretesAdapter(this, crs);
        this.listaLembretes.setAdapter(this.adapter);

        this.setFonts();
    }

    public void adicionar(View v) {
        Intent i = new Intent(this, CadastroLembreteActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            LembreteDAO dao = new LembreteDAO(this);
            Cursor crs = dao.listar();
            this.adapter.swapCursor(crs);
            this.adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent i = new Intent(this, CadastroLembreteActivity.class);
        i.putExtra("ID_LEMBRETE", id);
        startActivityForResult(i, 1);
    }

    public void setFonts(){
        Typeface black = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Black.otf");

        TextView lblForget = (TextView) findViewById(R.id.lblForget);
        lblForget.setTypeface(black);
    }
}
