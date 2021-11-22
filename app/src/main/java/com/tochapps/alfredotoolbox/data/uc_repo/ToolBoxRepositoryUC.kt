package com.tochapps.alfredotoolbox.data.uc_repo

import com.tochapps.alfredotoolbox.data.network.use_cases.remote.ToolBoxLoginUC
import com.tochapps.alfredotoolbox.data.network.use_cases.remote.ToolBoxMoviesUC
import com.tochapps.alfredotoolbox.data.network.use_cases.retroRemote.RetroToolBoxLoginUC
import com.tochapps.alfredotoolbox.data.network.use_cases.retroRemote.RetroToolBoxMoviesUC
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class ToolBoxRepositoryUC @Inject constructor(
    val toolBoxLoginUC: ToolBoxLoginUC,
    val toolBoxMoviesUC: ToolBoxMoviesUC,
    val toolBoxLoginRetro: RetroToolBoxLoginUC,
    val toolBoxMoviesRetro: RetroToolBoxMoviesUC,
)