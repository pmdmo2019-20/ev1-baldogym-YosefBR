package es.iessaladillo.pedrojoya.baldogym.ui.trainingsession
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.baldogym.R
import es.iessaladillo.pedrojoya.baldogym.data.LocalRepository
import kotlinx.android.synthetic.main.training_session_activity.*

class TrainingSessionActivity : AppCompatActivity() {

    private val viewModel: TrainingSessionActivityViewModel by viewModels {
        TrainingSessionActivityViewModelFactory(LocalRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.training_session_activity)
        setupViews()
    }

    private fun setupViews() {
        val id = intent.getLongExtra("TrainingSessionId", 0)
        imgSession.setImageResource(viewModel.getTrainingSession(id).photoResId)
        lblSessionName.text = viewModel.getTrainingSession(id).name
        lblSessionTrainer.text = viewModel.getTrainingSession(id).trainer
        lblSessionDay.text = viewModel.getTrainingSession(id).weekDay.toString()
        lblSessionHour.text = viewModel.getTrainingSession(id).time
        lblSessionRoom.text = viewModel.getTrainingSession(id).room
        lblSessionDesc.text = viewModel.getTrainingSession(id).description
        lblParticipants.text = getString(R.string.participants, viewModel.getTrainingSession(id).participants)
    }

}
