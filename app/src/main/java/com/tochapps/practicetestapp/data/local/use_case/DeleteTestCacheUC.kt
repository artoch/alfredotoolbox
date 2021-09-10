package com.tochapps.practicetestapp.data.local.use_case

import com.tochapps.practicetestapp.common.asCommonFlow
import com.tochapps.practicetestapp.common.errors.GenericErrorMapper
import com.tochapps.practicetestapp.data.local.repository.testdata.TestCacheRepository
import com.tochapps.practicetestapp.data.state.DataState
import com.tochapps.practicetestapp.data.use_cases.BaseUseCase
import javax.inject.Inject

class DeleteTestCacheUC @Inject constructor(
    private val repository: TestCacheRepository,
) : BaseUseCase() {

    fun execute(
        id: Int
    ) = handlerErrorMapper<Unit>(GenericErrorMapper) {
        emit(DataState.loading())
        repository.deletePost(id)
        emit(DataState.data(Unit))
    }.asCommonFlow()
}