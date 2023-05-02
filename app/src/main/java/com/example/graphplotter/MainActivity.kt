package com.example.graphplotter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.math.E


class MainActivity : AppCompatActivity() {

    private lateinit var lineChart: LineChart
    private lateinit var xIn: EditText
    private lateinit var yIn: EditText
    private lateinit var getButton: Button
    private lateinit var plotButton: Button
    private lateinit var coordinates: ArrayList<Entry>
    private val lineEntry: ArrayList<Entry> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lineChart = findViewById(R.id.lineChart)
        xIn = findViewById(R.id.editText_X_Coordinate)
        yIn = findViewById(R.id.editText_Y_Coordinate)
        getButton = findViewById(R.id.button_Add_Point)
        plotButton = findViewById(R.id.button_Plot)
        getButton.setOnClickListener {
            GetCoordinates()
        }
        plotButton.setOnClickListener {
            SetLineChartData()
        }
    }
    fun GetCoordinates(){
        var xCoord = xIn.text.toString().toFloat()
        var yCoord = yIn.text.toString().toFloat()
        lineEntry.add(Entry(xCoord, yCoord))
    }

    fun SetLineChartData() {
        //val lineEntry = ArrayList<Entry>();
        //coordinates.add(Entry(0f,0f))
        //lineEntry.add(0,Entry(10f,10f))
        //lineEntry.add(1,Entry(10f,10f))
        //lineEntry.add(2,Entry(20f,50f))
        //lineEntry.add(3,Entry(30f,30f))
        //lineEntry.add(4,Entry(40f,49f))

        val lineDataSet = LineDataSet(lineEntry, "test")

        lineDataSet.color = resources.getColor(R.color.purple_200)
        val data = LineData(lineDataSet)
        lineChart.data = data
        lineChart.animateXY(3000,3000)
    }
}