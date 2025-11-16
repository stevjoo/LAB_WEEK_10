package com.example.lab_week_10

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab_week_10.viewmodels.TotalViewModel

class FirstFragment : Fragment(R.layout.fragment_first) {

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[TotalViewModel::class.java]
    }
    private var tvTotal: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvTotal = view.findViewById(R.id.text_total)
        prepareViewModel()
    }

    private fun updateText(total: Int) {
        tvTotal?.text = getString(R.string.text_total, total)
    }

    private fun prepareViewModel() {
        viewModel.total.observe(viewLifecycleOwner) { total ->
            updateText(total)
        }
    }
}