package com.example.room2021;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CompetenceDao {
    @Insert
    void insert(Competence competence);

    @Delete
    void deleteCompetence(Competence competence);

    @Query("DELETE FROM competence_table")
    void deleteAll();

    @Query("SELECT * from competence_table ORDER BY ordreAffiche ASC")
    LiveData<List<Competence>> getToutesCompetences();

    // @Query("SELECT MAX(ordreAffiche) from competence_table")
    // int getMaxOrdre();

    @Update
    void updateCompetence(Competence competence);

}

