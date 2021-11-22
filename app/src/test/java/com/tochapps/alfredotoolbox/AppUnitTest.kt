package com.tochapps.alfredotoolbox

import com.tochapps.alfredotoolbox.common.EMPTY_STRING
import com.tochapps.alfredotoolbox.data.local.model.getToken
import com.tochapps.alfredotoolbox.repo.FakeToolBoxRepository
import com.tochapps.alfredotoolbox.vm.FakeMainActivityViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class AppUnitTest {

    private lateinit var vm : FakeMainActivityViewModel

    @Before
    fun setup(){
        vm = FakeMainActivityViewModel(FakeToolBoxRepository())
    }

    @Test
    fun `make login without sub`(){
        val token = vm.login(EMPTY_STRING)
        assert(token == null)
        checkToken(token.getToken())
    }

    @Test
    fun `make login app with sub`() {
        val token = vm.login("ToolboxMobileTest")
        assert(token != null)
        checkToken(token.getToken())
    }

    private fun checkToken(token: String){
        if (token.isEmpty())
            assert(vm.getMovies(token).isEmpty())
        else
            assert(vm.getMovies(token).isNotEmpty())
    }

}