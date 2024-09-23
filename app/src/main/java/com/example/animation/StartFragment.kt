package com.example.animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)
        val startButton: Button = view.findViewById(R.id.startButton)
        val animationButton = AnimationUtils.loadAnimation(context, R.anim.move)
        startButton.startAnimation(animationButton)

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val animationImage = AnimationUtils.loadAnimation(context, R.anim.slide)
        imageView.startAnimation(animationImage)

        startButton.setOnClickListener {
            val transaction = fragmentManager?.beginTransaction()
            val signInFragment = SignInFragment()
            transaction?.replace(R.id.fragment_container, signInFragment)
            transaction?.addToBackStack(null)
            transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction?.commit()
        }
        return view
    }

}