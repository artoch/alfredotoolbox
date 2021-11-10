package com.tochapps.alfredotoolbox.data.local.use_case

import com.tochapps.alfredotoolbox.data.local.repository.tokendata.TokenRoomRepositoryImpl
import javax.inject.Inject

class GetTokenUC  @Inject constructor(
    private val roomRepository: TokenRoomRepositoryImpl
) {

    suspend operator fun invoke() = roomRepository.getToken(1)

}