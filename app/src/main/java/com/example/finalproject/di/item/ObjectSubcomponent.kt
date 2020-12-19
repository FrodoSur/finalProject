package com.example.finalproject.di.item

import com.example.finalproject.di.item.module.ObjectModule
import com.example.finalproject.di.repository.RepositorySubcomponent
import com.example.finalproject.mvp.presenter.ObjectPresenter
import com.example.finalproject.mvp.presenter.ObjectsPresenter
import com.example.finalproject.ui.adapter.ObjectsRVAdapter
import dagger.Subcomponent

@ObjectScope
@Subcomponent(
    modules = [
        ObjectModule::class
    ]
)
interface ObjectSubcomponent {
    fun repositorySubcomponent(): RepositorySubcomponent

    fun inject(usersPresenter: ObjectsPresenter)
    fun inject(usersRVAdapter: ObjectsRVAdapter)

    fun inject(objectPresenter: ObjectPresenter)
}