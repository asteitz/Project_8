package com.example.project8

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.project8.databinding.FragmentDisplayBinding
import com.example.project8.model.OMDBMovie


class DisplayFragment: Fragment() {
     /**
     * A Fragment that displays detailed information about a movie received as a Parcelable argument.
     * It includes the movie's genre, IMDb rating, title, release year, rating, runtime, poster image,
     * and a link to the IMDb page. Users can also share the movie details or submit feedback via email.
     */

    private var movie: OMDBMovie? = null
    private var _binding: FragmentDisplayBinding? = null

    private val binding get() = _binding!!
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         /**
         * Inflates the layout for this fragment, initializes UI elements, and sets up event listeners.
         *
         * @param inflater           The LayoutInflater object that can be used to inflate any views in the fragment.
         * @param container          If non-null, this is the parent view that the fragment's UI should be attached to.
         * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state.
         * @return The root view of the inflated layout.
         */
        _binding = FragmentDisplayBinding.inflate(inflater, container, false)

        movie = DisplayFragmentArgs.fromBundle(requireArguments()).Movie
        val view = binding.root

        binding.Genre.text = movie?.genre
        binding.imdbRating.text = movie?.imdbRating
        binding.Title.text = movie?.title
        binding.Year.text = movie?.year
        binding.Rated.text = movie?.rating
        binding.Runtime.text = movie?.runtime
        binding.Link.text = "https://www.imdb.com/title/${movie?.imdbID}/"

        Glide.with(requireContext()).load(movie?.posterString)
            .apply(
                RequestOptions().transform(
                    CenterCrop(), RoundedCorners(20)
                )
            )
            .into(binding.Poster)
            
        // Open IMDb page when link is clicked
        binding.Link.setOnClickListener {
            val url = binding.Link.text
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url.toString())
            startActivity(intent)
        }
        
        // Share movie details when button is clicked
        binding.button.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${binding.Title.text}: ${binding.Link.text}")
                type = "text/plain"
            }

            startActivity(Intent.createChooser(shareIntent, "Share Movie"))
        }
        
        // Submit feedback via email when feedback button is clicked
        binding.feedback.setOnClickListener {
            val emailRecipient = arrayOf("jamfritz@iu.edu")
            val emailSubject = "Feedback"
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.setType("message/rfc882")
            emailIntent.putExtra(Intent.EXTRA_EMAIL  , emailRecipient)
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
            emailIntent.putExtra(Intent.EXTRA_TEXT   , "Please submit feedback")

            startActivity(Intent.createChooser(emailIntent, "Submit Feedback"))

        }
        return view

    }



}

