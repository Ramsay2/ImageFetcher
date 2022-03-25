package com.ramsay.imagefetcher.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ramsay.imagefetcher.adapter.ImageAdapter
import com.ramsay.imagefetcher.databinding.FragmentHomePageBinding
import com.ramsay.imagefetcher.viewModel.ImageViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HomePageFragment : Fragment() {

    private lateinit var bindingHomeFragment: FragmentHomePageBinding
    private lateinit var imagePagingAdapter: ImageAdapter
    private lateinit var imageViewModel: ImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingHomeFragment = FragmentHomePageBinding.inflate(layoutInflater)
        return bindingHomeFragment.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imagePagingAdapter = ImageAdapter()
        imageViewModel = ViewModelProvider(this)[ImageViewModel::class.java]
        setUpObserver()

        setUpAdapter()

    }

    fun setUpAdapter() {
        bindingHomeFragment.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = imagePagingAdapter
        }
    }

    fun setUpObserver(){
        imageViewModel.imageLiveData().observe(viewLifecycleOwner){
            CoroutineScope(IO).launch {
                imagePagingAdapter.submitData(it)
            }
        }
    }

}