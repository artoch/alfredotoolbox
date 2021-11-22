package com.tochapps.alfredotoolbox.data.local.use_case

import com.tochapps.alfredotoolbox.data.local.repository.tokendata.TokenRoomRepositoryImpl
import com.tochapps.alfredotoolbox.common.BaseUseCase
import com.tochapps.alfredotoolbox.common.asCommonFlow
import com.tochapps.alfredotoolbox.common.error.GenericErrorMapper
import javax.inject.Inject

class DeleteTokenUC @Inject constructor(
    private val roomRepository: TokenRoomRepositoryImpl,
) : BaseUseCase() {

    operator fun invoke() = handlerErrorMapper<Unit>(GenericErrorMapper) {
        roomRepository.deleteToken()
    }.asCommonFlow()
}