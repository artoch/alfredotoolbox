package com.tochapps.alfredotoolbox.data.local.use_case

import com.tochapps.alfredotoolbox.data.local.repository.testdata.TestCacheRepository
import com.tochapps.alfredotoolbox.data.use_cases.BaseUseCase
import javax.inject.Inject

class ListTestCacheUC   @Inject constructor(
    private val repository: TestCacheRepository,
): BaseUseCase() {

    fun execute(
    ) = repository.getAllLocalTest()
}