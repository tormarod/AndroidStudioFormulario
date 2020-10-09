package com.example.formulario

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_main.*

object constants {
    val NAME = "name"
    val LASTNAME = "lastname"
    val GENDER = "gender"
    val HOBBIES = "hobbies"
    val AGE = "age"
}

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var lastName: EditText
    lateinit var ageActual: TextView
    lateinit var radioGroup: RadioGroup
    lateinit var radioButtonMale: RadioButton
    lateinit var radioButtonFemale: RadioButton
    lateinit var checkBoxFootball: CheckBox
    lateinit var checkBoxTennis: CheckBox
    lateinit var checkBoxSwimming: CheckBox
    lateinit var seekBarAge: SeekBar
    var age: Int = 18

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
        ageActual.text = getString(R.string.ageActual).format(age)
        setListeners()
    }

    private fun setListeners() {
        // Send button
        buttonSendId.setOnClickListener {
            send()
        }
        // Age seek bar
        seekBarAgeId.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                age = progress + 18
                ageActual.text = getString(R.string.ageActual).format(age)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //TODO("Not yet implemented")
            }

        })
    }

    private fun setup() {
        // Binding variables with layout elements
        name = editTextNameId // name = findViewById(editTextName)
        lastName = editTextLastNameId
        ageActual = textViewAgeActualId
        radioGroup = radioGroupSexId
        radioButtonMale = radioButtonMaleId
        radioButtonFemale = radioButtonFemaleId
        checkBoxFootball = checkBoxFootballId
        checkBoxTennis = checkBoxTennisId
        seekBarAge = seekBarAgeId
    }

    fun clear(v: View) {
        Toast.makeText(this, getString(R.string.msgClear), Toast.LENGTH_SHORT).show()
        editTextNameId.setText("")
        editTextLastNameId.setText("")
        radioGroupSexId.clearCheck()
        checkBoxFootballId.isChecked = false
        checkBoxTennisId.isChecked = false
        checkBoxSwimmingId.isChecked = false
        seekBarAgeId.progress = 0
        age = 18
        ageActual.text = getString(R.string.ageActual).format(age)
        editTextNameId.requestFocus()
    }

    private fun send() {
        Toast.makeText(this, getString(R.string.msgSend), Toast.LENGTH_SHORT).show()
        // Start DataActivity
        //val launchDataActivity: Intent = Intent(this, DataActivity::class.java)
        //startActivity(launchDataActivity)
        // Creating an intent sending data one by one
//        if(name.text.isEmpty()) {
//            editTextNameId.setError("Pon un nombre")
//            return
//        }
//        val nameOutput: String? = name.text?.toString()?: "Sin nombre"
        val launchDataActivity: Intent = Intent(this, DataActivity::class.java).apply {
            putExtra(constants.NAME, name.text?.toString()?:"")
        }
        startActivity(launchDataActivity)
    }
}