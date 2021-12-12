package dev.kingbond.frnd.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dev.kingbond.frnd.R
import dev.kingbond.frnd.databinding.ActivityCreateTaskBinding
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
@RequiresApi(Build.VERSION_CODES.O)
class CreateTaskActivity : AppCompatActivity(), DateClickListener {

    private var selectedDate: LocalDate? = null
    private lateinit var binding: ActivityCreateTaskBinding
    private lateinit var daysInMonth: ArrayList<String>
    private lateinit var calendarAdapter: CalendarAdapter
    private var curDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectedDate = LocalDate.now()
        curDate = selectedDate.toString()
        //Toast.makeText(this, selectedDate.toString(), Toast.LENGTH_SHORT).show()
        setMonthView()

        binding.addTaskToGoal.setOnClickListener {
            val intent = Intent(this, NewTaskActivity::class.java)
            intent.putExtra("currentDate", selectedDate.toString())
            intent.putExtra("curDate", curDate)
            startActivity(intent)
        }
    }

    private fun setMonthView() {

        previousMonthAction()
        nextMonthAction()

        val currentDate = selectedDate.toString()
        daysInMonth = daysInMonthArray(selectedDate!!)
        calendarAdapter = CalendarAdapter(daysInMonth, this, currentDate, this)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 7)

        binding.apply {
            monthYearTV.text = monthYearFromDate(selectedDate!!)
//            monthYearTV.text = currentDate
            calendarRecyclerView.layoutManager = layoutManager
            calendarRecyclerView.adapter = calendarAdapter
        }
//        currentdate.text = selectedDate.toString()
    }

    private fun daysInMonthArray(date: LocalDate): ArrayList<String> {
        val daysInMonthArray: ArrayList<String> = ArrayList()
        val yearMonth: YearMonth = YearMonth.from(date)
        val daysInMonth: Int = yearMonth.lengthOfMonth()
        val firstOfMonth = selectedDate!!.withDayOfMonth(1)
        val dayOfWeek = firstOfMonth.dayOfWeek.value
        for (i in 1..42) {
            if (i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
                if (i > daysInMonth + dayOfWeek) break
                daysInMonthArray.add("")
            } else {
                daysInMonthArray.add((i - dayOfWeek).toString())
            }
        }
        return daysInMonthArray
    }

    private fun previousMonthAction() {
        binding.previousMonth.setOnClickListener {
            selectedDate = selectedDate!!.minusMonths(1)
            setMonthView()
        }
    }

    private fun nextMonthAction() {
        binding.nextMonth.setOnClickListener {
            selectedDate = selectedDate!!.plusMonths(1)
            setMonthView()
        }
    }

    private fun monthYearFromDate(date: LocalDate): String? {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM yyyy")
        return date.format(formatter)
    }

    override fun onDateClicked(date: String, position: Int, today: String) {
        curDate = today
        //  Toast.makeText(this, today, Toast.LENGTH_SHORT).show()
    }

}