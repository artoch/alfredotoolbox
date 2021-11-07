package com.tochapps.alfredotoolbox.data.local.use_case

import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.errors.GenericErrorMapper
import com.tochapps.alfredotoolbox.data.local.model.TestEntity
import com.tochapps.alfredotoolbox.data.local.repository.testdata.TestCacheRepository
import com.tochapps.alfredotoolbox.data.state.DataState
import com.tochapps.alfredotoolbox.data.use_cases.BaseUseCase
import javax.inject.Inject

class GetTestCacheUC  @Inject constructor(
    private val repository: TestCacheRepository,
) : BaseUseCase() {

    fun execute(
        id:Int
    ) = handlerErrorMapper<TestEntity>(GenericErrorMapper) {
        emit(DataState.loading())
        val data = repository.getPost(id)
        emit(DataState.data(data))
    }.asCommonFlow()
}