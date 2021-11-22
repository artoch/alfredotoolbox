package com.tochapps.alfredotoolbox.ui.views.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.ui.views.detail.model.ExoPlayerHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel() {

    private val _exoPlayerParams = MutableLiveData(ExoPlayerHelper())
    val exoPlayerParams:LiveData<ExoPlayerHelper> = _exoPlayerParams

    private val _selectedMovie = MutableLiveData<ToolBoxItemEntity>()
    val selectedMovie: LiveData<ToolBoxItemEntity> = _selectedMovie

    fun init(data: ToolBoxItemEntity){
        _selectedMovie.value = data
    }

    fun setExoparams(data: ExoPlayerHelper){
        _exoPlayerParams.value = data
    }
}