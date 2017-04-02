package br.edu.unisep.remindme.vo;

import android.content.Intent;

/**
 * Created by Allan Horst on 02/04/2017.
 */

public class LembreteVO {

    public static final String NOME_TABELA = "lembretes";

    private Integer id;

    private String descricao;

    /**
     * ATIVO, INATIVO
     */
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
