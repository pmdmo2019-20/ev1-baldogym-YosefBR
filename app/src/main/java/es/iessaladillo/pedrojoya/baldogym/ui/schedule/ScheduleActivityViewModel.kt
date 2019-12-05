package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession

class ScheduleActivityViewModel(private val repository: Repository,
                             private val application: Application) : ViewModel() {


    private val _trainingSessions: MutableLiveData<List<TrainingSession>> = MutableLiveData()
    val trainingSessions: LiveData<List<TrainingSession>>
        get() = _trainingSessions

    init {
        _trainingSessions.value = repository.queryTrainingSessions()
    }
}