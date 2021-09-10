package com.tochapps.practicetestapp.data.use_cases.test

import com.tochapps.practicetestapp.common.asCommonFlow
import com.tochapps.practicetestapp.common.errors.GenericErrorMapper
import com.tochapps.practicetestapp.data.model.PostItemEntity
import com.tochapps.practicetestapp.data.network.repository.testdata.TestRepository
import com.tochapps.practicetestapp.data.state.DataState
import com.tochapps.practicetestapp.data.use_cases.BaseUseCase
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