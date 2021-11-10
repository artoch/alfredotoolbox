package com.tochapps.alfredotoolbox.ui.views.content

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tochapps.alfredotoolbox.R
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.databinding.FragmentContentBinding
import com.tochapps.alfredotoolbox.ui.views.MainActivityViewModel
import com.tochapps.alfredotoolbox.ui.views.content.adapter.ListAdapter


class ContentFragment : Fragment() {

    private var _binding: FragmentContentBinding? = null

    private val vm by lazy {
        ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }

    private val navController by lazy {
        requireActivity().findNavController(R.id.nav_host_fragment_content_main)
    }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivIconDn.setOnClickListener {
            when (requireContext().resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> { AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) }
                Configuration.UI_MODE_NIGHT_NO -> { AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) }
                Configuration.UI_MODE_NIGHT_UNDEFINED -> { AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) }
            }
        }
        setObserver()
    }

    private fun setObserver(){
        vm.movies.observe(viewLifecycleOwner, ::setView)
    }

    private fun setView(data: List<ToolBoxListEntity>){
        if (data.isNotEmpty()){
            binding.rvMain.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.rvMain.adapter = ListAdapter(data.reversed(), ::goToMovie)
        }
    }

    private fun goToMovie(data: ToolBoxItemEntity){
        if (data.videoUrl != null){
            vm.setSelectedMovie(data)
            navController.navigate(R.id.goToDetail)
        }else{
            Toast.makeText(requireContext(), getString(R.string.no_video), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onResume() {
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }
}