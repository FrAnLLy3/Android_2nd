package com.example.room2021;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "competence_table")
public class Competence {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name= "nomCompetence")
    private String nomCompetence ;

    @NonNull
    @ColumnInfo(name= "ordreAffiche")
    private int ordreAffiche ;

    public Competence(String nomCompetence,int ordreAffiche) {
        this.nomCompetence = nomCompetence;
        this.ordreAffiche = ordreAffiche ;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public int getOrdreAffiche() {
        return ordreAffiche ;
    }

    public void setOrdreAffiche(@NonNull int ordreAffiche) {
        this.ordreAffiche = ordreAffiche;
    }

    public void setNomCompetence(@NonNull String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }
}
