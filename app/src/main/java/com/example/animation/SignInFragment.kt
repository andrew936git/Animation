package com.example.animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction


class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        val regTextView: TextView = view.findViewById(R.id.regTextView)
        val loginET: EditText = view.findViewById(R.id.loginET)
        val passwordET: EditText = view.findViewById(R.id.passwordET)
        val saveBt: Button = view.findViewById(R.id.saveBt)

        val animationMoveDown = AnimationUtils.loadAnimation(context, R.anim.move_up_to_center)
        val animationMoveUp = AnimationUtils.loadAnimation(context, R.anim.move_down_to_center)

        regTextView.startAnimation(animationMoveDown)
        loginET.startAnimation(animationMoveUp)
        passwordET.startAnimation(animationMoveUp)
        saveBt.startAnimation(animationMoveUp)

        saveBt.setOnClickListener {
            if (loginET.text.isNotEmpty() && passwordET.text.isNotEmpty()) {
                val transaction = fragmentManager?.beginTransaction()
                val finalFragment = FinalFragment()
                transaction?.replace(R.id.fragment_container, finalFragment)
                transaction?.addToBackStack(null)
                transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                transaction?.commit()
            }
        }

        return view
    }

}