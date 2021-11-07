package com.tochapps.alfredotoolbox.data.use_cases.test

import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.errors.GenericErrorMapper
import com.tochapps.alfredotoolbox.data.model.PostItemEntity
import com.tochapps.alfredotoolbox.data.network.repository.testdata.TestRepository
import com.tochapps.alfredotoolbox.data.state.DataState
import com.tochapps.alfredotoolbox.data.use_cases.BaseUseCase
import javax.inject.Inject

class TestUseCase @Inject constructor(
    private val repository: TestRepository,
) : BaseUseCase() {

    fun execute() = handlerErrorMapper<List<PostItemEntity>>(GenericErrorMapper) {
        emit(DataState.loading())
        val data = repository.getAllPost()
        emit(DataState.data(data))
    }.asCommonFlow()
}