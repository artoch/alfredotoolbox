package com.tochapps.alfredotoolbox.data.state

import com.tochapps.alfredotoolbox.common.error.ErrorDomain
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity


sealed class AppState {
    object Success:AppState()
    object Loading: AppState()
    object MovieSuccess: AppState()
    class  Error(val error: ErrorDomain): AppState()
}