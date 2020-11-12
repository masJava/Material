package com.mas.material.ui.style

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mas.material.R
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_style.*

class StyleFragment : Fragment() {

    private lateinit var styleViewModel: StyleViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        styleViewModel =
                ViewModelProvider(this).get(StyleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_style, container, false)
        var textView: String
        styleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView = it
        })
        return root
    }
}