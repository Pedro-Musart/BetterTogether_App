package com.example.bettertogether.ui.awards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bettertogether.databinding.FragmentAwardsBinding


class AwardsFragment : Fragment() {

    private lateinit var binding: FragmentAwardsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAwardsBinding.inflate(inflater, container, false)
        return binding.root
    }

}