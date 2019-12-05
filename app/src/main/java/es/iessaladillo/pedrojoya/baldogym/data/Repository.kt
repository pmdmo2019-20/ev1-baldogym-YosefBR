package es.iessaladillo.pedrojoya.baldogym.data

import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.data.entity.WeekDay

interface Repository {

    fun queryTrainingSessions(): List<TrainingSession>
    fun querySessionsByDay(weekDay: WeekDay): List<TrainingSession>
    fun getTrainingSession(trainingSessionId: Long): TrainingSession
}