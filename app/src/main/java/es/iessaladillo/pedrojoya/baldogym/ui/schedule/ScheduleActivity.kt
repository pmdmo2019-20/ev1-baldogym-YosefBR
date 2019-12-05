package es.iessaladillo.pedrojoya.baldogym.ui.schedule

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import es.iessaladillo.pedrojoya.baldogym.data.entity.TrainingSession
import es.iessaladillo.pedrojoya.baldogym.data.entity.getCurrentWeekDay
import es.iessaladillo.pedrojoya.baldogym.utils.invisibleUnless
import kotlinx.android.synthetic.main.schedule_activity.*

class ScheduleActivity : AppCompatActivity() {

    private val viewModel: ScheduleActivityViewModel by viewModels {
        ScheduleActivityViewModelFactory(LocalRepository, application)
    }

    private val listAdapter: ScheduleActivityAdapter = ScheduleActivityAdapter().also {
        it.onItemClickListener = { position ->
            watchTrainingSession(it.getItem(position))
        }
    }

    private fun watchTrainingSession(trainingSession: TrainingSession) {
        val intent = viewModel.seeTrainingSession(trainingSession)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.schedule_activity)
        setupViews()
        setupRecyclerView()
        observeTrainingSessions()
    }

    private fun setupRecyclerView() {
        lstSessions.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            itemAnimator = DefaultItemAnimator()
            adapter = listAdapter
        }
    }

    private fun setupViews() {
        actualDay.text = getCurrentWeekDay().toString()
        buttonMon.setOnClickListener {
            actualDay.text = "MONDAY"
            viewModel.filterMonday()
        }
        buttonTue.setOnClickListener {
            actualDay.text = "TUESDAY"
            viewModel.filterTuesday()
        }
        buttonWed.setOnClickListener {
            actualDay.text = "WEDNESDAY"
            viewModel.filterWednesday()
        }
        buttonThu.setOnClickListener {
            actualDay.text = "THURSDAY"
            viewModel.filterThursday()
        }
        buttonFri.setOnClickListener {
            actualDay.text = "FRIDAY"
            viewModel.filterFriday()
        }
        buttonSat.setOnClickListener {
            actualDay.text = "SATURDAY"
            viewModel.filterSaturday()
        }
        buttonSun.setOnClickListener {
            actualDay.text = "SUNDAY"
            viewModel.filterSunday()
        }
    }

    private fun observeTrainingSessions() {
        viewModel.trainingSessions.observe(this) {
            showTrainingSessions(it)
        }
    }

    private fun showTrainingSessions(newList: List<TrainingSession>) {
        lstSessions.post {
            listAdapter.submitList(newList)
            lblEmptyView.invisibleUnless(newList.isEmpty())
        }
    }
}
