package com.example.room2021;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CompetenceRepository {
    private CompetenceDao maCompetenceDao ;
    private LiveData<List<Competence>> mesCompetences ;

    CompetenceRepository(Application application){
        CompetenceRoomDatabase database = CompetenceRoomDatabase.getDatabase(application);
        maCompetenceDao = database.competenceDao() ;
        mesCompetences = maCompetenceDao.getToutesCompetences() ;
    }
    LiveData<List<Competence>> getMesCompetences(){
        return mesCompetences ;
    }


    /**
     * Insere une nouvelle Competence passee en parametre par le ViewModel <BR>
     *     Lance une tâche asynchrone en background qui fait l'insertion en utilisant la DAO <BR>
     *         Pas de retour
     * @param uneCompetence
     */
    public void insert (Competence uneCompetence){
        CompetenceRoomDatabase.databaseWriteExecutor.execute(()-> {
            maCompetenceDao.insert(uneCompetence);
        });
    }

    public void deleteCompetence (Competence uneCompetence){
        CompetenceRoomDatabase.databaseWriteExecutor.execute(()-> {
            maCompetenceDao.deleteCompetence(uneCompetence);
        });
    }

    public void updateCompetence (Competence uneCompetence){
        CompetenceRoomDatabase.databaseWriteExecutor.execute(()-> {
            maCompetenceDao.updateCompetence(uneCompetence);
        });    }


    public void supprimeTout(){
        CompetenceRoomDatabase.databaseWriteExecutor.execute(()-> {
            maCompetenceDao.deleteAll();
        });
    }


}
