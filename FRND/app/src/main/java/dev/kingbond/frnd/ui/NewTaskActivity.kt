package dev.kingbond.frnd.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import dev.kingbond.frnd.R
import dev.kingbond.frnd.databinding.ActivityNewTaskBinding
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class NewTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewTaskBinding
    private var time = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDate()
        setTime()

        binding.ibProfileBackNewTask.setOnClickListener {
            startActivity(Intent(this, CreateTaskActivity::class.java))
        }

        binding.submitTask.setOnClickListener {
            startActivity(Intent(this, ShowTaskActivity::class.java))
        }
    }

    private fun setDate() {
        val sdf = SimpleDateFormat("  yyyy-MM-dd")
        val currentDate = sdf.format(Date())
        binding.addToDateTask.text = currentDate

        binding.addToDateTask.setOnClickListener {
            val cal = Calendar.getInstance()

            val dateSetListener =
                DatePickerDialog.OnDateSetListener { anotherView, year, monthOfYear, dayOfMonth ->
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, monthOfYear)
                    cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    val myFormat = "yyyy-MM-dd" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    binding.addToDateTask.text = sdf.format(cal.time)
                }

            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }


    // to take the input : time
    private fun setTime() {
        val sdf = SimpleDateFormat("hh-mm aaa")
        val currentDate = sdf.format(Date())
        binding.addTimeTask.text = currentDate

        binding.addTimeTask.setOnClickListener {
            val cal = Calendar.getInstance()

            val dateSetListener =
                TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                    cal.set(Calendar.HOUR_OF_DAY, i)
                    cal.set(Calendar.MINUTE, i2)

                    time = "$i:$i2"
                    val myFormat = "hh-mm aaa" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat)
                    binding.addTimeTask.text = sdf.format(cal.time)
                }

            TimePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.HOUR),
                cal.get(Calendar.MINUTE),
                false
            ).show()

        }
    }
}