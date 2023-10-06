package com.example.appmvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //esto generará to-do el codigo necesario
class MvvmExampreApp : Application()
    //la primera en llamarse cuando se inicie la app
    //Se tiene que modificar el android manifest
    //Insertar esto:         android:name=".MvvmExampreApp"
