package com.tochapps.alfredotoolbox

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tochapps.alfredotoolbox.data.local.model.TestEntity
import com.tochapps.alfredotoolbox.data.local.use_case.AddTestCacheUC
import com.tochapps.alfredotoolbox.data.local.use_case.DeleteTestCacheUC
import com.tochapps.alfredotoolbox.data.local.use_case.GetTestCacheUC
import com.tochapps.alfredotoolbox.data.local.use_case.ListTestCacheUC
import com.tochapps.alfredotoolbox.data.use_cases.test.TestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val testUseCase: TestUseCase,
    private val addTestCacheUC: AddTestCacheUC,
    private val listTestCacheUC: ListTestCacheUC,
    private val getTestCacheUC: GetTestCacheUC,
    private val deleteTestCacheUC: DeleteTestCacheUC
): ViewModel() {

    fun init(){
        listData()
        getRemoteData()
    }

    private fun getRemoteData(){
        testUseCase.execute().collectCommon(viewModelScope){
            if (it.data != null){
                println("TODO OK" + it.data.toString())

                saveOneTest(TestEntity(it.data[0].id, it.data[0].userId, it.data[0].title, it.data[0].body ))
            }else{
                println("ALGO FALLO")
            }
        }
    }

    private fun listData(){
        viewModelScope.launch {
            listTestCacheUC.execute().collect {
                Log.e("SEGUIMIENTO", "DATA GUARDATA $it")
            }
        }
    }

    private fun saveOneTest(data: TestEntity){
        Log.e("SEGUIMIENTO","$data")
        addTestCacheUC.execute(data).collectCommon(viewModelScope){ lo ->
            if (lo.data!= null ){
                Log.e("SEGUIMIENTO", "SE GUARDO EL DATO BIEN")
                getData()
                deleteData()

            }
        }

    }

    private fun getData(){
        getTestCacheUC.execute(1).collectCommon(viewModelScope){
            if (it.data!=null){
                Log.e("SEGUIMIENTO", "SE OBTUVO EL ${it.data}!")
            }
        }
    }

    private fun deleteData(){
        deleteTestCacheUC.execute(1).collectCommon(viewModelScope){
            if (it.data != null ){
                Log.e("SEGUIMIENTO", "SE Elimino!")
            }
        }
    }
}