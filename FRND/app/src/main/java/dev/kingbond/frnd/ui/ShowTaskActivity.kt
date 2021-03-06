package dev.kingbond.frnd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.kingbond.frnd.data.local.TaskDatabaseModel
import dev.kingbond.frnd.data.remote.request.DeleteTaskRequest
import dev.kingbond.frnd.data.remote.request.TaskGetRequest
import dev.kingbond.frnd.databinding.ActivityMainBinding
import dev.kingbond.frnd.ui.recyclerview.ClickListener
import dev.kingbond.frnd.ui.recyclerview.TaskAdapter
import dev.kingbond.frnd.utils.Constants
import dev.kingbond.frnd.utils.Constants.showNotifications
import dev.kingbond.frnd.viewmodel.TaskViewModel

@AndroidEntryPoint
class ShowTaskActivity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: TaskAdapter
    private var list = ArrayList<TaskDatabaseModel>()
    private val viewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (!Constants.checkForInternet(this)) {

            viewModel.getTaskfromRepo().observe(this, Observer {
                list.clear()
                list.addAll(it)
                adapter.notifyDataSetChanged()
            })
            setRecyclerView()

        } else {
            setRecycler()
        }
    }

    private fun setRecycler() {

        setRecyclerView()
        viewModel.deleteFromDb()
        val taskGetRequest = TaskGetRequest(Constants.USER_ID)
        viewModel.saveDataToDB(taskGetRequest)
        viewModel.getTaskfromRepo().observe(this, Observer {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun setRecyclerView() {
        adapter = TaskAdapter(list, this)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = linearLayoutManager
        }
    }

    override fun onClick(databaseModel: TaskDatabaseModel, position: Int) {
        if (Constants.checkForInternet(this)) {
            viewModel.deleteFromApi(DeleteTaskRequest(databaseModel.task_id, Constants.USER_ID))
            viewModel.deleteTask(databaseModel)
            adapter.notifyDataSetChanged()
        } else {
            showNotifications(this, "Please turn on Internet")
        }

    }


}