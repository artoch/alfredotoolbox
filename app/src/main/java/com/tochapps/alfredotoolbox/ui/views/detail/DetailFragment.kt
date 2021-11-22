package com.tochapps.alfredotoolbox.ui.views.detail

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.dash.DashMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Log
import com.google.android.exoplayer2.util.Util
import com.tochapps.alfredotoolbox.R
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.databinding.FragmentDetailBinding
import com.tochapps.alfredotoolbox.ui.views.MainActivityViewModel
import com.tochapps.alfredotoolbox.ui.views.detail.model.ExoPlayerHelper

class DetailFragment : Fragment(), Player.EventListener  {

    private val player: SimpleExoPlayer by lazy {
        SimpleExoPlayer.Builder(requireContext()).build()
    }
    private var _binding: FragmentDetailBinding? = null

    private val fragmentVm: DetailViewModel by viewModels()

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
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.ivBack.setOnClickListener{
            navController.popBackStack()
        }
        setObserver()
    }

    private fun setObserver(){
        vm.selectedMovie.observe(viewLifecycleOwner, fragmentVm::init)
        fragmentVm.selectedMovie.observe(viewLifecycleOwner, ::setView)
        fragmentVm.exoPlayerParams.observe(viewLifecycleOwner, ::setPlayerParams)
    }

    private fun setView(data: ToolBoxItemEntity){
        binding.apply {
            tvTitle.text = data.title
            tvDescription.text = data.description
            data.videoUrl?.let{
                exoPlayer.player = player
                player.playWhenReady = true
                player.setMediaSource(getMediaSource(data.videoUrl))
                player.prepare()
            }
        }
    }

    private fun setPlayerParams(data: ExoPlayerHelper){
        player.playWhenReady = data.playWhenReady
        player.seekTo(data.currentWindow, data.playBackPosition)
    }

    private fun getMediaSource(url:String): MediaSource {
        val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(
            requireContext(),
            Util.getUserAgent(requireContext(), requireActivity().applicationInfo.name)
        )

        val uri = Uri.parse(url)

        return when(Util.inferContentType(uri)){
            C.TYPE_SS -> SsMediaSource.Factory(dataSourceFactory)
            C.TYPE_DASH -> DashMediaSource.Factory(dataSourceFactory)
            C.TYPE_HLS -> HlsMediaSource.Factory(dataSourceFactory)
            C.TYPE_OTHER -> ProgressiveMediaSource.Factory(dataSourceFactory)
            else -> throw Exception("Fuente desconocida")
        }.createMediaSource(uri)
    }

    override fun onPause() {
        super.onPause()
        player.playWhenReady = false
    }

    override fun onResume() {
        super.onResume()
        player.playWhenReady = true
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentVm.setExoparams(ExoPlayerHelper(player.playWhenReady,player.currentWindowIndex, player.currentPosition))
        player.release()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPlayerError(error: PlaybackException) {
        super.onPlayerError(error)
        Log.e("ExoPlayer", "Error: ", error)
    }
}