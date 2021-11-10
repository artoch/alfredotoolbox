package com.tochapps.alfredotoolbox.ui.views.splash

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import com.tochapps.alfredotoolbox.R
import com.tochapps.alfredotoolbox.common.error.*
import com.tochapps.alfredotoolbox.data.state.AppState
import com.tochapps.alfredotoolbox.data.state.error.LoginErrorState
import com.tochapps.alfredotoolbox.databinding.FragmentSplashBinding
import com.tochapps.alfredotoolbox.ui.views.MainActivityViewModel


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null

    private val binding get() = _binding!!

    private val vm by lazy {
        ViewModelProvider(requireActivity()).get(MainActivityViewModel::class.java)
    }


    private val navController by lazy {
        requireActivity().findNavController(R.id.nav_host_fragment_content_main)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onResume() {
        super.onResume()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.viewState.observe(viewLifecycleOwner, ::stateHandler)
        vm.getMovies()
        binding.btnLogin.setOnClickListener {
            vm.login()
        }
    }

    private fun stateHandler(state: AppState){
        binding.progressBar.visibility = View.GONE
        when (state){
            is AppState.Loading -> {
                binding.btnLogin.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                vm.getMovies()
                Toast.makeText(requireContext(), getString(R.string.login_complete), Toast.LENGTH_SHORT).show()}
            is AppState.MovieSuccess -> {
                navController.navigate(R.id.goToMain,null,
                    NavOptions.Builder().setPopUpTo(navController.graph.startDestination, true).build())
            }
            is AppState.Error -> {
                binding.btnLogin.visibility = View.VISIBLE
                errorStateHandler(state.error)
            }
        }
    }

    private fun errorStateHandler(error: ErrorDomain) =
        when (error) {
            is CommonError.ConnectError -> { Toast.makeText(requireContext(), getString(R.string.error_conect), Toast.LENGTH_SHORT).show() }
            is ErrorStatus.ErrorMsg -> Toast.makeText(requireContext(), getString(R.string.no_local_token), Toast.LENGTH_SHORT).show()
            is LoginErrorState.NoToken -> {
                Toast.makeText(requireContext(), getString(R.string.no_token), Toast.LENGTH_SHORT).show()
            }
            is LoginErrorState.ErrorToken -> {
                Toast.makeText(requireContext(), getString(R.string.expired_token), Toast.LENGTH_SHORT).show()
            }
            is LoginErrorState.NoAuth -> {
                Toast.makeText(requireContext(), getString(R.string.no_auth), Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(requireContext(), getString(R.string.error_conect), Toast.LENGTH_SHORT).show() }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}