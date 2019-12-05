package es.iessaladillo.pedrojoya.baldogym.data

import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession

interface Repository {

    fun queryTrainingSessions(): List<TrainingSession>

    fun queryMondaySessions(): List<TrainingSession>
    fun queryTuesdaySessions(): List<TrainingSession>
    fun queryWednesdaySessions(): List<TrainingSession>
    fun queryThursdaySessions(): List<TrainingSession>
    fun queryFridaySessions(): List<TrainingSession>
    fun querySaturdaySessions(): List<TrainingSession>
    fun querySundaySessions(): List<TrainingSession>
    fun getTrainingSession(trainingSessionId: Long): TrainingSession
}