package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession

class TrainingSessionActivityViewModel(private val repository: Repository) : ViewModel() {

    private val trainingSessionList: List<TrainingSession> = repository.queryTrainingSessions()

    fun getTrainingSession(trainingSessionId: Long): TrainingSession {
        return repository.getTrainingSession(trainingSessionId)
    }
}