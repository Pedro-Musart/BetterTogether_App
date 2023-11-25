package com.example.bettertogether.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.bettertogether.R

import com.example.bettertogether.databinding.FragmentChatBetterTogetherBinding

class ChatBetterTogether : Fragment() {

    private lateinit var binding: FragmentChatBetterTogetherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBetterTogetherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val webView = binding.webView
        webView.loadUrl("https://cloud.openchat.so/chat/ElnEkJpMHREDHCNYQ1pJ")
        webView.settings.javaScriptEnabled = true
    }
}

