package com.example.project8


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project8.databinding.FragmentSearchBinding
import com.example.project8.model.OMDBMovie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.util.Log
import androidx.navigation.fragment.findNavController


private const val BASE_URL = "https://www.omdbapi.com/"


class SearchFragment: Fragment() {
    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    private val TAG = "MovieSearch"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val OMDBService = retrofit.create(OMDBapi::class.java)

        binding.searchButton.setOnClickListener {
            OMDBService.search(binding.searchParameter.text.toString())?.enqueue(object :
                Callback<OMDBMovie> {
                override fun onResponse(call: Call<OMDBMovie>, response: Response<OMDBMovie>) {
                    Log.i(TAG, "onResponse $response")
                    val body = response.body()
                    if (body == null) {
                        Log.w(TAG, "Did not receive valid response body from OMDB API... exiting")
                        return
                    }
                    val action = SearchFragmentDirections.actionSearchToDisplay(body)
                    findNavController().navigate(action)
                }

                override fun onFailure(call: Call<OMDBMovie>, t: Throwable) {
                    Log.i(TAG, "Failed")
                }
            })
        }
        binding.feedback.setOnClickListener {
            val emailRecipient = "jamfritz@iu.edu"
            val emailSubject = "Feedback"
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity")
            emailIntent.setDataAndType(Uri.parse("mailto:"),"text/plain")
            emailIntent.putExtra(Intent.EXTRA_EMAIL  , emailRecipient);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            emailIntent.putExtra(Intent.EXTRA_TEXT   , "Please submit feedback");
            startActivity(Intent.createChooser(emailIntent, "Submit Feedback"))
        }
        return view
    }
}