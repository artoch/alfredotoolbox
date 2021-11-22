package com.tochapps.alfredotoolbox.data.local.use_case


import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity
import com.tochapps.alfredotoolbox.data.local.repository.tokendata.TokenRoomRepositoryImpl
import javax.inject.Inject

class AddTokenUC @Inject constructor(
    private val roomRepository: TokenRoomRepositoryImpl,
)  {

    suspend operator fun invoke(
        data: TokenRoomEntity
    ) =
        roomRepository.addToken(data)


}