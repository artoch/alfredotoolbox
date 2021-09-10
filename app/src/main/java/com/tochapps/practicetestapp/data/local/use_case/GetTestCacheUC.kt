package com.tochapps.practicetestapp.data.local.use_case

import com.tochapps.practicetestapp.common.asCommonFlow
import com.tochapps.practicetestapp.common.errors.GenericErrorMapper
import com.tochapps.practicetestapp.data.local.model.TestEntity
import com.tochapps.practicetestapp.data.local.repository.testdata.TestCacheRepository
import com.tochapps.practicetestapp.data.state.DataState
import com.tochapps.practicetestapp.data.use_cases.BaseUseCase
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