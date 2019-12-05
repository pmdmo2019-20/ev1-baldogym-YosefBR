package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.ui.schedule.ScheduleActivityViewModel

class TrainingSessionActivityViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrainingSessionActivityViewModel(repository) as T
    }

}