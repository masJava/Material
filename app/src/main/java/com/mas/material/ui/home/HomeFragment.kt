package com.mas.material.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mas.material.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textInputLayout: TextInputLayout = root.findViewById(R.id.textField)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textInputLayout.helperText = it
        })

        val passtext: TextInputEditText = root.findViewById(R.id.pass_text)
        passtext.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null)
                    if (s.length > textInputLayout.counterMaxLength) {
                        textInputLayout.error = "Max count!!!"
                    } else {
                        textInputLayout.error = null
                    }
            }

            override fun afterTextChanged(s: Editable?) {}

        })

        return root
    }
}