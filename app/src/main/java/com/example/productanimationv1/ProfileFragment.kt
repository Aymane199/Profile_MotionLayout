package com.example.productanimationv1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(
            R.layout.fragment_profile,
            container,
            false
        )

        val cvMore = view.findViewById<ExtendedFloatingActionButton>(R.id.ExtendedFloatingActionButtonMore)
        val motionLayout = view.findViewById<MotionLayout>(R.id.layout);

        view.findViewById<CardView>(R.id.CardViewLinkdin).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://aymane199.github.io/CV-Aymane-RIZKE-2020.pdf")
            startActivity(intent)
        }

        view.findViewById<CardView>(R.id.CardViewGithub)

        view.findViewById<CardView>(R.id.CardViewMail).setOnClickListener {
            val recipientList: String = "aymanerizke199@gmail.com"
            val recipients =
                recipientList.split(",".toRegex()).toTypedArray()
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.type = "message/rfc822"
            startActivity(intent)
        }

        view.findViewById<CardView>(R.id.CardViewPhone).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+3376027137")
            startActivity(intent)
        }
        view.findViewById<CardView>(R.id.CardViewPlayStore)

        view.findViewById<FloatingActionButton>(R.id.floatingActionButtonInfo).setOnClickListener { showInfoDialog() }

        view.findViewById<FloatingActionButton>(R.id.floatingActionButtonCV).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://aymane199.github.io/CV-Aymane-RIZKE-2020.pdf")
            startActivity(intent)
        }


        return view
    }


    fun showInfoDialog(){

        val builder = MaterialAlertDialogBuilder(requireContext())

        // dialog title
        builder.setTitle("Information about the project")

        // set alert dialog message text color
        val message = getString(R.string.info)

        // dialog message
        builder.setMessage(message)

        // alert dialog buttons
        builder.setPositiveButton("Go to code source",null)
        builder.setNeutralButton("Cancel",null)

        // finally, create the alert dialog and show it
        val dialog = builder.create()
        dialog.show()
    }


}