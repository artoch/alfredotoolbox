package com.tochapps.practicetestapp.data.local.use_case

import com.tochapps.practicetestapp.data.local.repository.testdata.TestCacheRepository
import com.tochapps.practicetestapp.data.use_cases.BaseUseCase
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class ListTestCacheUC   @Inject constructor(
    private val repository: TestCacheRepository,
): BaseUseCase() {

    fun execute(
    ) = repository.getAllLocalTest()
}