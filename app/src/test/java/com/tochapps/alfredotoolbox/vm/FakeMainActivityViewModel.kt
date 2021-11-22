package com.tochapps.alfredotoolbox.vm

import com.tochapps.alfredotoolbox.repo.FakeToolBoxRepository

class FakeMainActivityViewModel constructor(
    private val toolboxRepo: FakeToolBoxRepository
){

    fun login(sub: String) =
        toolboxRepo.loginToolBox(sub)


    fun getMovies(token: String) =
        toolboxRepo.getMovies(token)
}