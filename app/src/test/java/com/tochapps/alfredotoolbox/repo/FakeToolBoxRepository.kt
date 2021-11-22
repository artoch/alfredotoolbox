package com.tochapps.alfredotoolbox.repo

import com.tochapps.alfredotoolbox.common.EMPTY_STRING
import com.tochapps.alfredotoolbox.data.local.model.TokenRoomEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxItemEntity
import com.tochapps.alfredotoolbox.data.network.model.ToolBoxListEntity

class FakeToolBoxRepository {

    fun loginToolBox(sub: String = EMPTY_STRING): TokenRoomEntity? =
        if (sub != "ToolboxMobileTest") null else TokenRoomEntity(id = 1,sub = sub, "TOKEN", "Bearer")

    fun getMovies(token: String = EMPTY_STRING): List<ToolBoxListEntity> =
        if (token == EMPTY_STRING) emptyList() else listOf(
            ToolBoxListEntity(
                title = "TEST",
                type = "Carousel",
                items = listOf(
                    ToolBoxItemEntity(
                        title = "TEST ITEM",
                        imageUrl = "IMA_URL",
                        videoUrl = "VIDEO_URL",
                        description = "TEST DESCRIPTION"
                    )
                )
            )
        )
}