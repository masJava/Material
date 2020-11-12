package com.mas.material.ui.gallery

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.mas.material.R
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textInputLayout: TextInputLayout = root.findViewById(R.id.textField)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fabButton = fab
        fabButton.setOnClickListener {
            fabButton.animate()
                .rotationBy(90f)
                .setDuration(300)
                .start()
            Snackbar.make(view, "Action", Snackbar.LENGTH_LONG)
                //                        .setAction("ADD") {
                //                            Toast.makeText(context,"toast",Toast.LENGTH_SHORT).show()
                //                        }
                .show()
        }
        red_button.setOnClickListener {
            MaterialAlertDialogBuilder(view.context)
                .setTitle("О программе!")
                .setMessage("Текст о программе!")
                .setPositiveButton("Ok") { dialog, which ->  }
                .show()
        }
    }
}