package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.app.Application
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.baldogym.data.Repository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.data.entity.WeekDay
import es.iessaladillo.pedrojoya.baldogym.data.entity.getCurrentWeekDay
import es.iessaladillo.pedrojoya.baldogym.ui.trainingsession.TrainingSessionActivity

class ScheduleActivityViewModel(private val repository: Repository,
                             private val application: Application) : ViewModel() {

    private val _trainingSessions: MutableLiveData<List<TrainingSession>> = MutableLiveData()
    private val trainingSessionId: MutableList<Long> = mutableListOf()

    val trainingSessions: LiveData<List<TrainingSession>>
        get() = _trainingSessions

    init {
        _trainingSessions.value = repository.querySessionsByDay(getCurrentWeekDay())
    }

    private fun queryListData(newList: List<TrainingSession>) {
        _trainingSessions.value = newList.sortedByDescending { it.id }
        trainingSessionId.clear()
        trainingSessions.value?.forEach {
            trainingSessionId.add(it.id)
        }
    }

    fun filterMonday() {
        queryTrainingSessions(WeekDay.MONDAY)
    }
    fun filterTuesday() {
        queryTrainingSessions(WeekDay.TUESDAY)
    }
    fun filterWednesday() {
        queryTrainingSessions(WeekDay.WEDNESDAY)
    }
    fun filterThursday() {
        queryTrainingSessions(WeekDay.THURSDAY)
    }
    fun filterFriday() {
        queryTrainingSessions(WeekDay.FRIDAY)
    }
    fun filterSaturday() {
        queryTrainingSessions(WeekDay.SATURDAY)
    }
    fun filterSunday() {
        queryTrainingSessions(WeekDay.SUNDAY)
    }

    private fun queryTrainingSessions(filter: WeekDay) {
        when (filter) {
            WeekDay.MONDAY ->
                queryListData(repository.querySessionsByDay(filter))
            WeekDay.TUESDAY ->
                queryListData(repository.querySessionsByDay(filter))
            WeekDay.WEDNESDAY ->
                queryListData(repository.querySessionsByDay(filter))
            WeekDay.THURSDAY ->
                queryListData(repository.querySessionsByDay(filter))
            WeekDay.FRIDAY ->
                queryListData(repository.querySessionsByDay(filter))
            WeekDay.SATURDAY ->
                queryListData(repository.querySessionsByDay(filter))
            WeekDay.SUNDAY ->
                queryListData(repository.querySessionsByDay(filter))
        }
    }

    fun seeTrainingSession(trainingSessionId: TrainingSession): Intent {
        return Intent(application, TrainingSessionActivity::class.java).putExtra("TrainingSessionId", trainingSessionId.id)
    }
}