package com.example.timepickerdialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Obtener la hora actual
        val hour = 12
        val minute = 0

        // Crear y devolver el diálogo del selector de tiempo
        return TimePickerDialog(requireContext(), this, hour, minute, false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        // Manejar la hora seleccionada aquí
        val time = "Hora seleccionada: $hourOfDay:$minute"
        // Puedes hacer lo que quieras con el tiempo seleccionado, como mostrarlo en un TextView
    }
}
