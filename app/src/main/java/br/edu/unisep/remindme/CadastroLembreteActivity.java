package br.edu.unisep.remindme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.edu.unisep.remindme.dao.LembreteDAO;
import br.edu.unisep.remindme.service.LocationListener;
import br.edu.unisep.remindme.vo.LembreteVO;

public class CadastroLembreteActivity extends AppCompatActivity  {

    private EditText descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_lembrete);

        this.descricao = (EditText) findViewById(R.id.txt_descricao);

        Intent serviceIntent = new Intent(this, LocationListener.class);
        startService(serviceIntent);
    }

    public void salvar(View v) {
        LembreteDAO dao = new LembreteDAO(this);

        LembreteVO vo = new LembreteVO();
        vo.setDescricao(this.descricao.getText().toString());
        vo.setStatus("ATIVO");

        dao.inserir(vo);

        setResult(RESULT_OK);
        finish();
    }


}
