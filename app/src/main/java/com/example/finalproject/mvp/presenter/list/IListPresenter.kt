package com.kotlin.museamproject.mvp.presenter.list

interface IListPresenter<V> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}