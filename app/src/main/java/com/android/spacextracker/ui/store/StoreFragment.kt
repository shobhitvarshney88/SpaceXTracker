package com.android.spacextracker.ui.store

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.android.spacextracker.MyApp
import com.android.spacextracker.data.room.UrlDao
import com.android.spacextracker.data.room.UrlEntity
import com.android.spacextracker.databinding.FragmentStoreBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoreFragment : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!
    private lateinit var urlDao: UrlDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStoreBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        urlDao = MyApp.database.urlDao()
        lifecycleScope.launch {
            val urlEntity = urlDao.getUrl()
            if (urlEntity != null) {
                binding.webView.loadUrl(urlEntity.url)
            } else {
                val url = "https://www.spacex.com/vehicles/falcon-9/"
                binding.webView.loadUrl(url)
                urlDao.insertUrl(UrlEntity(url = url))
            }
        }
        savedInstanceState?.let {
            binding.webView.restoreState(it)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.webView.saveState(outState)
    }

}