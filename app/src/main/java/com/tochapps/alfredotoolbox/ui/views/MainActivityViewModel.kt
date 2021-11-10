package com.tochapps.alfredotoolbox.ui.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tochapps.alfredotoolbox.common.error.orGenericError
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity
import com.tochapps.alfredotoolbox.data.state.AppState
import com.tochapps.alfredotoolbox.data.uc_repo.ToolBoxRepositoryUC
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val toolboxRepo: ToolBoxRepositoryUC
): ViewModel() {

    private val _viewState = MutableLiveData<AppState>()
    val viewState: LiveData<AppState> = _viewState

    private val _movies = MutableLiveData<List<ToolBoxListEntity>>(emptyList())
    val movies: LiveData<List<ToolBoxListEntity>> = _movies

    private val _selectedMovie = MutableLiveData<ToolBoxItemEntity>()
    val selectedMovie: LiveData<ToolBoxItemEntity> = _selectedMovie

    fun login(){
        toolboxRepo.toolBoxLoginUC.invoke().collectCommon(viewModelScope){
            _viewState.value = when {
                it.isLoading -> AppState.Loading
                it.data != null -> AppState.Success
                else -> AppState.Error(it.error.orGenericError())
            }
        }
    }

    fun getMovies(){
        toolboxRepo.toolBoxMoviesUC.invoke().collectCommon(viewModelScope){
            _viewState.value = when {
                it.isLoading -> AppState.Loading
                it.data != null -> setMyMovies(data = it.data)
                else -> AppState.Error(it.error.orGenericError())
            }
        }
    }

    private fun setMyMovies(data: List<ToolBoxListEntity>): AppState{
        _movies.value = data
        return AppState.MovieSuccess
    }

    fun setSelectedMovie(data: ToolBoxItemEntity){
        _selectedMovie.value = data
    }


}